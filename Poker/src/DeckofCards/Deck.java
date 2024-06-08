package DeckofCards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Cards> cards;
	
	public Deck() {
		setCards(new ArrayList<Cards>());
	}
	
	public void initDeck() {
	    String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
	    String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

	    for (String suit : suits) {
	        for (String rank : ranks) {
	            Cards card = new Cards(rank, suit);
	            cards.add(card);
                System.out.println(card.Name()); // Print the name of each card in the shuffled deck
	        }
	    }
	}
	
	public ArrayList<Cards> getCards() {
		return cards;
	}
	
	public void setCards(ArrayList<Cards> cards) {
		this.cards = cards;
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
        for (Cards card : cards) {
            System.out.println(card.Name()); // Print the name of each card in the shuffled deck
        }
	}

	public int size() {
	        return cards.size();
	    }
	 
	public void printDeck() {
        for (Cards card : cards) {
            System.out.println(card);
        }
    }
	 
	public Cards dealCard() {
        if (cards.isEmpty()) {
            return null; // No cards left in the deck
        }
        return cards.remove(0); // Remove and return the top card
    }
	
	
}
