package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Adult extends Customer {
    private Map<AdultProduct, Integer> adultProducts = new LinkedHashMap<>();
    private Map<GeneralProduct, Integer> generalProducts = new LinkedHashMap<>();

    public Adult(String name, Gender gender) {
        super(name, gender);
    }

    public Adult(String name, Gender gender, double money) {
        super(name, gender, money);
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
        if (Store.getProducts().containsKey(product)) {
            Store.getProducts().put(product, Store.getProducts().get(product) - 1);

            if (Store.getProducts().get(product) == 0) {
                Store.getProducts().remove(product);
            }

            this.getProducts().putIfAbsent(product, 0);
            this.getProducts().put(product, this.getProducts().get(product) + 1);

            if (product instanceof AdultProduct) {
                adultProducts.putIfAbsent((AdultProduct) product, 0);
                adultProducts.put((AdultProduct) product, adultProducts.get(product) + 1);
            }
            if (product instanceof GeneralProduct) {
                generalProducts.putIfAbsent((GeneralProduct) product, 0);
                generalProducts.put((GeneralProduct) product, generalProducts.get(product) + 1);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Adult adult = (Adult) o;
        return Objects.equals(adultProducts, adult.adultProducts) && Objects.equals(generalProducts, adult.generalProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), adultProducts, generalProducts);
    }

    @Override
    public String toString() {
        return "Adult{" +
                "adultProducts=" + adultProducts +
                ", generalProducts=" + generalProducts +
                '}' + ", " + super.toString();
    }

    public Map<AdultProduct, Integer> getAdultProducts() {
        return adultProducts;
    }

    public void setAdultProducts(Map<AdultProduct, Integer> adultProducts) {
        this.adultProducts = adultProducts;
    }

    public Map<GeneralProduct, Integer> getGeneralProducts() {
        return generalProducts;
    }

    public void setGeneralProducts(Map<GeneralProduct, Integer> generalProducts) {
        this.generalProducts = generalProducts;
    }


}
