package equipements.arme;

import entites.Statistiques;
import equipements.Equipement;

/**
 * Classe abstraite pour les armes.
 * Elles ont des dégats et une portée
 */
public abstract class Arme extends Equipement {
    String m_degat;
    int m_portee;

    /**
     * Constructeur de l'arme
     * @param nom de l'arme
     * @param description de l'arme
     * @param actif si elle est active ou non
     * @param portee de l'arme
     * @param degat de l'arme
     * @param stat statistiques de l'arme
     */
    public Arme(String nom, String description, boolean actif, int portee, String degat, Statistiques stat) {
        super(nom, description, actif,stat);
        m_degat = degat;
        m_portee = portee;
    }

    /**
     * Méthode pour avoir le poid de l'arme
     * @return le poid de l'arme
     */
    public abstract String Poid();

    /**
     * Méthode pour avoir le type
     * @return le type
     */
    @Override
    public String toString(){return "arme";}

    /**
     * Méthode pour avoir les dégats de l'arme
     * @return les dégats de l'arme
     */
    public String getDegat() {return m_degat;}

    /**
     * Méthode pour avoir la portée
     * @return la portée de l'arme
     */
    public int getPortee(){return m_portee;}

    /**
     * Méthode abstraite pour afficher les informations de l'arme
     */
    public abstract void afficherInfo();
}
