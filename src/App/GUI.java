package App;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import DeckofCards.Card;
import Game.Poker;

public class GUI {

	// Window Size
	int boardeHeight = 700;
	int boardWidth = boardeHeight;

	// Card Size (1:1.4)
	int cardWidth = 110;
	int cardHeight = 154;

	Poker poker = new Poker();
	JFrame frame = new JFrame("Poker");
	JPanel gamePanel = new JPanel() {

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			// Draw hidden card
			Image hiddenCardImg = new ImageIcon(getClass().getResource("./CardImages/BACK.png")).getImage();
			if (!foldButton.isEnabled()) {
//				hiddenCardImg = new ImageIcon(getClass().getResource(hiddenCard.getImagePath())).getImage();
			}
			g.drawImage(hiddenCardImg, 20, 20, cardWidth, cardHeight, null);

			// Display dealer's hand
			for (int i = 0; i < poker.getDealer().getHand().size(); i++) {
				Card card = poker.getDealer().getHand().get(i);
				Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
				g.drawImage(cardImg, cardWidth + 25 + (cardWidth + 5) * i, 20, cardWidth, cardHeight, null);
			}

			// Display player's hand
			for (int i = 0; i < poker.getPlayer().getHand().size(); i++) {
				Card card = poker.getPlayer().getHand().get(i);
				Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
				g.drawImage(cardImg, 20 + (cardWidth + 5) * i, 320, cardWidth, cardHeight, null);
			}

		}
	};

	JPanel buttonPanel = new JPanel();
	JButton foldButton = new JButton("Fold");
	JButton raiseButton = new JButton("Raise");
	JButton checkButton = new JButton("Check");

	public GUI() {

		// poker.beginGame();

		// Frame Initialization
		frame.setVisible(true);
		frame.setSize(boardWidth, boardeHeight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Game Background
		gamePanel.setLayout(new BorderLayout());
		gamePanel.setBackground(new Color(53, 101, 77));
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
