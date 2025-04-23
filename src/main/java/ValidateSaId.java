
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

    private static boolean isProperLengthAndDigits(String idNumber) {
        return idNumber != null && idNumber.length() == 13 && idNumber.matches("\\d{13}");
    }

    private static boolean isValidDate(String yymmdd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        try {
            LocalDate.parse(yymmdd, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    private static boolean isValidCitizenship(char digit) {
        return digit == '0' || digit == '1';
    }


