package Classes;

import Interfaces.Critere;

public class CritereMarque implements Critere {
    private String marque;
    public CritereMarque(String marque) {
        this.marque = marque;
    }
    public boolean estSatisfaitPar(Voiture v) {
        return marque == v.getMarque();
    }
}
