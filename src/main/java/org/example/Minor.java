package org.example;

public class Minor extends Customer {
    public Minor(String name, Gender gender) {
        super(name, gender);
    }

    @Override
    public boolean purchaseProduct(Product product) {
        if (product == null) {
            throw new NullPointerException("Product is null");
        }
        if (product.getRetailPrice() < 0) {
            throw new IllegalArgumentException("Product price is negative");
        }
        if (this.getMoney() - product.getRetailPrice() < 0) {
            System.out.println("Customer is trying to make an invalid purchase");
            return false;
        }
        if (Store.getProducts().containsKey(product)) {
            Store.getProducts().put(product, Store.getProducts().get(product) - 1);

            this.getProducts().putIfAbsent(product, 0);
            this.getProducts().put(product, Store.getProducts().get(product) + 1);

            Store.setMoney(Store.getMoney() + product.getRetailPrice());
            this.setMoney(this.getMoney() - product.getRetailPrice());

            if (Store.getProducts().get(product) == 0) {
                Store.getProducts().remove(product);
            }
            return true;
        }

        return false;
    }
}
