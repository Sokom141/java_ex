public class Test {
  
  static StringSList list = new StringSList();
  
  public static boolean testNull() {
    return list.isNull();
  }
  
  public static int testLength() {
    return list.length();
  }
  
  public static StringSList testCons( String arg ) {
    
    list = list.cons(arg);
    return list;
  }
}