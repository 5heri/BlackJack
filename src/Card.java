
public class Card {
	
	private CardType type;
	private int value;
	
	public Card(CardType type, int value) {
		this.type = type;
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public CardType getType() {
		return type;
	}
	
	public boolean isAce() {
		return value == 1;
	}
	
	public void setValue(int newValue) {
		value = newValue;
	}

}
