import java.util.ArrayList;

class Agenzia {
  
  private final String nome_agenzia;
  private final String telefono_agenzia;
  private ArrayList<Immobile> lista_immobili = new ArrayList<Immobile>();
  
  public Agenzia(String nome, String telefono){
    
    nome_agenzia = nome;
    telefono_agenzia = telefono;
  }
  
  public String getNome() {
    
    return nome_agenzia;
  }
  
  public String getTelefono() {
    
    return telefono_agenzia;
  }
  
  public int aggiungi(Immobile im){
    
    lista_immobili.add(im);
    return lista_immobili.size();
  }
  
  public ArrayList<Immobile> trova(double lat, double lon, double raggioKM, double minMQ){
    
    Immobile current_im;
    ArrayList<Immobile> immobili_disp = new ArrayList<Immobile>();
    for(int i=0; i<lista_immobili.size(); i++){
      current_im = lista_immobili.get(i);
      if (( current_im.distanza(lat, lon) < raggioKM ) && ( minMQ < current_im.getAreaMQ() )){
        immobili_disp.add(current_im);
      }
    }
    return immobili_disp;
  }
  
}