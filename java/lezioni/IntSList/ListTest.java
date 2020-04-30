// Test di oggetti di tipo IntSList
public class ListTest {
 
  public static int test() {
    
    IntSList il = new IntSList();
    il = il.cons(5);
    il = il.cons(4);
    
    return il.cdr().car();
  }
}