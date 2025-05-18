package stuff;

public abstract class Equipement {
    boolean m_actif=false;
    String m_nom;
    String m_description;
    Position m_position;
    public Equipement(String nom, String description, boolean actif) {
        this.m_nom = nom;
        this.m_description = description;
        this.m_actif = actif;
        m_position=new Position();
    }

    public boolean estEquipe() {
        return m_actif;
    }
    public String getNom(){
        return m_nom;
    }
    public Position getPosition(){
        return m_position;
    }

}

