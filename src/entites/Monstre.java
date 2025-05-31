package entites;

public class Monstre extends Entite {
    int m_numero;
    int m_portee;
    String m_degat;
    int m_class_armure;

    public Monstre(String espece, int numero, int portee, String degat,int classe_armure,Statistiques stat) {
        super(espece,stat);
        m_numero = numero;
        m_portee = portee;
        m_degat = degat;
        m_class_armure = classe_armure;
    }

    public int getArmure(){
        return m_class_armure;
    }
    public String getDegat() {
        return m_degat;
    }
    public String toString() {
        return "Monstre";
    }
    public int getPortee(){return m_portee;}
    public int getNumero(){return m_numero;}

    public String setPseudo(String nom){return nom+ getNumero();}
}
