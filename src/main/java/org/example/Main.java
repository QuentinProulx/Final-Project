package org.example;

public class Main {
    public static void main(String[] args) {
        Adult adult = new Adult("Adiya", Customer.Gender.FEMALE, 15);
        AdultProduct product1 = new AdultProduct("Medium Fries", 4);
        GeneralProduct product2 = new GeneralProduct("Gaming", 4);

        Store.getProducts().put(product1, 1);
        Store.getProducts().put(product2, 1);
        adult.purchaseProduct(product1);
        adult.purchaseProduct(product2);

        product2.returnItem();

        System.out.println(product2.getOwner());
        System.out.println(Store.getReceiptNumbers());
        System.out.println(Store.getProducts());
    }
}