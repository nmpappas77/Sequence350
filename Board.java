package package1;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel
{
    private SequenceGame game;
    private JFrame frame;
    private JPanel center, left, right;
    private ButtonListener listener;
    private JButton[][] gameBoard = new JButton[8][8];
    private JButton[] player1Hand = new JButton[5];
    private JButton[] player2Hand = new JButton[5];
    private Dimension dim = new Dimension(40,40);
    
    
    private Space[][] iBoard;
    
    private String[] iDeck;
    
    
    public Board(){
        listener = new ButtonListener();
        
        //create a game to be played
        game = new SequenceGame();
        
      //panel sections
        center = new JPanel();
        left = new JPanel();
        right = new JPanel();
        
      //create board grid
      		center.setLayout(new GridLayout(8,8,5,7));
      		
      		constructBoard(center, listener);
      		
      		showBoard();
      		
      		setLayout (new BorderLayout ());
    		add(center, BorderLayout.CENTER);
    		add(left, BorderLayout.WEST);
    		add(right, BorderLayout.EAST);
    }
    
    public void constructBoard(JPanel panel, ButtonListener listener){
               
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++)
            {
            	Border thickBorder = new LineBorder(Color.black, 2);
				
            	//creates buttons based on board, adds listener and adds to panel
				gameBoard[row][col] = new JButton("");
				gameBoard[row][col].setPreferredSize(dim);
				gameBoard[row][col].setBorder(thickBorder);
				
				gameBoard[row][col].addActionListener(listener);
				panel.add(gameBoard[row][col]);
        }
    }

    for( int x = 0; x == 4; x++){
        JButton handButton = new JButton();
        
        player1Hand[x] = handButton;
    
        right.add(handButton);
    }
    
    for (int y = 0; y == 4; y++)
    {
        JButton handButton = new JButton();
        
        player2Hand[y] = handButton;
        
        left.add(handButton);
    }
    }
    
    private void showBoard(){
		iBoard = game.getBoard();
		
		
		
		//set button text on panel
		for (int row = 0; row < 8; row++)
			for (int col = 0; col < 8; col++){
				
				gameBoard[row][col].setText(iBoard[row][col].getCardSpace());
	}
    }
    
    private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
		}
    }
    }




