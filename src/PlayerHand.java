import java.util.ArrayList;

public class PlayerHand {
	
	private static final int ACE_LOW = 1;
	private static final int ACE_HIGH = 11;
	private static final int BLACKJACK = 21;

	private ArrayList<Card> cards;
	private int score;
	
	public PlayerHand() {
		cards = new ArrayList<Card>();
		score = 0;
	}
	
	public boolean hasBust() {
		return getScore() > BLACKJACK;
	}
	
	public int getScore() {
		return score;
	}
	
	public void add(Card card) {
		if (card.isAce()) {
			int currentScore = score;
			if (currentScore + ACE_HIGH > BLACKJACK) {
				card.setValue(ACE_LOW);
			}
		}
		score += card.getValue();
		cards.add(card);
	}
	
	public void displayCardValues() {
		for (Card card : cards) {
			if (card.isAce()) {
				System.out.println(card.getType().toString() + " ACE");
			} else if (card.getValue() == 11) {
				System.out.println(card.getType().toString() + " JACK");
			} else if (card.getValue() == 12) {
				System.out.println(card.getType().toString() + " QUEEN");
			} else if (card.getValue() == 13) {
				System.out.println(card.getType().toString() + " KING");
			} else {
				System.out.println(card.getType().toString() + " " + card.getValue());
			}
			
		}
	}
}
