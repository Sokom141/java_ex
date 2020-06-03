class TestGui{
  public static Tavoletta board;
  
  public static void test(int n){
    
    board = new Tavoletta(n);    
    board.fill();
    board.config();
    board.guiMove();
  }
  
}