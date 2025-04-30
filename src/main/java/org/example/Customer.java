package org.example;

import java.util.*;

public abstract class Customer {
    private String name;
    private Map<Product, Integer> products = new LinkedHashMap<>();
    private boolean isEmployee;
    private Gender gender;

    public Customer(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public List<Product> getProducts(Store store, String keyword) {
        // TODO: Make it so this searches for products with a certain keyword
        // TODO: Requires: Store Stock Integration
        return null;
    }

    // TODO: Make it so this takes an item from the store, removes that item from the store, and adds it to the user's products
    // TODO: Requires: Store Stock Integration
    // NOTE: Only works if the store has the product
    public abstract boolean purchaseProduct(Store store, Product product);

    public boolean returnProduct(Store store, Product product) {
        // TODO: Make it so this gives back and item that the player has and gives it back to the store
        // TODO: Requires: Store Stock Integration
        // NOTE: Only works if the user has the product
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return isEmployee == customer.isEmployee && Objects.equals(name, customer.name) && Objects.equals(products, customer.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, products, isEmployee);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", products=" + products +
                ", isEmployee=" + isEmployee +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    public enum Gender {
        MALE, FEMALE
    }
}
