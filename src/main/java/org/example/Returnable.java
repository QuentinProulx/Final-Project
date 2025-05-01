package org.example;

public interface Returnable {
    /**
     * Returns an item to where it was bought from for some value
     * @param store the store that the product is returned to
     * @return whether the Customer was able to return the Item or not
     */
    boolean returnItem(Store store);

    /**
     * Calculates how much money would be gained upon returning the Item
     * @return the amount of money that would be gained or lost if the Item were to be returned
     */
    int calculateReturnValue();
}
