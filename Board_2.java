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
    private JPanel center, left, right, bottom;
    private ButtonListener listener;
    private JButton[][] gameBoard = new JButton[8][8];
    private JButton[] player1Hand = new JButton[5];
    private JButton[] player2Hand = new JButton[5];
    private Dimension dim = new Dimension(10,10);
    
    
    private Space[][] iBoard;
    
    private String[] iDeck;
    
    private String[] iPlayerOne;
    
    private String[] iPlayerTwo;
    
    
    public Board(){
    	   	
        listener = new ButtonListener();
        
        //create a game to be played
        game = new SequenceGame();
        
      //panel sections
        center = new JPanel();
        left = new JPanel();
        right = new JPanel();
        bottom = new JPanel();
        
        setLayout (new BorderLayout ());
        
		add(center, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
		//add(right, BorderLayout.EAST);
        
      //create board grid
      		center.setLayout(new GridLayout(8,8,0,0));
      		//right.setLayout(new GridLayout(5,1,0,0));
      		bottom.setLayout(new GridLayout(5,1,0,0));
      		
      		constructBoard(center, listener);
      		
      		showBoard();
      		
      //create hands
      		
      		
      		//constructHand(right, player1Hand);
      		constructHand(bottom, player2Hand);
      		
      		
    }
    
    public void constructBoard(JPanel panel, ButtonListener listener){
               
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
            
            	Border thickBorder = new LineBorder(Color.black, 2);
				
            	//creates buttons based on board, adds listener and adds to panel
				gameBoard[row][col] = new JButton("");
				gameBoard[row][col].setPreferredSize(new Dimension(10,10));
				//gameBoard[row][col].setSize(20,20);
				gameBoard[row][col].setBorder(thickBorder);
				
				gameBoard[row][col].addActionListener(listener);
				panel.add(gameBoard[row][col]);
            }
        }   
   }
    
    public void constructHand(JPanel panel, JButton[] hand){
    	for(int i = 0; i < 5; i++){
    		JButton[] phand;
    		
    		phand = hand;
    		
    		Border thickBorder = new LineBorder(Color.black, 2);
    		
    		phand[i] = new JButton("");
    		phand[i].setPreferredSize(dim);
    		phand[i].setBorder(thickBorder);
    		
    		panel.add(phand[i]);
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




