/**
 * IntSList il = new InstSLit() // null
 * il.isNull() : boolean        // null?
 * il.car()    : int            // car
 * il.cdr()    : IntSList       // cdr
 * il.cons(n)  : IntSList       // cons
 */

public class IntSList {
  
  private boolean empty;
  private int first;
  private IntSList rest;
  
  public IntSList() {
    
    empty = true;
    first = 0;    //irrilevante
    rest = null;
  }
  
  public IntSList( int f, IntSList r ) {
  
    empty = false;
    first = f;
    rest = r;
  }
  
  public boolean isNull() {
   
    return empty;
  }
  
  public int car() {
  
    return first;
  }
  
  public IntSList cdr() {
  
    return rest;
  }
  
  public IntSList cons( int n ) {
  
    return ( new IntSList(n,this) );
  }
  
}