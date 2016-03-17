	/*
	 * Method to tell users if a players has won the game or not. In order to win
	 * the game a player must have got 4 in a row.
	 * @returns true if there is a winner, false if a tie
	 */
	
	private boolean gameWon() {

		//check for horizontal win
		
		for (int row = 0; row < 8; row++){
			counter=0;
			for(int col = 1; col < 8; col++){
				if (board [row][col] == board[row][col-1])
					counter++;

		if (counter >= 4){
			return true;
		}
	}
		//check vertical win
		
		for (int col = 0; col < 8; col++){
			counter=0;
			for (int row1 = 1; row1 < 8; row1++){
				if (board[row1][col] == board[row1-1][col])
					counter++;
				if (counter >= 4)
					return true;
			}
		}
		
		//int col;
		//check for diagonal from top-left to bottom-right
        for (int col1 = 0; col1 < 8; ++col1) {
            int count = 0;
            for (int row1 = 1; row1 < 8; ++row1) {
                if (col1 + row1 >= 8) break;
                if (board[row1-1][col1 + row1 - 1] == board[row1][col1+row1])
                    ++count;
       
                if (count >= 4) 
                	return true;
            }
        }
        
        // There are diagonals, that starts on left of each row
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
        for (int col1 = 0; col1 < 8; ++col1) {
            int count = 0;
            for (int row1 = 1; row1 < 8; ++row1) {
                if (col1 - row1 < 0) break;
                if (board[row1 - 1][col1 - row1 + 1] == board[row1][col1-row1])
                    ++count;
                else
                    count = 1;
                if (count >= 4) 
                	return true;
                
            }	
        }
		
		
		}
		return false;
	}
