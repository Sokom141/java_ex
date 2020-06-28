public class Correctness {
  
  public static int sqr( int n ){   // Pre: n >= 0 
    
    int x = 0;
    int y = 0;
    int z = 1;
    
    while( x < n ) {                // Inv: 0 <= x <= n, y = x^2, z = 2x+1
                                    // Term: n-x
      x += 1;
      y += z;
      z += 2;
    }
    return y;                       // Post: y = n^2
  }
  
  /*
   *  Notazione: Inv(x,y,z)  
   * 
   *  Inv(0,0,1) : 0<=0<=n, 0 = 0^2, 1 = 2*0+1  
   *                  0<=n <--- Pre
   * 
   *  Conservazione 
   *  Assumo:   Inv(x,y,z) & ( x < n ) 
   *  Dimostro: Inv(x+1, y+z, z+2) 
   * 
   *  Inv(x+1, y+z, z+2) : 0 <= x+1 <= n, y+z = (x+1)^2, z+2 = 2(x+1)+1
   *                       0 <= x+1 <--- 0 <= x
   *                            x+1 <=n <--- x < n
   *                                    y+z = (x+1)^2 = x^2 + 2x + 1 <--- y = x^2, z = 2x+1
   *                                                    z+2 = 2(x+1)+1 = 2x+1 + 2 <-- z = 2x+1
   * 
   *  Risultato finale
   *  Assumo:  Inv(x,y,z) & (x >= n)
   *  Dimostro: y = n^2
   * 
   *  x <= n, x >= n --> x = n
   *  x = n, y = x^2 --> y = n^2
   * 
   *  term(x,y,z) = n - x >=0  <-- x <= n
   * 
   *  term(x+1, y+z, z+2) = n - (x+1) = n-x -1 < n-x = term(x,y,z)  <-- Inv(x,y,z)2
   * 
   */
  
  public static int lcm( int m, int n ) {   // Pre: m, n > 0    
    
    
    int x = m;
    int y = n;
    
    while ( x != y ) {                      // Inv: 0< x, y <= mcm(m,n), x mod m = 0, y mod n = 0
                                            // Term: 2*mcm(m,n)-x-y
      if (x < y) {
        
        x += m;
        
      } else {
        
        y +=n;
        
      }
    }
    
    return x;                              // Post: x = mcm(m, n)
  }
  
  /*
   *  Notazione: Inv(x,y)
   * 
   *  Inv(m, n) : 0 < m, n <= mcm(m,n), m mod m = 0, n mod n = 0
   *              Pre
   * 
   *  Conservazione
   *  Assumo (a) :     Inv(x,y) & ( x < y )
   *  Dimostro:        Inv(x+m, y)
   *  
   *  Assumo (b) :     Inv(x,y) & ( x > y )
   *  Dimostro:         Inv(x, y+n) 
   *
   *  (a) Inv(x+m,y) : 0 < x+m, y <= mcm(m,n), x+m mod m = 0, y mod n = 0
   *                   
   *     x < y <= mcm(m,n)  --> x+m <= mcm(m, n)
   * 
   *  (b) Inv(x,y+n) : 0 < x, y+n <= mcm(m,n), x mod m = 0, y+n mod n = 0
   *   
   *    y < x <= mcm(m,n)   --> y+n <= mcm(m,n)
   * 
   *  Risultato Finale
   *  Assumo:          Inv(x,y) & (x = y) 
   *  Dimostro:        x = mcm(m, n)
   *   
   *   0 < x = y <= mcm(m,n), x mod m = 0, x mod n = 0
   *   x mod m = 0, x mod n = 0 --> x >= mcm(m, n) 
   *   x <= mcm(m,n), x >= mcm(m,n) --> x = mcm(m,n)
   *   
   *  Terminazione
   *   
   *   term(x,y) = 2*mcm(m,n)-x-y >= 0 <-- x,y <= mcm(m,n)
   * 
   *   term(x',y') = 2*mcm(m,n)-x'-y' <= 2*mcm(m,n)-x-y-min(m,n) < 2*mcm(m,n)-x-y <-- m, n > 0
   * 
   */
  
  public static int cube( int n ) { // Pre: n >= 0
    
    int x = 0;
    int y = 0;
    int u = 1;
    int v = 6;
    
    while ( x < n ) {              /* Inv: 0 <= x <= n, y = x^3
     u = 3x^2 + 3x + 1, v = 6x + 6 */
      // Term = ?
      x += 1;
      y += u;
      u += v;
      v += 6;
    }
    return y;                     // Post: y = n^3
  }
  
  public static int[] fattorizzazione( int n ) {   // Pre: n >= 2
    
    int[] fattori = new int[n+1];
    
    for(int i=0; i<=n; i++) {
      fattori[i] = 0;
    }
    int x = n;
    int p = 2;
    
    while ( x > 1 ) {                             // Inv: 1 <= x <= n,  n = x * Prod (k: [2,n]) k^fattori[k] 
                                                            // x non ha fattori < p,  2 <= p <= n
                                                            // term: x + n - p
      if ( x % p == 0 ) {
        fattori[p] += 1;
        x /= p;
      } else {
        p += 1;
      }
    }
    return fattori;                               // Post: n = Prod (k: [2, n]) k^fattori[k]
  }
  
  /*
   *  Notazione: Inv( {0,0,...,0}, n, 2) : 1 <= x <= n,  n = n * Prod (k: [2,n]) k^0 = n * 1
   *                                       n non ha fattori < 2, 2 <= 2 <= n
   * 
   *  (a) p divide x
   *     
   *     ? : 1 <= x/p <= n,
   *         n = x/p * Prod (k: [2,p-1]) k^fattori[k] * p^(fattori[p]+1) * Prod (k: [p+1,n]) k^fattori[k]
   *         x/p non ha fattori < p,  2 <= p <= n
   *         
   *         n = x * Prod (k: [2,p-1]) k^fattori[k] * p^(fattori[p]) * Prod (k: [p+1,n]) k^fattori[k]
   *           = x * Prod (k: [2,n]) k^fattori[k]
   * 
   *  (b) p + 1 
   * 
   *    ...
   *  
   *       x non ha fattori < p+1,  2 <= p+1 <= n
   * 
   *    
   *  Inv(fattori, x, p) & x <= 1  -->  x = 1 -->
   *     
   *     n = 1 * Prod (k: [2, n]) k^fattori[k]
   * 
   *  term: x + n - p >= 0
   * 
   *  (a) term': x/p + n - p < x + n - p  : term
   * 
   *  (b) term': x + n - (p+1) = (x + n - p ) - 1 < x + n - p : term
   * 
   * 
   * 
   *  Esercizio 4/A della prova di accertamento del 25 Giugno 2019
   * 
   *  y = 2q + 1 -> y = 2*0 + 1 = 1
   *  y+z = n -> z = n - 1
   *  x + H = (q+1)^2 = q^2 + 2q + 1 -> x = x + y
   *  2 - K = 0 -> K = -2
   *  q^2 > z
   *  n = y+z < 2q+1 + q^2 = (q+1)^2
   *  n < (q+1)^2
   *  q^2 <= n
   */
  
}