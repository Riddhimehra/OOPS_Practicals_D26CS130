import java.util.Scanner;

public class VendingMachine{
    public static void main(String[] args) {
        enum Coin{ONE, TWO, FIVE, TEN}
        final int PRICE = 15;
        int total = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Coin from ONE, TWO, FIVE, TEN...");

        while (total < PRICE) {
            System.out.print("Coin:- ");
            String input = sc.next().toUpperCase();

            Coin coin = null;

            try{
                coin = Coin.valueOf(input);
            }
            catch(Exception e){
                System.out.println("Invaild Input!!! Please try again");
                continue;
            }

            int value = 0;
            switch (coin) {
                case ONE:
                    value = 1;
                    break;
                
                case TWO:
                    value = 2;
                    break;

                case FIVE:
                    value = 5;
                    break;

                case TEN:
                    value = 10;
                    break;
            }

            total += value;
            System.out.println("Your total is:- " + total);
            
        }
        System.out.println("Your change is:- " + (total-PRICE));
        sc.close();
    }
}