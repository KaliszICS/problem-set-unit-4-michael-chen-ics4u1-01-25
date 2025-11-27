public class DiscardPile {
    private Card[] discard;

    public DiscardPile(Card[] discard) {
        this.discard = discard;
    }

    public DiscardPile() {
        this.discard = new Card[]{};
    }

    public Card[] getDiscardPile() {
        return this.discard;
    }

    public int size() {
        return this.discard.length;
    }

    public void addCard(Card card) {
        Card[] discard = new Card[this.discard.length + 1];
        for (int i = 0; i < this.discard.length; i++) {
            discard[i] = this.discard[i];
        }
        discard[this.discard.length] = card;
        this.discard = discard;
    }

    public Card removeCard(Card card) {
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

    public Card[] removeAll() {
        Card[] discard = this.discard;
        this.discard = new Card[]{};
        return discard;
    }

    @Override
    public String toString() {
        if (this.discard.length == 0) {
            return "";
        }
        String discard = this.discard[0].getName() + " of " + this.discard[0].getSuit();
        for (Card i : this.discard) {
            discard += ", " + i.getName() + " of " + i.getSuit();
        }

        return discard + ".";
    }
}
