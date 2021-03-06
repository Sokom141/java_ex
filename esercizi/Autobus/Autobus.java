class Autobus {
  
  public double litriGasolioSerbatoio = 0;
  public int numPasseggeri = 0;
  public Passeggero[] passeggeri;
  
  public Autobus(int maxNumeroPostiSedere){
    
    int posti = maxNumeroPostiSedere;
    passeggeri = new Passeggero[posti];
  }
  
  public int carica(Passeggero p) {
    
    if ( numPasseggeri == passeggeri.length ) {
      return -1;
    } else {
      passeggeri[numPasseggeri] = p;
      numPasseggeri += 1;
      return numPasseggeri;
    }
  }
  
  public void svuota() {
    
    numPasseggeri = 0;
  }
  
  public double caricaGasolio(double litriGasolio) {
    
    litriGasolioSerbatoio += litriGasolio;
    return litriGasolioSerbatoio;
  }
  
  public double pesoPasseggeriKg() {
    
    double totalePeso = 0;
    
    for (int i = 0; i < passeggeri.length; i++) {
      totalePeso += passeggeri[i].getPesoKg();
    }
    
    return totalePeso;
  }
  
  public double percorriKm(double distanzaKm) {
    
    double distanzaPercorsa;
    double consumoKmPerLitro = 5.0 - pesoPasseggeriKg()/(75 * passeggeri.length);
    double consumoPerViaggioLitriGasolio = distanzaKm/consumoKmPerLitro;
    
    if ( consumoPerViaggioLitriGasolio > litriGasolioSerbatoio ) {
      
      distanzaPercorsa = litriGasolioSerbatoio * consumoKmPerLitro;
      litriGasolioSerbatoio = 0;
    } else {
      
      distanzaPercorsa = distanzaKm;
      litriGasolioSerbatoio = litriGasolioSerbatoio - consumoPerViaggioLitriGasolio;
    }
    
    return distanzaPercorsa;
  }
  
}
