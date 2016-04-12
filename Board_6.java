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

public class Board extends JPanel implements MouseListener, MouseMotionListener
{
    private SequenceGame game;
    private JFrame frame;
    private JPanel center;
    private ButtonListener listener;
    private JButton[][] gameBoard = new JButton[8][8];
    private JLabel[] player1Hand = new JLabel[5];
    private JLabel[] player2Hand = new JLabel[5];
    private Dimension dim = new Dimension(93,59);
    private GridBagConstraints c;
    
    private JLabel dragged;
    
    private Point point;
    
    private boolean drag = false;
    
    private int counter;
    
    private ImageIcon kingheart, aceheart, queenheart, jackheart, aceclub, kingclub, queenclub, jackclub, 
    	acediamond, kingdiamond, queendiamond,jackdiamond, acespade, kingspade, queenspade, jackspade; 
    
    private Space[][] iBoard;
    
    private String[] iDeck;
    
    private String[] iPlayerOne;
    
    private String[] iPlayerTwo;
    
    private JLabel turn;
    
    
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
        
        dragged = new JLabel();
        
        //create a game to be played
        game = new SequenceGame();
        
      //panel section
        center = new JPanel(new GridBagLayout());
                
		frame = new JFrame();
		
		frame = Sequence.frame;
		
		c = new GridBagConstraints();
		
		 c.insets = new Insets(2,2,2,2);
         c.weightx = .5;
         c.weighty = .5;	
		
		//setVisible(true);
		
		frame.add(center);
		
		center.setPreferredSize(new Dimension(800,700));
		center.setBackground(new Color(20,107,23));
		
		
		
		iPlayerOne = game.getPlayerOne();
		iPlayerTwo = game.getPlayerTwo();
      		      		
      	constructBoard(center, listener, this);
      		
      	showBoard();
      		
      //create hands
      		
      		
      	constructHand1(center, player1Hand);
      	constructHand2(center, player2Hand);
      		
      	displayHand1();
      	displayHand2();
      	
      	setHandIcon(player1Hand);
      	setHandIcon(player2Hand);
      	      	
