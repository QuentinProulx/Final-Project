package org.example;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Store {
    private String name;
    private int profit;
    private int debt;
    private Map<Product, Integer> products = new TreeMap<>();
    private Map<AdultProduct, Integer> adultProducts = new TreeMap<>();
    private Map<GeneralProduct, Integer> generalProducts = new TreeMap<>();

    public Store(String name) {
        this.name = name;
        profit = 0;
    }

    public boolean acquireItem(Product product) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return profit == store.profit && Objects.equals(name, store.name) && Objects.equals(products, store.products) && Objects.equals(adultProducts, store.adultProducts) && Objects.equals(generalProducts, store.generalProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, profit, products, adultProducts, generalProducts);
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", profit=" + profit +
                ", products=" + products +
                ", adultProducts=" + adultProducts +
                ", generalProducts=" + generalProducts +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
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
