import org.example.GeneralProduct;
import org.example.RentedUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneralUtilityTest {

    // calculateReturnValue

    @Test
    public void testGeneralProduct() {
        GeneralProduct generalProduct = new GeneralProduct(15, "tool");

        Assertions.assertEquals(15, generalProduct.calculateReturnValue());
    }
}
