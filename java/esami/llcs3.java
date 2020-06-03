class llcs3{
  
  public static int llcs3(String t, String u, String v){
    
    int lt = t.length();
    int lu = u.length();
    int lv = v.length();
    
    int[][][] mem = new int[lt+1][ut+1][vt+1];
    
    for(int i=0; i<lt; i++){
      for(int j=0; j<ut; j++){
        for(int z=0; z<vt; z++){
          mem[x][y][z] = -1;
        }
      }
    }
    
    return llcs3rec(t, u, v, mem)
  }
  
  public static int llcs3rec(String t, String u, String v, int[][][] memo){
    
    if ( (t == 0) || (u == 0) || (v == 0) ){
    
      return 0;
    }
    
    else-if () {
      
    }
    else{
      
    }
  }
  
}