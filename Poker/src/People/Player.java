package People;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import DeckofCards.Cards;
// IDEA
// Players 3 potential moves in poker
// Call : Player puts out the same amount of chips into the pot equal to the bet of the previous player 
// Raise : Place a bigger bet than the previous one
// Fold : Give up cards and lose

public class Player {
	private String Name;
	private Integer Money;
	private ArrayList<Cards> Hand;
	
	public Player() {
		setName("Unknown");
		Hand = new ArrayList<Cards>();
		setMoney(100);
	}
	

	public void Buyin(int amount) {
		if (amount >= 25) {
			amount = amount - 25;
			System.out.println("Ante Placed. $" + amount + " Remaining");
		
		}
		else {
			System.out.println("Cant Afford Buyin. Time to go home");
		}
	}
	
	
	// This is going to show what cards we have in our hand
	 public void showHand() {
	        System.out.println(Name + "'s Hand:");
	        for (Cards card : Hand) {
	            System.out.println(card.getRank() + " of " + card.getSuit());
	        }
	    }
	 
	 // Returning an Integer to make easier comparison 
	  public String evaluateHand(ArrayList<Cards> hand) {
	        if (isRoyalFlush(hand)) {
	            System.out.println("Royal Flush");
	        } else if (isStraightFlush(hand)) {
	        	System.out.println("Straight Flush");
//	        } else if (isFourOfAKind(hand)) {
//	            return 8;
//	        } else if (isFullHouse(hand)) {
//	            return 7;
	        } else if (isFlush(hand)) {
	        	System.out.println("Flush");
	        } else if (isStraight(hand)) {
	        	System.out.println("Straight");
	        } else if (isThreeOfAKind(hand)) {
	            System.out.println("Three of a kind");;
//	        } else if (isTwoPair(hand)) {
//	            return 3;
//	        } else if (isOnePair(hand)) {
//	            return 2;
	        } else {
	        	System.out.println("High Card");
	        }
			return Name;
	    }
	  
	  
	  private boolean isRoyalFlush(ArrayList<Cards> hand) {
	       boolean Ten = false;
	       boolean Jack = false;
	       boolean Queen = false;
	       boolean King = false;
	       boolean Ace = false;

	       	  // Checking through list of cards to see if they have all these requirements
		      for (Cards c : hand)  {
		    	if( c.getRank().equals("10")) {
		    		 Ten = true;
		    	}
		    	
		    	if( c.getRank().equals("J")) {
			    	 Jack = true;
			    	}
		    	
		    	if( c.getRank().equals("Q")) {
			    	 Queen = true;
			    	}
		    	
		    	if( c.getRank().equals("K")) {
			    	 King = true;
			    	}
		    	
		    	if( c.getRank().equals("A")) {
			    	 Ace = true;
			    	}
	
	      }   
		return Ten && Jack && Queen && King && Ace;
	    }
	  private boolean isStraightFlush(ArrayList<Cards> hand) {
		    // Check if the hand is a flush first
		    if (!isFlush(hand)) {
		        return false;
		    }

		    // Then, check if the hand is a straight
		    if (!isStraight(hand)) {
		        return false;
		    }

		    // If the hand is both a flush and a straight, it's a straight flush
		    return true;
		}
	  private boolean isFlush(ArrayList<Cards> hand) {
		    String firstSuit = hand.get(0).getSuit();
		    for (Cards card : hand) {
		        if (!card.getSuit().equals(firstSuit)) {
		            return false;
		        }
		    }
		    return true;
		}
	  
	  private boolean isStraight(ArrayList<Cards> hand) {
		    for (int i = 0; i < hand.size() - 1; i++) {
		        // Check if the difference between adjacent elements is not 1
		        if (hand.get(i + 1).getValue() - hand.get(i).getValue() != 1) {
		            return false; // Not consecutive
		        }
		    }
		    
		    // If the loop completes without returning false, it's a consecutive sequence
		    return true;
		}
	
	  private boolean isThreeOfAKind(ArrayList<Cards> hand) {
		    Map<String, Integer> rankCount = new HashMap<>();

		    // Count the occurrences of each rank in the hand
		    for (Cards card : hand) {
		        String rank = card.getRank();
		        rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
		    }

		    // Check if there is a rank that occurs three times
		    for (int count : rankCount.values()) {
		        if (count == 3) {
		            return true;
		        }
		    }

		    return false;
		}

	 
	 public void addCard(Cards card) {
	        Hand.add(card);
	    }
	 
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public ArrayList<Cards> getHand() {
		return Hand;
	}
	// Sets for array of five cards given at the round
	public void setHand(ArrayList<Cards> hand) {
		Hand = hand;
	}
	
	public Integer getMoney() {
		return Money;
	}

	public void setMoney(Integer money) {
		Money = money;
	}
	
	// Once Round is Over we Clear the hand
	public void clearHand() {
        Hand.clear();
    }


	
	
}
