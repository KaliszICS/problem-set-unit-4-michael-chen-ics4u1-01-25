import java.util.Random;

public class Deck {
    private Card[] deck;

    public Deck(Card[] deck) {
        this.deck = deck;
    }

    public Deck() {
        String[] suits = new String[]{"Hearts", "Clubs", "Diamonds", "Spades"};
        String[] names = new String[]{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        Card[] deck = new Card[52];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck[i * 13  + j] = new Card(names[j], suits[i], j + 1 + j * 4);
            }
        }
        this.deck = deck;
    }

    public int size() {
        return this.deck.length;
    }

    public Card draw() {
        Card top = deck[0];
        if (this.deck.length == 1) {
            this.deck[0] = null;
            return top;
        }
        Card[] deck = new Card[this.deck.length - 1];
        for (int i = 1; i < this.deck.length; i++) {
            deck[i - 1] = this.deck[i];
        }
        this.deck = deck;
        return top;
    }

    public void shuffle() {
        for (int i = 0; i < this.deck.length; i++) {
            Random random = new Random();
            int index = random.nextInt(i + 1);
            Card temp = this.deck[i];
            this.deck[i] = this.deck[index];
            this.deck[index] = temp;
        }
    }

    public void addCard(Card card) {
        Card[] deck = new Card[this.deck.length + 1];
        for (int i = 0; i < this.deck.length; i++) {
            deck[i] = this.deck[i];
        }
        deck[this.deck.length] = card;
        this.deck = deck;
    }

    public void reshuffle(Card[] cards) {
        for (Card i : cards) {
            addCard(i);
        }

        shuffle();
    }
}
