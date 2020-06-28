
/*
 * Protocollo ProximityStructure
 * 
 * new ProximityStructure()  -> costruisce una collezione vuota di misure
 * s.size()                  -> restituisce il numero di misure contenute nella collezione
 * s.add(x)                  -> aggiunge la misura x alla collezione s
 * s.removeClosestTo(x)      -> rimuove da s e restituisce la misura più prossima a x in s
 * 
 */

import java.util.Vector;

public class ProximityStructure {
  
  private Vector<Double> collection;
  
  public ProximityStructure() {
    
    collection = new Vector<Double>();
  }
  
  public int size() {
    
    return collection.size();
  }
  
  public void add( double x ) {
    
    collection.add(x);
  }
  
  public double removeClosestTo( double x ) { // la struttura non è vuota
    
    double closest = collection.get(0);
    int k = 0;
    
    for( int i=0; i<collection.size(); i++) {
      
      double z = collection.get(i);
      if ( Math.abs(z-x) < Math.abs(closest-x) ) {
        closest = z;
        k = i;
      }
    }
    
    collection.removeElementAt(k);
    return closest;
  }
  
  public String toString() {
    String output = "[ ";
    
    for(int i=0; i<collection.size(); i++){
      output += collection.get(i);
      if ( collection.size() - i > 1 ) {
        output += ", ";
      }
    }
    return output + " ]";
  }
  
} // class ProximityStructure