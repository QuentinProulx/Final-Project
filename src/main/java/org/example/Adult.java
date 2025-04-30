package org.example;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Adult extends Customer {
    Map<AdultProduct, Integer> adultProducts = new LinkedHashMap<>();
    Map<GeneralProduct, Integer> generalProducts = new LinkedHashMap<>();

    public Adult(String name, Gender gender) {
        super(name, gender);
    }

    @Override
    public boolean purchaseProduct(Store store, Product product) {
        // TODO: Make it so this takes an item from the store, removes that item from the store, and adds it to the user's products
        // TODO: Requires: Store Stock Integration
        // NOTE: Only works if the store has the product

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Adult adult = (Adult) o;
        return Objects.equals(adultProducts, adult.adultProducts) && Objects.equals(generalProducts, adult.generalProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), adultProducts, generalProducts);
    }

    @Override
    public String toString() {
        return "Adult{" +
                "adultProducts=" + adultProducts +
                ", generalProducts=" + generalProducts +
                '}' + ", " + super.toString();
    }

    public Map<AdultProduct, Integer> getAdultProducts() {
        return adultProducts;
    }

    public void setAdultProducts(Map<AdultProduct, Integer> adultProducts) {
        this.adultProducts = adultProducts;
    }

    public Map<GeneralProduct, Integer> getGeneralProducts() {
        return generalProducts;
    }

    public void setGeneralProducts(Map<GeneralProduct, Integer> generalProducts) {
        this.generalProducts = generalProducts;
    }


}
