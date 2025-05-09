import org.example.RentedUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RentedUtilityTest {

    // calculateReturnValue

    @Test
    public void testRentedUtility() {
        RentedUtility rentedUtility = new RentedUtility("tool", 15);
        rentedUtility.setMonthsOwned(5);

        Assertions.assertEquals(5 * 15, rentedUtility.calculateReturnValue());
    }
}
