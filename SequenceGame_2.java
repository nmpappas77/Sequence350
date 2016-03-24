package package1;

import java.util.Random;

public class SequenceGame {

	/** 2D array of spaces to create board */
	private Space[][] board;
	
	/** int to keep track of player turn */
	 private int counter;
	 
	 /** Array of card names that resembles the deck */
	 private String[] deck;
	 
	 /** array to keep track how many of each card need to be inserted or are left */
	 private int[] deckCount;
	 
	 /**array to keep track of how many of each card need to be inserted for board initially
	  * Not used after game start, it is only to initialize the deck */
	 private int[] secDeckCount;
	 
	 /**Player one's hand */
	 private String[] playerOne;
	 
	 /** Player two's hand */
	 private String[] playerTwo;
	 
	 /** Check for valid button press */
	 private boolean valid;
	 
	 /** Boolean for games won */
	 private boolean oneWin, twoWin;
	
	 
	 /**Constructor to create a game */
	public SequenceGame(){
		//create the deck
		deck = new String[16];
		createDeck(deck);
		
		deckCount = new int[16];
		secDeckCount = new int[16];
		
		//create internal board
		board = new Space[8][8];
		createBoard();
		
		//Create player hands
		playerOne = new String[5];
		playerTwo = new String[5];
		
		//gives the players their hands
		giveHand(playerOne);
		giveHand(playerTwo);
		
		//Print out card to test system functionality with player hand and board
		//System.out.println(playerTwo[3].toString());
		//System.out.println(board[4][5].getCardSpace());
		
		counter = 0;
		
		valid = false;
		
		oneWin = false;
		twoWin = false;
	}
	
	public boolean getOneWin(){
		return oneWin;
	}
	
	public boolean getTwoWin(){
		return twoWin;
	}
	
	public String[] getPlayerOne(){
		return playerOne;
	}
	
	public String[] getPlayerTwo(){
		return playerTwo;
	}
	
	public Space[][] getBoard(){
		return board;
	}
	
	public Boolean getValid(){
		return valid;
	}
	
	public void setValid(Boolean b){
		valid = false;
	}
	
	/** Creates the array of cards in the deck */
	public String[] createDeck(String[] cards){
		
		deck = cards;
		
		deck[0] = "J of Spades";
		deck[1] = "Q of Spades";
		deck[2] = "K of Spades";
		deck[3] = "A of Spades";
		
		deck[4] = "J of Clubs";
		deck[5] = "Q of Clubs";
		deck[6] = "K of Clubs";
		deck[7] = "A of Clubs";
		
		deck[8] = "J of Diamonds";
		deck[9] = "Q of Diamonds";
		deck[10] = "K of Diamonds";
		deck[11] = "A of Diamonds";
		
		deck[12] = "J of Hearts";
		deck[13] = "Q of Hearts";
		deck[14] = "K of Hearts";
		deck[15] = "A of Hearts";
		
		return deck;
	}
	
	/** makes every card have a count of 4 in the array */
	public int[] fillDeck(int[] counts){
		int[] counting;
		
		counting = counts;
		
		for (int i = 0; i < counts.length; i++)
			counting[i] = 4;
		
		return counting;
	}
	
	public String[] giveHand(String[] playerHand){
		String[] hand;
		hand = playerHand;
		
		int x;
		int y;
		
		String tempCard;
		
		Random ran = new Random();
		Random rand = new Random();
		
		for (int i = 0; i < 5; i++){
			x = ran.nextInt(16); //number 1-16
			
			tempCard = deck[x]; //card is that card from deck position
			
			while(deckCount[x] == 0){
				y = rand.nextInt(16);
				 //if no cards of that kind left move on
				x = (x + y) % 16; //replace x if necessary
			}
			tempCard = deck[x].toString();
			
			deckCount[x] = deckCount[x] - 1; //remove one of 4 cards
			hand[i] = tempCard; //first spot in hand is that card from deck
			
			//random number generated, inputed through the deck cards, then 
			//that card is placed in player's hand. The next step is to subtract
			//one from the count array
		}
		return hand;
	}
	
	public void createBoard(){
		
		fillDeck(secDeckCount);
		fillDeck(deckCount);
		
		Random ran = new Random();
		Random rand = new Random();
		
		String temp;
	
		int x;
		int y;
		
		for(int row = 0; row < 8; row++){
			for(int col = 0; col < 8; col++){
				x = ran.nextInt(16); //number 1-16
								
				while(secDeckCount[x] == 0){
					y = rand.nextInt(16);
					x = (x + y) % 16;
				}
				
				temp = deck[x].toString();//possible new deck position
				
				secDeckCount[x] = secDeckCount[x] - 1;//remove one of 4 cards
				board[row][col] = new Space(temp);//associates board position with card
			}
		}
	}
	
