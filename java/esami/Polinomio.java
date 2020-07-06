public class Polinomio{
  
  private int intero;
  private char var = ' ';
  private char operatore;
  private Polinomio pol1;
  private Polinomio pol2;
  
  public Polinomio( int a ) {
    
    intero = a;
  }
  
  public Polinomio( char b ) {
    
    if (( b == 'x') || (b == 'y') || (b == 'z')){
      var = b;
    } else {
      throw new IllegalArgumentException("Variabile non accettata. Variabili possibili: x,y,z");
    }
  }
  
  public Polinomio( char op, Polinomio p, Polinomio q ) {
    
    if ( ( op == '+' ) || ( op == '*') ) {
      pol1 = p;
      operatore = op;
      pol2 = q;
    } else {
     throw new IllegalArgumentException("Operatore non accettato. Operatori possibili: +, *");
    }
  }
  
  public double valuta( double[] valori ) {
    
    double risultato = 0;
    double p = 0;
    
    if ( pol1 != null) {
      
      if (this.operatore == '+') {
        
        risultato = pol1.valuta(valori) + pol2.valuta(valori);
      } else if (this.operatore == '*'){
        
        risultato = pol1.valuta(valori) * pol2.valuta(valori);
      }
      
    } else {
      if (this.var == 'x') {
        
        p = valori[0];
      } else if (this.var == 'y') {
        
        if ( valori.length < 2 ){
          throw new IllegalArgumentException("Non ci sono abbastanza valori da assegnare.");
        }
        p = valori[1];
        
      } else if (this.var == 'z') {
        if ( valori.length < 3 ){
          throw new IllegalArgumentException("Non ci sono abbastanza valori da assegnare.");
        }
        
        p = valori[2];
      }
    }
    
    if (intero != 0) {
      risultato += intero;
    } else {
      risultato += p;
    }
    
    
    return risultato;
  }
  
  public String toString() {
    String pre = "( ";
    
    
    if ( pol1 != null ) {
      
      pre += pol1.toString() + " ";
      pre += operatore + " ";
      pre += pol2.toString();
    } else {
      
      if ( var != ' ') {
        pre = pre + var;
      } else  {
        pre = pre + intero;
      }
      
    }
    
    return pre + " )";
  }
}