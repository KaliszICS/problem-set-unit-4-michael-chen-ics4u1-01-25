public class Card {
    private int value;
    private String suit;
    private String name;

    public Card(String name, String suit, int value) {
        this.value = value;
        this.name = name;
        this.suit = suit;
    }

    public String getName() {
        return this.name;
    }

    public String getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.name + " of " + this.suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) {
            throw new IllegalArgumentException("Argument for equals() must be of type Card");
        }
        Card card = (Card) obj;
        return this.value == card.getValue() && this.name.equals(card.getName()) && this.suit.equals(card.getSuit());
    }

}
