class Passeggero {
  
  private String nomePersona;
  private double peso;
  
  public Passeggero(String nome, double pesoKg) {
    
    nomePersona = nome;
    peso = pesoKg;
  }
  
  public String getNome(){
    
    return nomePersona;
  }
  
  public double getPesoKg(){
    
    return peso;
  }

}