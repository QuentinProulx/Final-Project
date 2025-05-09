import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class AdultTest {

    // purchaseProduct

    @Test
    public void testPurchaseProduct() { // General Test Case
        Product product1 = new GeneralProduct("Ball", 15);
        Product product2 = new GeneralProduct("Gum", 2);
        Product product3 = new AdultProduct(30, "Cigar");
        Product product4 = new AdultProduct(15, "Beer");

        Adult customer = new Adult("Bob", Customer.Gender.MALE, 100);

        Store.getProducts().put(product1, 1);
        Store.getProducts().put(product2, 1);
        Store.getProducts().put(product3, 1);
        Store.getProducts().put(product4, 1);

        boolean result = customer.purchaseProduct(product1);

        Map<Product, Integer> products = new LinkedHashMap<>();
        products.put(product1, 1);

        Map<Product, Integer> storeProducts = new LinkedHashMap<>();
        storeProducts.put(product2, 1);
        storeProducts.put(product3, 1);
        storeProducts.put(product4, 1);

        Assertions.assertTrue(result);
        Assertions.assertEquals(products, customer.getProducts());
        Assertions.assertEquals(storeProducts, Store.getProducts());

        Map<Product, Integer> generalProducts = new LinkedHashMap<>();
        generalProducts.put(product1, 1);

        Assertions.assertEquals(customer.getGeneralProducts(), generalProducts);
    }

    @Test
    public void testPurchaseProduct2() { // Null test case
        Product product1 = null;
        Product product2 = new GeneralProduct("Gum", 2);
        Product product3 = new AdultProduct(30, "Cigar");
        Product product4 = new AdultProduct(15, "Beer");

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
        Product product3 = new AdultProduct(30, "Cigar");
        Product product4 = new AdultProduct(15, "Beer");

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
        Product product3 = new AdultProduct(30, "Cigar");
        Product product4 = new AdultProduct(15, "Beer");

        Adult customer = new Adult("Bob", Customer.Gender.MALE, 0);

        Store.getProducts().put(product1, 1);
        Store.getProducts().put(product2, 1);
        Store.getProducts().put(product3, 1);
        Store.getProducts().put(product4, 1);

        boolean result = customer.purchaseProduct(product1);

        Assertions.assertFalse(result);
    }
}
