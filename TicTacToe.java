public class TicTacToe extends basicpackage.BasicBoard implements Game {
	
	// Dimension of the board, only quadratic boards allowed
	int dimension;
	
	// Constructor, Object created with one int (for witdh and height)
	public TicTacToe(int x) throws Exception {
		// Call super-class constructor (to make board Field accessible) 
		super();
		// If min height of 3 not provided
		if(x < 3){ 
			// Pass exception with corresponding message
			throw new Exception("Minimum valid dimension is 3!");
		} else {
			// Create 2D-Array with dimension specified and save dimensions in field
			board = new int[x][x];
			dimension = x;
		}
	}

	/**
	 * Method called to make a move. Determines whether a move is actually possible
	 * 
	 * @param player - Integer that specifies the player (should only be 1 or 2, provided by Runner)
	 * @param x - Integer for the row where the chip should be set
	 * @param y - Integer for the column where the chip should be set
	 * @throws Exception - Exception thrown at certain illegal moves, containing Message to be printed if received
	 */
	public void setChip(int player, int x, int y) throws Exception{
		// Selected Field is empty and within the board
		if(this.board[y][x] == 0 && x < dimension && y < dimension) {
			this.board[y][x] = player;
		} 
		// Selected field is on board but already occupied by opponent
		else if(this.board[y][x] != 0 && this.board[y][x] != player && x < dimension && y < dimension){
			throw new Exception("This Fiel is already occupied by your opponent. Plase choose a different one! \n");
		} 
		// Selected field is on board but already occupied by you
		else if(this.board[y][x] != 0 && this.board[y][x] == player && x < dimension && y < dimension){
			throw new Exception("This Fiel is already occupied by you. Plase choose a different one! \n");
		} 
		// Selected field is outside the board borders
		else {
			int max = dimension-1;
			throw new Exception("Your provided coodinates are out of bounce.\n Please provice valid coorinates within 0 0 and " + max + " " + max + "\n");
		}
	}

	/**
	 * Method to check whether a player has won the game based on the current status of the board
	 * 
	 * @return - Boolean to be checked by the Runner class and end game upon true
	 */
	public boolean existWinner(){
		// Stores number set in the first field (of row / column / diagonal)
		int prev;
		// Flag for winner. If not changed to false during checking, the game is already over
		boolean winner = true;

		// Checks Rows for "dimension" times the same value excluding 0
		for(int i = 0; i < board.length; i++ ){
			// Set the value to true to give each row a chance
			winner = true;
			// Store first position in current row
			prev = board[i][0];
			
			// Check every column in current row, skipping the first as it is already saved in prev.
			for(int j = 1; j < board.length; j++){
				// Change Flag to false, if current column in current row does not match first position or is equal to 0
				// Abort further checking if true
				if(board[i][j] != prev || prev == 0){
					winner = false;
					break;
				}
			}

			// If current row is checked trough and flag is still true, end method and return true
			if(winner){
				return true;
			}
		}

		// Checks Columns for "dimension" times the same value excluding 0
		for(int i = 0; i < board.length; i++){
			// Set the value to true to give each row a chance 
			winner = true;
			// Store first position in current column
			prev = board[0][i];
			
			// Check every row in current column, skipping the first as it is already saved in prev.
			for(int j = 1; j < board.length; j++) {
				// Change Flag to false, if current row in current column does not match first position or is equal to 0
				// Abort further checking if true
				if(board[j][i] != prev || prev == 0){
					winner = false;
					break;
				}
			}

			// If current column is checked trough and flag is still true, end method and return true
			if (winner){
				return true;
			}
		}

		// Checks diagonal (\) for "dimension" times the same value excluding 0
		// Set flag back to true
		winner = true;
		// Store number in the top left corner
		prev = board[0][0];
		
		// Increase X and Y coordinates equally to follow the main-diagonal
		for(int i = 0; i < board.length; i++){
			// Change Flag to false, if current position does not match first position or is equal to 0
			// Abort further checking if true
			if(board[i][i] != prev || prev ==0){
				winner = false;
				break;
			}
		}

		// If current column is checked trough and flag is still true, end method and return true
		if (winner){
			return true;
		}

		// Checks diagonal (/) for "dimension" times the same value excluding 0
		// Set flag back to true
		winner=true;
		// Store number in the top right corner
		prev = board[0][board.length-1];
		// Help number for x coordinate
		int i = 0;
		
		// Increase X and decrease Y coordinates equally to follow the main-diagonal
		for(int j = board.length-1; j >= 0; j--){
			// Change Flag to false, if current position does not match first position or is equal to 0
			// Abort further checking if true
			if(board[i][j] != prev || prev == 0){
				winner = false;
				break;
			}
			i++;
		}
		
		// If current column is checked trough and flag is still true, end method and return true
		if (winner){
			return true;
		}
		
		// If trough all checks and no true has been already returned, return false. The game is still on
		return false;
	}
	
	/**
	 * If game ends with no winner
	 * 
	 * @return - true if every field is occupied
	 */
	public boolean noMoreFreeFields(){
		// Set flag to true
		boolean full = true;
		
		// Go trough every field
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board.length; j++){
				// Set flag to false if found empty field
				if(board[i][j] == 0) full = false; 
			}
		}
		
		// Return flag
		return full;
	}

	/**
	 * Prints the current state of the board
	 */
	public void ausgeben(){
		// Define row and column helper
		System.out.print("x\\y\t");
		for(int k = 0; k < board.length; k++){
			// Print y coordinates
			System.out.print(k + "\t");
		}
		// Spacer
		System.out.print("\n\n");
		// Go to every field in 2D Array
		for(int i = 0; i < board.length; i++){
			// Print current x coordinate
			System.out.print(i + "\t");
			for(int j = 0; j < board.length; j++){
				// No icon if field belongs to nobody
				if(board[i][j] == 0){
					System.out.print(" \t");
				}
				// "x" icon if field belongs to player 1
				else if(board[i][j] == 1){
					System.out.print("x\t");
				} 
				// "y" icon if field belongs to player 2
				else if(board[i][j] == 2){
					System.out.print("o\t");
				}
			}
			// Spacer
			System.out.print("\n\n");
		}
	}

	/**
	 * I guessed that this method should turn the boolean into a String 
	 * 
	 * @return - Result of boolean method existWinner() as String
	 */
	@Override
	public String gameStatus(){
		if(this.existWinner()) {
			return "Game is over";
		} else {
			return "Game is still on";
		}
	}
  
}
