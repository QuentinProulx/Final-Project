package org.example;

import java.util.Objects;

public class Utility extends Item {
    protected int monthsOwned;

    public Utility(int price, String name) {
        super(price, name);
        this.monthsOwned = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Utility utility = (Utility) o;
        return monthsOwned == utility.monthsOwned;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), monthsOwned);
    }

    @Override
    public String toString() {
        return "Utility{" +
                "monthsOwned=" + monthsOwned +
                '}' + ", " + super.toString();
    }

    public int getMonthsOwned() {
        return monthsOwned;
    }

    public void setMonthsOwned(int monthsOwned) {
        this.monthsOwned = monthsOwned;
    }
}
