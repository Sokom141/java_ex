
public class BtrSucc {
  
  int length;
  String lsb;
  String pre;
    
  public BtrSucc( String btr ){
    // length = btr.length();
    // lsb = btr.substring( length-1 );
    next( btr );
  }
  
  public String next( String s ) {
    
    length = s.length();
    lsb = s.substring( length-1 );
    if ( s.length() == 1 ) {
      if (lsb == "+") {
        return "+-";
      } else {
        return "+";
      }
    } else {
      pre = s.substring( 0, length-1);
      if (lsb == "+") {
        return next(pre) + "-";
      } else {
        if ( lsb == "-") {
          return next(pre) + ".";
        } else {
          return next(pre) + "+";
        }
      }
    }
  }

} // BtrSucc