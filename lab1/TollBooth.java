import java.util.Scanner;

record Vehicle(String type, String number) {}

public class TollBooth {
    public static void main(String[] args){

        int bike = 0, car = 0, truck = 0, totalToll = 0;

        Scanner sc = new Scanner(System.in);
        Vehicle []v = new Vehicle[10];
        // v[0] = new Vehicle("bike", "123");
        int i = 0;

        while(true){
            System.out.println("Please Enter Vehicle Type or Done to Exit: ");
            String type = sc.next().toLowerCase();

            if(type.equals("done"))
                break;
            
            System.out.println("Enter Your Vehicle Number");
            String number = sc.next().toLowerCase();

            v[i] = new Vehicle(type, number);

            int toll = switch(v[i].type()){
                case "bike" -> {
                    bike++;
                    yield 20;
                }

                case "car" -> {
                    car++;
                    yield 50;
                }

                case "truck" -> {
                    truck++;
                    yield 150;
                }

                default -> {
                    System.out.println("Invalid Vehicle Type");
                    yield 0;
                }
            };

            System.out.println(v[i].type() + " passed with toll:- " + toll);
            totalToll += toll;
            i++;
        }

        if(bike > car && bike > truck)
            System.out.println("Most Frequent:- Bike");
        else if(car > bike && car > truck)
             System.out.println("Most Frequent:- Car");
        else
            System.out.println("Most Frequent:- Truck");

        System.out.println(bike + " Bike(s) passed, " + car + " Car(s) passed and " + truck + " Truck(s) passed with Total Toll:- " + totalToll);
    }
}
