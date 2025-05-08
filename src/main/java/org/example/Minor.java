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
        if (product instanceof AdultProduct) {
            System.out.println("Minors can not buy Adult Products");
            return false;
        }
        if (Store.getProducts().containsKey(product)) {
            Store.getProducts().put(product, Store.getProducts().get(product) - 1);

            System.out.println(Store.getProducts());

            if (Store.getProducts().get(product) == 0) {
                Store.getProducts().remove(product);
            }

            this.getProducts().putIfAbsent(product, 0);
            this.getProducts().put(product, this.getProducts().get(product) + 1);

            Store.setMoney(Store.getMoney() + product.getRetailPrice());
            this.setMoney(this.getMoney() - product.getRetailPrice());

            product.setOwner(this);

            return true;
        }

        return false;
    }
}
