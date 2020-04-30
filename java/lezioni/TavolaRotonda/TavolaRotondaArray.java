public class TavolaRotondaArray {
  
  private final int[] cavalieri;
  
  public TavolaRotondaArray(int n) {
    
    cavalieri = new int[n];
    for (int k=1; k<=n; k=k+1) {
      cavalieri[k-1] = k;
    }
  }
  
  private TavolaRotondaArray( int[] cav ) {
    
    cavalieri = cav;
  }
  
  public int numeroDiCav() {
    
    return cavalieri.length;
  }
  
  public int cavConLaBrocca() {
    
    return cavalieri[0];
  }
  
  public TavolaRotondaArray dopoUscitaCav() {
    
    int n = cavalieri.length - 1;
    int[] cav = new int[n];
    for (int i=0; i<n-1; i=i+1) {
      
      cav[i] = cavalieri[i+2];
    }
    cav[n-1] = cavalieri[0];
    
    return new TavolaRotondaArray(cav);
  }
}