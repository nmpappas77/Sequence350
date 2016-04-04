	public void gameWonCheck(){
		//Horizontal check
		for(int row = 0; row < 8; row++){
			for(int col = 0; col < 8; col++){
				if(board[row][col].getCardSpace().equals("Player One") || 
						board[row][col].getCardSpace().equals("Player Two")){
					String play = board[row][col].getCardSpace();
					tick++;
					
					if(col + 3 > 7){
						tick = 0;
						continue;
					}
					else{	
					
						if(board[row][col + 1].getCardSpace().equals(play))
							tick++;
						else{
							tick = 0;
						}
						
						if(board[row][col + 2].getCardSpace().equals(play))
							tick++;
						else{
							tick = 0;
						}
						
						if(board[row][col + 3].getCardSpace().equals(play))
							tick++;
						else{
							tick = 0;
						}
						
						if(tick == 4){
							if(counter % 2 == 1){
								oneWin = true;
								System.out.println("Player One Wins");
							}
							else{
								twoWin = true;
								System.out.println("Player Two Wins");
							}
						}
						else{
							tick = 0;							
						}
					}
				}
			}
		}
		//Vertical check
				for(int row = 0; row < 8; row++){
					for(int col = 0; col < 8; col++){
						if(board[row][col].getCardSpace().equals("Player One") || 
								board[row][col].getCardSpace().equals("Player Two")){
							String play = board[row][col].getCardSpace();
							tick++;
							
							if(row + 3 > 7){
								tick = 0;
								continue;
							}
							else{
								if(board[row + 1][col].getCardSpace().equals(play))
									tick++;
								else{
									tick = 0;
								}
								
								if(board[row + 2][col].getCardSpace().equals(play))
									tick++;
								else{
									tick = 0;
								}
								
								if(board[row + 3][col].getCardSpace().equals(play))
									tick++;
								else{
									tick = 0;
								}
								
								if(tick == 4){
									if(counter % 2 == 1){
										oneWin = true;								
										System.out.println("Player One Wins");
									}
									else{
										twoWin = true;
										System.out.println("Player Two Wins");
									}
								}
							}
						}
					}
				}
				//diagonal right check
				for(int row = 0; row < 8; row++){
					for(int col = 0; col < 8; col++){
						if(board[row][col].getCardSpace().equals("Player One") || 
								board[row][col].getCardSpace().equals("Player Two")){
							String play = board[row][col].getCardSpace();
							tick++;
							
							if(row + 3 > 7){
								tick = 0;
								continue;
							}
							else{
								if(board[row + 1][col + 1].getCardSpace().equals(play))
									tick++;
								else{
									tick = 0;
								}
								
								if(board[row + 2][col + 2].getCardSpace().equals(play))
									tick++;
								else{
									tick = 0;
								}
								
								if(board[row + 3][col + 3].getCardSpace().equals(play))
									tick++;
								else{
									tick = 0;
								}
								
								if(tick == 4){
									if(counter % 2 == 1){
										oneWin = true;								
										System.out.println("Player One Wins");
									}
									else{
										twoWin = true;
										System.out.println("Player Two Wins");
									}
								}
							}
						}
					}
				}
				//diagonal check left
				for(int row = 0; row < 8; row++){
					for(int col = 0; col < 8; col++){
						if(board[row][col].getCardSpace().equals("Player One") || 
								board[row][col].getCardSpace().equals("Player Two")){
							String play = board[row][col].getCardSpace();
							tick++;
							
							if(row + 3 > 7){
								tick = 0;
								continue;
							}
							else{
								if(board[row + 1][col - 1].getCardSpace().equals(play))
									tick++;
								else{
									tick = 0;
								}
								
								if(board[row + 2][col - 2].getCardSpace().equals(play))
									tick++;
								else{
									tick = 0;
								}
								
								if(board[row + 3][col - 3].getCardSpace().equals(play))
									tick++;
								else{
									tick = 0;
								}
								
								if(tick == 4){
									if(counter % 2 == 1){
										oneWin = true;								
										System.out.println("Player One Wins");
									}
									else{
										twoWin = true;
										System.out.println("Player Two Wins");
									}
								}
							}
						}
					}
				}
				//check final two spots in diagonal (up-right check)
				for(int row = 0; row < 8; row++){
					for(int col = 0; col < 8; col++){
						if(board[row][col].getCardSpace().equals("Player One") || 
								board[row][col].getCardSpace().equals("Player Two")){
							String play = board[row][col].getCardSpace();
							tick++;
							
							if(col == 4)
								if(row == 5 || row == 6 || row == 7){
								tick = 0;
								continue;
								}
								else{
									if(board[row + 1][col + 1].getCardSpace().equals(play))
										tick++;
									else{
										tick = 0;
									}
									
									if(board[row + 2][col + 2].getCardSpace().equals(play))
										tick++;
									else{
										tick = 0;
									}
									
									if(board[row + 3][col + 3].getCardSpace().equals(play))
										tick++;
									else{
										tick = 0;
									}
									
									if(tick == 4){
										if(counter % 2 == 1){
											oneWin = true;								
											System.out.println("Player One Wins");
										}
										else{
											twoWin = true;
											System.out.println("Player Two Wins");
										}
									}
								}
							}
						}
					}
	}
