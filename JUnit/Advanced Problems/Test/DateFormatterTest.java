import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DateFormatterTest {

    @Test
    void testValidDateConversion() {
        assertEquals("15-02-2025", DateFormatter.formatDate("2025-02-15"), "Should convert yyyy-MM-dd to dd-MM-yyyy");
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"), "Should convert yyyy-MM-dd to dd-MM-yyyy");
    }

    @Test
    void testInvalidDateFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("15-02-2025"));
        assertEquals("Invalid date format. Expected yyyy-MM-dd.", exception.getMessage());
    }

    @Test
    void testNonDateString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("invalid-date"));
        assertEquals("Invalid date format. Expected yyyy-MM-dd.", exception.getMessage());
    }

    @Test
    void testEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate(""));
        assertEquals("Invalid date format. Expected yyyy-MM-dd.", exception.getMessage());
    }

    @Test
    void testNullInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate(null));
        assertEquals("Invalid date format. Expected yyyy-MM-dd.", exception.getMessage());
    }
}
