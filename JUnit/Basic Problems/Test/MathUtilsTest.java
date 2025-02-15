import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

    MathUtils mathUtils = new MathUtils();

    @Test
    void testDivide() {
        assertEquals(2, mathUtils.divide(6, 3));
        assertEquals(-2, mathUtils.divide(-6, 3));
        assertEquals(0, mathUtils.divide(0, 5));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> mathUtils.divide(5, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
