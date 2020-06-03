import puzzleboard.PuzzleBoard;

class Tavoletta{
  
  private final int size;
  private int[][] griglia; 
  private int[] zero_pos = {0,0};
  private int[] num_pos = {0,0};
  private PuzzleBoard gui;
  
  public Tavoletta(int n){
  
    size = n;
    griglia = new int[size][size];
    gui = new PuzzleBoard(size);
  }
  
  
  public void fill(){
    int n = 1;
    for( int i=0; i<size; i++){
      for( int k=0; k<size; k++){
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

    
  public boolean inOrder(){
    
    int n = 1;
    for( int i=0; i<size; i++) {
      for( int k=0; k<size; k++) {
        if ( griglia[i][k] == n ) {
          n += 1;
        } else { 
          return false;
        }
      }
    }
    
    return true;
  }
  
  public boolean canBeMoved(int x, int y) {
    
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
  
  public void config(){
    
    for( int i=0; i < size; i++){
      for( int k=0; k < size; k++) {
        System.out.print( griglia[i][k] + " ");
      }
      System.out.println();
    }
  }
  
  public void move(int x_from, int y_from, int x_to, int y_to){
    
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
  
  private void find(int n){
    
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
  
  private void update(){
    
    gui.display();
  }
  
  public void setNumber(int i, int j, int k){
    
    gui.setNumber(i, j, k);
    update();
  }
  
  public void clearNumber(int i, int j) {
    
    gui.clear(i, j);
    update();
  }
  
  public int getNumber() {
    
    return gui.get();
  }
  
  public void guiMove() {
    
    while (true) {
      int k = getNumber();
      find(k);
      move(num_pos[0], num_pos[1], zero_pos[0], zero_pos[1]);
      config(); // debug
    }
  }
  
}