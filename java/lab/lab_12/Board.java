class Board{
  
  private final int size;
  private final int queens;
  private final String config;
  private final SList<Integer> COLS;
  private final SList<Integer> ROWS;
  private final SList<Integer> DgP;
  private final SList<Integer> DgM;
  private final String RIGHE = "123456789ABCDEF";
  private final String COLONNE = "abcdefghijklmno";
  
  
  public Board( int n ){
    
    size = n;
    queens = 0;
    COLS = new SList<Integer>();
    ROWS = new SList<Integer>();
    DgP = new SList<Integer>();
    DgM = new SList<Integer>();
    config = "< ";
  }
    
  private Board(int n, int q, SList<Integer> cols, SList<Integer> rows, SList<Integer> dgP, SList<Integer> dgM, String c) {
    
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
  
  private boolean underAttackRec(int i, int j, SList<Integer> cols, SList<Integer> rows, SList<Integer> dgP, SList<Integer> dgM) {
    
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
   
    return arrangement() + ">";
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
                      " |") );
  }
  
} // class Board
               