package equipements.armure;

import entites.Statistiques;
import equipements.Equipement;

/**
 * Classe des armures
 * Elles ont une classe d'armure qui vaut pour la résistance
 */
public abstract class Armure extends Equipement {
    int m_classeArmure;

    /**
     * Constructeur des armures
     * @param nom de l'armure
     * @param description de l'armure
     * @param actif true si elle est équipé, false sinon
     * @param classeArmure de l'armure
     * @param stat statistiques de l'armure
     */
    public Armure(String nom, String description, boolean actif, int classeArmure, Statistiques stat) {
        super(nom, description, actif,stat);
        m_classeArmure = classeArmure;
    }

    /**
     * Méthode qui renvoie le type de l'armure
     * @return le type de l'armure
     */
    public String toString(){return "armure";}

    /**
     * Méthode abstraite pour avoir le poid de l'armure
     * @return le poid de l'armure
     */
    public abstract String getPoid();

    /**
     * Méthode qui renvoie la classe d'armure de l'armure
     * @return la classe d'armure
     */
    public int getClasseArmure(){
        return m_classeArmure;
    }
}
