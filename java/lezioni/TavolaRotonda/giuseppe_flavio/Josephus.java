public class Josephus {
 
  public static int josephus( int n ) {
    
    RoundTable rt = new RoundTable(n);
    
    while ( rt.numberOfKnightsIn() > 1 ) {
     
      rt.afterNextKnightQuits();
    }
    return rt.knightWithJugIn();
  }
  
}