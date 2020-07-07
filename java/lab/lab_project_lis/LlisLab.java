class LlisLab {
  
  private static int[][] mem;
  
  
  public static int llis(int[] s) { //s[i] > 0 per i in [0, n-1], dove n = s.length
    
    mem = new int[s.length+1][s.length+1];
    
    for ( int i=0; i<=s.length; i++) {
      for ( int j=0; j<=s.length; j++ ) {
        mem[i][j] = -1;
      }
    }
    
    return llisRec(s, 0, 0, mem);
  }
  
  private static int llisRec(int[] s, int i, int t, int[][] m) {
    
    final int n = s.length;
    int pos = 0;
    
    for(int k=0;k<n;k++){
      if(s[k] == t){
        pos = k + 1;
        break;
      }
    }
    
    if ( m[i][pos] == -1 ) {
      if (i == n) {
        m[i][pos] = 0;
      } else if ( s[i] <= t ) {
        m[i][pos] = llisRec(s, i+1, t, m);
      } else {
        m[i][pos] = Math.max( 1+llisRec(s, i+1, s[i], m), llisRec(s, i+1, t, m) );
      }
    }
    return m[i][pos];
  }
  
  public static IntSList lis( int[] s ) { // restituisce la lista della sottosequenza più lunga
    34, 465, 481, 491,
    final int n = s.length;
    IntSList l = IntSList.NULL_INTLIST;
    
    IntSList[][][] s_mem = new IntSList[n+1][n+1][n+1];
    
    for ( int i=0; i<=s.length; i++) {
      for ( int j=0; j<=s.length; j++ ) {
        for( int k=0; k<=s.length; k++) {
        s_mem[i][j][k] = IntSList.NULL_INTLIST;
        }
      }
    }
    
    return lisRec(s, 0, l, 0, s_mem);
  }
  
  private static IntSList lisRec(int[] s, int i, IntSList l, int t, IntSList[][][] m){
    
    final int n = s.length;
    
    int p = l.length();
    int pos = 0;
    
    for(int k=0;k<n;k++){
      if(s[k] == t){
        pos = k + 1 ;
        break;
      }
    }
    
    if ( m[i][pos][p] == IntSList.NULL_INTLIST ) {
      if(i==n) {
        m[i][pos][p] = l.reverse();
      } else if( s[i]<= t) { // caso in cui il numero considerato è più piccolo (o uguale) a t -> non entra nella lista
        m[i][pos][p] = lisRec(s,i+1,l,t, m);
      } else { // caso in cui il numero si può inserire nella lista
        
        IntSList lp = l.cons(s[i]);
        m[i][pos][p] = longestIntList(lisRec(s, i+1, lp, s[i], m), lisRec(s, i+1, l, t, m));
      } 
    }
    return m[i][pos][p];
  }
  
  public static IntSList longestIntList( IntSList a, IntSList b) {
    
    IntSList c = a; // salvo le due liste in due placeholder
    IntSList d = b; // perchè stanno per essere modificate
    
    while((a.length() > 0) && (b.length() > 0)){
      a = a.cdr();
      b = b.cdr();
    }
    if(a.length() == 0){
      
      return d;//caso in cui d è più lungo (perchè a si esaurisce prima)
    } else {
      
      return c;//caso in cui c è più lungo (perchè b si esaurisce prima)
    }
  }
  
  public static String llisTester(int[] s) { //s[i] > 0 per i in [0, n-1], dove n = s.length
    
    mem = new int[s.length+1][s.length+1];
    
    for ( int i=0; i<=s.length; i++) {
      for ( int j=0; j<=s.length; j++ ) {
        mem[i][j] = -1;
      }
    }
    
    llisRec(s, 0, 0, mem);
    return tester(mem);
    
  }
  
  private static String tester( int[][] cache ){
    
    int utilizzati = 0;
    int n = cache.length;
    int liberi = (int)(Math.pow(n, 2));
    
    for ( int i=0; i<n; i++ ) {
      for ( int j=0; j<n; j++ ) {
        
        if (cache[i][j] != -1) {
          
          utilizzati += 1;
          liberi -= 1;
        }
      }
    }
    
    return "Celle utilizzate: " + utilizzati + "\nCelle libere: " + liberi;
    
  }
    
}