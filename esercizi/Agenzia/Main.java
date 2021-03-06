import java.util.ArrayList;
public class Main {
   public static void main(String[] args) {
        Agenzia agenz = new Agenzia("Bandabassotti Trovacasa", "555-454545");
        System.out.println("Creata Agenzia " + agenz.getNome() + " tel." + agenz.getTelefono());
        //latitudine e longitudine fornite in radianti
        Immobile im1 = new Immobile("Via del Covo 5", 56, 0.7989, 0.2272);
        Immobile im2 = new Immobile("Piazza Nascosta 2", 80, 0.7996, 0.2271);
        Immobile im3 = new Immobile("Vicolo Buio 1", 50, 0.7989, 0.2269);

        System.out.println("Distanza tra due immobili: " + im1.distanza(im2.getLat(), im2.getLon()) + "Km");
        System.out.println("\nCerchiamo immobili che distano dal punto voluto massimo 7 Km e di minimo 65mq\n");
        
        agenz.aggiungi(im1);
        agenz.aggiungi(im2);
        agenz.aggiungi(im3);

        ArrayList<Immobile> ris = agenz.trova(0.7988, 0.2273, 7, 65);
        for (Immobile imm : ris) {
            System.out.println("Immobile in " + imm.getIndirizzo() + " potrebbe interessarti");
        }

        System.out.println("\n\nOUTPUT atteso:\nCreata Agenzia Bandabassotti Trovacasa tel.555-454545\n"
                + "distanza tra due immobili: 4.4817686914223005Km\n"
                + "Immobile in Piazza Nascosta 2 potrebbe interessarti");
    }
}