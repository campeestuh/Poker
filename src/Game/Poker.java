package Game;

import DeckofCards.Card;
import DeckofCards.Deck;
import People.Player;
import App.GUI;

public class Poker {

	private Player currPlayer;
	private Player daddyDealer;
	private Integer Buyin;

	GUI newGUI;

	// 10 Basic ways to win poker
	// High Card
	// Pair of cards
	// Three of a kind (4Clubs 4Hearts 4Spades)
	// Straight (5 cards in sequential order no matter the suit) (3,4,5,6,7)
	// Flush (When a player has 5 cards of the same suit in any order)
	// Full House (When a player has a pair and three of a kind)
	// Four of a kind (When a player has the same rank for all dour suits) (4Hearts,
	// 4Diamonds, 4Clubs, 4Spades)
	// Straight Flush (Have 5 cards in sequential order of the same suit)
	// Royal Flush (Hand contains: 10, Jack , Queen, King, Ace)

	public Poker() {
		beginGame();
	}

	public void beginGame() {
		// initialize
		currPlayer = new Player();
		daddyDealer = new Player();
		Deck deck = new Deck();

		setBuyIn(100);
		deck.initDeck();
		deck.shuffle();

		// Giving 5 cards to player
		for (int i = 0; i < 5; i++) {
			Card card = deck.dealCard();
			if (card != null) {
				currPlayer.addCard(card);

			} else {
				System.out.println("No cards left in the deck.");
				break;
			}
		}

		// Giving 5 cards to the dealer
		for (int i = 0; i < 5; i++) {
			Card card = deck.dealCard();
			if (card != null) {
				daddyDealer.addCard(card);

			} else {
				System.out.println("No cards left in the deck.");
				break;
			}
		}

		newGUI = new GUI();

	}

	public Integer getBuyIn() {
		return Buyin;
	}

	public void setBuyIn(Integer buyin) {
		Buyin = buyin;
	}

	public Player getPlayer() {
		return currPlayer;
	}

	public Player getDealer() {
		return daddyDealer;
	}

}
