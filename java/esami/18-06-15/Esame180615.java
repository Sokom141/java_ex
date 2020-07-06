public class Esame180615 {
  
  public static long q( int i, int j, boolean b ) {
    
    if ( b ) {
      
      if ( i*j == 0 ) {
        return i+j+1;
        
      } else {
        return q(i-1, j, b) + q(i, j-1, b) + q(i, j, !b);
      }
    } else {
      if ( i*j==0 ) {
        return 1;
      } else {
        return q(i-1, j, b) + q(i, j-1, b);
      }
    }
  }
  
  public static long qDP( int i, int j, boolean b ){
    
    int[][] mat = new int[i+1][j+1][2];
    
    
    for(int x=0; x<=i; x++){
      for(int y=0; y<=j; y++) {
        mat[0][y] = 1;
        mat[x][0] = 1;
      }
    }    
    
    for(int x=1; x<=i; x++){
      for(int y=1; y<=j; y++) {
        mat[x][y] = mat[x-1][y] + mat[x][y-1];
        counter += 2;
      }
    }
          
    return mat[i][j] + counter;
  }
  
}