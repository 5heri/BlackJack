import java.util.ArrayList;
import java.util.Random;


public class Deck {
	
	private static final int NUMBER_OF_CARDS = 52;
	private static final int CARDS_FIRST_ITR = 13;
	private static final int CARDS_SECOND_ITR = 26;
	private static final int CARDS_THIRD_ITR = 39;
	
	private ArrayList<Card> deck;
	
	public Deck() {
		deck = new ArrayList<Card>();
		for (int i = 1; i <= NUMBER_OF_CARDS; i++) {
			if (i <= CARDS_FIRST_ITR) {
				deck.add(new Card(CardType.CLUBS, i));
			} else if (i <= CARDS_SECOND_ITR) {
				deck.add(new Card(CardType.DIAMONDS, i - CARDS_FIRST_ITR));
			} else if (i <= CARDS_THIRD_ITR) {
				deck.add(new Card(CardType.HEARTS, i - CARDS_SECOND_ITR));
			} else {
				deck.add(new Card(CardType.SPADES, i - CARDS_THIRD_ITR));
			}
		}
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
	public Card getRandomCardFromDeck() {
		Random rand = new Random();
		int random = rand.nextInt(deck.size() - 1);
		Card card = deck.remove(random);
		deck.trimToSize();
		return card;
	}

}
