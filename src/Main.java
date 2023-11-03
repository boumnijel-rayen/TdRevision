import Classes.Agence;
import Classes.Client;
import Classes.Voiture;
import Exceptions.VoitureException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Agence a = new Agence("Agence1");

        Client c1 = new Client(1,"rayen","boumnijel");
        Voiture v1 = new Voiture(1,"BMW",100);

        /*try{
            a.ajoutVoiture(v1);
        }catch (VoitureException e){
            e.getMessage();
        }*/

        try {
            a.loueClientVoiture(c1, v1);
        }catch (VoitureException e){
            System.out.println(e.getMessage());
        }

        try {
            a.suppVoiture(v1);
        }catch (VoitureException e){
            e.getMessage();
        }


    }
}