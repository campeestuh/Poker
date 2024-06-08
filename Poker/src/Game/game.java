package Game;
// import java.util.ArrayList;
// import DeckofCards.Cards;
// import People.Player;

public class game  {
private Integer Buyin;
	// 10 Basic ways to win poker
	// High Card
	// Pair of cards 
	// Three of a kind (4Clubs 4Hearts 4Spades)
	// Straight (5 cards in sequential order no matter the suit) (3,4,5,6,7)
	// Flush (When a player has 5 cards of the same suit in any order)
	// Full House (When a player has a pair and three of a kind)
	// Four of a kind (When a player has the same rank for all dour suits) (4Hearts, 4Diamonds, 4Clubs, 4Spades)
	// Straight Flush (Have 5 cards in sequential order of the same suit)
	// Royal Flush (Hand contains: 10, Jack , Queen, King, Ace)
	
	public game() {
		setBuyIn(25);
	} 
	
	public Integer getBuyIn() {
		return Buyin;
	}

	public void setBuyIn(Integer buyin) {
		Buyin = buyin;
	}
	
}
