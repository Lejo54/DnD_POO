package entites;

public class Monstre extends Entite {
    String m_espece;
    int m_numero;
    int m_portee;
    String m_degat;
    int m_class_armure;

    public Monstre(String espece, int numero, int portee, String degat) {
        m_espece = espece;
        m_numero = numero;
        m_portee = portee;
        m_degat = degat;
    }
    public String getNom() {
        return m_espece + " " + m_numero;
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
    public String getType() {
        return "Monstre";
    }
    public int getPortee(){return m_portee;}
}
