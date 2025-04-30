package org.example;

public class RentedUtility extends Utility implements Returnable {
    public RentedUtility(int price, String name) {
        super(price, name);
    }

    @Override
    public boolean returnItem(Store store, Product product) {
        return false;
    }
}
