import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CustomerTest {

    // searchProducts

    @Test
    public void testSearchProducts1() { // General test case
        Customer customer = new Adult("Bob", Customer.Gender.MALE);

        Product product1 = new AdultProduct(15, "Cheese Ball");
        Product product2 = new AdultProduct(1, " Cheese Candy");
        Product product3 = new GeneralProduct(5, "Cotton Candy");
        Product product4 = new GeneralProduct(5, "Cotton Ball");

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
        Customer customer = new Adult("Bob", Customer.Gender.MALE);

        Product product1 = new AdultProduct(15, "Cheese Ball");
        Product product2 = new AdultProduct(1, " Cheese Candy");
        Product product3 = new GeneralProduct(5, "Cotton Candy");
        Product product4 = new GeneralProduct(5, "Cotton Ball");

        Store.getProducts().put(product4, 1);
        Store.getProducts().put(product1, 1);
        Store.getProducts().put(product2, 1);
        Store.getProducts().put(product3, 1);

        String keyword = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> customer.searchProducts(keyword));
    }

    @Test
    public void testSearchProducts3() { // Empty test case
        Customer customer = new Adult("Bob", Customer.Gender.MALE);

        Product product1 = new AdultProduct(15, "Cheese Ball");
        Product product2 = new AdultProduct(1, " Cheese Candy");
        Product product3 = new GeneralProduct(5, "Cotton Candy");
        Product product4 = new GeneralProduct(5, "Cotton Ball");

        Store.getProducts().put(product4, 1);
        Store.getProducts().put(product1, 1);
        Store.getProducts().put(product2, 1);
        Store.getProducts().put(product3, 1);

        String keyword = "";

        Assertions.assertThrows(IllegalArgumentException.class, () -> customer.searchProducts(keyword));
    }

    @Test
    public void testSearchProducts4() { // Different case test
        Customer customer = new Adult("Bob", Customer.Gender.MALE);

        Product product1 = new AdultProduct(15, "Cheese Ball");
        Product product2 = new AdultProduct(1, " Cheese Candy");
        Product product3 = new GeneralProduct(5, "Cotton Candy");
        Product product4 = new GeneralProduct(5, "Cotton Ball");

        Store.getProducts().put(product4, 1);
        Store.getProducts().put(product1, 1);
        Store.getProducts().put(product2, 1);
        Store.getProducts().put(product3, 1);

        String keyword = "CHEESE";

        Set<Product> expected = new TreeSet<>();
        expected.add(product1);
        expected.add(product2);

        Set<Product> actual = customer.searchProducts(keyword);

        System.out.println(Store.getProducts());

        Assertions.assertEquals(expected, actual);
    }
}
