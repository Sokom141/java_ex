
public class BtrSucc {
      
  public static String btrSucc( String btr ){
    
    return next( btr );
  }
  
  private static String next( String s ) {
    
    int len = s.length();
    String lsb = s.substring( len-1 );
    
    if ( len == 1 ) {

      if ( lsb.equals("+") ) {
        return "+-";
      } else {
        return "+";
      }
    } else {
      
      String pre = s.substring( 0, len-1);
      if ( lsb.equals("+") ) {
        
        return next(pre) + "-";
      } else {
        
        if ( lsb.equals("-") ) {
          return pre + ".";
        } else {
          return pre + "+";
        }
      }
    }
  }

} // BtrSucc