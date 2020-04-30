/**
  *
  * Costruttori per creare "nuove" situazioni:
  *
  * 
  * Metodi per acquisire informazioni sulla situazione modellata:
  * 
  * TavolaRotonda tr;
  * 
  * tr.numeroDiCavalieri() : int
  * tr.cavConLaBrocca()    : int [etichetta, posizione]
  * ...
  * 
  * Metodi per generare una nuova situazione a partire da una situazione data:
  * 
  * tr.dopoUscitaCav()     : TavolaRotonda
  * 
  */

public class TavolaRotonda {
  
  private final IntSList cavalieri;
  
  public TavolaRotonda( int n ) { // n > 0
   
    cavalieri = range( 1, n );
  }
  
  private TavolaRotonda( IntSList cav ){
    
    cavalieri = cav;
  }
  
  public int numeroDiCavalieri() {
    
    return cavalieri.length();
  }
  
  public int cavConLaBrocca() {
    
    return cavalieri.car();
  }
  
  public TavolaRotonda dopoUscitaCav() {
   
    IntSList listaDiUnElemento = IntSList.NULL_INTLIST.cons( cavalieri.car() );
    IntSList listaCon2ElementiInMeno = cavalieri.cdr().cdr();
    
    listaCon2ElementiInMeno.append(listaDiUnElemento);
    
    return new TavolaRotonda( listaCon2ElementiInMeno );
  }
  
  private static IntSList range( int m, int n ){
    
    if( m > n ) {
      return IntSList.NULL_INTLIST;
    } else {
      return range(m+1,n).cons(m);
    }
  }
   
  
} // end of class TavolaRotonda