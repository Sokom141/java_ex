/**
 * IntSList il = new InstSLit() // null
 * il.isNull() : boolean        // null?
 * il.car()    : int            // car
 * il.cdr()    : IntSList       // cdr
 * il.cons(n)  : IntSList       // cons
 */

public class IntSList {
  
  public static final IntSList NULL_INTLIST = new IntSList();
  private final boolean empty;
  private final int first;
  private final IntSList rest;
  
  public IntSList() {
    
    empty = true;
    first = 0;    //irrilevante
    rest = null;
  } // costruttore
  
  public IntSList( int f, IntSList r ) {
  
    empty = false;
    first = f;
    rest = r;
  } // serve per il cons, ha 2 variabili: car,cdr
   
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
  
    return ( new IntSList(n,this) );  // this fa riferimento alla lista che stiamo costruendo
  }
  
  public int length() {
    if (isNull()) {
      return 0;
    } else {
      return (1 + cdr().length());
    }
  }
  
  public IntSList append(IntSList ql) {
    if (isNull()) {
      return ql;
    } else {
      return ( (cdr().append(ql)).cons(car()) );
    }
  }
  
  public IntSList reverse() {
    return reverseRec(NULL_INTLIST);
  }
  
  private IntSList reverseRec(IntSList rl) {
    if (isNull()) {
      return rl;
    } else {
      return cdr().reverseRec(rl.cons(car()));
    }
  }
  
  public String toString() { // metodo per trasformare in testo il contenuto dell'oggetto
    if (empty) {
      return "()";
    } else if (rest.isNull()) {
      return "(" + first + ")";
    } else {
      String rep = "(" + first;
      IntSList r = rest;
      while ( !r.isNull() ) {
        rep = rep + ", " + r.car();
        r = r.cdr();
      }
      return ( rep + ")" );
    }
  }
  
} // class IntSList