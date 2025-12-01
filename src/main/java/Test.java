public class Test {
    public static void main(String[] args) {
        Card card = new Card("Frog", "Squares", 4);
        System.out.println();
        Deck deck = new Deck(null);
        deck.shuffle();
        DiscardPile discardPile = new DiscardPile();
        Player player = new Player("James", 8);
        deck.addCard(card);
        deck.shuffle();

        // for (int i = 0; i < 53; i++) {
        //     player.draw(deck);
        //     player.discardCard(player.getHand()[0], discardPile);
        // }

       for (int i = 0; i < 500; i++) {
        deck.shuffle();
       }
    }
}
