import java.util.Arrays;

public class TicTacToe extends basicpackage.BasicBoard implements Game {

  public TicTacToe(int x) {
    super();
    board = new int[x][x];
  }

  public void setChip(int player, int x, int y){
    this.board[y][x] = player;
  }

  public boolean existWinner(){
    int prev;
    boolean winner = true;

    for(int i = 0; i < board.length; i++ ){
      prev = board[i][0];
      for(int j = 1; j < board.length; j++){
        if(board[i][j] != prev || prev == 0){
          winner = false;
          break;
        }
      }

      if(winner){
        return true;
      }
    }


    winner = true;
    for(int i = 0; i < board.length; i++){
      prev = board[0][i];
      for(int j = 1; j < board.length; j++) {
        if(board[j][i] != prev || prev == 0){
          winner = false;
          break;
        }
      }

      if (winner){
        return true;
      }
    }

    winner = true;
    prev = board[0][0];
    for(int i = 0; i < board.length; i++){
      if(board[i][i] != prev || prev ==0){
        winner = false;
        break;
      }
    }

    if (winner){
      return true;
    }

    winner = true;
    prev = board[0][board.length-1];
    for(int i = 0; i < board.length; i++){
      for(int j = board.length-1; j >= 0; j--){
        if(board[i][i] != prev || prev == 0){
          winner = false;
          break;
        }
      }
    }

    if (winner){
      return true;
    }


    return false;
  }

  public void ausgeben(){
    for(int i = 0; i < board.length; i++){
      System.out.println(Arrays.toString(board[i]));
    }
  }

  @Override
  public String gameStatus(){
    return "";
  }
}
