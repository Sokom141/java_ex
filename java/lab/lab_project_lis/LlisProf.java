public class LlisProf {
  
  public static int llis( int[] s ) {  // s[i] > 0 per i in [0,n-1], dove n = s.length  
    return llisRec( s, 0, 0 );  } 
  
  public static int llisRec( int[] s, int i, int t ) { 
    final int n = s.length;    
    if ( i == n ) {   
      
      return 0;  
    } else if ( s[i] <= t ) { 
      return llisRec( s, i+1, t );    
    } else {
      return Math.max( 1+llisRec(s,i+1,s[i]), llisRec(s,i+1,t) );   
    } 
  }
}