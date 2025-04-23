
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ValidateSaId {

    public static boolean isIdNumberValid(String idNumber) {
        return isProperLengthAndDigits(idNumber)
                && isValidDate(idNumber.substring(0, 6))
                && isValidCitizenship(idNumber.charAt(10))
                && isValidLuhn(idNumber);
    }

