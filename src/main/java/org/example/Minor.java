package org.example;

public class Minor extends Customer {
    public Minor(String name, Gender gender) {
        super(name, gender);
    }

    @Override
    public boolean purchaseProduct(Store store, Product product) {
        // TODO: Make it so this takes an item from the store, removes that item from the store, and adds it to the user's products
        // TODO: Requires: Store Stock Integration
        // NOTE: Only works if the store has the product

        return false;
    }
}
