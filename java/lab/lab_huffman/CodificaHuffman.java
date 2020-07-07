import huffman_toolkit.*;

class CodificaHuffman{
  
  private static final int CHARS = InputTextFile.CHARS;
  
  public static void freq(String input_text, String output_text) {
    
    // Codice ASCII | Simbolo Carattere | Occorenze | codice di Huffman | numero di bit
    
    InputTextFile input = new InputTextFile(input_text);
    OutputTextFile output = new OutputTextFile(output_text);
    output.writeTextLine("Codice ASCII | Simbolo Carattere | Occorenze | codice di Huffman | numero di bit");
    
    int[] freqh = Huffman.charHistogram(input_text);
    Node n = Huffman.huffmanTree(freqh);
    String[] huff_code = Huffman.huffmanCodesTable(n);
    String s = "";
    
    for ( int i=0; i<CHARS; i++) {
      
      char c = (char) i;
      
      
      if ( c == '\n' ) {
        s = "\\n";
      } else if ( c == '\t' ) {
        s = "\\t";
      } else if ( c == '\r' ) {
        s = "\\r";
      }
      
      int len;
      
      if( huff_code[i] == null ) {
        len = 0;
      } else {
        
        len = huff_code[i].length();
      }
      
      output.writeTextLine(i + " | " + ( s.length()>0 ? s:c ) + " | " + freqh[i] + " | " + huff_code[i] + " | " + len);
      s = "";
    }
    
    input.close();
    output.close();
  }
  
  public static void randomGenerator( String dst, int dimensione ) {
    
    OutputTextFile out = new OutputTextFile(dst);
    
    
    for ( int i=0; i<dimensione; i++ ) {
      
      char c = (char)(Math.random()*128);
      out.writeChar(c);
    }
    
    out.close();
  }
  
  public static String stima( String src ){
    
    
    int[] freq = Huffman.charHistogram( src );                     // istogramma delle frequenze
    Node root = Huffman.huffmanTree( freq );                        // albero di Huffman
    int header = Huffman.flattenTree(root).length();
    int count = root.weight();                              // numero complessivo di caratteri
    int result = 0;   
    String[] codes = Huffman.huffmanCodesTable( root );
    InputTextFile in = new InputTextFile(src);
    
    for ( int j=0; j<count; j++ ) {                       // scansione: codifica dei caratteri
      
      char c = in.readChar();
      result += codes[c].length();

    }
    
    result /= 7;
    in.close();
    return "Stima file compresso: " + (header + result) ;
  }
  
}