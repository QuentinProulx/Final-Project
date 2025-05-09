import org.example.GeneralProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneralProductTest {

    // calculateReturnValue

    @Test
    public void testGeneralProduct1() { // Unused test case
        GeneralProduct generalProduct = new GeneralProduct("tool", 15);

        Assertions.assertEquals(15, generalProduct.calculateReturnValue());
    }

    @Test
    public void testGeneralProduct2() { // Used test case
        GeneralProduct generalProduct = new GeneralProduct("tool", 15);

        generalProduct.useProduct();

        Assertions.assertEquals(0, generalProduct.calculateReturnValue());
    }

    // useProduct

    @Test
    public void testUseProduct() {
        GeneralProduct generalProduct = new GeneralProduct("tool", 15);

        generalProduct.useProduct();

        Assertions.assertTrue(generalProduct.isUsed());
    }

    // returnItem

    @Test
    public void testReturnItem() {

    }
}
