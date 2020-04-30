public class TestBtr {
  
  static BtrSucc s; 
  static String prova = "+-";
  
  public static String test(){
    s = new BtrSucc(prova);
    return s.next(prova);
  }
  
}