public class SeatBooking {
    public static void main(String[] args) {
        Booking b = new Booking();
        Thread t1 = new Thread(b);
        Thread t2 = new Thread(b);
        Thread t3 = new Thread(b);
        Thread t4 = new Thread(b);
        Thread t5 = new Thread(b);
        Thread t6 = new Thread(b);
        Thread t7 = new Thread(b);
        Thread t8 = new Thread(b);
        Thread t9 = new Thread(b);
        Thread t10 = new Thread(b);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }
}

class Booking implements Runnable {
    int seats = 5;

    synchronized public void booked() {
        if (seats > 0) {
            seats--;
            System.out.println("Booked Successfully");
        }
        else{
            System.out.println("All seats are booking...No more booking available");
        }
    }

    public void run(){
        booked();
    }
}