      	frame.setVisible(true);
    }
    
    public JLabel getDragged(){
    	return dragged;
    }
    
    public void constructBoard(JPanel panel, ButtonListener listener, MouseListener mlistener){
    	mlistener = this;
               
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
            	int count = 0;
            
            	Border thickBorder = new LineBorder(Color.black, 2);
				
            	//creates buttons based on board, adds listener and adds to panel
				gameBoard[row][col] = new JButton("");
				gameBoard[row][col].setPreferredSize(new Dimension(93,59));
				//gameBoard[row][col].setSize(20,20);
				gameBoard[row][col].setBorder(thickBorder);
				
				 c.fill = GridBagConstraints.HORIZONTAL;
	             c.gridx = row;
	             c.gridy = col;
	                         
	             				
				gameBoard[row][col].addActionListener(listener);
				gameBoard[row][col].addMouseListener(mlistener);
				panel.add(gameBoard[row][col], c);
				
            }
        }   
        
        c.gridx = 7;
        c.gridy = 8;
        
        turn = new JLabel("Player One Turn");
        
        center.add(turn, c);
       
        turn.setForeground(Color.WHITE);
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
    		
    		player2Hand[i].setText(temp);
    	}
    }
    
    public void constructHand1(JPanel panel, JLabel[] hand){
    	
    	JLabel playerOneLabel = new JLabel("Player One Hand:");
        c.gridx = 0;
        c.gridy = 8;
        panel.add(playerOneLabel, c);
        playerOneLabel.setForeground(Color.WHITE);
    	
    	for(int i = 0; i < 5; i++){
    		JLabel[] phand;
    		
    		phand = hand;
    		
    		
    		
    		phand[i] = new JLabel(iPlayerOne[i]);
    		phand[i].setPreferredSize(new Dimension(93,59));
    		
    		phand[i].addMouseListener(this);
    		phand[i].addMouseMotionListener(this);
    		
    		c.gridx = i + 1;
            c.gridy = 8;
    		    		
    		center.add(phand[i], c);
    	}
    }
    
    public void constructHand2(JPanel panel, JLabel[] hand){
    	
    	JLabel playerTwoLabel = new JLabel("Player Two Hand:");
        c.gridx = 0;
        c.gridy = 9;
        panel.add(playerTwoLabel, c);
        playerTwoLabel.setForeground(Color.WHITE);

    	
    	for(int i = 0; i < 5; i++){
    		JLabel[] phand;
    		
    		phand = hand;
    		
    		phand[i] = new JLabel(iPlayerTwo[i]);
    		//setHandIcon();
    		phand[i].setPreferredSize(new Dimension(93,59));
    		
    		phand[i].addMouseListener(this);
    		phand[i].addMouseMotionListener(this);
    		
    		c.gridx = i + 1;
            c.gridy = 9;
    		    		
    		center.add(phand[i], c);
    	}
    }
    
    //Sets the image to the card in the hand
    private void setHandIcon(JLabel[] hand){
    	JLabel[] phand;
    	phand = hand;
    	ImageIcon temp = new ImageIcon();
    	
    	for(int i = 0; i < 5; i++){
    		if(phand[i].getText().equals("A of Spades")){
    			temp = acespade;
    			phand[i].setIcon(temp);
    		}
    		else if(phand[i].getText().equals("K of Spades")){
    			temp = kingspade;
    			phand[i].setIcon(temp);
    		}
    		else if(phand[i].getText().equals("Q of Spades")){
    			temp = queenspade;
    			phand[i].setIcon(temp);
    		}
    		else if(phand[i].getText().equals("J of Spades")){
    			temp = jackspade;
    			phand[i].setIcon(temp);
    		}
       		else if(phand[i].getText().equals("A of Hearts")){
    			temp = aceheart;
    			phand[i].setIcon(temp);
    		}
       		else if(phand[i].getText().equals("K of Hearts")){
    			temp = kingheart;
    			phand[i].setIcon(temp);
    		}
       		else if(phand[i].getText().equals("Q of Hearts")){
    			temp = queenheart;
    			phand[i].setIcon(temp);
    		}
       		else if(phand[i].getText().equals("J of Hearts")){
    			temp = jackheart;
    			phand[i].setIcon(temp);
    		}
       		else if(phand[i].getText().equals("A of Diamonds")){
    			temp = acediamond;
    			phand[i].setIcon(temp);
    		}
       		else if(phand[i].getText().equals("K of Diamonds")){
    			temp = kingdiamond;
    			phand[i].setIcon(temp);
    		}
       		else if(phand[i].getText().equals("Q of Diamonds")){
    			temp = queendiamond;
    			phand[i].setIcon(temp);
    		}
       		else if(phand[i].getText().equals("J of Diamonds")){
    			temp = jackdiamond;
    			phand[i].setIcon(temp);
    		}
       		else if(phand[i].getText().equals("A of Clubs")){
    			temp = aceclub;
    			phand[i].setIcon(temp);
    		}
       		else if(phand[i].getText().equals("K of Clubs")){
    			temp = kingclub;
    			phand[i].setIcon(temp);
    		}
       		else if(phand[i].getText().equals("Q of Clubs")){
    			temp = queenclub;
    			phand[i].setIcon(temp);
    		}
       		else{
       			temp = jackclub;
       			phand[i].setIcon(temp);
       		}
    	}
    	
    }
		
    
    private void showBoard(){
		iBoard = game.getBoard();
					
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
				else if(iBoard[row][col].getCardSpace().equals("J of Clubs"))
					gameBoard[row][col].setIcon(jackclub);
				
				gameBoard[row][col].setVisible(true);
				
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
                                    	turn.setText("Player Two Turn");
                                    	gameBoard[row][col].setBackground(Color.GREEN);
                                    	gameBoard[row][col].setIcon(null);
                                    	gameBoard[row][col].setText(iBoard[row][col].getCardSpace());
                                    	gameBoard[row][col].setPreferredSize(dim);
                                    	displayHand1();
                                    	setHandIcon(player1Hand);
                                    	
                                    	if(game.getOneWin() == true){
                                    		JOptionPane.showMessageDialog(frame,
                                      			    "Player One Wins!",
                                      			    "Game Over",
                                      			    JOptionPane.PLAIN_MESSAGE);
                                    		System.exit(0);
                                    	}
                                    	
                                    	if(counter > 53)
                                   			System.out.println("tie");
                                    }
                                    game.setValid(false);
                                   }                 
                         else{
                                      game.select(row,col);
                                      
                                      iBoard = game.getBoard();
                                      
                                      if(game.getValid() == true){
                                      	turn.setText("Player One Turn");
                                      	gameBoard[row][col].setBackground(Color.ORANGE);
                                    	gameBoard[row][col].setIcon(null);
                                      	gameBoard[row][col].setText(iBoard[row][col].getCardSpace());
                                      	gameBoard[row][col].setPreferredSize(dim);
                                      	displayHand2();
                                      	setHandIcon(player2Hand);
                                      	
                                      	if(game.getTwoWin() == true){
                                      		JOptionPane.showMessageDialog(frame,
                                      			    "Player Two Wins!",
                                      			    "Game Over",
                                      			    JOptionPane.PLAIN_MESSAGE);
                                      		System.exit(0);
                                      	}
                                      	
                                      	if(counter > 53){
                                      		JOptionPane.showMessageDialog(frame,
                                      			    "Tie Game!",
                                      			    "Game Over",
                                      			    JOptionPane.PLAIN_MESSAGE);
                                      		System.exit(0);
                                      	}
                                      }
                                      game.setValid(false);
                                      
                               }
                                      
                           }
                     		
                       }
                 
                   }
        }    
     }
	@Override
	public void mouseDragged(MouseEvent m) {
		if(drag == true){
			JComponent com = (JComponent)m.getSource();
			
			com.setLocation(com.getX() + m.getX(), com.getY() + m.getY());	
			
			//shows the dragged card in front of the board
			center.setComponentZOrder(com, 1);
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent m) {
		for(int i = 0; i < 5; i++)
			if(player1Hand[i] == m.getSource()){
				drag = true;
				dragged = player1Hand[i];
				point = new Point(dragged.getX(), dragged.getY());
			}
		
		for(int i = 0; i < 5; i++)
			if(player2Hand[i] == m.getSource()){
				drag = true;
				dragged = player2Hand[i];
				point = new Point(dragged.getX(), dragged.getY());
			}
		
		
	}

	@Override
	public void mouseReleased(MouseEvent m) {
		drag = false;
		
		counter = game.getCounter();
		
		//Do not attempt to move a card in a player's hand if none were dragged 
		if(point != null)
		dragged.setLocation(point);
		
		for(int row = 0; row < 8; row++){
			for(int col = 0; col < 8; col++){
				Rectangle rect = gameBoard[row][col].getBounds();
				//allows for some buffer for dropping the dragged card onto the desired location
				rect.grow(10, 10);
				
				if(rect.getBounds().contains(m.getLocationOnScreen())){
						if((counter % 2) == 0){
							//checks if card released on is same when dragging
							game.checkSame(row, col, dragged.getText());
							
							if(game.getSameDragBoo()){
								game.setSameDragBoo();
								
								game.select(row,col);
                            
                            iBoard = game.getBoard();
                           
                            if(game.getValid() == true){
                            	turn.setText("Player Two Turn");
                            	gameBoard[row][col].setBackground(Color.GREEN);
                            	gameBoard[row][col].setIcon(null);
                            	gameBoard[row][col].setText(iBoard[row][col].getCardSpace());
                            	gameBoard[row][col].setPreferredSize(dim);
                            	displayHand1();
                            	setHandIcon(player1Hand);
                            	
                            	if(game.getOneWin() == true){
                            		JOptionPane.showMessageDialog(frame,
                              			    "Player One Wins!",
                              			    "Game Over",
                              			    JOptionPane.PLAIN_MESSAGE);
                            		System.exit(0);
                            	}
                            
                            	
                            	if(counter > 53)
                           			System.out.println("tie");
                            }
								}	
                            game.setValid(false);
                           }                 
                 else{
                	 game.checkSame(row, col, dragged.getText());
						
						if(game.getSameDragBoo()){
							game.setSameDragBoo();
                	 
                              game.select(row,col);
                              
                              iBoard = game.getBoard();
                              
                              if(game.getValid() == true){
                              	turn.setText("Player One Turn");
                              	gameBoard[row][col].setBackground(Color.ORANGE);
                            	gameBoard[row][col].setIcon(null);
                              	gameBoard[row][col].setText(iBoard[row][col].getCardSpace());
                              	gameBoard[row][col].setPreferredSize(dim);
                              	displayHand2();
                              	setHandIcon(player2Hand);
                              
                              	
                              	if(game.getTwoWin() == true){
                              		JOptionPane.showMessageDialog(frame,
                              			    "Player Two Wins!",
                              			    "Game Over",
                              			    JOptionPane.PLAIN_MESSAGE);
                              		System.exit(0);
                              	}
                              	
                              	if(counter > 53){
                              		JOptionPane.showMessageDialog(frame,
                              			    "Tie Game!",
                              			    "Game Over",
                              			    JOptionPane.PLAIN_MESSAGE);
                              		System.exit(0);
                              	}
                              }
                              }
                              game.setValid(false);
                              
                              
                       }
                              
                   }
             		
				}
			}
		}
		
			
	}

		
	







