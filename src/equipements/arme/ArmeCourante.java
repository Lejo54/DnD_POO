package equipements.arme;

import entites.Statistiques;

import static partie.Affichage.afficherPhrase;

/**
 * Classe des armes courantes
 */
public class ArmeCourante extends Arme {

    /**
     * Constructeur des armes courantes
     * @param nom de l'arme
     * @param description de l'arme
     * @param actif true si elle est équipé, false sinon
     */
    public ArmeCourante(String nom, String description, boolean actif) {
        super(nom, description, actif, calculportee(nom), calculdegat(nom),new Statistiques(0,0,0));
    }

    /**
     * Méthode qui renvoit la portée de l'arme en fonction de son nom
     * @param nom de l'arme
     * @return la portée de l'arme
     */
    private static int calculportee(String nom){
        switch (nom.toLowerCase()) {
            case "baton":
                return 1;
            case "masse d arme":
                return 1;
        }
        return 0;
    }

    /**
     * Méthode qui renvoit les dégats de l'arme en fonction de son nom
     * @param nom de l'arme
     * @return les dégats de l'arme
     */
    private static String calculdegat(String nom){
        switch (nom.toLowerCase()) {
            case "baton":
                return "1d6";
            case "masse d arme":
                return  "1d6";
        }
        return "";
    }

    /**
     * Méthode qui renvoie le poid de l'arme
     * @return le poid de l'arme
     */
    @Override
    public String Poid() {
        return "courante";
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
        afficherPhrase(phrase+":\n -Dégat: "+getDegat()+"\n -Portée: "+getPortee()+"\n");
    }
}
