/**
 * Soluzione del rompicapo delle N regine
 * */

public class Queens {
  
  public static int numeroDiSoluzioni( int n ){
    
    return numeroDiCompletamenti( new Board(n) );
  }
  
  private static int numeroDiCompletamenti( Board b ){
    
    int n = b.size();
    int q = b.queensOn();
    
    if ( q == n ) {
      return 1;
    } else { // q < n
      
      int i = q + 1;
      int count = 0;
      for ( int j = 1; j<=n; j++ ) {
        if ( !b.underAttack(i,j) ) {
          count = count + numeroDiCompletamenti( b.addQueen(i,j) );
        }
      }
      return count;
    }
  }
  
  public static SList<Board> listaDiSoluzioni( int n ) {
    
    return listaDiCompletamenti( new Board(n) );
  }
  
  public static SList<Board> listaDiCompletamenti( Board b ){
   
    int n = b.size();
    int q = b.queensOn();
    
    if( q == n ) {
      
      return ( (new SList<Board>()).cons( b ) );
    } else {
     
      int i = q + 1;
      SList<Board> bl = new SList<Board>();
      for ( int j=1; j<=n; j++){
        if ( !b.underAttack(i, j) ){
          bl = bl.append( listaDiCompletamenti( b.addQueen(i, j) ));
        }
      }
      return bl;
    }
  }
  
  public static SList<Integer> numeriDiSoluzioni( int m, int n) {
    
    if ( m > n) {
      
      return ( new SList<Integer>() );
    } else {
      
      return (numeriDiSoluzioni( m+1, n ).cons(numeroDiSoluzioni(m)) );
    }
  }
}