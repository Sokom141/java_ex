public class TavolaRotonda2 {
  
  private final IntSList cavalieri;
  private final IntSList seguito;
  private final int num;
  
  public int numeroDiCavalieri() {
    
    return num;
  }
  
  public int cavConLaBrocca() {
    
    return cavalieri.car();
  }
  
  public TavolaRotonda2( int n ){
    
    cavalieri = range( 1,n );
    seguito = IntSList.NULL_INTLIST;
    num = n;
  }
  
  private TavolaRotonda2( IntSList cav, IntSList seg, int n ) { // n > 0
        
    cavalieri = cav;
    seguito = seg;
    num = n;
  }
  
  public TavolaRotonda2 dopoUscitaCav() {
   
    IntSList u = cavalieri.cdr();
    IntSList v = seguito.cons( cavalieri.car() );
    
    if (u.isNull() ) {
      return new TavolaRotonda2( v.reverse().cdr(), IntSList.NULL_INTLIST, num-1);
    } else if ( u.cdr().isNull() ) {
      return new TavolaRotonda2( v.reverse(), IntSList.NULL_INTLIST, num-1);
    } else {
      return new TavolaRotonda2( u.cdr(), v, num-1);
    }
  }
  
  private static IntSList range( int m, int n ) {
    
    if ( m > n ) {
      return IntSList.NULL_INTLIST;
    } else {
      return range(m+1, n).cons(m);
    }
  }
  
}