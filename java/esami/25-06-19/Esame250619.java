import java.util.*;
public class Esame250619 {
  
  private static final String[] UNKNOWN = null;
  
  public static String[] diffMem( String u, String v) {
    
    int ul = u.length();
    int vl = v.length();
    
    String[][][] h = new String[ul+1][vl+1][];
    
    for (int i=0; i<=ul; i++) {
      for (int j=0; j<=vl; j++) {
        
        h[i][j] = UNKNOWN;
      }
    }
    
    return diff(u, v, h);
  }
  
  
  public static String[] diff( String u, String v, String[][][] cache ) {
    
    int ul = u.length();
    int vl = v.length();
    
    if ( cache[ul][vl] == UNKNOWN ) {
    
      if ( u.equals("") || v.equals("") ) {
        
        cache[ul][vl] = new String[] { u, v };
      } else if ( u.charAt(0) == v.charAt(0) ) {
        
        cache[ul][vl] = diff(u.substring(1), v.substring(1), cache);
      } else {
        
        String[] x = diff( u.substring(1), v, cache );
        String[] y = diff( u, v.substring(1), cache );
        
        if ( x[0].length() < y[0].length() ) {
          
          cache[ul][vl] = new String[] { u.charAt(0)+x[0], x[1] };
          
        } else {
          
          cache[ul][vl] =  new String[] { y[0], v.charAt(0)+y[1] };
        }
      }
    }
    
    return cache[ul][vl];
  }
  
  
  public static long st( int n, int k ) {  // n, k > 0  
    long[] ct = new long[] { 0 };          // contatore: variabile di stato 
    sRec( 1, n, k, ct ); 
    return ct[0];
  } 
  
  private static void sRec( int n, int k, int q, long[] ct ) { 
    if ( (k == 1) || (k == n) ) { 
      ct[0] = ct[0] + q;   
    } else {
      sRec( n-1, k-1, q, ct ); 
      sRec( n-1, k, k*q, ct );  
    }  
  }
  
  public static long stIter( int n, int k ) { // n,k > 0
    long[] cn = new long[] {0};
    Stack<int[]> stack = new Stack<int[]>();
    
    int[] f = new int[] { 1, n, k };
    stack.push(f);
    
    while ( !stack.empty() ) {
      f = stack.pop();
      
      if ( (f[2] == 1) || ( f[2] == f[1] ) ) {
        
        cn[0] = cn[0] + f[0];
      } else {
        
        stack.push( new int[] { f[0] ,  f[1]-1, f[2]-1 } );
        stack.push( new int[] { f[0]*f[2], f[1]-1, f[2] });
      }
    }
    
    return cn[0];
  }
  
}