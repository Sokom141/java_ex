class BtrTest{
 
  public static StringSList btrString(String btr, int n){
    
    StringSList soluzioni = StringSList.NULL_STRINGLIST;
    
    for (int i=0; i<n; i++) {
      
      soluzioni = soluzioni.cons(btr);
      btr = BtrSucc.btrSucc(btr);
    }
    
    return soluzioni.reverse();
  }
}