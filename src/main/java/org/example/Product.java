package org.example;

import java.util.Objects;

public abstract class Product extends Item {
    protected Customer owner;
    protected double retailPrice;
    protected int receiptNumber;

    public Product(String name, int price) {
        super(name, price);
        retailPrice = price * 1.5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return Double.compare(retailPrice, product.retailPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), retailPrice);
    }

    @Override
    public String toString() {
        return "Product{" +
                ", retailPrice=" + retailPrice +
                '}' + ", " + super.toString();
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(int receiptNumber) {
        this.receiptNumber = receiptNumber;
    }
}
