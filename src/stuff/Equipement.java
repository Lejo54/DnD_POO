package stuff;

public class Equipement {
    boolean m_actif=false;
    String m_nom;
    String m_description;
    public Equipement(String nom, String description, boolean actif) {
        this.m_nom = nom;
        this.m_description = description;
        this.m_actif = actif;
    }

    public boolean estEquipe() {
        return m_actif;
    }
    public String getNom(){
        return m_nom;
    }

}

