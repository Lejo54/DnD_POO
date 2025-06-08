package equipements.armure;

import entites.Statistiques;

import static partie.Affichage.afficherPhrase;

/**
 * Classe des armures lourdes
 */
public class ArmureLourde extends Armure {

    /**
     * Constructeur des armures lourdes
     * @param nom de l'armure
     * @param description de l'armure
     * @param actif true si elle est équipé, false sinon
     */
    public ArmureLourde(String nom, String description, boolean actif) {
        super(nom, description, actif, calculclasseArmure(nom),new Statistiques(0,0,-4));
    }

    /**
     * Méthode qui renvoie la classe d'armure en fonction de son nom
     * @param nom de l'armure
     * @return la classe d'armure
     */
    public int calculclasseArmure(String nom){
        switch (nom.toLowerCase()) {
            case "armure d ecailles":
                return 9 ;
            case "demi plate":
                return  10;
        }
        return 0;
    }

    /**
     * Méthde qui renvoie le poid de l'armure
     * @return le poid de l'armure
     */
    @Override
    public String getPoid() {
        return "lourd";
    }

    /**
     * Méthode qui affiche les informations de l'armure
     */
    public void afficherInfo(){
        String phrase= this.getNom()+":";
        if(this.estEquipe()){
            phrase+= "(équipé)";
        }
        afficherPhrase(phrase+"\n -Classe d'armure :"+this.getClasseArmure()+"\n -Malus: -4 vitesse \n");
    }
}
