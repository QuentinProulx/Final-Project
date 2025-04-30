package org.example;

public class GeneralProduct extends Product implements Returnable {
    public GeneralProduct(int price, String name) {
        super(price, name);
    }

    @Override
    public boolean returnItem(Store store, Product product) {
        return false;
    }

    @Override
    public void calculateReturnValue() {

    }
}
