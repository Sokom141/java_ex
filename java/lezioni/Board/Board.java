import java.util.Scanner;
import java.lang.*;
import java.util.function.*;
/*
 * Protocollo della classe "Board":
 * 
 * Board b = new Board(n);
 * 
 * b.size()           : int
 * b.queensOn()       : int
 * b.underAttack(i,j) : boolean
 * b.arrangement()    : String
 * b.addQueen(i,j)    : Board
 * 
 */

public class Board {
  
  private static final String ROWS = " 123456789ABCDEF";
  private static final String COLS = " abcdefghijklmno";
  
  private final int size;
  private final int queens;
  private final BiPredicate<Integer,Integer> attack;
  private final String config;
  // private int table[][];
  
  public Board( int n ) {
    
    size = n;
    //table = new int[size][size];
    queens = 0;
    attack = (x, y) -> false;  // (lambda (x y) false)
    config = "";
  }
  
  private Board( int n, int q, BiPredicate<Integer, Integer> p, String c ) {
   
    size = n;
    queens = q;
    attack = p;
    config = c;
  }
  
  public int size() {
    
    return size;
  }
  
  public int queensOn() {
    
    return queens;
  }
  
  public boolean underAttack( int i, int j ) {
    
    return attack.test( i, j );
  }
  
  public String arrangement() {
    
    return config;
  }
  
  public Board addQueen( int i, int j ) {
    
    return new Board(
                     size,
                     queens + 1,
                     ( x, y) -> ,
                     config + " " + COLS.substring(j,j+1) + ROWS.substring(i,i+1) + " "
                       );
     
}