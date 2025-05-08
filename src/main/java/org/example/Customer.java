package org.example;

import java.io.File;
import java.io.IOException;
import java.util.*;

public abstract class Customer {
    protected static int id = 0;
    protected File receiptFile = new File("src/main/resources/" + id++);

    protected String name;
    protected Gender gender;
    protected double money;
    protected boolean isEmployee;

    private Map<Product, Integer> products = new LinkedHashMap<>();

    public Customer(String name, Gender gender) {
        this(name, gender, 0);
    }

    public Customer(String name, Gender gender, double money) {
        try {
            receiptFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.name = name;
        this.gender = gender;
        this.money = money;
    }

    /**
     * Gets a list of products that the store has with the keyword specified by the customer
     * @param keyword the keyword the Customer is searching for
     * @return the set of all the products which contain the keyword which the store contains
     */
    public Set<Product> searchProducts(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            throw new IllegalArgumentException("Keyword cannot be null or empty");
        }
        Set<Product> productList = new TreeSet<>();

        for (Product product : Store.getProducts().keySet()) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                productList.add(product);
            }
        }

        return productList;
    }

    /**
     * Takes a product from the store and gives it to the Customer if the Customer is eligible and has the funds
     * @param product the product that the Customer is attempting to buy
     * @return whether the transaction was successful or not
     */
    public abstract boolean purchaseProduct(Product product);

    public class CustomerComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
            if (isEmployee) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return Double.compare(o1.getMoney(), o2.getMoney());
            }
        }
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Customer.id = id;
    }

    public File getReceiptFile() {
        return receiptFile;
    }

    public void setReceiptFile(File receiptFile) {
        this.receiptFile = receiptFile;
    }

    public enum Gender {
        MALE, FEMALE
    }
}
