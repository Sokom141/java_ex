import java.util.Scanner;

class Pila{
  
  private int[] array = new int [5];
  
  public Pila(int[] n){
    
    for (int i=0; i < n.length; i++) {
      array[i] = n[i];
    }
  }
  
  public void show(){
    
    for ( int i = 0; i < array.length; i++){
      System.out.println(array[i]);
    }
  }
  
}

class Main{
  
  static Scanner tastiera = new Scanner(System.in);
  static int[] gino = new int[5];
  
  public static void startArray(){
    for (int i=0; i< gino.length; i++) {
      int n = tastiera.nextInt();
      gino[i] = n;
    }
    
    Pila lista = new Pila(gino);
    lista.show();
  }
  
}