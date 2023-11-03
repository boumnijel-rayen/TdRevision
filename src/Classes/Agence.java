package Classes;

import Exceptions.VoitureException;
import Interfaces.Critere;

import java.util.*;

public class Agence {
    private String nom;
    private ListVoitures vs;
    private Map<Client, ListVoitures> ClientVoitureLoue;
    public Agence(String nom) {
        this.nom = nom;
        vs = new ListVoitures();
        ClientVoitureLoue = new HashMap<>();
    }
    public void ajoutVoiture(Voiture v) throws VoitureException {
        vs.ajoutVoiture(v);
    }
    public void suppVoiture(Voiture v)throws VoitureException{
        vs.supprimeVoiture(v);
    }
    public void loueClientVoiture(Client cl, Voiture v)throws VoitureException{
        if (!vs.getVoitures().contains(v))
            throw new VoitureException("Voiture non existante");
        if (!ClientVoitureLoue.containsKey(cl)){
            ClientVoitureLoue.put(cl,new ListVoitures());
            vs.supprimeVoiture(v);
            ClientVoitureLoue.get(cl).ajoutVoiture(v);
        }
        else{
            vs.supprimeVoiture(v);
            ClientVoitureLoue.get(cl).ajoutVoiture(v);
        }
    }
    public void retourClientVoiture(Client cl , Voiture v) throws VoitureException{
        if (!vs.getVoitures().contains(v))
            throw new VoitureException("Voiture non existante");
        if (!ClientVoitureLoue.containsKey(cl))
            throw new VoitureException("Client non existant");
        if (!ClientVoitureLoue.get(cl).getVoitures().contains(v))
            throw new VoitureException("Voiture non louée par ce client");
        ClientVoitureLoue.get(cl).supprimeVoiture(v);
        vs.ajoutVoiture(v);
    }
    public List<Voiture> selectVoitureSelonCritere(Critere c){
        List<Voiture> voitures = new ArrayList<>();
        for (Voiture v:vs.getVoitures()){
            if (c.estSatisfaitPar(v))
                voitures.add(v);
        }
        return voitures;
    }
    public Set<Client> ensembleClientsLoueurs(){
        return ClientVoitureLoue.keySet();
    }
    public Collection<ListVoitures> collectionVoituresLouees(){
        Collection<ListVoitures> voitures = new ArrayList<>();
        for (Voiture v:vs.getVoitures()){
            for (ListVoitures lv:ClientVoitureLoue.values()){
                if (lv.getVoitures().contains(v))
                    voitures.add(lv);
            }
        }
        return voitures;
    }
    public void afficheLesClientsEtLeursListesVoitures(){
        for (Map.Entry<Client, ListVoitures> c:ClientVoitureLoue.entrySet()){
            System.out.println(c.getKey());
            c.getValue().affiche();
        }
    }
    public Map<Client, ListVoitures> triCodeCroissant(){
        TreeMap<Client, ListVoitures> map = new TreeMap<>();
        for (Map.Entry<Client, ListVoitures> c:ClientVoitureLoue.entrySet()){
            map.put(c.getKey(),c.getValue());
        }
        return map;
    }
    public Map<Client, ListVoitures> triNomCroissant(){
        TreeMap<Client, ListVoitures> map = new TreeMap<>(new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getNom().compareTo(o2.getNom());
            }
        });
        for (Map.Entry<Client, ListVoitures> c:ClientVoitureLoue.entrySet()){
            map.put(c.getKey(),c.getValue());
        }
        return map;
    }
}
