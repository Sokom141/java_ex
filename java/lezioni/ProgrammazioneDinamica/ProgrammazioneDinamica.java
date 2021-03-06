public class ProgrammazioneDinamica {
  
  private static final int UNKNOWN = 0;
  
  public static long fib(long n){ // n > = 0
    
    if (n < 2) {
      return 1;
    } else {
      return fib(n-2) + fib(n-1);
    }
  }
  
  public static long fibMem(int n) {
    long[] h = new long[n+1];
    for (int i=0; i<=n; i++) {
      h[i] = UNKNOWN;
    }
    return fibRec(n, h);
  }
  
  private static long fibRec(int n, long[] h) {
    
    if (UNKNOWN == h[n]) {
      if (n < 2) {
        h[n] = 1;
      } else {
        h[n] = (fibRec(n-2, h) + fibRec(n-1, h));
      }
    }
    return h[n];  // non ha trasparenza referenziale
  }
    
  public static long fibDP(int n){
    
    long[] cache = new long[n+1];
    
    for(int i=0; i<=n; i++) {
      if(i < 2){
        cache[i] = 1;
      } else {
        cache[i] = cache[i-1] + cache[i-2];
      }
    }
    
    return cache[n];
  }
  
  public static long manhMem(int i, int j){
    
    long[][] h = new long[i+1][j+1];
    for (int x=0; x<=i; x++){
      for (int y=0; y<=j; y++) {
        h[x][y] = UNKNOWN;
      }
    }
    return manhRec(i, j, h);
  }
  
  public static long manhRec(int i, int j, long[][] h){
    
    if (h[i][j] == UNKNOWN) {
      
      if ( i==0 || j==0 ) {
        h[i][j] = 1;
      } else {
        h[i][j] = manhRec(i-1, j, h) + manhRec(i, j-1, h);
      }
    }
    return h[i][j];
  }
  
  public static long manhDP(int i, int j) {
    
    long[][] h = new long[i+1][j+1];
    for (int y=0; y<=j; y++){
      h[0][y] = 1;
    }
    
    for (int x=1; x<=i; x++){
      h[x][0] = 1;
    }
    
    for (int x=1; x<=i; x++) {
      for (int y=1; y<=j; y++) {
        h[x][y] = h[x-1][y] + h[x][y-1];
      }
    }
    return h[i][j];
  }
    
  public static int llcs(String u, String v) {
    
    int m = u.length();
    int n = v.length();
    
    if ( m==0 || n==0 ) {
      return 0;
    } else if ( u.charAt(0) == v.charAt(0) ) {
      return 1 + llcs( u.substring(1), v.substring(1) );
    } else {
      return Math.max( llcs(u.substring(1), v), llcs( u, v.substring(1) ) );
    }
  }
  
  public static int llcsMem(String u, String v) {
   
    int m = u.length();
    int n = v.length();
    
    int[][] h = new int[m+1][n+1];
    
    for(int i=0; i<=m; i++){
      for(int j=0; j<=n; j++){
        h[i][j] = -1;
      }
    }
    
    return rLlcs(u, v, h);
  }
  
  private static int rLlcs(String u, String v, int[][] h) {
    
    int m = u.length();
    int n = v.length();
    if ( h[m][n] == -1 ){
      if ( m==0 || n==0 ) {
        h[m][n] = 0;
      } else if ( u.charAt(m-1) == v.charAt(n-1) ) {
        h[m][n] = 1 + rLlcs(u.substring(0, m-1), v.substring(0, n-1), h);
      } else {
        h[m][n] = Math.max( rLlcs( u.substring(0, m-1), v, h), rLlcs(u, v.substring(0, n-1), h) );
      }
    }
    return h[m][n];
  }
    
  public static int llcsDP(String u, String v) {
   
    int m = u.length();
    int n = v.length();
    int[][] h = new int[m+1][n+1];
    
    for ( int x=0; x<=m; x++ ) {
      for ( int y=0; y<=n; y++ ) {
        if ( x==0 || y==0 ) {
          h[x][y] = 0;
        } else if ( u.charAt(m-x) == v.charAt(n-y) ) {
          h[x][y] = 1 + h[x-1][y-1];
        } else {
          h[x][y] = Math.max( h[x-1][y], h[x][y-1] );
        }
      }
    }
    return h[m][n];
  }
  
  public static String stringLlcsDP(String u, String v) {
    
    int m = u.length();
    int n = v.length();
    int[][] h = new int[m+1][n+1];
    
    for ( int x=0; x<=m; x++ ) {
      for ( int y=0; y<=n; y++ ) {
        
        if ( x==0 || y==0 ) {
          h[x][y] = 0;
        } else if ( u.charAt(m-x) == v.charAt(n-y) ) {
          h[x][y] = 1 + (h[x-1][y-1]);
        } else {
          h[x][y] = Math.max( h[x-1][y], h[x][y-1] );
        }
      }
    }
    
    String s = "";
    int i = m;
    int j = n;
    
    while ( ( i > 0 ) && ( j > 0 ) ) {
      
      if ( u.charAt(m-i) == v.charAt(n-j) ) {
       
        s = s + (u.charAt(m-i));
        i -= 1;
        j -= 1;
      } else if ( h[i-1][j] < h[i][j-1] ){
        j -=1;
      } else if ( h[i-1][j] > h[i][j-1] ){
        i -= 1;
      } else if ( Math.random() < 0.5 ){
        j -= 1;
      } else {
        i -= 1;
      }
    }
    
    return s;
  }
  
  
} // class ProgrammazioneDinamica