import huffman_toolkit.*;

public class IOExample {
 
  
  public static int copyFile( String src, String dst ) {
    
    InputTextFile in = new InputTextFile(src);
    OutputTextFile out = new OutputTextFile(dst);
    int count = 0;
    
    while ( in.textAvailable() ) {
      
      String line = in.readTextLine();
      out.writeTextLine( line );
      count += 1;
    }
    
    in.close();
    out.close();
    return count;
  }
  
  public static int copyFileChar( String src, String dst ) {
    
    InputTextFile in = new InputTextFile(src);
    OutputTextFile out = new OutputTextFile(dst);
    int count = 0;
    
    while ( in.textAvailable() ) {
      
      char c = in.readChar();
      out.writeChar( c );
      count += 1;
    }
    
    in.close();
    out.close();
    return count;
  }
  
    public static int copyFileBit( String src, String dst ) {
    
    InputTextFile in = new InputTextFile(src);
    OutputTextFile out = new OutputTextFile(dst);
    int count = 0;
    
    while ( in.bitsAvailable() ) {
      
      int bit = in.readBit();
      out.writeBit( bit );
      count += 1;
    }
    
    in.close();
    out.close();
    return count;
  }
}