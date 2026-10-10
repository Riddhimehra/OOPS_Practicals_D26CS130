public class PasswordChecker {

    // Rule 1: Length >= 8
    public static boolean hasValidLength(String pw) {
        return pw.length() >= 8;
    }

    // Rule 2: Contains uppercase letter
    public static boolean hasUppercase(String pw) {
        return pw.matches(".*[A-Z].*");
    }

    // Rule 3: Contains digit
    public static boolean hasDigit(String pw) {
        return pw.matches(".*[0-9].*");
    }

    // Rule 4: Contains special character
    public static boolean hasSpecialCharacter(String pw) {
        return pw.matches(".*[^a-zA-Z0-9].*");
    }

    // Calculate password strength
    public static String strength(String pw) {
        int count = 0;

        if (hasValidLength(pw))
            count++;

        if (hasUppercase(pw))
            count++;

        if (hasDigit(pw))
            count++;

        if (hasSpecialCharacter(pw))
            count++;

        if (count <= 1)
            return "Weak";
        else if (count <= 3)
            return "Medium";
        else
            return "Strong";
    }

    public static void main(String[] args) {

        String[] passwords = {
                "abc",
                "abcdefgh",
                "Abcdefgh",
                "Abcd1234",
                "Abcd1234!"
        };

        for (String pw : passwords) {

            System.out.println("Password: " + pw);

            System.out.println("Length >= 8: " +
                    (hasValidLength(pw) ? "Passed" : "Failed"));

            System.out.println("Uppercase letter: " +
                    (hasUppercase(pw) ? "Passed" : "Failed"));

            System.out.println("Digit: " +
                    (hasDigit(pw) ? "Passed" : "Failed"));

            System.out.println("Special character: " +
                    (hasSpecialCharacter(pw) ? "Passed" : "Failed"));

            System.out.println("Strength: " + strength(pw));
            System.out.println("-------------------------");
        }
    }
}