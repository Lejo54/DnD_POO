package equipements;

import donjons.Position;
import entites.Statistiques;

public abstract class Equipement {
    boolean m_actif=false;
    String m_nom;
    String m_description;
    Position m_position;
    Statistiques m_stat;
    public Equipement(String nom, String description, boolean actif,Statistiques stat) {
        this.m_nom = nom;
        this.m_description = description;
        this.m_actif = actif;
        m_position=new Position();
        m_stat=stat;
    }
    public abstract void afficherInfo();
    public abstract String toString();
    public boolean estEquipe() {
        return m_actif;
    }
    public String getNom(){
        return m_nom;
    }
    public Position getPosition(){return m_position;}
    public void equipe(){
        this.m_actif=true;
    }
    public void desequipe(){
        this.m_actif=false;
    }

}

