package entites;

import static partie.Affichage.demanderInt;

public class Monstre extends Entite {
    int m_numero;
    int m_portee;
    String m_degat;
    int m_class_armure;

    public Monstre(String espece, int numero, int portee,int classe_armure,Statistiques stat) {
        super(espece,stat);
        m_numero = numero;
        m_portee = portee;
        m_class_armure = classe_armure;
        m_degat = creerDegat();
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

    public String creerDegat(){
        String nbFace=String.valueOf(demanderInt("Entrez le nombre de face de votre dé de dégat:\n"));
        String nbLancer=String.valueOf(demanderInt("Entrez le numero de lancer de votre dé de dégat:\n"));
        return nbLancer+"d"+nbFace;
    }
    public void afficherEntite(){
        //On affiche les informations du monstre

    }
}
