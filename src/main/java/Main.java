public class Main {
    public static void main(String[] args) {
        String testId = "2001014800086"; // Valid ID
        boolean isValid = ValidateSaId.isIdNumberValid(testId);
        System.out.println("ID Number " + testId + " is valid: " + isValid);
    }
}