package org.example;

public class RentedUtility extends Utility implements Returnable {
    public RentedUtility(String name, int price) {
        super(name, price);
    }

    @Override
    public boolean returnItem() {
        if (!Store.getUtilities().containsKey(this)) {
            System.out.println("Store doesn't contain this utility");
            return false;
        }
        Store.getUtilities().put(this, Store.getUtilities().get(this) - 1);

        if (Store.getUtilities().get(this) == 0) {
            Store.getUtilities().remove(this);
        }

        System.out.println("Item successfully returned");

        if (Store.getMoney() < price) {
            Store.setDebt(calculateReturnValue() - Store.getMoney());
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
