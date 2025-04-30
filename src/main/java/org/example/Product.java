package org.example;

public class Product extends Item {
    Customer owner;

    public Product(int price, String name) {
        super(price, name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "owner=" + owner +
                '}' + ", " + super.toString();
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}
