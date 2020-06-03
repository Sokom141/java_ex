/*
class Main{
  
  public static void main(String[] args){
    
    Autobus a = new Autobus(5);
    Passeggero p = new Passeggero("Pino", 49);
  }
}
*/

public class Main {

    public static void main(String[] args) {
        Autobus corriera = new Autobus(8);
        double quantilitri = corriera.caricaGasolio(80);
        System.out.println("Litri in Serbatoio: " + quantilitri);
        quantilitri = corriera.caricaGasolio(20);
        System.out.println("Litri in Serbatoio dopo altro pieno: " + quantilitri);

        for (int i = 1; i < 11; i++) {
            Passeggero p = new Passeggero("Gino-" + i, 50);
            int num = corriera.carica(p);
            if (num < 0) {
                System.out.println("non ho potuto caricare Passeggero " + p.getNome());
            }
        }

        System.out.println("Caricati num.passeggeri: " + corriera.numPasseggeri);

        System.out.println("Passeggeri complessivamente pesano [Kg]: " + corriera.pesoPasseggeriKg());

        System.out.println("Litri in Serbatoio " + corriera.litriGasolioSerbatoio);
        double percorsoFatto = corriera.percorriKm(100);
        System.out.println("Viaggio " + percorsoFatto + " Km, litri resiudi in Serbatoio: " + corriera.litriGasolioSerbatoio);

        percorsoFatto = corriera.percorriKm(1000000);
        System.out.println("Viaggio " + percorsoFatto + " Km, litri resiudi in Serbatoio: " + corriera.litriGasolioSerbatoio);

        System.out.println("\nOUTPUT ATTESO:\nLitri in Serbatoio: 80.0\n"
                + "Litri in Serbatoio dopo altro pieno: 100.0\n"
                + "non ho potuto caricare Passeggero Gino-9\n"
                + "non ho potuto caricare Passeggero Gino-10\n"
                + "Caricati num.passeggeri: 8\n"
                + "Passeggeri complessivamente pesano [Kg]: 400.0\n"
                + "Litri in Serbatoio 100.0\n"
                + "Viaggio 100.0 Km, litri resiudi in Serbatoio: 76.92307692307692\n"
                + "Viaggio 333.3333333333333 Km, litri resiudi in Serbatoio: 0.0");
    }

}