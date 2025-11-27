public class Test {
    public static void main(String[] args) {
        Card card = new Card("Frog", "Squares", 4);
        Deck deck = new Deck();
        deck.shuffle();
        DiscardPile discardPile = new DiscardPile();
        Player player = new Player("James", 8);
        deck.addCard(card);
        deck.shuffle();

        for (int i = 0; i < 53; i++) {
            System.out.println(deck.draw());
        }
    }
}
