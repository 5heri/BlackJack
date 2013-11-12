import java.util.Scanner;


public class BlackJackGame {
	
	private Deck deck;
	private PlayerHand player;
	private PlayerHand theHouse;
	private boolean isPlayerOver;
	
	public BlackJackGame(Deck deck, PlayerHand player) {
		this.deck = deck;
		this.player = player;
		theHouse = new PlayerHand();
		isPlayerOver = false;
	}
	
	public void doTurn() {
		if (!isPlayerOver) {
			System.out.println("Your score:" + player.getScore());
			System.out.println("Hit?    1:Yes  0:No");
			Scanner in = new Scanner(System.in);
			int input = in.nextInt();
			if (input == 1) {
				player.add(deck.getRandomCardFromDeck());
			} else {
				isPlayerOver = true;
			}
		}
		if (theHouse.getScore() <= 15) {
			theHouse.add(deck.getRandomCardFromDeck());
		}
		if (player.hasBust()) {
			isPlayerOver = true;
			System.out.println("You have bust");
		}
	}
	
	public boolean isDraw() {
		return theHouse.hasBust() && player.hasBust() 
				|| theHouse.getScore() == player.getScore();
	}
	
	public boolean didPlayerWin() {
		return !player.hasBust() && player.getScore() > theHouse.getScore()
				|| player.getScore() <= 21 && theHouse.hasBust();
	}
	
	public boolean didHouseWin() {
		return !theHouse.hasBust() && theHouse.getScore() > player.getScore()
				|| theHouse.getScore() <= 21 && player.hasBust();
	}
	
	public boolean isOver() {
		return isPlayerOver && theHouse.getScore() > 15; 
	}
	
	public int getPlayerScore() {
		return player.getScore();
	}
	
	public int getHouseScore() {
		return theHouse.getScore();
	}
	
	public void display() {
		System.out.println();
		System.out.println("THE HOUSE:");
		theHouse.displayCardValues();
		System.out.println();
		System.out.println("THE PLAYER:");
		player.displayCardValues();
		System.out.println();
	}
	
}
