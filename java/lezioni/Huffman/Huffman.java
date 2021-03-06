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
  
  public static String flattenTree( Node n ) {
    
    if ( n.isLeaf() ) {
      char c = n.character();
      if (( c == '@' ) || ( c == '\\')) {
        return "\\" + c;
      } else {
        return "" + c;
      }
    } else {
      return "@" + flattenTree( n.left() ) 
                 + flattenTree( n.right() );
    }
  }
  
  public static void compress( String src, String dst ) {
  
    int[] freq = freqHistogram( src );
    Node root = huffmanTree( freq );
    String[] codes = codeTable( root );
    
    int size = root.weight();
    String ht = flattenTree( root );
    
    InputTextFile in = new InputTextFile(src);
    OutputTextFile out = new OutputTextFile(dst);
    
    out.writeTextLine( "" + size );
    out.writeTextLine( ht );
    
    for ( int i = 0; i<size; i++ ) {
      
      char c = in.readChar();
      out.writeCode( codes[c] );
    }
    
    
    in.close();
    out.close();
  }
    
  public static Node restoreTree( InputTextFile in ) {
    
    char c = in.readChar();
        
    if ( c == '@' ) {
      Node lft = restoreTree( in );
      Node rgt = restoreTree( in );
      return new Node( lft, rgt );
    } else {
      if ( c == '\\' ) {
        c = in.readChar();
      }
      return new Node( c, 0 );
    }
  }
  
  private static char restoreChar( Node n, InputTextFile in ) {
   
    while ( !n.isLeaf() ){
      int bit = in.readBit();
      
      if (bit == 0) {
        n = n.left(); 
      } else {
        n = n.right();
      }
    }
    return n.character();
  }
  
  public static void decompress( String src, String dst ) {
    
    InputTextFile in = new InputTextFile(src);
    OutputTextFile out = new OutputTextFile(dst);
    
    int size = Integer.parseInt( in.readTextLine() );
    Node root = restoreTree(in);
    String skip = in.readTextLine(); // salta capolinea
    
    for (int i=0; i<size; i++) {
      
      char c = restoreChar( root, in );
      out.writeChar(c);
    }
    
    in.close();
    out.close();
  }
 
}