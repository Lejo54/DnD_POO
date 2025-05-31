package entites;

public class Monstre extends Entite {
    int m_numero;
    int m_portee;
    String m_degat;
    int m_class_armure;

    public Monstre(String espece, int numero, int portee, String degat) {
        super(espece);
        m_numero = numero;
        m_portee = portee;
        m_degat = degat;
    }

    @Override
    public int getArmure() {
        return 0;
    }

    public int getarmure(){
        return m_class_armure;
    }
    public String getDegat() {
        return m_degat;
    }
    public String toString() {
        return "Monstre";
    }
    public int getPortee(){return m_portee;}
    public int getnumero(){return m_numero;}

    public String setPseudo(String nom){return nom+ getnumero();}
}
