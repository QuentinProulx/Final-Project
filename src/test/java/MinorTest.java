import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

public class MinorTest {

    // purchaseProduct

    @Test
    public void testPurchaseProduct() { // General Test Case
        Product product1 = new GeneralProduct("Ball", 15);
        Product product2 = new GeneralProduct("Gum", 2);
        Product product3 = new AdultProduct("Cigar", 30);
        Product product4 = new AdultProduct("Beer", 15);

        Adult customer = new Adult("Bob", Customer.Gender.MALE, 100);

        Store.getProducts().put(product1, 1);
        Store.getProducts().put(product2, 1);
        Store.getProducts().put(product3, 1);
        Store.getProducts().put(product4, 1);

        boolean result = customer.purchaseProduct(product1);

        Map<Product, Integer> products = new TreeMap<>();
        products.put(product1, 1);

        Map<Product, Integer> storeProducts = new TreeMap<>();
        storeProducts.put(product2, 1);
        storeProducts.put(product3, 1);
        storeProducts.put(product4, 1);

        Assertions.assertTrue(result);
        Assertions.assertEquals(products, customer.getProducts());
        Assertions.assertEquals(storeProducts, Store.getProducts());
    }

    @Test
    public void testPurchaseProduct2() { // Null test case
        Product product1 = null;
        Product product2 = new GeneralProduct("Gum", 2);
        Product product3 = new AdultProduct("Cigar", 30);
        Product product4 = new AdultProduct("Beer", 15);

        Adult customer = new Adult("Bob", Customer.Gender.MALE, 100);

        Store.getProducts().put(product1, 1);
        Store.getProducts().put(product2, 1);
        Store.getProducts().put(product3, 1);
        Store.getProducts().put(product4, 1);

        Assertions.assertThrows(NullPointerException.class, () -> customer.purchaseProduct(product1));
    }

    @Test
    public void testPurchaseProduct3() { // Price is negative test
        Product product1 = new GeneralProduct("Ball", -1);
        Product product2 = new GeneralProduct("Gum", 2);
        Product product3 = new AdultProduct("Cigar", 30);
        Product product4 = new AdultProduct("Beer", 15);

        Adult customer = new Adult("Bob", Customer.Gender.MALE, 100);

        Store.getProducts().put(product1, 1);
        Store.getProducts().put(product2, 1);
        Store.getProducts().put(product3, 1);
        Store.getProducts().put(product4, 1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> customer.purchaseProduct(product1));
    }

    @Test
    public void testPurchaseProduct4() { // Can't afford test case
        Product product1 = new GeneralProduct("Ball", 15);
        Product product2 = new GeneralProduct("Gum", 2);
        Product product3 = new AdultProduct("Cigar", 30);
        Product product4 = new AdultProduct("Beer", 15);

        Adult customer = new Adult("Bob", Customer.Gender.MALE, 0);

        Store.getProducts().put(product1, 1);
        Store.getProducts().put(product2, 1);
        Store.getProducts().put(product3, 1);
        Store.getProducts().put(product4, 1);

        boolean result = customer.purchaseProduct(product1);

        Assertions.assertFalse(result);
    }

    @Test
    public void testPurchaseProduct5() { // Store doesn't contain product test case
        Product product1 = new GeneralProduct("Ball", 15);

        Minor customer = new Minor("Bob", Customer.Gender.MALE);

        boolean result = customer.purchaseProduct(product1);

        Assertions.assertFalse(result);
    }
}
