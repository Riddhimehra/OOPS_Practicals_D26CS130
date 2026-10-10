import java.util.Scanner;

record BankInfo(String name, String branch) {
}

class MiniBank {
    public static void main(String[] args) {
        enum MenuOption {
            OPEN_ACCOUNT, DEPOSIT, WITHDRAW, TRANSFER, EXIT
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "Enter Your Choice From the Below Choices:- \n 1. Open Account \n 2. Deposit \n 3. Withdraw \n 4. Transfer \n 5. Exit");

            int choice = sc.nextInt();

            if(choice == 5){
                System.out.println("Thank You!!");
                break;
            }

            switch(choice){
                case 1: 
                    System.out.println("Open Account - to be implemented in a later lab");
                    break;
                case 2:
                    System.out.println("Deposit - to be implemented in a later lab");
                    break;

                case 3:
                    System.out.println("Withdraw - to be implemented in a later lab");
                    break;

                case 4:
                    System.out.println("Transfer - to be implemented in a later lab");
                    break;

                default:
                    System.out.println("Please Enter A Valid Choice");
            }
        }
    }
}
