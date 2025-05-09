import org.example.GeneralProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneralUtilityTest {

    // calculateReturnValue

    @Test
    public void testGeneralProduct() {
        GeneralProduct generalProduct = new GeneralProduct("tool", 15);

        Assertions.assertEquals(15, generalProduct.calculateReturnValue());
    }
}
