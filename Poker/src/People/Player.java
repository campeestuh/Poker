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
	

	 private static final Map<String, Integer> Value = new HashMap<>();
	    static {
	    	Value.put("2", 2);
	    	Value.put("3", 3);
	    	Value.put("4", 4);
	    	Value.put("5", 5);
	    	Value.put("6", 6);
	    	Value.put("7", 7);
	    	Value.put("8", 8);
	    	Value.put("9", 9);
	    	Value.put("10", 10);
	    	Value.put("Jack", 11);
	    	Value.put("Queen", 12);
	    	Value.put("King", 13);
	        Value.put("Ace", 14);
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
		    // Method 10 of winning
	        if (isRoyalFlush(hand)) {
	            System.out.println("Royal Flush");
	        }
		    // Method 9 of winning
//	        else if (isStraightFlush(hand)) {
//	        	System.out.println("Straight Flush");
//	        }
		    // Method 8 of winning
//	        	else if (isFourOfAKind(hand)) {
//	            return 8;
//	        } 
		    // Method 7 of winning
//	            else if (isFullHouse(hand)) {
//	            return 7;
//	        } 
		    // Method 6 of winning
			else if (isFlush(hand)) {
	        	System.out.println("Flush");
	        }
//	        	else if (isStraight(hand)) {
//	        	System.out.println("Straight");
//	        } 
	        else if (isThreeOfAKind(hand)) {
	            System.out.println("Three of a kind");
	        }
	            else if (isTwoPair(hand)) {
        	System.out.println("Two Pairs of Cards");
	        }
	        else if (isOnePair(hand)) {
	        	System.out.println("Pair of Cards");
	        }
	  else {
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
	
	  
	  private boolean isFlush(ArrayList<Cards> hand) {
		    String firstSuit = hand.get(0).getSuit();
		    for (Cards card : hand) {
		        if (!card.getSuit().equals(firstSuit)) {
		            return false;
		        }
		    }
		    return true;
		}
	  
	  public boolean isStraight(ArrayList<Cards> hand) {
	        // Sort the hand based on rank values
	        Collections.sort(hand, new Comparator<Cards>() {
	            @Override
	            public int compare(Cards card1, Cards card2) {
	                return Integer.compare(Value.get(card1.getRank()), Value.get(card2.getRank()));
	            }
	        });

	        // Check if the sorted hand forms a consecutive sequence
	        for (int i = 0; i < hand.size() - 1; i++) {
	            int currentValue = Value.get(hand.get(i).getRank());
	            int nextValue = Value.get(hand.get(i + 1).getRank());

	            // Check if the difference between adjacent elements is not 1
	            if (nextValue - currentValue != 1) {
	                return false; // Not consecutive
	            }
	        }

	        // If the loop completes without returning false, it's a consecutive sequence
	        return true;
	    }
	
	  // WORKS ✔✔✔
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
	  
	  // WORKS ✔✔✔
	  public boolean isTwoPair(ArrayList<Cards> hand) {
	        // Map to count occurrences of each rank
	        Map<String, Integer> rankCount = new HashMap<>();

	        // Count occurrences of each rank
	        for (Cards card : hand) {
	            String rank = card.getRank();
	            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
	        }

	        // Count the number of pairs
	        int pairCount = 0;
	        for (int count : rankCount.values()) {
	            if (count == 2) {
	                pairCount++;
	            }
	        }

	        // Check if there are exactly two pairs
	        return pairCount == 2;
	    }

	  
	  // WORKS ✔✔✔
	  public boolean isOnePair(ArrayList<Cards> hand) {
	        // Map to count occurrences of each rank
	        Map<String, Integer> rankCount = new HashMap<>();

	        // Count occurrences of each rank
	        for (Cards card : hand) {
	            String rank = card.getRank();
	            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
	        }

	        // Check if any rank appears exactly twice
	        for (int count : rankCount.values()) {
	            if (count == 2) {
	                return true; // Found "Two of a Kind"
	            }
	        }

	        return false; // No "Two of a Kind" found
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
