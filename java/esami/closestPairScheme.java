import java.util.Arrays;

class closestPairScheme{
  
  public static double[] closestPair(double[] n){
    
    if (n.length == 2){
      return n;
    } else {
      double d1 = Math.abs(n[1] - n[0]);
      double[] c = closestPair( Arrays.copyOfRange(n, 1, n.length) );
      double d2 = Math.abs(c[1] - c[0]);
      if (d1 < d2) {
        double[] ret_arr = new double[2];
        ret_arr[0] = n[0];
        ret_arr[1] = n[1];
        return ret_arr;
      } else {
        return c;
      }
    }
    
  }
  
}