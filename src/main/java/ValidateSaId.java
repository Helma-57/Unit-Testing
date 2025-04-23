
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

    private static boolean isValidLuhn(String idNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = idNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(idNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) n -= 9;
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

    private static LocalDate extractDate(String idNumber) {
        String yymmdd = idNumber.substring(0, 6);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        LocalDate parsed = LocalDate.parse(yymmdd, formatter);

        int currentYear = LocalDate.now().getYear();
        int twoDigitYear = Integer.parseInt(yymmdd.substring(0, 2));
        int fullYear;

        if (twoDigitYear > (currentYear % 100) + 10) {
            fullYear = 1900 + twoDigitYear;
        } else {
            fullYear = 2000 + twoDigitYear;
        }

        return parsed.withYear(fullYear);
    }
    private static String extractDateOfBirth(String idNumber) {
        return extractDate(idNumber).toString(); // yyyy-MM-dd
    }
    private static int calculateAge(String idNumber) {
        LocalDate birthDate = extractDate(idNumber);
        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today).getYears();
    }
    private static String extractGender(String idNumber) {
        int genderCode = Integer.parseInt(idNumber.substring(6, 10));
        return (genderCode >= 5000) ? "Male" : "Female";
    }

    private static String extractCitizenship(String idNumber) {
        return (idNumber.charAt(10) == '0') ? "SA Citizen" : "Permanent Resident";
    }


