package org.example;

public class RentedUtility extends Utility implements Returnable {
    public RentedUtility(int price, String name) {
        super(price, name);
    }

    @Override
    public boolean returnItem(Store store) {
        // TODO: Make the item returnable upon class of TextIO in the Store class
        // Remember that if the store can't afford to pay the rented price, the money will go into the debt
        return false;
    }

    @Override
    public int calculateReturnValue() {
        return getMonthsOwned() * getPrice();
    }
}
