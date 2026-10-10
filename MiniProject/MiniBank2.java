class Customer1 {

    private String name;
    private String email;
    private String mobile;
    private final String CustomerId;

    private static long Customer1Counter = 101;

    private static String generateCustomerId() {
        return "CUST" + Customer1Counter++;
    }

    Customer1(String name, String email, String mobile) {   
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.CustomerId = generateCustomerId();
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
        return CustomerId;
    }

    // Nested Address class
    public static class Address {

        private String line;
        private String city;
        private String pincode;

        public Address(String line, String city, String pincode) {
            this.line = line;
            this.city = city;
            this.pincode = pincode;
        }

        public String getLine() {
            return line;
        }

        public String getCity() {
            return city;
        }

        public String getPincode() {
            return pincode;
        }
    }

    private Address address;

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}


class Account1 {

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

    Account1(String ownerName, long balance) {
        this.accountNumber = generateAccountNumber();
        this.ownerName = ownerName;
        this.balance = balance;
        this.active = true;
    }

    Account1(String ownerName) {
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

    // toString method
    public String toString() {
        return "Account Number: " + accountNumber
                + ", Owner Name: " + ownerName
                + ", Balance: " + balance;
    }

    // equals method
    public boolean equals(Object o) {

        if (o instanceof Account) {

            Account other = (Account) o;

            if (accountNumber.equals(other.accountNumber)) {
                return true;
            }
        }

        return false;
    }
}


public class MiniBank2 {

    public static void main(String[] args) {

        // Creating three accounts
        Account1[] accounts = new Account1[3];

        accounts[0] = new Account1("Krishna", 5000);
        accounts[1] = new Account1("Rahul");
        accounts[2] = new Account1("Priya", 10000);

        // Deposits and withdrawals
        accounts[0].deposit(1000);
        accounts[1].deposit(3000);
        accounts[2].withdraw(2500);
        accounts[1].withdraw(500);

        // Printing accounts using toString()
        System.out.println("----- Account Details -----");

        for (Account a : accounts) {
            System.out.println(a.toString());
        }

        // Comparing two accounts
        System.out.println("\n----- Account Comparison -----");

        if (accounts[0].equals(accounts[1])) {
            System.out.println("Account 1 and Account 2 are equal.");
        } else {
            System.out.println("Account 1 and Account 2 are not equal.");
        }

        // instanceof check
        System.out.println("\n----- instanceof Check -----");

        if (accounts[0] instanceof Account1) {
            System.out.println("accounts[0] is an Account object.");
        }

        // Creating Customer1
        Customer1 Customer1 = new Customer1(
                "Krishna",
                "krishna@gmail.com",
                "9876543210"
        );

        // Creating Address
        Customer1.Address address = new Customer1.Address(
                "123 Main Road",
                "Rajkot",
                "360001"
        );

        Customer1.setAddress(address);

        // Printing Customer1 and address
        System.out.println("\n----- Customer1 Details -----");
        System.out.println("Customer1 ID : " + Customer1.getCustomerId());
        System.out.println("Name        : " + Customer1.getName());
        System.out.println("Email       : " + Customer1.getEmail());
        System.out.println("Mobile      : " + Customer1.getMobile());

        System.out.println("Address     : " + Customer1.getAddress().getLine());
        System.out.println("City        : " + Customer1.getAddress().getCity());
        System.out.println("Pincode     : " + Customer1.getAddress().getPincode());
    }
}