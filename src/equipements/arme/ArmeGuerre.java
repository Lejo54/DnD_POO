package equipements.arme;

import entites.Statistiques;
import static partie.Affichage.afficherPhrase;

/**
 * Classe des armes de guerre
 */
public class ArmeGuerre extends Arme {

    /**
     * Constructeur des armes de guerre
     * @param nom de l'arme
     * @param description de l'arme
     * @param actif true si elle est équipé, false sinon
     */
    public ArmeGuerre(String nom, String description, boolean actif) {
        super(nom, description, actif, calculportee(nom), calculdegat(nom),new Statistiques(4,0,-2));
    }

    /**
     * Pour calculer la portée de l'arme en fonction du nom
     * @param nom de l'arme
     * @return la portée de l'arme
     */
    public int calculportee(String nom){
        switch (nom.toLowerCase()) {
            case "epee longue":
                return 1;
            case "rapiere":
                return  1;
            case "epee a deux mains" :
                return 1;
                //vitesse du personnage -2 force +4
        }
        return 0;
    }

    /**
     * Méthode qui renvoit les dégats de l'arme en fonction de son nom
     * @param nom de l'arme
     * @return les dégats de l'arme
     */
    public String calculdegat(String nom){
        switch (nom.toLowerCase()) {
            case "epee longue":
                return "1d8";
            case "rapiere":
                return  "1d8";
            case "epee a deux mains" :
                return "2d6";
            //vitesse du personnage -2 force +4
        }
        return "";
    }

    /**
     * Méthode qui renvoie le poid de l'arme
     * @return le poid de l'arme
     */
    @Override
    public String Poid() {
        return "guerre";
    }

    /**
     * Méthode pour afficher les informations de l'arme.
     * Elle affiche son nom, ses dégats et sa portée
     */
    public void afficherInfo(){
        String phrase= this.getNom()+":";
        if(this.estEquipe()){
            phrase+= "(équipé)";
        }
        afficherPhrase(phrase+":\n -Dégat: "+getDegat()+"\n -Portée: "+getPortee()+"\n -Malus: -2 vitesse"+"\n -Bonus: +4 force \n");
    }
}
