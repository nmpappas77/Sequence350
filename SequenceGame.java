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
		
		turn = 1;
		
		
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
}
