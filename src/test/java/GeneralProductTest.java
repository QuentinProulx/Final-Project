import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
    public void testReturnItem1() { // General Test Case
        int iterator = 0;
        while (new File("src/main/resources/" + iterator + ".csv").exists()) {
            new File("src/main/resources/" + iterator + ".csv").delete();
        }

        Adult adult = new Adult("Bob", Customer.Gender.MALE, 100);
        GeneralProduct generalProduct = new GeneralProduct("Popcorn", 15);
        AdultProduct adultProduct = new AdultProduct("Beer", 15);

        Store.setMoney(1000);
        Store.acquireItem(generalProduct);
        Store.acquireItem(adultProduct);

        adult.purchaseProduct(generalProduct);
        adult.purchaseProduct(adultProduct);

        try {
            Scanner scanner = new Scanner(new File("src/main/resources/0.csv"));
            Assertions.assertEquals(scanner.nextLine(), "Bob,");

            while (scanner.hasNextLine()) {
                Assertions.assertEquals(scanner.nextLine(), "Popcorn,22.5,0,");
                Assertions.assertEquals(scanner.nextLine(), "Beer,22.5,1,");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        generalProduct.returnItem();
    }

    @Test
    public void testReturnItem2() { // Null owner test case
        int iterator = 0;
        while (new File("src/main/resources/" + iterator + ".csv").exists()) {
            new File("src/main/resources/" + iterator + ".csv").delete();
        }

        GeneralProduct generalProduct = new GeneralProduct("Popcorn", 15);

        Assertions.assertThrows(NullPointerException.class, generalProduct::returnItem);
    }
}
