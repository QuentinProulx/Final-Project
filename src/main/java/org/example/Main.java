package org.example;

public class Main {
    public static void main(String[] args) {
        Adult adult = new Adult("Adiya", Customer.Gender.FEMALE, 15);
        GeneralProduct product = new GeneralProduct("Medium Fries", 4);

        adult.purchaseProduct(product);
    }
}