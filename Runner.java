import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
  public static void main(String[] args) throws IOException{
    TicTacToe ttt;

    if(args.length != 0) {
      ttt = new TicTacToe(Integer.parseInt(args[0]));
      ttt.ausgeben();
    } else {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Please define board dimensions:");
      String s = br.readLine();

      ttt = new TicTacToe(Integer.parseInt(s));
      ttt.ausgeben();
    }

    int turn = 0;
    while (ttt.existWinner() == false){
      turn++;

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      if(turn % 2 != 0) {
        System.out.print("Player 1 ");
      }  else {
        System.out.print("Player 2" );
      }
      System.out.print(" plase provide x and y coordinates for next move: ");
      String s = br.readLine();

      int x = Integer.parseInt(s.split(" ")[0]);
      int y = Integer.parseInt(s.split(" ")[1]);

      if (turn % 2 != 0) {
        ttt.setChip(1,x,y);
      } else {
        ttt.setChip(2,x,y);
      }

      ttt.ausgeben();
    }

    if(turn % 2 != 0) {
      System.out.print("Player 1 hat gewonnen");
    }  else {
      System.out.print("Player 2 hat gewonnen");
    }

  }
}
