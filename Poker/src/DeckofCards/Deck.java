package DeckofCards;

import java.util.ArrayList;
import java.util.Collections;



public class Deck {
	
	private ArrayList<Cards> cards;
	
	
	public Deck() {
	setCards(new ArrayList<Cards>());
	}
	
	public void initDeck(){
		// 52 Cards in a Deck
		String[] deck = new String[52];
		// 4 Suits to a Deck of Cards
		String[] suit = {"Spades","Hearts","Diamonds","Clubs"};
		// Rank from Lowest to Highest
		String[] rank = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		
		Integer[] value = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		  for (String s : suit) {
			  for (Integer v : value) {
	            for (String r : rank) {
	                Cards card = new Cards(r, s, v);
	                cards.add(card);
	                System.out.println(card.Name());
	            }
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
