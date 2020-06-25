import java.util.Scanner;
class TestGui{
  
  public static Tavoletta board;
  private static Scanner input = new Scanner(System.in);
  
  public static void main(String args[]){
    
    
    int n = input.nextInt();
    board = new Tavoletta(n);    
    board.fill();
    board.config();
    board.guiMove();
  }
  
  public static void play(){
    
    System.out.println("Inserisci la dimensione della Tavola: ");
    int n = input.nextInt();
    board = new Tavoletta(n);
    for (int c=1; c<=n; c++) {
      board.setNumber(c, c, c);
    }
    
  }
}