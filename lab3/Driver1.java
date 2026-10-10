class Card {

    private String rank;
    private String suit;

    Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    public boolean equals(Object ob) {

        if (this == ob)
            return true;

        if (!(ob instanceof Card))
            return false;

        Card c = (Card) ob;

        return rank.equals(c.rank) && suit.equals(c.suit);
    }

}

public class Driver1 {

    public static void main(String[] args) {

        Card[] table = new Card[5];

        Card[] cards = {
            new Card("Ace", "Spades"),
            new Card("King", "Hearts"),
            new Card("Queen", "Clubs"),
            new Card("Ace", "Spades"),
            new Card("Jack", "Diamonds")
        };

        boolean duplicateFound = false;

        for (int i = 0; i < cards.length; i++) {

            for (int j = 0; j < i; j++) {

                if (cards[i].equals(table[j]) && !duplicateFound) {
                    System.out.println("Duplicate found: " + cards[i]);
                    duplicateFound = true;
                }
            }

            table[i] = cards[i];
        }

        System.out.println("\nCards on Table:");

        for (Card c : table) {
            System.out.println(c);
        }
    }
}