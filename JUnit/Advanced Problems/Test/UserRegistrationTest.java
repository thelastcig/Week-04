import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserRegistrationTest {

    private final UserRegistration userRegistration = new UserRegistration();

    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> userRegistration.registerUser("Sonu Sharma", "sonu@example.com", "SecurePass1"));
    }

    @Test
    void testEmptyUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                userRegistration.registerUser("", "sonu@example.com", "SecurePass1"));
        assertEquals("Username cannot be empty.", exception.getMessage());
    }

    @Test
    void testNullUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                userRegistration.registerUser(null, "sonu@example.com", "SecurePass1"));
        assertEquals("Username cannot be empty.", exception.getMessage());
    }

    @Test
    void testInvalidEmailFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                userRegistration.registerUser("Sonu Sharma", "invalid-email", "SecurePass1"));
        assertEquals("Invalid email format.", exception.getMessage());
    }

    @Test
    void testNullEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                userRegistration.registerUser("Sonu Sharma", null, "SecurePass1"));
        assertEquals("Invalid email format.", exception.getMessage());
    }

    @Test
    void testShortPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                userRegistration.registerUser("Sonu Sharma", "sonu@example.com", "short"));
        assertEquals("Password must be at least 8 characters long.", exception.getMessage());
    }

    @Test
    void testNullPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                userRegistration.registerUser("Sonu Sharma", "sonu@example.com", null));
        assertEquals("Password must be at least 8 characters long.", exception.getMessage());
    }
}
