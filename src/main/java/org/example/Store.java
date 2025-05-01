package org.example;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Store {
    private String name;
    private double money;
    private double debt;
    private Map<Product, Integer> products = new TreeMap<>();

    public Store(String name) {
        this.name = name;
        money = 0;
    }

    public boolean acquireItem(Product product) {
        if (product.getPrice() - money < 0) {
            return false;
        }
        products.putIfAbsent(product, 0);
        products.put(product, 1);

        money -= product.getPrice();

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return money == store.money && Objects.equals(name, store.name) && Objects.equals(products, store.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, products);
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", profit=" + money +
                ", products=" + products +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
}
