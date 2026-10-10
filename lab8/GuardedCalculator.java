import java.util.Scanner;

class DivideByZeroExpression extends Exception {
    DivideByZeroExpression(String message) {
        super(message);
    }
}

public class GuardedCalculator {
    public static void main(String[] args) {
        boolean success = false;
        int attempt = 0;
        Scanner sc = new Scanner(System.in);

        while (!success) {
            try {

                System.out.println("Enter Number 1:- ");
                double n1 = Double.parseDouble(sc.nextLine());
                System.out.println("Enter Operator:- ");
                String op = sc.nextLine().trim();
                System.out.println("Enter Number 2:- ");
                double n2 = Double.parseDouble(sc.nextLine());
                attempt++;

                if (n2 == 0 && op.equals("/")) {
                    throw new DivideByZeroExpression("Cann't divide by zero");
                }

                double result = 0;
                switch (op) {
                    case "+":
                        result = n1 + n2;
                        break;

                    case "-":
                        result = n1 - n2;
                        break;

                    case "*":
                        result = n1 * n2;
                        break;

                    case "/":
                        result = n1 / n2;
                        break;

                    default:
                        System.out.println("Invalid Operator Entered By user. Please enter a valid operator");
                        continue;
                }
                System.out.println("Result = " + result);
                success = true;
            } catch (DivideByZeroExpression de) {
                System.out.println(de);
            } catch (NumberFormatException ne) {
                System.out.println(ne);
            } finally {
                System.out.println("Attempts = " + attempt);
            }
        }
    }
}
