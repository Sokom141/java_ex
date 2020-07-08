/*
 * public Towers( int n )
costruttore, il cui parametro n indica il numero di dischi, ovvero l’altezza della torre da ricostruire.

public void put( int disk, int rod )
metodo per stabilire la posizione iniziale del disco disk in corrispondenza all’asticella rod, prima di giocare.

public void move( int disk, int dst )
metodo che consente di modificare lo stato del gioco effettuando una mossa che sposta il disco disk dall’asticella in cui si trova all’asticella di destinazione dst.

public int height()
metodo che restituisce l’altezza della torre da ricostruire (o equivalentemente il numero di dischi del gioco).

public int site( int disk )
metodo che restituisce il numero che identifica l’asticella in corrispondenza alla quale è collocato il disco disk.

public int transit( int disk, int dst )
metodo che restituisce il numero che identifica l’asticella di transito per il disco disk con destinazione dst: l’asticella di transito è quella che rimane escludendo l’asticella in cui è collocato disk e l’asticella dst.

public String moves()
metodo per acquisire la stringa che codifica la sequenza di mosse effettuate
 * 
 * 
 */


public class Towers {
  
  
  
  // Variabili di istanza ...
  
  private int height;
  private String moves;
  private int[] uno;
  private int[] due;
  private int[] tre;
  
  // Costruttore ...
  public Towers( int n ) {
    
    height = n;
    uno = new int[n];
    due = new int[n];
    tre = new int[n];
    for(int i=0; i<uno.length; i++){
      uno[i] = i+1;
    }
  }
  
  
  // Metodi ...
  
  public void put( int disk, int rod ) {
    
    int pos = search_disk(disk);
    if ( rod == 1 ) {
      
    } else if ( rod == 2 ){
      
    } else {
      
    }
    
  }
  
  public void move( int disk, int dst ) {
    
    
  }
  
  public int height() {
    return height;
  }
  
  public int site( int disk ) {
    
  }
  
  public String moves(int src, int dst) {
    moves = " " + src + "->" + dst + " ";
  }
  
  
  public int transit( int disk, int dst ) {
    
    return ( 6 - site(disk) - dst );
    
  }
  
  private int search_disk( int disk ) {
   
    for(int i=0; i<uno.length; i++) {
      if ( disk == uno[i] ) {
        return 1;
      } else if ( disk == due[i]) {
        return 2;
      } else if ( disk == tre[i]) {
        return 3;
      }
    }
    
  }
  
  
  
}  // class Towers

