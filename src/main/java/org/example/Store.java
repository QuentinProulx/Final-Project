package org.example;

import java.util.*;

public class Store {
    private static String name = "Quentin's Store";
    private static double money = 0;
    private static double debt = 0;
    private static Map<Product, Integer> products = new LinkedHashMap<>();
    private static Map<Utility, Integer> utilities = new LinkedHashMap<>();
    private static List<Integer> receiptNumbers = new ArrayList<>();

    /**
     * Adds a product to the store's products in exchange for money
     * @param item the product to be added
     * @return whether the transaction has gone through or not
     */
    public static boolean acquireItem(Item item, int amount) {
        if (item == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (amount < 1) {
            throw new IllegalArgumentException("Amount cannot be less than 1");
        }
        if (money - item.getPrice() * amount < 0) {
            System.out.println("Store doesn't have enough money to make the purchase");
            return false;
        }

        if (item instanceof Product) {
            products.putIfAbsent((Product) item, 0);
            products.put((Product) item, 1);
        }
        if (item instanceof Utility) {
            utilities.putIfAbsent((Utility) item, 0);
            utilities.put((Utility) item, 1);
        }

        money -= item.getPrice() * amount;

        return true;
    }

    public static boolean acquireItem(Product product) {
        return acquireItem(product, 1);
    }

    /**
     * Removes a product from the store's products in exchange for money
     * @param item the product to be sold
     * @param amount the amount of the product to be sold
     * @return whether the transaction was successful or not
     */
    // TODO: Make t so that the it sells products instead
    public static boolean sellProduct(Item item, int amount) {
        if (item == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (amount < 1) {
            throw new IllegalArgumentException("Amount cannot be less than 1");
        }

        if (item instanceof Product) {
            if (!products.containsKey(item)) {
                System.out.println("Store doesn't have this product");
                return false;
            }
            if (products.get(item) < amount) {
                System.out.println("Selling a greater amount of the product than the store has in stock");
            }
            products.put((Product) item, products.get((Product) item) - amount);
            money += ((Product) item).getRetailPrice() * amount;
            if (products.get((Product) item) == 0) {
                products.remove((Product) item);
            }
        }

        if (item instanceof Utility) {
            if (item instanceof RentedUtility) {
                throw new IllegalArgumentException("Can't sell Rented Utilities; they must be returned!");
            }
            if (!utilities.containsKey(item)) {
                System.out.println("Store doesn't have this product");
                return false;
            }
            if (utilities.get(item) < amount) {
                System.out.println("Selling a greater amount of the product than the store has in stock");
            }
            utilities.put((Utility) item, utilities.get((Utility) item) - amount);
            money += item.getPrice() * amount;
            if (utilities.get((Utility) item) == 0) {
                utilities.remove((Utility) item);
            }
        }

        return true;
    }

    public static boolean sellItem(Product product) {
        return sellItem(product, 1);
    }

    /**
     * Takes a loan, increasing both the money that the store has and the debt that the store has
     * @param amount the amount of money that the store is asking for in the loan
     * @return whether the loan was able to go through or not
     */
    public static boolean takeLoan(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be less than 0");
        }
        if (debt + amount >= 10000) {
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
    public static boolean payDebt(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be less than 0");
        }
        if (debt - amount < 0) {
            System.out.println("Cannot pay non-existent debt");
            return false;
        }
        if (money - amount < 0) {
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

    /**
     * Calculates how much the store is spending on rented items per year
     * @return the amount the store is spending on rented items every year
     */
    public static double calculateAmountSpentPerYear() {
        double amount = 0;

        for (Utility utility : utilities.keySet()) {
            if (!(utility instanceof RentedUtility)) {
                continue;
            }
            amount += utility.getPrice() * utilities.get(utility);
        }

        return amount;
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

    public static Map<Utility, Integer> getUtilities() {
        return utilities;
    }

    public static void setUtilities(Map<Utility, Integer> utilities) {
        Store.utilities = utilities;
    }

    public static List<Integer> getReceiptNumbers() {
        return receiptNumbers;
    }

    public static void setReceiptNumbers(List<Integer> receiptNumbers) {
        Store.receiptNumbers = receiptNumbers;
    }
}
