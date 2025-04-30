package org.example;

import java.util.Objects;

public abstract class Item {
    private int id;
    private int price;
    private String name;

    private static int nextId = 0;
    public Item(int price, String name) {
        this.price = price;
        this.name = name;
        this.id = nextId++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && price == item.price && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, name);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Item.nextId = nextId;
    }
}
