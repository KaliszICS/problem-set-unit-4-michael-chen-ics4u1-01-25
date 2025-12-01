public class DiscardPile {
    /**
     * Class to define a discard pile for cards
     * @author Michael Chen
     * @version 1.0.0
     */
    private Card[] discard;

    /**
     * Constructor for DiscardPile, takes an array of type Card and sets it as the discard pile
     * @param discard Array of cards
     */
    public DiscardPile(Card[] discard) {
        if (discard == null) {
            throw new NullPointerException("Discard pile cannot be null");
        }
        this.discard = discard;
    }

    /**
     * Constructor for DiscardPile, defaults an empty Card array as the DiscardPile
     */
    public DiscardPile() {
        this.discard = new Card[]{};
    }

    /**
     * Method to get the discard pile
     * @return Returns the discard pile as a Card array
     */
    public Card[] getDiscardPile() {
        return this.discard;
    }

    /**
     * Method to get the size of the discard pile
     * @return The length of the Card array representing the discard pile as an int
     */
    public int size() {
        return this.discard.length;
    }

    /**
     * Adds a card to the discard pile
     * @param card Card to add to the discard pile
     */
    public void addCard(Card card) throws NullPointerException {
        if (card == null) {
            throw new NullPointerException("Card cannot be null");
        }

        Card[] discard = new Card[this.discard.length + 1];
        for (int i = 0; i < this.discard.length; i++) {
            discard[i] = this.discard[i];
        }
        discard[this.discard.length] = card;
        this.discard = discard;
    }

    /**
     * Removes a card from the discard pile
     * @param card Card to find and remove from the discard pile
     * @return Returns the card removed from the discard pile if card is in the discard pile, otherwise return null
     */
    public Card removeCard(Card card) throws NullPointerException {
        if (card == null) {
            throw new NullPointerException("Card cannot be null");
        }

        for (int i = 0; i < this.discard.length; i++) {
            if (this.discard[i].equals(card)) {
                Card toDiscard = this.discard[i];
                Card[] discard = new Card[this.discard.length - 1];
                for (int j = 0, k = 0; j < this.discard.length; j++) {
                    if (this.discard[j] != this.discard[i]) {
                        discard[k] = this.discard[j];
                        k++;
                    }
                }
                this.discard = discard;
                return toDiscard;
            }
        }
        return null;
    }

    /**
     * Removes all cards from the discard pile
     * @return Returns all removed cards
     */
    public Card[] removeAll() {
        Card[] discard = this.discard;
        this.discard = new Card[]{};
        return discard;
    }

    /**
     * Overrides the toString() method
     * @return Returns the discard pile, concatenated with commas and punctuated with a period, as a String
     */
    @Override
    public String toString() {
        if (this.discard.length == 0) {
            return "";
        }
        String discard = this.discard[0].getName() + " of " + this.discard[0].getSuit();
        for (int i = 1; i < this.discard.length; i++) {
            discard += ", " + this.discard[i].getName() + " of " + this.discard[i].getSuit();
        }

        return discard + ".";
    }
}
