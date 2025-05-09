package org.example;

public class Main {
    public static void main(String[] args) {
        Adult adult = new Adult("Adiya", Customer.Gender.FEMALE, 15);
        Product product = new Product("Medium Fries", 4);

        adult.purchaseProduct(product);
    }
}