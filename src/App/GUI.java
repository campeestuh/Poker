package App;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import DeckofCards.Deck;
//import Game.Poker;

public class GUI {

    // Window Size
    int boardeHeight = 700;
    int boardWidth = boardeHeight;

    // Card Size (1:1.4)
    int cardWidth = 110;
    int cardHeight = 154;

    JFrame frame = new JFrame("Poker");
    JPanel gamePanel = new JPanel() {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw hidden card
            Image hiddenCardImg = new ImageIcon(getClass().getResource("./CardImages/BACK.png")).getImage();
            g.drawImage(hiddenCardImg, 20, 20, cardWidth, cardHeight, null);
            
            // Draw dealer's hand
            
        }
    };
    
    JPanel buttonPanel = new JPanel();
    JButton foldButton = new JButton("Fold");
    JButton raiseButton = new JButton("Raise");
    JButton checkButton = new JButton("Check");

    GUI() {
        //Poker poker = new Poker();
        //poker.Poker();

        frame.setVisible(true);
        frame.setSize(boardWidth, boardeHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Game Background
        gamePanel.setLayout(new BorderLayout());
        gamePanel.setBackground(new Color(53,101,77));
        frame.add(gamePanel);

        // Button Panel Setup
        foldButton.setFocusable(false);
        buttonPanel.add(foldButton);
        raiseButton.setFocusable(false);
        buttonPanel.add(raiseButton);
        checkButton.setFocusable(false);
        buttonPanel.add(checkButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
    }


	
}
