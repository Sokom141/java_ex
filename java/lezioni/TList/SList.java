/**
 * SList<T> tl = new SList<T>()    // null
 * tl.isNull()   : boolean         // null?
 * tl.car()      : T               // car
 * tl.cdr()      : SList<T>        // cdr
 * tl.cons(e)    : SList<T>        // cons
 * 
 * tl.length()   : int             // length
 * tl.listRef(i) : T               // list-ref
 * tl.equals(cl) : boolean         // equal?
 * tl.append(ql) : SList<T>        // append
 * tl.reverse()  : SList<T>        // reverse
 */

public class SList<T> {
  
  // lista vuota: new SList<T>();
  
  private final boolean empty;
  private final T first;
  private final SList<T> rest;
  
  public SList() {
    
    empty = true;
    first = null;    //irrilevante
    rest = null;
  }
  
  public SList( T f, SList<T> r ) {
  
    empty = false;
    first = f;
    rest = r;
  }
  
  public boolean isNull() {
   
    return empty;
  }
  
  public T car() {
  
    return first;
  }
  
  public SList<T> cdr() {
  
    return rest;
  }
  
  public SList<T> cons( T e ) {
  
    return ( new SList<T>(e,this) );
  }
  
  public int length() {
    
    if ( isNull() ) {
      return 0;
    } else {
      return (1 + cdr().length() );
    }
  }
  
  public T listRef( int i ) {
    
    if ( i == 0 ){
      return car();
    } else {
      return ( cdr().listRef(i-1) );
    }
  }
  
  public boolean equals( SList<T> cl ){
    
    if ( isNull() ) {
      return ( cl.isNull() );
    } else if ( cl.isNull() ) {
      return false;
    } else if ( car() == cl.car() ){
      return ( cdr().equals(cl.cdr()) );
    } else {
      return false;
    }
  }
  
  public SList<T> append( SList<T> ql ) {
   
    if ( isNull() ) {
      return ql;
    } else {
      return ( (cdr().append(ql)).cons(car()) );
    }
  }
  
  public SList<T> reverse() {
    
    return reverseRec( new SList<T>() );
  }
  
  private SList<T> reverseRec( SList<T> rl ) {
    
    if ( isNull() ) {
      return rl;
    } else {
      return ( cdr().reverseRec(rl.cons(car())) );
    }
  }
    
  public String toString() {
    
    if ( empty ) {
      return "()";
    } else if ( rest.isNull() ) {
      return "(" + first + ")";
    } else {
      String rep = "(" + first;
      SList<T> r = rest;
      while ( !r.isNull() ) {
        rep = rep + ", " + r.car();
        r = r.cdr();
      }
      return ( rep + ")" );
      }
  }
  
}