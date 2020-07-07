public class NodeQueue {
  
  private Node[] queue;
  private int size;
  
  public NodeQueue() { // creazione coda vuota
    
    size = 0;
  }
  
  public int size() { // restituisce il numero di elementi contenuti nella coda
    
    return size;
  }
  
  public Node peek() { // restituisce l'elemento con "peso minore" (senza rimuoverlo)
    
    return queue[0];
  }
  
  public Node poll() { // restituisce e rimuove dalla coda l'elemento con "peso minore"
    
    size -= 1;
    Node n = queue[0];
    Node[] placeholder = new Node[size];
    
    for ( int i=0; i<size; i++ ) {
      placeholder[i] = queue[i+1];
    }
    
    queue = placeholder;
    
    return n;
  }
  
  public void add( Node n ) { // aggiunge un nuovo elemento n alla coda
    
    size += 1;
    Node[] q_old = queue;
    queue = new Node[size];
    queue[0] = n;
    merge(q_old, queue);
    sort(queue);
  }
  
  private void merge( Node[] n_old, Node[] n_new) { // inserisce in coda il vecchio array di lunghezza size-1
    
    for (int i=0; i<size-1; i++ ) {
      
      n_new[i+1] = n_old[i];
    }
  }
  
  private void sort( Node[] to_sort ) { // Ordina l'array in base al peso dei nodi
    
    boolean swapped = true;
    int j = 0;
    Node tmp;
    
    while ( swapped ) {
      j++;
      swapped = false;
      
      for ( int i = 0; i < size - j ; i++ ) {
        int compare = to_sort[i].compareTo(to_sort[i+1]);
        
        if ( compare == 1 ) {
          tmp = to_sort[i];
          to_sort[i] = to_sort[i+1];
          to_sort[i+1] = tmp;
          swapped = true;
        }
      }
      
    }
  }
  
  public String toString() {
    
    String pre = "[";
    
    for ( int i=0; i<size; i++ ) {
      
      pre += " " + queue[i] + (i==size-1?" ":",");
    }
    
    return pre + "]";
  }
  
}