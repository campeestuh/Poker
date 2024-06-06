package DeckofCards;
// import java.util.ArrayList;

public class Cards {
	
	private String suit;
	public String rank;
	public Integer value;

	public Cards(String rank, String suit) {
	       this.rank = rank;
	        this.suit = suit;
 
	}

	public String Name() {
		return rank + " of " + suit;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	
}
