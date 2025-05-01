package org.example;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Store {
    private static String name;
    private static double money;
    private static double debt;
    private static Map<Product, Integer> products = new TreeMap<>();

    /**
     * Adds a product to the store's products in exchange for money
     * @param product the product to be added
     * @return whether the transaction has gone through or not
     */
    public static boolean acquireItem(Product product, int amount) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (amount < 1) {
            System.out.println("Amount can not be less than 1");
            return false;
        }
        if (product.getPrice() - money * amount < 0) {
            System.out.println("Store doesn't have enough money to make the purchase");
            return false;
        }
        products.putIfAbsent(product, 0);
        products.put(product, 1);

        money -= product.getPrice() * amount;

        return true;
    }

    public static boolean acquireItem(Product product) {
        return acquireItem(product, 1);
    }

    /**
     * Takes a loan, increasing both the money that the store has and the debt that the store has
     * @param amount the amount of money that the store is asking for in the loan
     * @return whether the loan was able to go through or not
     */
    public static boolean takeLoan(int amount) {
        if (amount < 0) {
            System.out.println("Cannot take a negative loan");
            return false;
        }
        if (debt + amount > 10000) {
            System.out.println("Cannot be more than $10,000 in debt after taking a loan");
            return false;
        }

        debt += amount;
        money += amount;

        return true;
    }

    /**
     * Pays debt; Removes the amount of debt that is being paid and
     * @param amount the amount of debt that is going to be paid
     * @return whether this transaction can go through or not
     */
    public static boolean payDebt(int amount) {
        if (amount < 0) {
            System.out.println("Cannot pay a negative amount");
            return false;
        }
        if (debt - amount < 0) {
            System.out.println("Cannot pay non-existent debt");
            return false;
        }
        if (money - amount > 0) {
            System.out.println("Can't go into debt paying debt");
            return false;
        }

        debt -= amount;
        money -= amount;

        return true;
    }

    /**
     * Hires a customer to work at the store
     * @param customer the customer to be hired
     */
    public static void hireEmployee(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer can not be null");
        }
        customer.setEmployee(true);
    }

    /**
     * Fires a customer from working at the store
     * @param customer the customer to be fired
     */
    public static void fireEmployee(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer can not be null");
        }
        customer.setEmployee(false);
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", profit=" + money +
                ", products=" + products +
                '}';
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Store.name = name;
    }

    public static double getMoney() {
        return money;
    }

    public static void setMoney(double money) {
        Store.money = money;
    }

    public static double getDebt() {
        return debt;
    }

    public static void setDebt(double debt) {
        Store.debt = debt;
    }

    public static Map<Product, Integer> getProducts() {
        return products;
    }

    public static void setProducts(Map<Product, Integer> products) {
        Store.products = products;
    }
}
