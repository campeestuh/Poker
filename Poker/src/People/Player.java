package People;
import java.util.ArrayList;
import java.util.Collections;
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
	

//	 private static final Map<String, Integer> Value = new HashMap<>();
//	    static {
//	    	Value.put("2", 2);
//	    	Value.put("3", 3);
//	    	Value.put("4", 4);
//	    	Value.put("5", 5);
//	    	Value.put("6", 6);
//	    	Value.put("7", 7);
//	    	Value.put("8", 8);
//	    	Value.put("9", 9);
//	    	Value.put("10", 10);
//	    	Value.put("Jack", 11);
//	    	Value.put("Queen", 12);
//	    	Value.put("King", 13);
//	        Value.put("Ace", 14);
//	    }
//	    
	public void buyIn(int amount) {
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
	 
	 // Returning an Integer to make easier comparison to determine winner 
	  public Integer evaluateHand(ArrayList<Cards> hand) {
		    // Method 10 of winning
	        if (isRoyalFlush(hand)) {
	            System.out.println("Royal Flush");
	            return 10;
	        }
		    // Method 9 of winning
	        else if (isStraightFlush(hand)) {
	        	System.out.println("Straight Flush");
	            return 9;
	        }
		    // Method 8 of winning
	        	else if (isFourOfAKind(hand)) {
		        	System.out.println("Four of a Kind");	      
		        	return 8;
	        } 
		    // Method 7 of winning
	            else if (isFullHouse(hand)) {
		        System.out.println("Full House");
	            return 7;
	        } 
		    // Method 6 of winning
			else if (isFlush(hand)) {
	        	System.out.println("Flush");
	            return 6;
	        }
		    // Method 5 of winning
	        	else if (isStraight(hand)) {
	        	System.out.println("Straight");
	            return 5;
	        } 
		    // Method 4 of winning
	        else if (isThreeOfAKind(hand)) {
	            System.out.println("Three of a kind");
	            return 4;
	        }
		    // Method 3 of winning
	            else if (isTwoPair(hand)) {
        	System.out.println("Two Pairs of Cards");
           		return 3;
	        }
		    // Method 2 of winning
	        else if (isOnePair(hand)) {
	        	System.out.println("Pair of Cards");
	            return 2;
	        }
		    // Method 1 of winning
	        else {
	        	System.out.println("High Card");
	        }
			return 1;
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
	  
	  // Straight Flush Logic
	  public boolean isStraightFlush(ArrayList<Cards> hand) {
	        return isFlush(hand) && isStraight(hand);
	    }

	  // Flush Logic
	  // WORKS ✔✔✔
	  private boolean isFlush(ArrayList<Cards> hand) {
		    String firstSuit = hand.get(0).getSuit();
		    for (Cards card : hand) {
		        if (!card.getSuit().equals(firstSuit)) {
		            return false;
		        }
		    }
		    return true;
		}
	  
	  	  // WORKS ✔✔✔
		  public boolean isStraight(ArrayList<Cards> hand) {
		        // Map rank names to their corresponding values
		        Map<String, Integer> rankValues = new HashMap<>();
		        rankValues.put("2", 2);
		        rankValues.put("3", 3);
		        rankValues.put("4", 4);
		        rankValues.put("5", 5);
		        rankValues.put("6", 6);
		        rankValues.put("7", 7);
		        rankValues.put("8", 8);
		        rankValues.put("9", 9);
		        rankValues.put("10", 10);
		        rankValues.put("J", 11);
		        rankValues.put("Q", 12);
		        rankValues.put("K", 13);
		        rankValues.put("A", 14);

		        // Extract the ranks of the cards in the hand
		        ArrayList<Integer> handRanks = new ArrayList<>();
		        for (Cards card : hand) {
		            handRanks.add(rankValues.get(card.getRank()));
		        }

		        // Sort the ranks
		        Collections.sort(handRanks);

		        // Check for consecutive values
		        for (int i = 0; i < handRanks.size() - 1; i++) {
		            if (handRanks.get(i + 1) - handRanks.get(i) != 1) {
		                return false;
		            }
		        }

		        return true;
		    }
		  
	  // WORKS ✔✔✔
	  public boolean isFourOfAKind(ArrayList<Cards> hand) {
	        // Map to count occurrences of each rank
	        Map<String, Integer> rankCount = new HashMap<>();

	        // Count occurrences of each rank
	        for (Cards card : hand) {
	            String rank = card.getRank();
	            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
	        }

	        // Check for a rank with a count of four
	        for (int count : rankCount.values()) {
	            if (count == 4) {
	                return true; // Found four of a kind
	            }
	        }

	        return false; // No four of a kind found
	    }
	  
	  // WORKS ✔✔✔
	  public boolean isFullHouse(ArrayList<Cards> hand) {
	        // Map to count occurrences of each rank
	        Map<String, Integer> rankCount = new HashMap<>();

	        // Count occurrences of each rank
	        for (Cards card : hand) {
	            String rank = card.getRank();
	            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
	        }

	        // Check for exactly two different ranks with counts of three and two
	        boolean hasThreeOfAKind = false;
	        boolean hasPair = false;
	        for (int count : rankCount.values()) {
	            if (count == 3) {
	                hasThreeOfAKind = true;
	            } else if (count == 2) {
	                hasPair = true;
	            }
	        }

	        return hasThreeOfAKind && hasPair;
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
