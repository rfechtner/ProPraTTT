import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
  public static void main(String[] args) {
	  
	// Reserve space for TicTacToe Object
    TicTacToe ttt = null;

    // Flag for valid dimension of board (minimum = 3)
    boolean validDimension = false;
    
    // While Flag not changed
    while(validDimension == false){
    	// If user started application with parameter
    	if(args.length != 0) {
    		// Create Board if valid dimension and print it
    		// Catch errors i.e. dimension < 3 or parameter could not be parsed to number
    		try {
				ttt = new TicTacToe(Integer.parseInt(args[0]));
				ttt.ausgeben();
	    		validDimension = true;
			} catch (NumberFormatException e) {
				System.out.print(e.getMessage());
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
    	} 
    	// If not started with parameter
    	else {
    		
    		// Offer user possibility to specify dimension via input
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		System.out.println("Please define board dimensions: (i.e. 3)\n");
    		String s = null;
      
    		// Try reading, catch possible exceptions
    		try {
    			s = br.readLine();
    		} catch (IOException e) {
    			System.out.print(e.getMessage());
    		}

    		// Create Board if valid dimension and print it
    		// Catch errors i.e. dimension < 3 or input could not be parsed to number 
    		try {
				ttt = new TicTacToe(Integer.parseInt(s));
				ttt.ausgeben();
				validDimension = true;
			} catch (NumberFormatException e) {			
				System.out.print(e.getMessage());
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
    	}
    }

    // Turn counter
    int turn = 0;
    
    // While game is not over
    while (ttt.existWinner() == false){
      // Next turn has begun
      turn++;

      // Flag to be set if chosen move is valid
      boolean validTurn = false;
      
      // While not 
      while(validTurn == false){ 
    	  // Provide user the possibility to choose next move
    	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	  
    	  // Reference player by current turn, always starting with player 1
    	  if(turn % 2 != 0) {
    		  System.out.print("Player 1 ");
    	  }  else {
    		  System.out.print("Player 2 ");
    	  }
    	  
    	  // Actual question with input example
    	  System.out.print("plase provide x (row) and y (column)\n coordinates for next move: (i.e. 1 1)");
    	  String s = null;
    	  
    	  
    	  int x = 0;
    	  int y = 0;
    	  
    	  // Try reading, catch possible exceptions
    	  try {
			s = br.readLine();
			x = Integer.parseInt(s.split(" ")[0]);
	    	y = Integer.parseInt(s.split(" ")[1]);
    	  } catch (Exception e1) {
			e1.getMessage();
    	  }

    	  // Reference player by turn
    	  if (turn % 2 != 0) {
    		  try {
    			  // "Request" move, provided by user
    			  ttt.setChip(1,y,x);
    			  // If no exception has been thrown
    			  validTurn=true;
    		  } catch (Exception e) {
    			  System.out.print(e.getMessage());
    		  }
    	  } else {
    		  try {
    			  // "Request" move, provided by user
    			  ttt.setChip(2,y,x);
    			  // If no exception has been thrown
    			  validTurn=true;
    		  } catch (Exception e) {
    			  System.out.print(e.getMessage());
    		  }
    	  }
    	  
    	  
      }
      // Display board with new setup
      ttt.ausgeben();
      
      // Set flag back for next move
      validTurn=false;

      // Continue until game over
    }
    
    // Once game over == true
    // Announce winner based on the current (winning) turn
    if(turn % 2 != 0) {
    	System.out.print("Player 1 hat gewonnen!");
    } else {
    	System.out.print("Player 2 hat gewonnen!");
    }
    
  }
}
