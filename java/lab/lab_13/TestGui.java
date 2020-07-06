import java.util.Scanner;

class TestGui{
  
  public static Tavoletta board;
  private static Scanner input = new Scanner(System.in);
  
  public static void main( String[] args ) {
    
    int n = input.nextInt();
    board = new Tavoletta(n);    
    
    if ( args.length == 1 ) { 
      if ( args[0].equals( "-r" ) ) { // è possibile creare una configurazione randomica con cui giocare con l'argomento --r
        board.randomFill( (n * n) - 1);
      } 
    }
    else {
      board.fill();
    }
    
    board.config();
    board.guiMove();
  }
  
}