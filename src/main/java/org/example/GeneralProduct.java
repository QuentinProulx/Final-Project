package org.example;

import java.util.Objects;

public class GeneralProduct extends Product implements Returnable {
    boolean isUsed = false;

    public GeneralProduct(int price, String name) {
        super(price, name);
    }

    public void useProduct() {
        isUsed = true;
    }

    @Override
    public boolean returnItem(Store store, Product product) {
        return false;
    }

    @Override
    public int calculateReturnValue() {
        return (isUsed) ? 0 : getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GeneralProduct that = (GeneralProduct) o;
        return isUsed == that.isUsed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isUsed);
    }

    @Override
    public String toString() {
        return "GeneralProduct{" +
                "isUsed=" + isUsed + '}'
                + ", " + super.toString();
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}
