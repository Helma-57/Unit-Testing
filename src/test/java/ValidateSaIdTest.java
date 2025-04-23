import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateSaIdTest {
    @Test
    public void testValidIdNumbers() {
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086"));
        assertTrue(ValidateSaId.isIdNumberValid("2909035800085"));
    }

    @Test
    public void testInvalidLengthTooShort() {
        assertFalse(ValidateSaId.isIdNumberValid("20010148000"));
    }
    @Test
    public void testInvalidLengthTooLong() {
        assertFalse(ValidateSaId.isIdNumberValid("20010148000866"));
    }
    @Test
    public void testNonNumericCharacters() {
        assertFalse(ValidateSaId.isIdNumberValid("20010A4800086"));
    }
    @Test
    public void testInvalidDate() {
        assertFalse(ValidateSaId.isIdNumberValid("9913325800085"));
    }

    @Test
    public void testInvalidCitizenshipDigit() {
        assertFalse(ValidateSaId.isIdNumberValid("2001014800286"));
    }
