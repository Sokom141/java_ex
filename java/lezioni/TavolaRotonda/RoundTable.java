
/**
 * Astrazione sullo stato.
 * 
 * Classe RoundTable:
 * 
 * RoundTable t = new RoundTable()
 * 
 * t.numberOfKnightsIn() : int
 * t.knightWithJugIn()   : int
 * 
 * t.afterNextKnightQuits();
 * 
 * */

public class RoundTable {
  
  private int[] knights;
  private int num;
  private int jug;
  
  public RoundTable( int n ) {
   
    knights = new int[2*n-1];
    for ( int k=1; k<=n; k++ ) {
      knights[k-1] = k;
    }
    num = n;
    jug = 0;
  }
  
  public int numberOfKnightsIn() {
   
    return num;
  }
  
  public int knightWithJugIn() {
   
    return knights[jug];
  }
  
  public void afterNextKnightQuits() {
    
    knights[jug+num] = knights[jug];
    jug += 2;
    num -= 1;
  }
  
}