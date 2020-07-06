public class Esame110618 {
  
  private static final int UNKNOWN = -1;
    
    public static int q( int[] s ) { //s.length > 0
    
    int n = s.length;
    int[] t = new int[n];
    t[0] = s[0];
    
    for ( int k=1; k<n; k++) {
      int i = k-1;
      
      while ( ( i >= 0 ) && ( t[i] > s[k] ) ) {
        
        t[i+1] = t[i];
        i = i - 1;
      }
      t[i+1] = s[k];
    }
    return qRec( s, t, n, 0, 0 );
  }
  
  private static int qRec( int[] s, int[] t, int n, int i, int j ) {
    
    if ( ( i == n ) || ( j == n ) ) {
      return 0;
    } else if ( s[i] == t[j] ) {
      return 1 + qRec( s, t, n, i+1, j+1 );
    } else {
      return Math.max( qRec(s,t,n,i+1,j), qRec(s,t,n,i,j+1) );
    }
  }
  
  public static int qMem( int[] s ) {
    
    int n = s.length;
    int[] t = new int[n];
    t[0] = s[0];
    
    int[][] cache = new int[n+1][n+1];
    
    for ( int k=1; k<n; k++) {
      int i = k-1;
      
      while ( ( i >= 0 ) && ( t[i] > s[k] ) ) {
        
        t[i+1] = t[i];
        i = i - 1;
      }
      t[i+1] = s[k];
    }
    
    for ( int i=0; i<=n; i++) {
      for ( int j=0; j<=n; j++) {
        cache[i][j] = UNKNOWN;
      }
    }
    
    return qRecMem( s, t, n, 0, 0, cache );
  }
  
  private static int qRecMem( int[] s, int[] t, int n, int i, int j, int[][] h ) {
    
    if (h[i][j] == UNKNOWN) {
      if ( ( i == n ) || ( j == n ) ) {
        h[i][j] = 0;
      } else if ( s[i] == t[j] ) {
        h[i][j] = 1 + qRecMem( s, t, n, i+1, j+1, h );
      } else {
        h[i][j] = Math.max( qRecMem(s,t,n,i+1,j, h), qRecMem(s,t,n,i,j+1,h) );
      }
    }
    return h[i][j];
  }
  
}