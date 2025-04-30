package org.example;

public interface Returnable {
    boolean returnItem(Store store, Product product);
    void calculateReturnValue();
}
