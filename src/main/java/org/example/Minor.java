package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class Minor extends Customer {
    public Minor(String name, Gender gender) {
        super(name, gender);
    }

    @Override
    public boolean purchaseProduct(Product product) {
        if (product == null) {
            throw new NullPointerException("Product is null");
        }
        if (product.getRetailPrice() * ((isEmployee) ? 0.3 : 1) < 0) {
            throw new IllegalArgumentException("Product price is negative");
        }
        if (this.getMoney() - product.getRetailPrice() * ((isEmployee) ? 0.3 : 1) < 0) {
            System.out.println("Customer is trying to make an invalid purchase");
            return false;
        }
        if (product instanceof AdultProduct) {
            System.out.println("Minors can not buy Adult Products");
            return false;
        }
        if (Store.getProducts().containsKey(product)) {
            Store.getProducts().put(product, Store.getProducts().get(product) - 1);

            this.getProducts().putIfAbsent(product, 0);
            this.getProducts().put(product, this.getProducts().get(product) + 1);

            if (Store.getProducts().get(product) == 0) {
                Store.getProducts().remove(product);
            }

            Store.getReceiptNumbers().add(receiptNumber);
            product.setReceiptNumber(receiptNumber);

            try (FileWriter fileWriter = new FileWriter(receiptFile, true)) {
                fileWriter.write(product.getName() + ",");
                fileWriter.write(product.getRetailPrice() + ",");
                fileWriter.write(receiptNumber++ + ",\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Store.setMoney(Store.getMoney() + product.getRetailPrice() * ((isEmployee) ? 0.3 : 1));
            this.setMoney(this.getMoney() - product.getRetailPrice() * ((isEmployee) ? 0.3 : 1));

            product.setOwner(this);

            return true;
        }

        System.out.println("The store doesn't contain this product");
        return false;
    }
}
