/**
 * Soluzione del rompicapo delle N regine
 * */

public class Queens2 {
  
  public static int numeroDiSoluzioni( int n ){
    
    return numeroDiCompletamenti( new Board2(n) );
  }
  
  private static int numeroDiCompletamenti( Board2 b ){
    
    int n = b.size();
    int q = b.queensOn();
    
    if ( q == n ) {
      return 1;
    } else { // q < n
      
      int i = q + 1;
      int count = 0;
      for ( int j = 1; j<=n; j++ ) {
        if ( !b.underAttack(i,j) ) {
          b.addQueen(i, j);
          count = count + numeroDiCompletamenti( b );
          b.rmQueen(i, j);
        }
      }
      return count;
    }
  }
  
  public static SList<String> listaDiSoluzioni( int n ) {
    
    return listaDiCompletamenti( new Board2(n) );
  }
  
  public static SList<String> listaDiCompletamenti( Board2 b ){
   
    int n = b.size();
    int q = b.queensOn();
    
    if( q == n ) {
      
      return ( (new SList<String>()).cons( b.arrangement() ) );
    } else {
     
      int i = q + 1;
      SList<String> bl = new SList<String>();
      for ( int j=1; j<=n; j++){
        if ( !b.underAttack(i, j) ){
          b.addQueen(i, j);
          bl = bl.append( listaDiCompletamenti( b ));
          b.rmQueen(i, j);
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