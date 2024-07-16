package Driver;

import java.util.ArrayList;
import App.GUI;
import DeckofCards.Card;
import DeckofCards.Deck;
import Game.Poker;
import People.Player;

// help.exe

public class Driver {

	public static void main(String[] args) {

		/* Initialize System */

		GUI newGUI;

		Deck deck = new Deck();
		// Creates instantances of player and Dealer
		Player player = new Player();
		Player dealer = new Player();
		player.setName("Juan");
		dealer.setName("Dealer");
		// Adding players to a list
		ArrayList<Player> players = new ArrayList<>();
		players.add(dealer);
		players.add(player);

		// Printing list of player
		System.out.println("Players:");
		for (Player p : players) {
			System.out.println(p.getName());
		}

		player.buyIn(0);
		player.buyIn(25);
		////////////////////////////////////////////////////////////
		// Deck Functionality
		// Building beck method
		System.out.println("Initial deck:");
		deck.initDeck();
		System.out.println("Cards Remainig Cards: " + deck.size());
		System.out.println("\n-------------------------------------\n");
		// Shuffling the deck
		System.out.println("\nShuffling deck...");
		deck.shuffle();
		System.out.println("\n-------------------------------------\n");
		// Shuffle deck twice to verify shuffle is working
		System.out.println("\nShuffled deck:");
		deck.shuffle();
		System.out.println("\n\n");
		////////////////////////////////////////////////////////////
		// Creatig hands to dealer
		// Giving 5 cards to player
		for (int i = 0; i < 5; i++) {
			Card card = deck.dealCard();
			if (card != null) {
				player.addCard(card);

			} else {
				System.out.println("No cards left in the deck.");
				break;
			}
		}

		// Giving 5 cards to the dealer
		for (int i = 0; i < 5; i++) {
			Card card = deck.dealCard();
			if (card != null) {
				dealer.addCard(card);

			} else {
				System.out.println("No cards left in the deck.");
				break;
			}
		}
		
		player.showHand();
		player.evaluateHand(player.getHand());
		System.out.println("\n\n");
		dealer.showHand();
		dealer.evaluateHand(dealer.getHand());
		System.out.println("\n");
		System.out.println("Cards Remainig Cards: " + deck.size());
		
		newGUI = new GUI();

	}

	////////////////////////////////////////////////////////////

}
