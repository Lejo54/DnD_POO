package Entites;

public class Statut {
    private int pointDeVie;
    private int initiative;
    private int vitesse;
    private int force;
    private int dexterite;

    public Statut(int pointDeVie, int initiative, int vitesse, int force, int dexterite) {
        this.pointDeVie = pointDeVie;
        this.initiative = initiative;
        this.vitesse = vitesse;
        this.force = force;
        this.dexterite = dexterite;
    }

    // Getters
    public int getPointDeVie() {
        return pointDeVie;
    }

    public int getInitiative() {
        return initiative;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getForce() {
        return force;
    }

    public int getDexterite() {
        return dexterite;
    }

    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setDexterite(int dexterite) {
        this.dexterite = dexterite;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }
}
