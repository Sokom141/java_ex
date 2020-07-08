public class Stato {
  
  // int[] v;
  
  public static int[] es(int[] v) {
    int n = v.length;
    
    for ( int i=n-3; i>=0; i=i-1 ) {
      
      v[i+2] = v[i+2] * v[i];
      
      
    }
    
    return v;
    
  }
  
  public static int[] back( int[] v ) {
    
    int n = v.length;
    
    for ( int i = 0; i < n-2; i++ ) {
      
      v[i+2] = v[i+2] / v[i];
    }
    
    return v;
  }
  
}