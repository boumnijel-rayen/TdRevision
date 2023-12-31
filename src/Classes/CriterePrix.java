package Classes;

import Interfaces.Critere;

public class CriterePrix implements Critere {
     private float prix;
     public CriterePrix(float prix) {
         this.prix = prix;
     }
     public boolean estSatisfaitPar(Voiture v) {
        return prix > v.getPrixLocation();
     }
}
