package equipements;

import entites.Statistiques;

public abstract class Arme extends Equipement {
    String m_degat;
    int m_portee;

    public Arme(String nom, String description, boolean actif, int portee, String degat, Statistiques stat) {
        super(nom, description, actif,stat);
        m_degat = degat;
        m_portee = portee;
    }
    public abstract String Poid();
    public String toString(){return "arme";}
    public String getDegat() {return m_degat;
    }
    public int getPortee(){return m_portee;}
    public abstract void afficherInfo();
}
