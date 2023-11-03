package Classes;

public class Voiture implements Comparable<Voiture>{
    private int immariculation;
    private String marque;
    private float prixLocation;

    public Voiture(int immariculation, String marque, float prixLocation) {
        this.immariculation = immariculation;
        this.marque = marque;
        this.prixLocation = prixLocation;
    }
    public int getImmariculation() {
        return immariculation;
    }
    public void setImmariculation(int immariculation) {
        this.immariculation = immariculation;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public float getPrixLocation() {
        return prixLocation;
    }
    public void setPrixLocation(float prixLocation) {
            this.prixLocation = prixLocation;
    }

    public int hashCode() {
        return immariculation+marque.hashCode();
    }

    public boolean equals(Object obj) {
        if(obj==this)
            return true;
        if(obj==null) return false;
        if(obj.getClass()!=this.getClass())
            return false;
        Voiture V=(Voiture) obj;
        if((V.immariculation==immariculation) && (V.marque==marque))
            return true;
        return false;
    }

    public String toString(){
        return "Immariculation : "+immariculation+" Marque : "+marque+" Prix de location : "+prixLocation;
    }

    @Override
    public int compareTo(Voiture o) {
        if (this.immariculation>o.immariculation)
            return 1;
        else if (this.immariculation<o.immariculation)
            return -1;
        else
            return 0;
    }
}
