import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class StoreTest {

    // acquireItem

    @Test
    public void testAcquireItem1() { // Null test case
        Product product = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Store.acquireItem(product);});
    }

    @Test
    public void testAcquireItem2() { // General test case
        Product product = new GeneralProduct("Ball", 15);
        Store.setMoney(15);

        boolean result = Store.acquireItem(product);

        Map<Product, Integer> map = new HashMap<>();
        map.put(product, 1);

        Assertions.assertTrue(result);
        Assertions.assertEquals(0, Store.getMoney());
        Assertions.assertEquals(map, Store.getProducts());
    }

    @Test
    public void testAcquireItem3() { // Product too expensive test case
        Product product = new GeneralProduct("Ball", 15);

        boolean result = Store.acquireItem(product);

        Assertions.assertFalse(result);
    }

    @Test
    public void testAcquireItem4() { // Amount out of bounds test case
        Product product = new GeneralProduct("Ball", 15);
        int amount = -5;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {Store.acquireItem(product, amount);});
    }

    // takeLoan

    @Test
    public void testTakeLoan1() { // Negative amount test case
        double amount = -1;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {Store.takeLoan(amount);});
    }

    @Test
    public void testTakeLoan2() { // General test case
        double amount = 100;

        boolean result = Store.takeLoan(amount);

        Assertions.assertTrue(result);
        Assertions.assertEquals(100, Store.getMoney());
        Assertions.assertEquals(100, Store.getDebt());
    }

    @Test
    public void testTakeLoan3() { // Amount above to 10000 test case
        double amount = 10001;

        boolean result = Store.takeLoan(amount);

        Assertions.assertFalse(result);
    }

    // payDebt

    @Test
    public void testPayDebt1() { // General test case
        Store.setMoney(200);
        Store.setDebt(100);

        double amount = 100;

        boolean result = Store.payDebt(amount);

        Assertions.assertTrue(result);
        Assertions.assertEquals(100, Store.getMoney());
        Assertions.assertEquals(0, Store.getDebt());
    }

    @Test
    public void testPayDebt2() { // Negative amount test case
        Store.setMoney(200);
        Store.setDebt(100);

        double amount = -100;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {Store.payDebt(amount);});
    }

    @Test
    public void testPayDebt3() { // Store money ends up negative test case
        Store.setMoney(200);
        Store.setDebt(400);

        double amount = 300;

        boolean result = Store.payDebt(amount);

        Assertions.assertFalse(result);
    }

    @Test
    public void testPayDebt4() { // Debt ends up negative test case
        Store.setMoney(200);
        Store.setDebt(100);
        double amount = 300;

        boolean result = Store.payDebt(amount);

        Assertions.assertFalse(result);
    }

    // hireEmployee

    @Test
    public void testHireEmployee1() { // General test case
        Customer customer = new Adult("Bob", Customer.Gender.MALE);

        Store.hireEmployee(customer);

        Assertions.assertTrue(customer.isEmployee());
    }

    @Test
    public void testHireEmployee2() { // Null test case
        Customer customer = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {Store.hireEmployee(customer);});
    }

    // fireEmployee

    @Test
    public void testFireEmployee1() { // General test case
        Customer customer = new Adult("Bob", Customer.Gender.MALE);
        customer.setEmployee(true);

        Store.fireEmployee(customer);

        Assertions.assertFalse(customer.isEmployee());
    }

    @Test
    public void testFireEmployee2() { // Null test case
        Customer customer = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {Store.fireEmployee(customer);});
    }

    // calculateAmountSpentPerYear

    @Test
    public void testCalculateAmountSpentPerYear() { // General test case
        RentedUtility rentedUtility1 = new RentedUtility("Tool1", 15);
        RentedUtility rentedUtility2 = new RentedUtility("Tool2", 15);
        RentedUtility rentedUtility3 = new RentedUtility("Tool3", 15);

        Store.getUtilities().put(rentedUtility1, 1);
        Store.getUtilities().put(rentedUtility2, 1);
        Store.getUtilities().put(rentedUtility3, 1);

        double expected = 45 * 12;

        Assertions.assertEquals(expected, Store.calculateAmountSpentPerYear());
    }
}
