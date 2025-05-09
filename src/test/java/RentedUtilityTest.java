import org.example.RentedUtility;
import org.example.Store;
import org.example.Utility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class RentedUtilityTest {

    // calculateReturnValue

    @Test
    public void testRentedUtility() {
        RentedUtility rentedUtility = new RentedUtility("tool", 15);
        rentedUtility.setMonthsOwned(5);

        Assertions.assertEquals(5 * 15, rentedUtility.calculateReturnValue());
    }

    // returnItem

    @Test
    public void testReturnItem1() { // General test case
        RentedUtility rentedUtility = new RentedUtility("tool", 15);
        rentedUtility.setMonthsOwned(5);

        Store.setMoney(1000);
        Store.acquireItem(rentedUtility);

        rentedUtility.returnItem();

        Map<Utility, Integer> utilities = new HashMap<>();

        Assertions.assertEquals(utilities, Store.getUtilities());
    }
}
