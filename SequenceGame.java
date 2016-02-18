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
			
			//create internal board
			board = new Space[8][8];
			createBoard();
			
			//Create player hands
			playerOne = new String[5];
			playerTwo = new String[5];
			
			giveHand(playerOne);
			giveHand(playerTwo);//gives the players their hands
			
			//Print out card to test system functionality with player hand and board
			//System.out.println(playerTwo[3].toString());
			//System.out.println(board[4][5].getCardSpace());
			
			turn = 0;
			
			
		}
		
		public Space[][] getboard(){
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
			deckCount = counts;
			
			for (int i = 0; i < counts.length; i++)
				deckCount[i] = 4;
			
			return deckCount;
		}
		
		public String[] giveHand(String[] playerHand){
			String[] hand;
			hand = playerHand;
			
			int x;
			String tempCard;
			
			Random ran = new Random();
			
			for (int i = 0; i < 5; i++){
				x = ran.nextInt(16); //number 1-16
				tempCard = deck[x]; //card is that card from deck position
				if(deckCount[x] == 0){
					tempCard = deck[(x + 1) % 16]; //if no cards of that kind left move on
					x = (x + 1) % 16; //replace x if necessary
				}
				deckCount[x] = deckCount[x] - 1; //remove one of 4 cards
				hand[i] = deck[x]; //first spot in hand is that card from deck
				
				//random number generated, inputed through the deck cards, then 
				//that card is placed in player's hand. The next step is to subtract
				//one from the count array
			}
			return hand;
		}
		
		public void createBoard(){
			Random ran = new Random();
			
			String temp;
			
			int name;
			int x;
			
			for(int row = 0; row < 8; row++)
				for(int col = 0; col < 8; col++){
					x = ran.nextInt(15) + 1; //number 1-16
					temp = deck[x]; //card is that card from deck position
					if(deckCount[x] == 0){
						temp = deck[(x+1) % 16];//if no cards of that kind move on
						x = (x+1) % 16; //replace x if necessary
					}
					deckCount[x] = deckCount[x] - 1; //remove one of 4 cards
					board[row][col] = new Space(deck[x].toString());//associates board position with card
				}
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
		
		//check for vertical win
		int counter = 0;
		for (int row = 0; row < 8; row++){
			counter++;
			for(int col = 1; col < 8; col++){
				if (board[row][col] != 'Space' && board [row][col] == board[row][col-1])
					counter++;
			
		else 
			counter = 1;
		if (counter >= 4){
			return true;
		}
	}
		//check horizontal win
		
		for (int col = 0; col < 8; col++){
			counter++;
			for (int row = 1; row < 8; row++){
				if (board[row][col] != ' ' && board[row][col] == board[row-1][col])
`					counter++;
				else counter = 1;
				
				if (counter >= 4)
					return true;
			}
		}
		
		//check for diagonal from top-left to bottom-right
        for (int column = 0; column < 8; ++column) {
            int count = 0;
            for (int row = 1; row < 8; ++row) {
                if (col + row >= 8) break;
                if (board[row][col+row] != ' ' &&
                    board[row-1][col + row - 1] == board[row][col+row])
                    ++count;
                else
                    count = 1;
                if (count >= 4) 
                	return true;
            }
        }
        
        // There are diagonals, that starts on left of each row, let's check them
        for (int row = 0; row < 8; ++row) {
            int count = 0;
            for (int col = 1; col < 8; ++col) {
                if (col + row >= 7) break;
                if (board[row + col][col] != ' ' &&
                    board[row+col - 1][col - 1] == board[row + col][col])
                    ++count;
                else
                    count = 1;
                if (count >= 4) 
                	return true;
            }
        }
        
        //check diagonal top-right to bottom-left
        for (int column = 0; col < 7; ++col) {
            int count = 0;
            for (int row = 1; row < 7; ++row) {
                if (col - row < 0) break;
                if (board[row][col-row] != ' ' &&
                    board[row - 1][col - row + 1] == board[row][col-row])
                    ++count;
                else
                    count = 1;
                if (count >= 4) 
                	return true;
            }
        }

        // There are diagonals, that starts on left of each row, let's check them
        for (int row = 0; row < 7; ++row) {
            int count = 0;
            for (int col = 5; col >= 0; --column) {
                if (col - row < 0) break;
                if (board[col - row][col] != ' ' &&
                    board[col - row - 1][col + 1] == board[col - row][col])
                    ++count;
                else
                    count = 1;
                if (count >= 4) 
                	return true;
            }
        }
		
		return false;
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
