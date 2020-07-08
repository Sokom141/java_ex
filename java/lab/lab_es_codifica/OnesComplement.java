public class OnesComplement {
  
  public static String onesComplement( String bin ) {// Stringa di 0/1
    String result = "";
    if (bin.length() == 0) {
      return "";
    } else {
      result += onesComplement(bin.substring(0, bin.length()-1)) + bitComplement( bin.substring(bin.length()-1));
    }
    return result;
  }
  
  private static String bitComplement( String bit ) { // Stringa di un carattere 0/1
    
    if (bit.equals("0")){
      return "1";
    } else{
      return "0";
    }
  }
  
  public static String onesComplementIter( String bin ) {
   
    String result = "";
    int c = 0;
    
    for (int i=0; i<bin.length(); i++ ) {
      result += bitComplement( bin.substring(c, c+1));
      c++;
    }
    return result;
  }
}