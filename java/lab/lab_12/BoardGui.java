import queens.*;
import java.util.Scanner;
 
public class BoardGui {
 
  public static void main( String[] args ){
   
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    ChessboardView gui = new ChessboardView(n);
    SList<Board> sol = Queens.listOfAllSolutions(n);
    
    for(int i=0; i<sol.length(); i++){
      
      gui.setQueens((sol.listRef(i)).arrangement());
    }
  }
}