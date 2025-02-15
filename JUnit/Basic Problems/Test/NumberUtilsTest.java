import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class NumberUtilsTest {

    NumberUtils numberUtils = new NumberUtils();

    @Test
    void testIsEven_WithMultipleValues() {
        List<Integer> evenNumbers = Arrays.asList(2, 4, 6);
        List<Integer> oddNumbers = Arrays.asList(7, 9);

     
        for (int number : evenNumbers) {
            assertTrue(numberUtils.isEven(number), number + " should be even.");
        }

       
        for (int number : oddNumbers) {
            assertFalse(numberUtils.isEven(number), number + " should be odd.");
        }
    }
}
