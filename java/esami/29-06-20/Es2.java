public class Es2 {
  
  public static long rec( int t, int u, int v ) {    // 1 <= u, v <= t
    
    if ( (u > 1) && (v < t) ) {
      return rec( t, u-1, v ) + u * rec( t, u, v+1 );
      
    } else {
      
      return 1;
      
    }
    
  }
  
  public static long iter( int t, int u, int v ) {
   
    long[][] dp = new long[u+1][t+1];
    
    for (int i=0; i<=u; i++) {
      for (int j=0; j<=t; j++) {
          dp[i][0] = 1;
          dp[0][j] = 1;
      }
    }
    
    for (int i=1; i<=u; i++ ) {
      for (int j=1; j<=t; j++) {
        dp[i][j] = dp[i-1][j] + u * dp[i][j+1];
      }
    }
    
    return dp[u][v];
    
  }
  
}