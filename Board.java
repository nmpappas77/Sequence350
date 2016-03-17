package package1;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
    
    private int counter;
    
    private ImageIcon kingheart, aceheart, queenheart, jackheart, aceclub, kingclub, queenclub, jackclub, 
    	acediamond, kingdiamond, queendiamond,jackdiamond, acespade, kingspade, queenspade, jackspade; 
    
    private Space[][] iBoard;
    
    private String[] iDeck;
    
    private String[] iPlayerOne;
    
    private String[] iPlayerTwo;
    
    
    public Board(){
    	aceheart = new ImageIcon(this.getClass().getResource("/aceheart.png"));
    	kingheart = new ImageIcon(this.getClass().getResource("/kingheart.png"));
    	queenheart = new ImageIcon(this.getClass().getResource("/queenheart.png"));
    	jackheart = new ImageIcon(this.getClass().getResource("/jackheart.png"));
    	
    	acediamond = new ImageIcon(this.getClass().getResource("/acediamond.png"));
    	kingdiamond = new ImageIcon(this.getClass().getResource("/kingdiamond.png"));
    	queendiamond = new ImageIcon(this.getClass().getResource("/queendiamond.png"));
    	jackdiamond = new ImageIcon(this.getClass().getResource("/jackdiamond.png"));
    	
    	acespade = new ImageIcon(this.getClass().getResource("/acespades.png"));
    	kingspade = new ImageIcon(this.getClass().getResource("/kingspades.png"));
    	queenspade = new ImageIcon(this.getClass().getResource("/queenspades.png"));
    	jackspade = new ImageIcon(this.getClass().getResource("/jackspades.png"));
    	
    	aceclub = new ImageIcon(this.getClass().getResource("/aceclubs.png"));
    	kingclub = new ImageIcon(this.getClass().getResource("/kingclubs.png"));
    	queenclub = new ImageIcon(this.getClass().getResource("/queenclubs.png"));
    	jackclub = new ImageIcon(this.getClass().getResource("/jackclubs.png"));

    	
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

		bottom.setPreferredSize(new Dimension(200,100));
		
		center.setPreferredSize(new Dimension(400,600));
        
      //create board grid
      		center.setLayout(new GridLayout(8,8,7,8));
      		//right.setLayout(new GridLayout(5,1,0,0));
      		bottom.setLayout(new GridLayout(5,2,1,5));
      		
      		constructBoard(center, listener);
      		
      		showBoard();
      		
      //create hands
      		
      		
      		constructHand(bottom, player1Hand);
      		//constructHand(bottom, player2Hand);
      		
      		displayHand1();
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
    
    public void displayHand1(){
    	iPlayerOne = game.getPlayerOne();
    	
    	for(int i = 0; i < 5; i++){
    		String temp = new String();
    		temp = iPlayerOne[i].toString();
    		
    		player1Hand[i].setText(temp);
    	}
    }
    
    public void displayHand2(){
    	iPlayerTwo = game.getPlayerTwo();
    	
    	for(int i = 0; i < 5; i++){
    		String temp = new String();
    		temp = iPlayerTwo[i].toString();
    		
    		player1Hand[i].setText(temp);
    	}
    }
    
    public void constructHand(JPanel panel, JButton[] hand){
    	for(int i = 0; i < 5; i++){
    		JButton[] phand;
    		
    		phand = hand;
    		
    		phand[i] = new JButton("AAAAAAA");
    		phand[i].setPreferredSize(new Dimension(dim));
    		    		
    		panel.add(phand[i]);
    	}
    }
    
    private void showBoard(){
		iBoard = game.getBoard();
		
		System.out.println(kingheart.getIconHeight());
				
		//set button text on panel
		for (int row = 0; row < 8; row++)
			for (int col = 0; col < 8; col++){
				//gameBoard[row][col].setText(iBoard[row][col].getCardSpace());
				
				if(iBoard[row][col].getCardSpace().equals("K of Hearts"))
				gameBoard[row][col].setIcon(kingheart);				
				else if(iBoard[row][col].getCardSpace().equals("A of Hearts"))
					gameBoard[row][col].setIcon(aceheart);
				else if(iBoard[row][col].getCardSpace().equals("Q of Hearts"))
					gameBoard[row][col].setIcon(queenheart);
				else if(iBoard[row][col].getCardSpace().equals("J of Hearts"))
					gameBoard[row][col].setIcon(jackheart);
				else if(iBoard[row][col].getCardSpace().equals("A of Diamonds"))
					gameBoard[row][col].setIcon(acediamond);
				else if(iBoard[row][col].getCardSpace().equals("K of Diamonds"))
					gameBoard[row][col].setIcon(kingdiamond);
				else if(iBoard[row][col].getCardSpace().equals("Q of Diamonds"))
					gameBoard[row][col].setIcon(queendiamond);
				else if(iBoard[row][col].getCardSpace().equals("J of Diamonds"))
					gameBoard[row][col].setIcon(jackdiamond);
				else if(iBoard[row][col].getCardSpace().equals("A of Spades"))
					gameBoard[row][col].setIcon(acespade);
				else if(iBoard[row][col].getCardSpace().equals("K of Spades"))
					gameBoard[row][col].setIcon(kingspade);
				else if(iBoard[row][col].getCardSpace().equals("Q of Spades"))
					gameBoard[row][col].setIcon(queenspade);
				else if(iBoard[row][col].getCardSpace().equals("J of Spades"))
					gameBoard[row][col].setIcon(jackspade);
				else if(iBoard[row][col].getCardSpace().equals("A of Clubs"))
					gameBoard[row][col].setIcon(aceclub);
				else if(iBoard[row][col].getCardSpace().equals("K of Clubs"))
					gameBoard[row][col].setIcon(kingclub);
				else if(iBoard[row][col].getCardSpace().equals("Q of Clubs"))
					gameBoard[row][col].setIcon(queenclub);
				else
					gameBoard[row][col].setIcon(jackclub);
	}
   }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	
        	counter = game.getCounter();
             
             for(int row = 0; row < 8; row++){
                 for(int col = 0; col < 8; col ++){
                     if(gameBoard[row][col] == e.getSource()){
                         if((counter % 2) == 0){
                                    game.select(row,col);
                                    
                                    iBoard = game.getBoard();
                                   
                                    if(game.getValid() == true){
                                    	gameBoard[row][col].setBackground(Color.GREEN);
                                    	gameBoard[row][col].setIcon(null);
                                    	gameBoard[row][col].setText(iBoard[row][col].getCardSpace());
                                    	displayHand2();
                                    }
                                    game.setValid(false);
                                   }                 
                         else{
                                      game.select(row,col);
                                      
                                      iBoard = game.getBoard();
                                      
                                      if(game.getValid() == true){
                                      	displayHand1();
                                      	gameBoard[row][col].setBackground(Color.ORANGE);
                                    	gameBoard[row][col].setIcon(null);
                                      	gameBoard[row][col].setText(iBoard[row][col].getCardSpace());
                                      }
                                      game.setValid(false);
                               }
                           
                           }
                         
                       }
                       
                   }
        }
               
           
             
     }

}





