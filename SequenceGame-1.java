package package1;

import java.util.Random;

public class SequenceGame {

	/** 2D array of spaces to create board */
	private Space[][] board;
	
	/** int to keep track of player turn */
	 private int turn;
	 
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
		
		turn = 1;
	}
	
	public Space[][] getBoard(){
		return board;
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
		int[] counter;
		
		counter = counts;
		
		for (int i = 0; i < counts.length; i++)
			counter[i] = 4;
		
		return counter;
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
		
		Random ran = new Random();
		Random rand = new Random();
		
		String temp;
		
		int name;
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
	

	
	/*
	 * This method switches turns between player 1 and player 2 and prints off
	 * who's turn it is as well.
	 */
	
	public void Turn(){
		while (!gameWon()){
			if (turn % 2 == 0){
				System.out.println("Player 1 Move");
			}if (turn % 2 == 1){
				System.out.println("Player 2 Move");
			}
			turn++;
		}

	}
	
	/*
	 * Method to tell users if a players has won the game or not. In order to win
	 * the game a player must have got 4 in a row.
	 * @returns true if there is a winner, false if a tie
	 */
	
	private boolean gameWon() {

		//check for horizontal win
		int counter = 0;
		for (int row = 0; row < 8; row++){
			counter++;
			for(int col = 1; col < 8; col++){
				if (board [row][col] == board[row][col-1])
					counter++;

		if (counter >= 4){
			return true;
		}
	}
		//check vertical win
		
		for (int col = 0; col < 8; col++){
			counter++;
			for (int row1 = 1; row1 < 8; row1++){
				if (board[row1][col] == board[row1-1][col])
					counter++;
				if (counter >= 4)
					return true;
			}
		}
		
		int col;
		//check for diagonal from top-left to bottom-right
        for (int column = 0; column < 8; ++column) {
            int count = 0;
            for (int row1 = 1; row1 < 8; ++row1) {
                if (col + row1 >= 8) break;
                if (board[row1-1][col + row1 - 1] == board[row1][col+row1])
                    ++count;
       
                if (count >= 4) 
                	return true;
            }
        }
        
        // There are diagonals, that starts on left of each row, let's check them
        for (int row1 = 0; row1 < 8; ++row1) {
            int count = 0;
            for (int col1 = 1; col1 < 8; ++col1) {
                if (col1 + row1 >= 7) break;
                if (board[row1+col1 - 1][col1 - 1] == board[row1 + col1][col1])
                    ++count;
             
                if (count >= 4) 
                	return true;
            }
        }
        
        //check diagonal top-right to bottom-left
        for (int column = 0; col < 8; ++col) {
            int count = 0;
            for (int row = 1; row < 8; ++row) {
                if (col - row < 0) break;
                if (board[row - 1][col - row + 1] == board[row][col-row])
                    ++count;
                else
                    count = 1;
                if (count >= 4) 
                	return true;
                
            }	
        }
		
		return false;
		}
	}

	/*
	 * This method resets the board, shuffles the deck of cards, gives player1 
	 * and player2 new cards and basically restarts the entire game, and makes 
	 * player1 start the game.
	 */
	public void Reset(){
		
			board = new Space[8][8];
			createBoard();
			
			deck = new String[16];
			createDeck(deck);
			
			playerOne = new String [5];
			playerTwo = new String [5];
			giveHand(playerOne);
			giveHand(playerTwo);
			
			deckCount = new int[16];
			
			turn = 0;
			
		}
	}

	


