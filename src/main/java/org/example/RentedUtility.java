package org.example;

public class RentedUtility extends Utility implements Returnable {
    public RentedUtility(int price, String name) {
        super(price, name);
    }

    @Override
    public boolean returnItem() {
        if (Store.getMoney() > price) {
            Store.setDebt(Store.getDebt() + calculateReturnValue());
            Store.setMoney(0);
            return true;
        }

        Store.setMoney(Store.getMoney() - price);
        return true;
    }

    @Override
    public double calculateReturnValue() {
        return getMonthsOwned() * getPrice();
    }
}
