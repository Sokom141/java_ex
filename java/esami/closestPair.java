class closestPair{
 
  static double minore = 999999999;
  static int index_1;
  static int index_2;
  static double[] arr2 = new double[2];
  
  public static double[] closestPair(double[] arr){
    
    if ( arr.length < 3 ){
      
      return arr;
    } else {
      
      for(int i=0; i<arr.length; i++){
        for(int j=i; j<arr.length; j++){
          
          if (i == j){
            
            continue;
          } else {
            
            double differenza = Math.abs(arr[i] - arr[j]);
            if ( differenza < minore ) {
              minore = differenza;
              index_1 = i;
              index_2 = j;
            }
          }
        }
      }
    }
    arr2[0] = arr[index_2];
    arr2[1] = arr[index_1];
    return arr2;
  }
  
}