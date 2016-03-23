	/*
	 * Method to tell users if a players has won the game or not. In order to win
	 * the game a player must have got 4 in a row.
	 * @returns true if there is a winner, false if a tie
	 */
	
	private boolean gameWon() {
	
		//check for vertical win--player2
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCardSpace() == playerTwo[i].toString()){
				if (board[i][j].getCardSpace() == board[i-1][j].getCardSpace() && board[i][j].getCardSpace() == board[i-2][j].getCardSpace() 
						&& board[i][j].getCardSpace() == board[i-3][j].getCardSpace()){
					return true;
				}
			}

		}
	}
		//horizontal win -- player2
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCardSpace() == playerTwo[i].toString()){
				if (board[i][j].getCardSpace() == board[i][j-1].getCardSpace() && board[i][j].getCardSpace() == board[i][j-2].getCardSpace()
						&& board[i][j].getCardSpace() == board[i][j-3].getCardSpace())
				return true;
			}

		}
	}
		//diagonal win -- player 2
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCardSpace() == playerTwo[i].toString()){
				if (board[i][j].getCardSpace() == board[i-1][j-1].getCardSpace() && board[i][j].getCardSpace() == board[i-2][j-2].getCardSpace()
						&& board[i][j].getCardSpace() == board[i-3][j-3].getCardSpace())
				return true;
			}

		}
	}
		//diagonal win -- player2
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCardSpace() == playerTwo[i].toString()){
				if (board[i][j].getCardSpace() == board[i+1][j+1].getCardSpace() && board[i][j].getCardSpace() == board[i+2][j+2].getCardSpace()
						&& board[i][j].getCardSpace() == board[i+3][j+3].getCardSpace())
				return true;
			}

		}
	}

		//vertical win -- player1
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCardSpace() == playerOne[i].toString()){
				if (board[i][j].getCardSpace() == board[i-1][j].getCardSpace() && board[i][j].getCardSpace() == board[i-2][j].getCardSpace()
						&& board[i][j].getCardSpace() == board[i-3][j].getCardSpace()){
					return true;
				}
			}

		}
	}
		//horizontal win -- player1
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCardSpace() == playerOne[i].toString()){
				if (board[i][j].getCardSpace() == board[i][j-1].getCardSpace() && board[i][j].getCardSpace() == board[i][j-2].getCardSpace()
						&& board[i][j].getCardSpace() == board[i][j-3].getCardSpace())
				return true;
			}
		}
	}
		//diagonal win -- player1
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCardSpace() == playerOne[i].toString()){
				if (board[i][j].getCardSpace() == board[i-1][j-1].getCardSpace() && board[i][j].getCardSpace() == board[i-2][j-2].getCardSpace()
						&& board[i][j].getCardSpace() == board[i-3][j-3].getCardSpace())
				return true;
			}
		}
	}
		//diagonal win -- player1
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCardSpace() == playerOne[i].toString()){
				if (board[i][j].getCardSpace() == board[i+1][j+1].getCardSpace() && board[i][j].getCardSpace() == board[i+2][j+2].getCardSpace()
						&& board[i][j].getCardSpace() == board[i+3][j+3].getCardSpace())
				return true;
			}
		}
	}

		return false;
}
