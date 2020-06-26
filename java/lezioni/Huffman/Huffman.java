import java.util.*;

import huffman_toolkit.*;

public class Huffman {
  
  private static final int CHARS = InputTextFile.CHARS;
  
  public static int[] freqHistogram( String src ) {
    
    int[] freq = new int[CHARS];
    
    for( int i=0; i<CHARS; i++) {
      freq[i] = 0;
    }
    
    InputTextFile in = new InputTextFile(src);
    
    while( in.textAvailable() ) {
      
      char chr = in.readChar();
      freq[chr] += 1;
      
    }
    
    in.close();
    
    return freq;    
  }
  
  public static Node huffmanTree( int[] freq ) {
    
    PriorityQueue<Node> q = new PriorityQueue<Node>();
    
    for ( int i=0; i<CHARS; i++) {
      if (freq[i] > 0){
        Node n = new Node( (char) i, freq[i]);
        q.add(n);
      }
    }
    while ( q.size() > 1 ) {
      
      Node l = q.poll();
      Node r = q.poll();
      Node n = new Node(l, r);
      
      q.add(n);
    }
    
    return q.poll();
  }
  
  public static String[] codeTable( Node root ) {
    
    String[] codes = new String[CHARS];
    
    fillTable( root, "", codes );
    
    return codes;
  }
  
  private static void fillTable( Node n, String pre, String[] codes ) {
    
    if ( n.isLeaf() ) { 
      char c = n.character();
      codes[c] = pre;
    } else {
      fillTable( n.left(), pre + "0", codes);
      fillTable( n.right(), pre + "1", codes);
    }
  }
  
}