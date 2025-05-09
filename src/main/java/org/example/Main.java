package org.example;

public class Main {
    public static void main(String[] args) {
        Adult adult = new Adult("Adiya", Customer.Gender.FEMALE, 15);
        AdultProduct product = new AdultProduct("Medium Fries", 4);

        Store.getProducts().put(product, 1);
        System.out.println(adult.purchaseProduct(product));
    }
}