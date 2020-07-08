class Board{
  
  private final int size;
  private final int queens;
  private final String config;
  private final IntSList COLS;
  private final IntSList ROWS;
  private final IntSList DgP;
  private final IntSList DgM;
  private final String RIGHE = "123456789ABCDEF";
  private final String COLONNE = "abcdefghijklmno";
  
  
  public Board( int n ){
    
    size = n;
    queens = 0;
    COLS = IntSList.NULL_INTLIST;
    ROWS = IntSList.NULL_INTLIST;
    DgP = IntSList.NULL_INTLIST;
    DgM = IntSList.NULL_INTLIST;
    config = "";
  }
    
  private Board(int n, int q, IntSList cols, IntSList rows, IntSList dgP, IntSList dgM, String c) {
    
    size = n;
    queens = q;
    COLS = cols;
    ROWS = rows;
    DgP = dgP;
    DgM = dgM;
    config = c;
  }
  
  public int size() {
    
    return size;
  }
  
  public int queensOn() {
    
    return queens;
  }
  
  public boolean underAttack(int x, int y){
    
    return underAttackRec(x, y, COLS, ROWS, DgP, DgM);
  }
  
  private boolean underAttackRec(int i, int j, IntSList cols, IntSList rows, IntSList dgP, IntSList dgM) {
    
    if ( cols.isNull() && rows.isNull() && dgP.isNull() && dgM.isNull() ) {
      
      return false;
      
    } else if ((i == cols.car())  ||
               (j == rows.car())  ||
               (i+j == dgP.car()) ||
               (i-j == dgM.car()) ) {
      
      return true;
    } else {
      
      return underAttackRec(i, j, cols.cdr(), rows.cdr(), dgP.cdr(), dgM.cdr());
    }
  }
  
  public String arrangement() {
    
    return config;
  }
  
  public String toString() {
   
    String s = "< " + size + ", "
      + queensOn() + ", "
      + ROWS.reverse() + ", "
      + COLS.reverse() + ", "
      + DgM.reverse() + ", "
      + DgP.reverse() + ", "
      + arrangement() + ">";
    return s;
  }
  
  public Board addQueen(int i, int j){
    
    return new Board(size,
                     queens +1,
                     COLS.cons(i),
                     ROWS.cons(j),
                     DgP.cons(i+j),
                     DgM.cons(i-j),
                     (config + " " +
                      COLONNE.substring(i-1, i) +
                      RIGHE.substring(j-1, j) +
                      " ") );
  }
  
} // class Board
               