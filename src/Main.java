
public class Main {

	public static void main(String[] args) {

		PlayerHand player = new PlayerHand();
		Deck deck = new Deck();
		BlackJackGame game = new BlackJackGame(deck, player);

		while (!game.isOver()) {
			game.doTurn();
		}
		
		game.display();
		
		if (game.isDraw()) {
			System.out.println("DRAW");
		} else if (game.didPlayerWin()) {
			System.out.println("You WON");
		} else if (game.didHouseWin()) {
			System.out.println("You LOST");
		} else {
			System.out.println("ERROR");
		}
		
		System.out.println("Your Score: " + game.getPlayerScore());
		System.out.println("House Score: " + game.getHouseScore());
	}

}
