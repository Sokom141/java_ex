class LlisLab {
  
  private static int[][] mem;
 
  
  public static int llis(int[] s) { //s[i] > 0 per i in [0, n-1], dove n = s.length
    
    mem = new int[s.length+1][s.length+1];
    return llisRec(s, 0, 0, mem);
  }
  
  public static int llisRec(int[] s, int i, int t, int[][] m) {
    
    final int n = s.length;
    int pos = 0;
    
    for(int k=0;k<n;k++){
      if(s[k] == t){
        pos = k;
        break;
      }
    }
    
    
    if (i == n) {
      for(int a=0; a<m.length;a++){
        for(int b=0; b<m.length;b++){
          System.out.print(m[a][b]);
        }
        System.out.println();
      }
      System.out.println("*********");
      return m[i][pos];
    } else if ( s[i] <= t ) {
      return llisRec(s, i+1, t, m);
    } else {
      m[i][pos] = Math.max( 1+llisRec(s, i+1, s[i], m), llisRec(s, i+1, t, m) );
      return m[i][pos];
    }
    
  }
 
}