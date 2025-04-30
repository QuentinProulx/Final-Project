package org.example;

import java.util.*;

public abstract class Customer {
    private String name;
    private Gender gender;

    private Map<Product, Integer> products = new LinkedHashMap<>();

    private boolean isEmployee;
    private int money;

    public Customer(String name, Gender gender) {
        this(name, gender, 0);
    }

    public Customer(String name, Gender gender, int money) {
        this.name = name;
        this.gender = gender;
        this.money = money;
    }

    /**
     * Gets a list of products that the store has with the keyword specified by the customer
     * @param store the store to be searched for products with said keyword
     * @param keyword the keyword the Customer is searching for
     * @return the list of all the products which contain the keyword which the store contains
     */
    public List<Product> getProducts(Store store, String keyword) {
        // TODO: Make it so this searches for products with a certain keyword
        // TODO: Requires: Store Stock Integration
        return null;
    }

    /**
     * Takes a product from the store and gives it to the Customer if the Customer is eligible and has the funds
     * @param store the store that the Customer is buying from
     * @param product the product that the Customer is attempting to buy
     * @return whether the transaction was successful or not
     */
    public abstract boolean purchaseProduct(Store store, Product product);

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
