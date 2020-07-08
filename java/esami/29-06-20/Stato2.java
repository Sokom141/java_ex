public class Stato2 {
  
  public static int[] q( int[] v ) {
    // int[] v;
    
    int n = v.length;
    
    if ( n > 3 ) {
      
      int[] x = new int[] { v[0], v[1], v[2] };
      
      for ( int i=3; i<n; i=i+1 ) {
        
        v[i-3] = v[i];
        
      }
      
      v[n-3] = x[0];
      v[n-2] = x[1]; 
      v[n-1] = x[2];
      
    } 
    
    return v;
  }
  
  public static int[] back( int[] v ) {
   
    int n = v.length;
    
    if ( n > 3 ){
      
      int[] x = new int[] { v[n-3], v[n-2], v[n-1] };
      
      for ( int i=n-1; i>2; i--) {
        
        v[i] = v[i-3];
      }
      
      v[0] = x[0];
      v[1] = x[1];
      v[2] = x[2];
      
    }
    
    return v;
  }
  
}