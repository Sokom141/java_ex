import java.util.Scanner;

class TestGui{
  
  private static Tavoletta board;
  private static Scanner input = new Scanner(System.in);
  
  public static void main( String[] args ) {
    
    int n = input.nextInt();
    board = new Tavoletta(n);    

    if ( args.length >= 1 ) { 
      if ( args[0].equals( "-r" ) ) {    // è possibile creare una configurazione randomica con cui giocare con l'argomento -r
        board.randomFill( (n * n) - 1);
      }
      if ( args.length > 1 ) {
        if ( args[1].equals( "-c" ) ) {
          System.out.println(board);
        }
      }
    }
    else {
      board.fill();
    }
    board.guiMove();
  }
  
}