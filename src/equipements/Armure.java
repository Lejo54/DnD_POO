package equipements;

import entites.Statistiques;

public abstract class Armure extends Equipement {
    int m_classe_Armure;

    public Armure(String nom, String description, boolean actif, int classe_Armure, Statistiques stat) {
        super(nom, description, actif,stat);
        m_classe_Armure = classe_Armure;
    }
    public String toString(){return "armure";}
    public abstract String getPoid();

    public int getClasseArmure(){
        return m_classe_Armure;
    }
}
