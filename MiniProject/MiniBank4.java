// Abstract Account class
abstract class Account {

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

        if (canWithdraw(amount)) {
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

    // Abstract methods
    public abstract double interestRate();

    public abstract boolean canWithdraw(long amount);

    // toString from previous practical
    public String toString() {
        return "Account Number: " + accountNumber
                + ", Owner Name: " + ownerName
                + ", Balance: " + balance;
    }
}


// Savings Account
class SavingsAccount extends Account {

    private long minBalance;

    SavingsAccount(String ownerName, long balance, long minBalance) {
        super(ownerName, balance);
        this.minBalance = minBalance;
    }

    public double interestRate() {
        return 4.0;
    }

    public boolean canWithdraw(long amount) {

        if (getBalance() - amount >= minBalance) {
            return true;
        }

        return false;
    }

    public long getMinBalance() {
        return minBalance;
    }
}


// Current Account
class CurrentAccount extends Account {

    private long overdraftLimit;

    CurrentAccount(String ownerName, long balance, long overdraftLimit) {
        super(ownerName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double interestRate() {
        return 0;
    }

    public boolean canWithdraw(long amount) {

        if (getBalance() - amount >= -overdraftLimit) {
            return true;
        }

        return false;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }
}


// Fixed Deposit Account
class FixedDepositAccount extends Account {

    FixedDepositAccount(String ownerName, long balance) {
        super(ownerName, balance);
    }

    public double interestRate() {
        return 7.0;
    }

    public boolean canWithdraw(long amount) {
        return false;
    }
}


// Main class
public class MiniBank4 {

    public static void main(String[] args) {

        // Creating different types of accounts
        Account[] accounts = new Account[3];

        accounts[0] = new SavingsAccount(
                "Krishna", 10000, 5000
        );

        accounts[1] = new CurrentAccount(
                "Rahul", 5000, 3000
        );

        accounts[2] = new FixedDepositAccount(
                "Priya", 20000
        );


        // Runtime polymorphism
        System.out.println("----- Account Details -----");

        for (Account account : accounts) {

            System.out.println(account);
            System.out.println("Interest Rate: "
                    + account.interestRate());

            System.out.println();
        }


        // Testing withdrawal
        System.out.println("----- Withdrawal Test -----");

        boolean result1 = accounts[0].withdraw(6000);

        if (result1) {
            System.out.println("Savings withdrawal successful");
        } else {
            System.out.println("Savings withdrawal failed");
        }


        boolean result2 = accounts[1].withdraw(7000);

        if (result2) {
            System.out.println("Current withdrawal successful");
        } else {
            System.out.println("Current withdrawal failed");
        }


        boolean result3 = accounts[2].withdraw(5000);

        if (result3) {
            System.out.println("Fixed Deposit withdrawal successful");
        } else {
            System.out.println("Fixed Deposit withdrawal failed");
        }


        // Pattern instanceof check
        System.out.println("\n----- instanceof Check -----");

        if (accounts[0] instanceof SavingsAccount savings) {

            System.out.println("This is a Savings Account.");
            System.out.println("Minimum Balance: "
                    + savings.getMinBalance());
        }
    }
}