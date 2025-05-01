package org.example;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Adult extends Customer {
    Map<AdultProduct, Integer> adultProducts = new LinkedHashMap<>();
    Map<GeneralProduct, Integer> generalProducts = new LinkedHashMap<>();

    public Adult(String name, Gender gender) {
        super(name, gender);
    }

    @Override
    public boolean purchaseProduct(Product product) {
        if (product == null) {
            throw new NullPointerException("Product is null");
        }
        if (product.getRetailPrice() < 0) {
            throw new IllegalArgumentException("Product price is negative");
        }
        if (this.getMoney() - product.getRetailPrice() < 0) {
            System.out.println("Customer is trying to make an invalid purchase");
            return false;
        }
        if (Store.getProducts().containsKey(product)) {
            Store.getProducts().put(product, Store.getProducts().get(product) - 1);

            this.getProducts().putIfAbsent(product, 0);
            this.getProducts().put(product, Store.getProducts().get(product) + 1);

            if (product instanceof AdultProduct) {
                adultProducts.putIfAbsent((AdultProduct) product, 0);
                adultProducts.put((AdultProduct) product, Store.getProducts().get(product) + 1);
            }
            if (product instanceof GeneralProduct) {
                generalProducts.putIfAbsent((GeneralProduct) product, 0);
                generalProducts.put((GeneralProduct) product, Store.getProducts().get(product) + 1);
            }

            Store.setMoney(Store.getMoney() + product.getRetailPrice());
            this.setMoney(this.getMoney() - product.getRetailPrice());

            if (Store.getProducts().get(product) == 0) {
                Store.getProducts().remove(product);
            }
            return true;
        }

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
