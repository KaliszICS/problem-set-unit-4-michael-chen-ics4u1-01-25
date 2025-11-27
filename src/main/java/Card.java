public class Card {
    /**
     * Class that defines a card with name, suit, and value
     * @author Michael Chen
     * @version 1.0.0
     */
    private int value;
    private String suit;
    private String name;

    /**
     * Constructor for Card class
     * @param name Name of the card
     * @param suit Suit of the card
     * @param value Value of the card
     * @throws IllegalArgumentException If name or suit is null or an empty string, or if age is less than 0
     */
    public Card(String name, String suit, int value) throws IllegalArgumentException {
        if (name == null || suit == null || name.strip().equals("") || suit.strip().equals("")) {
            throw new IllegalArgumentException("Name and suit must not be null or empty strings");
        }

        if (value < 0) {
            throw new IllegalArgumentException("Value must be greater than or equal to 0");
        }
        this.value = value;
        this.name = name;
        this.suit = suit;
    }

    /**
     * Method to get the name of the card
     * @return The name of the card as a String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method to get the sit of the card
     * @return The suit of the card as a String
     */
    public String getSuit() {
        return this.suit;
    }

    /**
     * Method to get the value of a card
     * @return The value of a card as an int
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Overrides the toString() method
     * @return Returns the name of the card and the suit of the card with "of" in between
     */
    @Override
    public String toString() {
        return this.name + " of " + this.suit;
    }

    /**
     * Overrides the equals() method
     * @param obj Object passed to equals to compare to the card
     * @return Returns true if name, suit, and value are equal, otherwise false 
     * @throws IllegalArgumentException If obj is not of type Card
     */
    @Override
    public boolean equals(Object obj) throws IllegalArgumentException {
        if (!(obj instanceof Card)) {
            throw new IllegalArgumentException("Argument for equals() must be of type Card");
        }
        Card card = (Card) obj;
        return this.value == card.getValue() && this.name.equals(card.getName()) && this.suit.equals(card.getSuit());
    }

}
