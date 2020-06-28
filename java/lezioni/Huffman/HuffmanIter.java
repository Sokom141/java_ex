/*
 * Huffman Iterativo
 */
import java.util.*;

import huffman_toolkit.*;

public class HuffmanIter {
  
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
    
    Stack<Frame> stack = new Stack<Frame>();
    stack.push( new Frame(root, "") );
    
    while( !stack.empty() ) {
      
      Frame f = stack.pop();
      Node n = f.node;
      String pre = f.pre;
      
      if ( n.isLeaf() ) { 
        char c = n.character();
        codes[c] = pre;
      } else {
        stack.push( new Frame( n.right(), pre + "1") );
        stack.push( new Frame( n.left(), pre + "0") );
      }
    }
    return codes;
  }
  
  public static String flattenTree( Node root ) {
    
    String ht = "";
    Stack<Node> stack = new Stack<Node>();
    stack.push( root );
    
    while ( !stack.empty() ) {
      
      Node n = stack.pop();
      
      if ( n.isLeaf() ) {
        char c = n.character();
        if (( c == '@' ) || ( c == '\\')) {
          ht += "\\" + c;
        } else {
          ht += c;
        }
      } else {
        ht += "@";
        stack.push( n.right() );
        stack.push( n.left() );
      }
    }
    return ht;
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