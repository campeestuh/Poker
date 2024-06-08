package Main;
import java.util.ArrayList;

import DeckofCards.Cards;
import DeckofCards.Deck;
import People.Player;
// help.exe
public class Deck_Driver {
	
	
    public static void main(String[] args) {
        Deck deck = new Deck();
        // Creates instants of player and Dealer
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
        
        
        player.Buyin(0);
        
        player.Buyin(25);
		////////////////////////////////////////////////////////////
		// Deck Functionality
        //Building beck method
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
        System.out.println("Cards Remainig Cards: " + deck.size());
            for (int i = 0; i < 5; i++) {
                Cards card = deck.dealCard();
                if (card != null) {
                    player.addCard(card);
                  

                } else {
                    System.out.println("No cards left in the deck.");
                    break;
                }
            }
            
         // Giving 5 cards to the dealer
            for (int i = 0; i < 5; i++) {
                Cards card = deck.dealCard();
                if (card != null) {
                    dealer.addCard(card);

                } else {
                    System.out.println("No cards left in the deck.");
                    break;
                }
            }
            // Displays Players and Dealers hand and gets evaluated
            player.showHand();
            player.evaluateHand(player.getHand());
            System.out.println("\n\n");
            dealer.showHand();
            dealer.evaluateHand(dealer.getHand());
            System.out.println("\n");
            System.out.println("Cards Remainig Cards: " + deck.size());
            System.out.println("\n");
            if (player.evaluateHand(player.getHand()) == dealer.evaluateHand(dealer.getHand())) {
            	System.out.println("FIX ME");
            }
            else if (player.evaluateHand(player.getHand()) > dealer.evaluateHand(dealer.getHand())) {
            	System.out.println(player.getName() + " Wins!");
            }
            else {
            	System.out.println(dealer.getName() + " Wins!");

            }
        }
 
    	////////////////////////////////////////////////////////////
    	// Determine Winner
    
    
    
    }
