
public class PrimoProgrammaJava {
 /*
  (define sup-tot-cil ;val: reale
    (lambda (r h)
       (* 2 pi r (+ r h))
       )
     )
  */
  
  public static double supTotCil(double r, double h) {
    
    return ( 2 * Math.PI * r * (r + h) );
  }
  
  // plurale sostantivo maschile
  public static String pluraleSm( String s) {
    
    return ( s.substring( 0, s.length()-1 ) + "i" );
  }
  
  public static String pluraleSf( String s) {
    
    return ( s.substring( 0, s.length()-1 ) + "e" );
  }
  
  public static boolean femminile( String s) {
    
    return s.charAt( s.length() - 1 ) == 'a';
  }
  
  public static String plurale( String s ) {
    
    if ( femminile(s) ) {
      
      return pluraleSf(s);
      
    } else {

      return pluraleSm(s);
    }
  }
  
  
  private static final double b0 = ( 100 * Math.pow(2,+0.25) );
  private static final double b1 = ( 100 * Math.pow(2,-0.25) );
  
  public static double b( int k) {
    
    if ( k == 0 ) {
      
      return b0;
    } else if ( k == 1) {
      
      return b1;
    } else {
      
      return ( b(k-2) / 2);
    }
  }
  
  public static int btrVal0( String num ) {
    final int k = num.length() - 1;
    
  }
  
  public static void main( String[] args) {
    System.out.println( plurale("torre") );
  }
  
  public static int btrVal( String num) {
    int n = num.length();
    int v = 0;
    
  
    for ( int i=0; i<n; i=i+1 ) {
      
      v = 3 * v + btdVal( num.charAt(i) );
      
    }
    return v;
  }
  
  public static int btdVal( char btd ){
    
    if ( btd == '-' ) {
      return -1;
    } else if ( btd == '.') {
      return 0;
    } else {
      return +1;
    }
    
    public static int ufo( int n ) {
      int[] u = new int[ n+1 ];
      
      u[1] = 1;
      
      for ( int x=2; x<=n; x++ ) {
        
        if ( x % 2 == 0) {  // x pari
          u[x] = ( u[x/2] * 2 ) - 1;
        } else { // x dispari
          u[x] = ( u[x/2] * 2) + 1;
        }
      }
      return u[n];
} // class PrimoProgrammaJava
    
