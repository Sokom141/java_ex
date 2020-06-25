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
  
  public static StringSList listaDiSoluzioni( int n ) {
    
    return listaDiCompletamenti( new Board(n) );
  }
  
  public static StringSList listaDiCompletamenti( Board b ){
   
    int n = b.size();
    int q = b.queensOn();
    
    if( q == n ) {
      
      return ( StringSList.NULL_STRINGLIST.cons( b.arrangement() ) );
    } else {
     
      int i = q + 1;
      StringSList sl = StringSList.NULL_STRINGLIST;
      for ( int j=1; j<=n; j++){
        if ( !b.underAttack(i, j) ){
          sl = sl.append( listaDiCompletamenti( b.addQueen(i, j) ));
        }
      }
      return sl;
    }
  }
  
}