import java.util.regex.Pattern;


// Validator class
class Validator {

    public static boolean isValidMobile(String mobile) {
        Pattern pattern = Pattern.compile("^[0-9]{10}$");
        return pattern.matcher(mobile).matches();
    }

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$");
        return pattern.matcher(email).matches();
    }

    public static boolean isValidPan(String pan) {
        Pattern pattern = Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]$");
        return pattern.matcher(pan).matches();
    }

    public static boolean isValidIfsc(String ifsc) {
        Pattern pattern = Pattern.compile("^[A-Z]{4}0[A-Z0-9]{6}$");
        return pattern.matcher(ifsc).matches();
    }
}


// TransactionType enum
enum TransactionType {
    DEPOSIT,
    WITHDRAW,
    TRANSFER
}


// Command record
record Command(TransactionType type, String accountNumber, long amount) {
}


// CommandParser class
class CommandParser {

    public static Command parse(String line) {

        String[] parts = line.split(" ");

        TransactionType type = TransactionType.valueOf(parts[0]);
        String accountNumber = parts[1];
        long amount = Long.parseLong(parts[2]);

        return new Command(type, accountNumber, amount);
    }
}


// StatementFormatter class
class MiniBank3 {

    public static String buildStatement(Account account) {    

        StringBuilder statement = new StringBuilder();

        statement.append("----- Account Statement -----\n");
        statement.append("Account Number : ");
        statement.append(account.getAccountNumber());
        statement.append("\n");

        statement.append("Owner Name     : ");
        statement.append(account.getOwnerName());
        statement.append("\n");

        statement.append("Balance        : ");
        statement.append(account.getBalance());
        statement.append("\n");

        statement.append("Active         : ");
        statement.append(account.isActive());
        statement.append("\n");

        return statement.toString();
    }
}


// Main class
public class MiniBank1 {

    public static void main(String[] args) {

        // Mobile validation
        System.out.println("----- Mobile Validation -----");

        System.out.println("9876543210 : "
                + Validator.isValidMobile("9876543210"));

        System.out.println("98765 : "
                + Validator.isValidMobile("98765"));


        // Email validation
        System.out.println("\n----- Email Validation -----");

        System.out.println("krishna@gmail.com : "
                + Validator.isValidEmail("krishna@gmail.com"));

        System.out.println("krishna@gmail : "
                + Validator.isValidEmail("krishna@gmail"));


        // PAN validation
        System.out.println("\n----- PAN Validation -----");

        System.out.println("ABCDE1234F : "
                + Validator.isValidPan("ABCDE1234F"));

        System.out.println("ABC1234 : "
                + Validator.isValidPan("ABC1234"));


        // IFSC validation
        System.out.println("\n----- IFSC Validation -----");

        System.out.println("SBIN0001234 : "
                + Validator.isValidIfsc("SBIN0001234"));

        System.out.println("SBIN123 : "
                + Validator.isValidIfsc("SBIN123"));


        // Command parsing
        System.out.println("\n----- Command Parsing -----");

        String line = "DEPOSIT AC0001 500";

        Command command = CommandParser.parse(line);

        System.out.println("Type          : " + command.type());
        System.out.println("Account Number: " + command.accountNumber());
        System.out.println("Amount        : " + command.amount());


        // Account and StatementFormatter
        System.out.println("\n----- Statement -----");

        Account account = new Account("Krishna", 5000);

        System.out.println(
                StatementFormatter.buildStatement(account)
        );
    }
}