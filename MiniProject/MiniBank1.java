class Customer {

    private String name;
    private String email;
    private String mobile;
    private final String customerId;

    private static long customerCounter = 101;

    private static String generateCustomerId() {
        return "CUST" + customerCounter++;
    }

    Customer(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.customerId = generateCustomerId();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getCustomerId() {
        return customerId;
    }
}

class Account {

    private final String accountNumber;
    private String ownerName;
    private long balance;
    private boolean active;

    private static long accountCounter = 1;

    private static String generateAccountNumber() {

        if (accountCounter < 10)
            return "AC000" + accountCounter++;
        else if (accountCounter < 100)
            return "AC00" + accountCounter++;
        else if (accountCounter < 1000)
            return "AC0" + accountCounter++;
        else
            return "AC" + accountCounter++;
    }

    Account(String ownerName, long balance) {
        this.accountNumber = generateAccountNumber();
        this.ownerName = ownerName;
        this.balance = balance;
        this.active = true;
    }

    Account(String ownerName) {
        this(ownerName, 0);
    }

    public void deposit(long amount) {
        balance += amount;
    }

    public boolean withdraw(long amount) {

        if (balance >= amount) {
            balance -= amount;
            return true;
        }

        return false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }
}

public class MiniBank1 {

    public static void main(String[] args) {

        Account[] accounts = new Account[3];

        accounts[0] = new Account("Krishna", 5000);
        accounts[1] = new Account("Rahul");
        accounts[2] = new Account("Priya", 10000);

        accounts[0].deposit(1000);
        accounts[1].deposit(3000);

        accounts[2].withdraw(2500);
        accounts[1].withdraw(500);

        for (Account a : accounts) {
            System.out.println("----------------------------");
            System.out.println("Account Number : " + a.getAccountNumber());
            System.out.println("Owner Name     : " + a.getOwnerName());
            System.out.println("Balance        : " + a.getBalance());
            System.out.println("Active         : " + a.isActive());
        }
    }
}