import java.util.Random;
import java.util.Arrays;

public class Deck {
    /**
     * Class to define a deck of cards
     * @author Michael Chen
     * @version 1.0.0
     */
    private Card[] deck;

    /**
     * Constructor to build a deck given an array of type Card
     * @param deck Card array to build deck with
     */
    public Deck(Card[] deck) {
        if (deck == null) {
            throw new NullPointerException("Deck cannot be null");
        }
        this.deck = deck;
    }

    /**
     * Constructor to build a default deck. Ace to King, with suits in order of Hearts, Clubs, Diamonds, Spades. Values set in chronological order from 1-52
     */
    public Deck() {
        String[] suits = new String[]{"Hearts", "Clubs", "Diamonds", "Spades"};
        String[] names = new String[]{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        Card[] deck = new Card[52];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck[i * 13  + j] = new Card(names[j], suits[i], i * 13  + j);
            }
        }
        this.deck = deck;
    }

    /**
     * Method to get the size of the deck
     * @return The size of the deck as an int
     */
    public int size() {
        return this.deck.length;
    }

    /**
     * Method to draw the top card from the deck. The top card is the last element of the array and is returned and removed from the deck
     * @return Returns card that was drawn; If array is empty returns null.
     */
    public Card draw() {
        if (this.deck.length == 0) {
            return null;
        }
        Card top = this.deck[this.deck.length - 1];
        Card[] deck = new Card[this.deck.length - 1];
        for (int i = 0; i < this.deck.length - 1; i++) {
            deck[i] = this.deck[i];
        }
        this.deck = deck;
        return top;
    }

    /**
     * Shuffles the deck
     */
    public void shuffle() {
        for (int i = 0; i < this.deck.length; i++) {
            Random random = new Random();
            int index = random.nextInt(i + 1);
            Card temp = this.deck[i];
            this.deck[i] = this.deck[index];
            this.deck[index] = temp;
        }
    }

    /**
     * Adds a card to the deck
     * @param card Card to add to the deck, adds the card to the end of the Card array
     */
    public void addCard(Card card) throws NullPointerException {
        if (card == null) {
            throw new NullPointerException("Card cannot be null");
        }
        Card[] deck = Arrays.copyOf(this.deck, this.deck.length + 1);
        deck[this.deck.length] = card;
        this.deck = deck;
    }

    /**
     * Adds all cards provided into the deck and shuffles the deck
     * @param cards Array of type Card to add to the deck
     */
    public void reshuffle(Card[] cards) {
        for (Card i : cards) {
            addCard(i);
        }

        shuffle();
    }
}
