package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class GeneralProduct extends Product implements Returnable {
    boolean isUsed = false;

    public GeneralProduct(String name, int price) {
        super(name, price);
    }

    public void useProduct() {
        isUsed = true;
    }

    @Override
    public boolean returnItem() {
        if (this.owner == null) {
            throw new IllegalStateException("Owner is null");
        }
        File file = new File(owner.receiptFile.getPath());
        try (Scanner scanner = new Scanner(file)) {
            String content = "";
            while (scanner.hasNextLine()) {
                content += scanner.nextLine();
            }
            System.out.println(content);

            String[] info = content.split(",");

            for (int i = 1; i < info.length; i++) {
                if (i % 3 == 0 && Integer.parseInt(info[i]) == receiptNumber) {
                    Store.getReceiptNumbers().remove(Integer.parseInt(info[i]));

                    owner.getProducts().put(this, owner.getProducts().get(this) - 1);
                    if (owner.getProducts().get(this) == 0) {
                        owner.getProducts().remove(this);
                    }

                    if (owner instanceof Adult) {
                        ((Adult) owner).getGeneralProducts().put(this, owner.getProducts().get(this) - 1);
                        if (((Adult) owner).getGeneralProducts().get(this) == 0) {
                            ((Adult) owner).getGeneralProducts().remove(this);
                        }
                    }

                    Store.getProducts().putIfAbsent(this, 0);
                    Store.getProducts().put(this, Store.getProducts().get(this) + 1);

                    this.owner = null;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public double calculateReturnValue() {
        return (isUsed) ? 0 : getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GeneralProduct that = (GeneralProduct) o;
        return isUsed == that.isUsed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isUsed);
    }

    @Override
    public String toString() {
        return "GeneralProduct{" +
                "isUsed=" + isUsed + '}'
                + ", " + super.toString();
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}
