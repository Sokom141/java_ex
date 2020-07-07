import puzzleboard.PuzzleBoard;
import java.util.Random;

class Tavoletta{
  
  private final int size;
  private int[][] griglia; 
  private int[] zero_pos = {0,0}; // { x, y } dello zero, cioè il tassello mancante
  private int[] num_pos = {0,0};
  private PuzzleBoard gui;        // Oggetto per gestire la GUI
  
  public Tavoletta(int n){
    
    size = n;
    griglia = new int[size][size];
    gui = new PuzzleBoard(size);
  }
  
  
  public void fill(){  // fill ordinato
    
    int n = 1;
    for( int i=0; i<size; i++ ) {
      for( int k=0; k<size; k++ ) {
        if ( ( i == size-1 ) && ( k == i ) ) {
          griglia[i][k] = 0;
        } else {
          griglia[i][k] = n;
          setNumber(i+1, k+1, n);
          n += 1;     
        }
      }
    }
    zero_pos[0] = size-1;
    zero_pos[1] = size-1;
  }
  
  public void randomFill( int max ) { // fill randomico
    
    Random rand = new Random();
    int[] used_values = new int[max+1];
    int count = 0;
    
    for ( int x=0; x<=max; x++ ) { // inizializzo l'array dei valori usati a -1 poichè lo 0 è un valore valido
      used_values[x] = -1;
    }
    
    for ( int i=0; i<size; i++ ) {
      for ( int j=0; j<size; j++ ) {
        
        
        int randomNum = rand.nextInt( max + 1 );
        if ( isUsed( randomNum, used_values ) ) {
          
          j -= 1;
        } else {
          
          used_values[count] = randomNum;
          count += 1;
          griglia[i][j] = randomNum;

          if ( randomNum == 0 ) {
            zero_pos[0] = j;
            zero_pos[1] = i;
          } else {
            
            setNumber(i+1, j+1, randomNum);
          }
          
          if ( count == max + 1 ) {
            break;
          }
        }
      }
    }
  }
  
  private boolean isUsed( int n, int[] arr ) { // metodo di supporto al fill randomico. Controllo se un numero è già stato inserito
    
    for(int i=0; i<arr.length; i++){
      if (n == arr[i]) {
        return true;
      }
    }
    return false;
    
  }
  
  public boolean inOrder() {  // la configurazione è ordinata? 
    
    int n = 1;
    for( int i=0; i<size; i++) {
      for( int k=0; k<size; k++) {
        if ( griglia[i][k] == n ) {
          n += 1;
        } else if ( (i == size-1) && (k == size-1) && griglia[i][k] == 0) {
          continue;
        } else { 
          return false;
        }
      }
    }
    return true;
  }
  
  public boolean canBeMoved(int x, int y) { // metodo per controllare se un tassello può essere mosso. 
                                            //(Deve essere a contatto con lo "0")
    if ( (zero_pos[0]-1 <= x && x <= zero_pos[0]+1) && (zero_pos[1]-1 <= y && y <= zero_pos[1]+1) ) {
      if ( (x != zero_pos[0]) && (y != zero_pos[1]) ) {
        
        return false;
      } else {
        
        return true;
      }
      
    } else {
      return false;
    }
  }
  
  public String config() { // metodo che restituisce la configurazione attuale della tavola
    
    String pre = "";
    for( int i=0; i < size; i++){
      for( int k=0; k < size; k++) {
        pre += griglia[i][k] + " ";
      }
      pre += "\n";
    }
    return pre;
  }
  
  public void move(int x_from, int y_from, int x_to, int y_to) { // se è possibile muovere il tassello, spostalo e aggiorna la GUI
    
    if (canBeMoved(x_from,y_from)) {
      
      int placeholder = griglia[y_from][x_from]; 
      griglia[y_from][x_from] = 0;
      zero_pos[0] = x_from;
      zero_pos[1] = y_from;
      griglia[y_to][x_to] = placeholder;
      
      setNumber(y_to+1, x_to+1, placeholder);
      clearNumber(y_from+1, x_from+1);
      
    } else {
      
      System.out.println("The piece cannot be moved.");
    }
  }
  
  public void set(int x, int y, int n) { // metodo per inserire manualmente i numeri ed aggiornare la GUI
    
    griglia[x][y] = n;
    setNumber(x+1, y+1, n);
  }
  
  public void remove(int x, int y) { // metodo per rimuovere manualmente i numeri ed aggiornare la GUI
    
    griglia[x][y] = 0;
    clearNumber(x+1, y+1);
  }
  
  public void setZero(int x, int y){ // metodo per impostare manualmente il tassello vuoto
    
    griglia[x][y] = 0;
    clearNumber(x+1, y+1);
    zero_pos[0] = x;
    zero_pos[1] = y;
  }
  
  private void find(int n){ // metodo di supporto per trovare la posizione del numero che vogliamo spostare
    
    for(int i=0; i<size; i++){
      for(int k=0; k<size; k++){
        if (n == griglia[i][k]) {
          num_pos[0] = k;
          num_pos[1] = i;
          break;
        }
      }
    }
  }
  
  private void update() { // metodo per aggiornare la GUI
    
    gui.display();
  }
  
  private void setNumber(int i, int j, int k) { // metodo per modificare la GUI
    
    gui.setNumber(i, j, k);
    update();
  }
  
  private void clearNumber(int i, int j) { // metodo per modificare la GUI
    
    gui.clear(i, j);
    update();
  }
  
  private int getNumber() { // metodo che restituisce il numero selezionato con il cursore
    
    return gui.get();
  }
  
  public void guiMove() { // metodo per far partire l'interazione con la GUI. Si blocca nel caso in cui il giocatore abbia risolto il rompicapo.
    
    while (true) {
      int k = getNumber();
      find(k);
      move(num_pos[0], num_pos[1], zero_pos[0], zero_pos[1]);
      if ( inOrder() ) {
        System.out.println( "Hai vinto!" );
        break;
      }
    }
  }
  
  public String toString(){ // metodo per visualizzare la configurazione
    
    return config();
  }
  
} // class Tavoletta