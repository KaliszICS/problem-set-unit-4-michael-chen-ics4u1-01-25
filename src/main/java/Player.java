import java.util.Arrays;

public class Player {
    /**
     * A class to define a player in a card game using name, age, and their hand of cards
     * @author Michael Chen
     * @version 1.0.0
     */
    private String name;
    private int age;
    private Card[] hand;

    /**
     * Constructor for a player, defining name, age, and a set of cards as hand
     * @param name Name of the player
     * @param age Age of the player
     * @param hand Hand of the player
     * @throws IllegalArgumentException When name is null or an empty string, or if age is less than 0
     */
    public Player(String name, int age, Card[] hand) throws IllegalArgumentException {
        if (name == null || name.strip().equals("")) {
            throw new IllegalArgumentException("Name must not be null or an empty string");
        }

        if (age < 0) {
            throw new IllegalArgumentException("Age must be greater than or equal to 0");
        }
        this.name = name;
        this.age = age;
        this.hand = hand;
    }

    /**
     * Constructor for a player, defining name, age, and defining a default hand of no cards
     * @param name Name of the player
     * @param age Age of the player
     * @throws IllegalArgumentException When name is null or an empty string, or if age is less than 0
     */
    public Player(String name, int age) throws IllegalArgumentException {
        if (name == null || name.strip().equals("")) {
            throw new IllegalArgumentException("Name must not be null or an empty string");
        }

        if (age < 0) {
            throw new IllegalArgumentException("Age must be greater than or equal to 0");
        }
        this.name = name;
        this.age = age;
        this.hand = new Card[]{};
    }

    /**
     * Gets the name of the player
     * @return Name of the player as a String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the age of the player
     * @return Age of the player as an int
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Gets the hand of the player
     * @return Hand of the player as an array of type Card
     */
    public Card[] getHand() {
        return this.hand;
    }

    /**
     * Method to find the size of the player's hand
     * @return The size of the player's hand as an int
     */
    public int size() {
        return this.hand.length;
    }

    /**
     * Method to draw a card from the top of the deck (the last element)
     * @param deck Deck to draw from
     * @throws NullPointerException If deck is empty
     */
    public void draw(Deck deck) throws NullPointerException {
        Card card = deck.draw();
        if (card == null) {
            throw new NullPointerException("Deck is empty; returned null");
        }
        Card[] hand = Arrays.copyOf(this.hand, this.hand.length + 1);
        hand[this.hand.length] = card;
        this.hand = hand;
    }

    /**
     * Discards a card from the hand to a DiscardPile
     * @param card Card to discard from hand
     * @param discardPile DiscardPile to discard to
     * @throws NullPointerException If card is not found in hand
     */
    public void discardCard(Card card, DiscardPile discardPile) throws NullPointerException {
        if (!Arrays.asList(hand).contains(card)) {
            throw new NullPointerException("Card not found in hand");
        }
        Card[] hand = new Card[this.hand.length - 1];
        for (int j = 0, k = 0; j < this.hand.length; j++) {
            if (this.hand[j] != card) {
                hand[k] = this.hand[j];
                k++;
            }
        }
        this.hand = hand;
        discardPile.addCard(card);
    }

    /**
     * Sends a card from the hand back to a Deck
     * @param card Card to return to deck
     * @param deck Deck to return card to
     * @return Returns true if card is found in hand, otherwise returns false
     */
    public boolean returnCard(Card card, Deck deck) {
        if (!Arrays.asList(hand).contains(card)) {
            return false;
        }
        Card[] hand = new Card[this.hand.length - 1];
        for (int j = 0, k = 0; j < this.hand.length; j++) {
            if (this.hand[j] != card) {
                hand[k] = this.hand[j];
                k++;
            }
        }
        this.hand = hand;
        deck.addCard(card);
        return true;
    }

    /**
     * Overrides toString() method to return player's hand
     * @return Returns player's hand seperated by commas and punctuated by a period as a String
     */
    @Override
    public String toString() {
        if (this.hand.length == 0) {
            return "";
        }
        String discard = this.hand[0].getName() + " of " + this.hand[0].getSuit();
        for (Card i : this.hand) {
            discard += ", " + i.getName() + " of " + i.getSuit();
        }

        return discard + ".";
    }
}