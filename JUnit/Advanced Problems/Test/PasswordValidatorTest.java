import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Secure123"), "Valid password should pass.");
    }

    @Test
    void testPasswordTooShort() {
        assertFalse(PasswordValidator.isValid("Short1"), "Password with less than 8 characters should fail.");
    }

    @Test
    void testPasswordWithoutUppercase() {
        assertFalse(PasswordValidator.isValid("secure123"), "Password without uppercase should fail.");
    }

    @Test
    void testPasswordWithoutDigit() {
        assertFalse(PasswordValidator.isValid("SecureOnly"), "Password without a digit should fail.");
    }

    @Test
    void testPasswordNull() {
        assertFalse(PasswordValidator.isValid(null), "Null password should fail.");
    }

    @Test
    void testPasswordWithOnlyNumbers() {
        assertFalse(PasswordValidator.isValid("12345678"), "Password with only numbers should fail.");
    }

    @Test
    void testPasswordWithOnlyUppercase() {
        assertFalse(PasswordValidator.isValid("SECUREPASS"), "Password with only uppercase letters should fail.");
    }
}
