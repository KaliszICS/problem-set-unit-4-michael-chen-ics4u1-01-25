import java.util.Scanner;

public class HighCard {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Scanner s = new Scanner(System.in);
        System.out.print("Enter your name player 1: ");
        String name1 = s.nextLine();
        System.out.print("Enter your name player 2: ");
        String name2 = s.nextLine();
        s.close();
        Player player1 = new Player(name1, 0);
        Player player2 = new Player(name2, 0);

        for (int i = 0; i < 5; i++) {
            player1.draw(deck);
            player2.draw(deck);
        }

        int p1Points = 0;
        int p2Points = 0;
        for (int i = 5; i > 0; i--) {
            int p1Highest = 0;
            Card p1High = player1.getHand()[0];
            Card p2High = player2.getHand()[0];
            int p2Highest = 0;
            for (int j = 0; j < i - 1; j++) {
                if (player1.getHand()[j].getValue() > p1Highest) {
                    p1Highest = player1.getHand()[j].getValue();
                    p1High = player1.getHand()[j];
                }
                if (player2.getHand()[j].getValue() > p2Highest) {
                    p2Highest = player2.getHand()[j].getValue();
                    p2High = player2.getHand()[j];
                }
            }
            System.out.println("---------------------------------");
            System.out.println(name1 + "'s highest card is " + p1High.toString());
            System.out.println(name2 + "'s highest card is " + p2High.toString());
            if (p1Highest > p2Highest) {
                p1Points++;
            } else {
                p2Points++;
            }
            player1.discardCard(p1High, new DiscardPile());
            player2.discardCard(p2High, new DiscardPile());
        }

        if (p1Points > p2Points) {
            System.out.println(name1 + " wins!");
        } else {
            System.out.println(name2 + " wins!");
        }
    }
}
