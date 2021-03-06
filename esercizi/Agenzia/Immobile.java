class Immobile{
  
  private final String indirizzo_im;
  private final double area_im;
  private final double lat_im;
  private final double lon_im;
  
  public Immobile(String indirizzo, double areaMQ, double lat, double lon){
    
    indirizzo_im = indirizzo;
    area_im = areaMQ;
    lat_im = lat;
    lon_im = lon;
  }
  
  public String getIndirizzo(){
    
    return indirizzo_im;
  }
  
  public double getLat(){
    
    return lat_im;
  }
  
  public double getLon(){
    
    return lon_im;
  }

  public double getAreaMQ(){
    
    return area_im;
  }
  
  public double distanza(double lat, double lon){
    
    double x = (lon_im - lon) * Math.cos(lon_im/lon);
    double y = lat_im - lat;
    double d = 6371 * Math.sqrt( Math.pow(x, 2) + Math.pow(y, 2) );
    return d;
  }
  
  
}
