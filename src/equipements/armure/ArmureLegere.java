package equipements.armure;

import entites.Statistiques;
import static partie.Affichage.afficherPhrase;

/**
 * Classe des armures légères
 */
public class ArmureLegere extends Armure {

    /**
     * Constructeur des armures légères
     * @param nom de l'armure
     * @param description de l'armure
     * @param actif true si elle est équipé, false sinon
     */
    public ArmureLegere(String nom, String description, boolean actif) {
        super(nom, description, actif, calculclasseArmure(nom),new Statistiques(0,0,0));
    }

    /**
     * Méthode qui renvoie la classe d'armure en fonction de son nom
     * @param nom de l'armure
     * @return la classe d'armure
     */
    public int calculclasseArmure(String nom){
        switch (nom.toLowerCase()) {
            case "cotte de mailles":
                return 11 ;
            case "harnois":
                return 12;
        }
        return 0;
    }

    /**
     * Méthde qui renvoie le poid de l'armure
     * @return le poid de l'armure
     */
    @Override
    public String getPoid() {
        return "leger";
    }

    /**
     * Méthode qui affiche les informations de l'armure
     */
    public void afficherInfo(){
        String phrase= this.getNom()+":";
        if(this.estEquipe()){
            phrase+= "(équipé)";
        }
        afficherPhrase(phrase+"\n -Classe d'armure :"+this.getClasseArmure()+"\n");
    }
}
