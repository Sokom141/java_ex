import java.util.function.*;
/*
 * Astrazione sullo stato.
 * Protocollo della classe "Board2":
 * 
 * Board2 b = new Board2(n);
 * 
 * b.size()           : int
 * b.queensOn()       : int
 * b.underAttack(i,j) : boolean
 * b.arrangement()    : String
 * 
 * b.addQueen(i,j)    : void
 * b.rmQueen(i,j)     : void
 * 
 */

public class Board2 {
  
  private static final String ROWS = " 123456789ABCDEF";
  private static final String COLS = " abcdefghijklmno";
  
  private final int size;
  private int queens;
  private int[] rowAttack;
  private int[] colAttack;
  private int[] dg1Attack;
  private int[] dg2Attack;
  private String config;
  
  public Board2( int n ) {
    
    size = n;
    queens = 0;
    rowAttack = newArray( n );
    colAttack = newArray( n );
    dg1Attack = newArray( 2*n-1 );
    dg2Attack = newArray( 2*n-1 );
    config = "";
  }
  
  private static int[] newArray( int k ) {
    
    int[] v = new int[k];
    for ( int i=0; i<k; i++) {
      v[i] = 0;
    }
    return v;
  }
  
  public int size() {
    
    return size;
  }
  
  public int queensOn() {
    
    return queens;
  }
  
  public boolean underAttack( int i, int j ) {
    
    return ( (rowAttack[i-1] > 0) || 
             (colAttack[j-1] > 0) ||
             (dg1Attack[i-j+size-1] > 0) ||
             (dg2Attack[i+j-2] > 0) );
  }
  
  public String arrangement() {
    
    return config;
  }
  
  public void addQueen( int i, int j ) {
    
    queens += 1;
    rowAttack[i-1] += 1;
    colAttack[j-1] += 1;
    dg1Attack[i-j+size-1] += 1;
    dg2Attack[i+j-2] += 1;
    config = config + " " + COLS.substring(j, j+1)
                          + ROWS.substring(i, i+1) + " ";
  }
  
    public void rmQueen( int i, int j ) {
    
    queens -= 1;
    rowAttack[i-1] -= 1;
    colAttack[j-1] -= 1;
    dg1Attack[i-j+size-1] -= 1;
    dg2Attack[i+j-2] -= 1;
    String pos = " " + COLS.substring(j, j+1)
                     + ROWS.substring(i, i+1) + " ";
    int k = config.indexOf( pos );
    config = config.substring(0, k) + config.substring(k+4);
  }
  
  public String toString() {
    
    return arrangement();
  }
}