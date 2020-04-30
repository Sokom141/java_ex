public class StringSList {
  
  public static final StringSList NULL_STRINGLIST = new StringSList();
  private final boolean empty;
  private final String first;
  private final StringSList rest;
  
  public StringSList() { // null
    
    empty = true;
    first = "";
    rest = null;
  } // costruttore
  
  public StringSList( String e, StringSList sl ) { // cons
    
    empty = false;
    first = e;
    rest = sl;
  }
  
  public boolean isNull() { // null?
    
    return empty;
  }
  
  public String car() { // car
    
    return first;
  }
  
  public StringSList cdr() { // cdr
    
    return rest;
  }
  
  public StringSList cons( String e ) { // cons (modalità alternativa)
    
    return new StringSList( e, this );
  }
  
  public int length() { // length
    
    if ( isNull() ) {
      return 0;
    } else {
      return 1 + cdr().length();
    }
  }
  
  public String listRef( int k ){ // list-ref
    return "";
  }
  
  public boolean equals( StringSList sl ) { // equal?
   return true; 
  }
  
  public StringSList append( StringSList sl ) { // append
    
    if ( isNull() ) {
      return sl;
    } else {
      return (cdr().append(sl)).cons(car());
    }
  }
  
  public StringSList reverse() { // reverse
    return reverseRec(NULL_STRINGLIST);
  }
  
  private StringSList reverseRec( StringSList sl ){
   
    if ( isNull() ) {
      return sl;
    } else {
      return cdr().reverseRec(sl.cons(car()));
    }
  }
    
  public String toString() { // visualizzazione testuale
    if ( empty ) {
      return "()";
    } else if ( rest.isNull() ) {
      return "(" + first + ")";
    } else {
      String rep = "(" + first;
      StringSList r = rest;
      while ( !r.isNull() ) {
        rep = rep + "," + r.car();
        r = r.cdr();
      }
      return rep + ")";
    }
  }

} // class StringSList