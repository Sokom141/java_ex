import java.util.Stack;
public class Esame230718{
  
  public static String migliore( String w, String[] ws ) {
    
    int len = ws.length;
    int k = 0;
    int y = ProgrammazioneDinamica.llcs(ws[0], w);
    
    for ( int i=1; i<len; i++ ) {
      
      int x = ProgrammazioneDinamica.llcs(ws[i], w);
      if ( x > y ) {
        k = i;
        y = x;
      }
    }
    return ws[k] ;
  }
  
  public static String hanoiMovesIter( int n ) {
    
    Stack<int[]> stack = new Stack<int[]>();
    stack.push( new int[] { n, 1, 2, 3 } );
    
    String moves = "";
    int s, d, t;
    
    while( !stack.empty()  ) {
      
      int[] args = stack.pop() ;
      n = args[0];
      s = args[1];
      d = args[2];
      t = args[3];
      
      if( n == 1 ) {
        moves = moves + " " + s + "->" + d;
      } else {
        stack.push( new int[] {n-1, t, d, s} );
        stack.push( new int[] {1, s ,d ,t} );  // segna posto
        stack.push( new int[] {n-1, s, t, d} );
      }
    }
    return moves;
  }
  
}