package equipements;

public abstract class Arme extends Equipement {
    String m_degat;
    int m_portee;

    public Arme(String nom, String description, boolean actif, int portee, String degat) {
        super(nom, description, actif);
        m_degat = degat;
        m_portee = portee;
    }
    public String getType(){return "arme";}
    public String getDegat() {return m_degat;
    }
    public int getPortee(){return m_portee;}
}
