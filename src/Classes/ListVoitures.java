package Classes;

import Exceptions.VoitureException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListVoitures {
    private List<Voiture> voitures;
    public ListVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }
    public ListVoitures() {
        voitures = new ArrayList<Voiture>();
    }
    public List<Voiture> getVoitures() {
        return voitures;
    }
    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }
    public void ajoutVoiture(Voiture v) throws VoitureException{
        if (voitures.contains(v))
            throw new VoitureException("Voiture déjà existante");
        voitures.add(v);
    }
    public void supprimeVoiture(Voiture v) throws VoitureException {
        if (!voitures.contains(v))
            throw new VoitureException("Voiture non existante");
        voitures.remove(v);
    }

    public int size(){
        return voitures.size();
    }
    public void affiche(){
        for (Voiture v:voitures)
            System.out.println(v);
    }
}
