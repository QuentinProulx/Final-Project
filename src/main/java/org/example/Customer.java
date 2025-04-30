package org.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Customer {
    private String name;
    private Map<Product, Integer> products = new LinkedHashMap<>();
    private boolean isEmployee;

    public Customer() {
        this("None");
    }

    public Customer(String name) {
        this(name, false);
    }

    public Customer(String name, boolean isEmployee) {
        this.name = name;
        this.isEmployee = isEmployee;
    }

    public List<Product> getProducts(Store store, String keyword) {
        // TODO: Make it so this searches for products with a certain keyword
        // TODO: Requires: Store Stock Integration
        return null;
    }

    public boolean purchaseProduct(Store store, Product product) {
        // TODO: Make it so this takes an item from the store, removes that item from the store, and adds it to the user's products
        // TODO: Requires: Store Stock Integration
        // NOTE: Only works if the store has the product
        return false;
    }

    public boolean returnProduct(Store store, Product product) {
        // TODO: Make it so this gives back and item that the player has and gives it back to the store
        // TODO: Requires: Store Stock Integration
        // NOTE: Only works if the user has the product
        return false;
    }
}
