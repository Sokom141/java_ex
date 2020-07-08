import java.util.stream.IntStream;

class LlisLab {
  
  private static int[][] mem;
  private static IntSList[][][] s_mem;
  private static final IntSList UNKNOWN = IntSList.NULL_INTLIST;
    
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
    
    pos = find(s, t, n) + 1;
    
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
    
  private static int find(int[] s, int t, int len) { // metodo privato per trovare l'indice di un elemento nell'array
   
    // filter(IntPredicate predicate) -> ritorna uno stream con gli elementi che corrispondono al predicato
    // findFirst() -> restituisce un OptionalInt con il valore della prima occorrenza corrispondente al predicato
    // se non viene trovato nulla viene restituito -1 al posto di un OptionalInt vuoto ma in questo programma non 
    // � prevista questa funzionalit�
    return IntStream.range(0, len).filter(i -> t == s[i]).findFirst().orElse(-1);
  }
  
  public static IntSList lis( int[] s ) { // restituisce la lista della sottosequenza più lunga
 
    final int n = s.length;
    
    IntSList l = UNKNOWN;
    
    s_mem = new IntSList[n+1][n+1][n+1];
    
    for ( int i=0; i<=s.length; i++) {
      for ( int j=0; j<=s.length; j++ ) {
        for( int k=0; k<=s.length; k++) {
        s_mem[i][j][k] = UNKNOWN;
        }
      }
    }
    
    return lisRec(s, 0, l, 0, s_mem);
  }
  
  private static IntSList lisRec(int[] s, int i, IntSList l, int t, IntSList[][][] m) {
    
    final int n = s.length;
    
    int p = l.length();
    int pos = 0;
        
    pos = find(s, t, n) + 1;
    
    if ( m[i][pos][p] == UNKNOWN ) {
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
  
  private static IntSList longestIntList( IntSList a, IntSList b) {
    
    if(a.length() > b.length()){
      
      return a;
    } else if (a.length() < b.length()) {
      
      return b;
    } else {
      return (Math.random()>=0.5?a:b);
    }
  }
  
  public static String llisTester( int[] s ) { //s[i] > 0 per i in [0, n-1], dove n = s.length
    
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
    
    return "\nCelle occupate: " + utilizzati + "\nCelle libere: " + liberi;
    
  }
  
  public static void main( String[] args ) { // test main
    
    int[] big_array = {412, 2, 9, 3, 312, 414, 18, 19, 147, 20, 21, 138, 481, 100, 516, 410, 41, 432, 45, 21, 46, 54, 421, 71, 99, 41, 512, 241, 60, 47, 0, 741, 876, 1293, 231, 32, 25, 61, 72, 73, 321, 4190, 231, 841, 192, 5617, 4000, 4001, 8, 12, 42, 5000, 67, 50, 51, 52, 124, 81, 48141, 94, 234, 59, 831, 465, 6810, 32, 841, 918, 481, 491, 12, 13, 14, 15, 75, 851, 571, 482};
    System.out.println( llis(big_array) );
    System.out.println( lis(big_array) );
  }
    
}