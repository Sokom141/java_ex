public class Test{
  
  public static double prova(){
    
    Potenza due = new Potenza(2);
    double r1 = due.pow(2);
    double r2 = due.pow(3);
    due.cambiobase(3);
    double r3 = due.pow(2);
    return r3;

  }
  
}