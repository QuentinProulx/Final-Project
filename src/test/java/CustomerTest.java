import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeSet;

public class CustomerTest {

    // searchProducts

    @Test
    public void testSearchProducts1() { // General test case
        Store.setProducts(new LinkedHashMap<>());

        Customer customer = new Adult("Bob", Customer.Gender.MALE);

        Product product1 = new AdultProduct("Cheese Ball", 15);
        Product product2 = new AdultProduct("Cheese Candy", 1);
        Product product3 = new GeneralProduct("Cotton Candy", 5);
        Product product4 = new GeneralProduct("Cotton Ball", 5);

        Store.getProducts().put(product4, 1);
        Store.getProducts().put(product1, 1);
        Store.getProducts().put(product2, 1);
        Store.getProducts().put(product3, 1);

        String keyword = "Ball";

        Set<Product> expected = new TreeSet<>();
        expected.add(product1);
        expected.add(product4);

        Set<Product> actual = customer.searchProducts(keyword);

        System.out.println(Store.getProducts());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearchProducts2() { // Null test case
        Store.setProducts(new LinkedHashMap<>());

        Customer customer = new Adult("Bob", Customer.Gender.MALE);

        Product product1 = new AdultProduct("Cheese Ball", 15);
        Product product2 = new AdultProduct("Cheese Candy", 1);
        Product product3 = new GeneralProduct("Cotton Candy", 5);
        Product product4 = new GeneralProduct("Cotton Ball", 5);

        Store.getProducts().put(product4, 1);
        Store.getProducts().put(product1, 1);
        Store.getProducts().put(product2, 1);
        Store.getProducts().put(product3, 1);

        String keyword = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> customer.searchProducts(keyword));
    }

    @Test
    public void testSearchProducts3() { // Empty test case
        Store.setProducts(new LinkedHashMap<>());

        Customer customer = new Adult("Bob", Customer.Gender.MALE);

        Product product1 = new AdultProduct("Cheese Ball", 15);
        Product product2 = new AdultProduct("Cheese Candy", 1);
        Product product3 = new GeneralProduct("Cotton Candy", 5);
        Product product4 = new GeneralProduct("Cotton Ball", 5);

        Store.getProducts().put(product4, 1);
        Store.getProducts().put(product1, 1);
        Store.getProducts().put(product2, 1);
        Store.getProducts().put(product3, 1);

        String keyword = "";

        Assertions.assertThrows(IllegalArgumentException.class, () -> customer.searchProducts(keyword));
    }

    @Test
    public void testSearchProducts4() { // Different case test
        Store.setProducts(new LinkedHashMap<>());

        Customer customer = new Adult("Bob", Customer.Gender.MALE);

        Product product1 = new AdultProduct("Cheese Ball", 15);
        Product product2 = new AdultProduct("Cheese Candy", 1);
        Product product3 = new GeneralProduct("Cotton Candy", 5);
        Product product4 = new GeneralProduct("Cotton Ball", 5);

        Store.getProducts().put(product4, 1);
        Store.getProducts().put(product1, 1);
        Store.getProducts().put(product2, 1);
        Store.getProducts().put(product3, 1);

        String keyword = "CHEESE";

        Set<Product> expected = new TreeSet<>();
        expected.add(product1);
        expected.add(product2);

        Set<Product> actual = customer.searchProducts(keyword);

        Assertions.assertEquals(expected, actual);
    }
}