	public void replaceCard(String[] playerHand){
		
		String [] hand;
		
		hand = playerHand;
		
		for(int i = 0; i < 5; i++){
			if(hand[i] == null)
				hand[i] = takeCard(deck);
			
		}
		
	}
	
	public String takeCard(String[] pile){
		Random ran = new Random();
		Random rand = new Random();
		
		int y;
		int x;
		
		String tempCard;
				
		x = ran.nextInt(16); //number 1-16
			
			while(deckCount[x] == 0){
				y = rand.nextInt(16);
				 //if no cards of that kind left move on
				x = (x + y) % 16; //replace x if necessary
			}
			tempCard = deck[x].toString();
			
			deckCount[x] = deckCount[x] - 1; //remove one of 4 cards
			
			return tempCard;
									
	}
	
	public int getCounter(){
		return counter;
	}
	
	public void Turn(){
			if(counter % 2 == 1){
				System.out.println("Player 1 Move");
				counter++;
			}
			else{ 
				System.out.println("Player 2 Move");
				counter++;
			}
			
	}
	
	//plays the card selected and replaces that card
	public void select(int row, int col){
				
		if(counter % 2 == 0)
			for(int i = 0; i < 5; i++)
				if(board[row][col].getCardSpace() == playerOne[i].toString()){
					board[row][col] = new Space("Player One");
					playerOne[i] = null;
					replaceCard(playerOne);
					Turn();
					valid = true;
				}
		
		if(counter % 2 == 1)
			for(int i = 0; i < 5; i++)
				if(board[row][col].getCardSpace() == playerTwo[i].toString()){
					board[row][col] = new Space("Player Two");
					playerTwo[i] = null;
					replaceCard(playerTwo);
					Turn();
					valid = true;
				}
		
	}
	
	private int switchSign(int i, int z){
		int w, b;
		w = z;
		b = i;
		
		if(b - w < 0){
			w = -w;
		
			if(w < 0)
				w = -1;
			else
				w = 1;
		}
		
		return w;
	}
	/*
	 * Method to tell users if a players has won the game or not. In order to win
	 * the game a player must have got 4 in a row.
	 * @returns true if there is a winner, false if a tie
	 */
	
	public void gameWon() {
		int tick = 0;
		int z = 1;
		int x = 2;
		int y = 3;
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				
				tick = 0;
				z = 1;
				x = 2;
				y = 3;
				
				if(board[i][j].getCardSpace().equals("Player Two"))
					tick++;
				
					z = switchSign(i, z);
					
					if(board[i - z][j].getCardSpace().equals("Player Two"))
						tick++;
					
					x = switchSign(i, x);
					
					if(board[i - x][j].getCardSpace().equals("Player Two"))
						tick++;
					
					y = switchSign(i, y);
					
					if(board[i - y][j].getCardSpace().equals("Player Two"))
						tick++;
						
					if(tick == 4)
						twoWin = true;
				}
			}
		
	for(int i = 0; i < 8; i++){
		for(int j = 0; j < 8; j++){
			
			tick = 0;
			z = 1;
			x = 2;
			y = 3;
			
			if(board[i][j].getCardSpace().equals("Player One"))
				tick++;
			
				z = switchSign(i, z);
				
				if(board[i - z][j].getCardSpace().equals("Player One"))
					tick++;
				
				x = switchSign(i, x);
				
				if(board[i - x][j].getCardSpace().equals("Player One"))
					tick++;
				
				y = switchSign(i, y);
				
				if(board[i - y][j].getCardSpace().equals("Player One"))
					tick++;
					
				if(tick == 4)
					oneWin = true;
			}
		}

	for(int i = 0; i < 8; i++){
		for(int j = 0; j < 8; j++){
			
			tick = 0;
			z = 1;
			x = 2;
			y = 3;
			
			if(board[i][j].getCardSpace().equals("Player One"))
				tick++;
			
				z = switchSign(j, z);
				
				if(board[i][j - z].getCardSpace().equals("Player One"))
					tick++;
				
				x = switchSign(j, x);
				
				if(board[i][j - x].getCardSpace().equals("Player One"))
					tick++;
				
				y = switchSign(j, y);
				
				if(board[i][j - y].getCardSpace().equals("Player One"))
					tick++;
					
				if(tick == 4)
					oneWin = true;
			}
		}
	
	for(int i = 0; i < 8; i++){
		for(int j = 0; j < 8; j++){
			
			tick = 0;
			z = 1;
			x = 2;
			y = 3;
			
			if(board[i][j].getCardSpace().equals("Player Two"))
				tick++;
		
			z = switchSign(j, z);
			
			if(board[i][j - z].getCardSpace().equals("Player Two"))
				tick++;
			
			x = switchSign(j, x);
			
			if(board[i][j - x].getCardSpace().equals("Player Two"))
				tick++;
			
			y = switchSign(j, y);
			
			if(board[i][j - y].getCardSpace().equals("Player Two"))
				tick++;
				
			if(tick == 4)
				twoWin = true;
			
			}
		}
	}
}
