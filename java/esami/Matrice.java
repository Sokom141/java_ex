class Matrice{
  
  public static boolean simmetrica(int[][] mat) {
    
    int c = 0;
    
    for(int i=0; i<mat.length-1; i++){
      for(int j=i+1; j<mat.length; j++) {
        if(mat[i][j] != mat[j][i]){
          c++;
          return false;
        }            
        c++;
      }
    }
    System.out.println(c);
    return true;
  }
  
}