	/*
	 * Method to tell users if a players has won the game or not. In order to win
	 * the game a player must have got 4 in a row.
	 * @returns true if there is a winner, false if a tie
	 */
	
	private boolean gameWon() {
	
		//check for vertical win--player2
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCurrentCard() == playerTwo[i].toString()){
				if (board[i-1][j].getCurrentCard() == playerTwo[i].toString() && playerTwo[i].toString() == board[i-2][j].getCurrentCard() 
						&& playerTwo[i].toString() == board[i-3][j].getCurrentCard()){
					return true;
				}
			}

		}
	}
		//horizontal win -- player2
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCurrentCard() == playerTwo[i].toString()){
				if (board[i][j-1].getCurrentCard() == playerTwo[i].toString() && board[i][j-2].getCurrentCard() == playerTwo[i].toString()
						&& board[i][j-3].getCurrentCard() == playerTwo[i].toString())
				return true;
			}

		}
	}
		//diagonal win -- player 2
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCurrentCard() == playerTwo[i].toString()){
				if (board[i-1][j-1].getCurrentCard() == playerTwo[i].toString() && board[i-2][j-2].getCurrentCard() == playerTwo[i].toString()
						&& board[i-3][j-3].getCurrentCard() == playerTwo[i].toString())
				return true;
			}

		}
	}
		//diagonal win -- player2
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCurrentCard() == playerTwo[i].toString()){
				if (board[i+1][j+1].getCurrentCard() == playerTwo[i].toString() && board[i+2][j+2].getCurrentCard() == playerTwo[i].toString()
						&& board[i+3][j+3].getCurrentCard() == playerTwo[i].toString())
				return true;
			}

		}
	}

		//vertical win -- player1
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCurrentCard() == playerOne[i].toString()){
				if (board[i-1][j].getCurrentCard() == playerOne[i].toString() && board[i-2][j].getCurrentCard() == playerOne[i].toString()
						&& board[i-3][j].getCurrentCard() == playerOne[i].toString()){
					return true;
				}
			}

		}
	}
		//horizontal win -- player1
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCurrentCard() == playerOne[i].toString()){
				if (board[i][j-1].getCurrentCard() == playerOne[i].toString() && board[i][j-2].getCurrentCard() == playerOne[i].toString()
						&& board[i][j-3].getCurrentCard() == playerOne[i].toString())
				return true;
			}
		}
	}
		//diagonal win -- player1
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCurrentCard() == playerOne[i].toString()){
				if (board[i-1][j-1].getCurrentCard() == playerOne[i].toString() && board[i-2][j-2].getCurrentCard() == playerOne[i].toString()
						&& board[i-3][j-3].getCurrentCard() == playerOne[i].toString())
				return true;
			}
		}
	}
		//diagonal win -- player1
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
			if(board[i][j].getCurrentCard() == playerOne[i].toString()){
				if (board[i+1][j+1].getCurrentCard() == playerOne[i].toString() && board[i+2][j+2].getCurrentCard() == playerOne[i].toString()
						&& board[i+3][j+3].getCurrentCard() == playerOne[i].toString())
				return true;
			}
		}
	}

		return false;
}
