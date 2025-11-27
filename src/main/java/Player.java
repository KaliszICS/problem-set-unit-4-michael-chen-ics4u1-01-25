import java.util.Arrays;

public class Player {
    private String name;
    private int age;
    private Card[] hand;

    public Player(String name, int age, Card[] hand) {
        this.name = name;
        this.age = age;
        this.hand = hand;
    }

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.hand = new Card[]{};
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public Card[] getHand() {
        return this.hand;
    }

    public int size() {
        return this.hand.length;
    }

    public void draw(Deck deck) {
        Card card = deck.draw();
        Card[] hand = Arrays.copyOf(this.hand, this.hand.length + 1);
        hand[this.hand.length] = card;
        this.hand = hand;
    }

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