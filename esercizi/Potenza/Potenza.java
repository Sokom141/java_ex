public class Potenza{
  
  private int x;
  
  public Potenza(int base) {
    
    x = base;
  }
  
  public double pow(int esponente) {
    
    double result = Math.pow(x,esponente);
    return result;
  }
  
  public void cambiobase(int nuova_base){
    
    x = nuova_base;
  }

}