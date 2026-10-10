abstract class Media {

    protected String title;
    protected int lateDays;

    Media(String title, int lateDays) {
        this.title = title;
        this.lateDays = lateDays;
    }

    abstract double calculateLateFee();

    void displayFee() {
        System.out.println(title + " -> Late fee: ₹" + calculateLateFee());
    }
}

// DVD: ₹5 per late day
class DVD extends Media {

    DVD(String title, int lateDays) {                        
        super(title, lateDays);
    }

    @Override
    double calculateLateFee() {
        return lateDays * 5;
    }
}

// Book: ₹2 per late day
class Book extends Media {

    Book(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    double calculateLateFee() {
        return lateDays * 2;
    }
}

// Magazine: ₹3 per late day
class Magazine extends Media {

    Magazine(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    double calculateLateFee() {
        return lateDays * 3;
    }
}

public class MediaFee {

    public static void main(String[] args) {

        Media[] returnedBatch = {
                new DVD("Avengers DVD", 3),
                new Book("Java Programming", 5),
                new Magazine("Tech Today", 2)
        };

        double totalFee = 0;

        for (Media media : returnedBatch) {
            media.displayFee();
            totalFee += media.calculateLateFee();
        }

        System.out.println("--------------------");
        System.out.println("Total late fee: ₹" + totalFee);
    }
}