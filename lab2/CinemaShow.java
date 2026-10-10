public class CinemaShow {

    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    CinemaShow(String title) {
        this(title, 100);
    }

    boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        }
        return false;
    }

    void cancel(int n) {

        int booked = capacity - seatsAvailable;
    
        if (n > booked) {
            n = booked;
        }
    
        seatsAvailable += n;
        totalBooked -= n;
    }

    int getSeatsAvailable() {
        return seatsAvailable;
    }

    static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {

        CinemaShow show = new CinemaShow("Avengers", 50);

        System.out.println("Available Seats: " + show.getSeatsAvailable());

        System.out.println("\nBooking 20 seats: " + show.book(20));
        System.out.println("Available Seats: " + show.getSeatsAvailable());

        System.out.println("\nBooking 25 seats: " + show.book(25));
        System.out.println("Available Seats: " + show.getSeatsAvailable());

        System.out.println("\nBooking 10 seats: " + show.book(10));
        System.out.println("Available Seats: " + show.getSeatsAvailable());

        System.out.println("\nCancel 5 seats");
        show.cancel(5);
        System.out.println("Available Seats: " + show.getSeatsAvailable());

        System.out.println("\nBooking 8 seats: " + show.book(8));
        System.out.println("Available Seats: " + show.getSeatsAvailable());

        System.out.println("\nCurrently Booked Seats: " + CinemaShow.getTotalBooked());
        System.out.println("Available Seats: " + show.getSeatsAvailable());
    }
}