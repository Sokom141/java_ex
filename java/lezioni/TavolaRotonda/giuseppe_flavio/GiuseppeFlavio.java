public class GiuseppeFlavio {
  
  public static int ultimo( int n ) {
    
    TavolaRotondaArray tr = new TavolaRotondaArray(n);
    
    while (tr.numeroDiCavalieri() > 1 ) {
      
      tr = tr.dopoUscitaCav();
    }
    return tr.cavConLaBrocca();
  }
  
} // class GiuseppeFlavio