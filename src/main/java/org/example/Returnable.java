package org.example;

public interface Returnable {
    /**
     * Returns an item to where it was bought from for some value
     * @return whether the class was able to return the Item or not
     */
    boolean returnItem();

    /**
     * Calculates how much money would be gained upon returning the Item
     * @return the amount of money that would be gained or lost if the Item were to be returned
     */
    double calculateReturnValue();
}
