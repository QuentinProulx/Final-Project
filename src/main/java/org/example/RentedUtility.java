package org.example;

public class RentedUtility extends Utility implements Returnable {
    public RentedUtility(String name, int price) {
        super(name, price);
    }

    @Override
    public boolean returnItem() {
        Store.getUtilities().put(this, Store.getUtilities().get(this) - 1);

        if (Store.getUtilities().get(this) == 0) {
            Store.getUtilities().remove(this);
        }

        if (Store.getMoney() > price) {
            Store.setDebt(Store.getDebt() + calculateReturnValue());
            Store.setMoney(0);
            return true;
        }

        Store.setMoney(Store.getMoney() - calculateReturnValue());
        return true;
    }

    @Override
    public double calculateReturnValue() {
        return getMonthsOwned() * getPrice();
    }
}
