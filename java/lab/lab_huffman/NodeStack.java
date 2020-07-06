public class NodeStack{
  
  private Node[] stack;
  private int size;
  
  public NodeStack() { // creazione di uno stack vuoto
    
    size = 0;
  }
  
  public boolean empty() { // verifica se lo stack è vuoto
    
    if ( size == 0 ) {
      return true;
    } else {
      return false;
    }
  }
  
  public Node peek() { // restituisce l'elemento in cima allo stack senza rimuoverlo
    
    if ( empty() ) {
      return null;
    } else {
      return stack[0];
    }
  }
  
  public Node pop() { // restituisce l'elemento in cima allo stack e lo rimuove
    
    if ( empty() ) {
      return null;
    } else {
      size -= 1;
      Node n = stack[0];
      Node[] placeholder = new Node[size];
      
      for ( int i=0; i<size; i++ ) {
        placeholder[i] = stack[i+1];
      }
      
      stack = placeholder;
      
      return n;
    }
  }
  
  public void push( Node n ) { // aggiunge un nuovo elemento n in cima allo stack
    
    size += 1;
    Node[] placeholder = stack;
    stack = new Node[size];
    stack[0] = n;
    merge(placeholder, stack);
  }
  
  private void merge( Node[] n_old, Node[] n_new) { // inserisce in coda il vecchio array di lunghezza size-1
    
    for (int i=0; i<size-1; i++ ) {
      
      n_new[i+1] = n_old[i];
    }
  }
  
  public String toString() {
    
    String pre = "[";
    
    for (int i=0; i<size; i++) {
      
      pre += " " + stack[i] + (i==size-1? "":",");
    }
    
    return pre + " ]";
  }
  
}