	/*
	 * Method to tell users if a players has won the game or not. In order to win
	 * the game a player must have got 4 in a row.
	 * @returns true if there is a winner, false if a tie
	 */
	
	private boolean gameWon() {
	
		//check for horizontal win
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCardSpace() == playerOne[i].toString()){
				if (board[i][j].getCardSpace() == board[i-1][j].getCardSpace()){
					counter++;
				}
			}
			if (counter >= 4)
				return true;
		}
	}
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCardSpace() == playerTwo[i].toString()){
				if (board[i][j].getCardSpace() == board[i][j-1].getCardSpace())
				counter++;
			}
			if (counter >= 4)
				return true;
		}
	}
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCardSpace() == playerTwo[i].toString()){
				if (board[i][j].getCardSpace() == board[i-1][j-1].getCardSpace())
				counter++;
			}
			if (counter >= 4)
				return true;
		}
	}
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCardSpace() == playerTwo[i].toString()){
				if (board[i][j].getCardSpace() == board[i+1][j+1].getCardSpace())
				counter++;
			}
			if (counter >= 4)
				return true;
		}
	}
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCardSpace() == playerTwo[i].toString()){
				if (board[i][j].getCardSpace() == board[i+1][j-1].getCardSpace())
				counter++;
			}
			if (counter >= 4)
				return true;
		}
	}
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCardSpace() == playerTwo[i].toString()){
				if (board[i][j].getCardSpace() == board[i-1][j+1].getCardSpace())
				counter++;
			}
			if (counter >= 4)
				return true;
		}
	}
		return false;
}
