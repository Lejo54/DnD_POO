package equipements.arme;

import entites.Statistiques;
import static partie.Affichage.afficherPhrase;

/**
 * Classe des armes à distance
 */
public class ArmeDistante extends Arme {

    /**
     * Constructeur de l'arme à distance
     * @param nom de l'arme
     * @param description de l'arme
     * @param actif true si elle est équipé, false sinon
     */
    public ArmeDistante(String nom, String description, boolean actif) {
        super(nom, description, actif, calculportee(nom), calculdegat(nom),new Statistiques(0,0,0));
    }

    /**
     * Pour calculer la portée de l'arme en fonction du nom
     * @param nom de l'arme
     * @return la portée de l'arme
     */
    private static int calculportee(String nom){
        switch (nom.toLowerCase()) {
            case "arc court","arbalete legere":
                return 16;
            case "fronde":
                return 6;
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
            case "arc court":
                return "1d6";
            case "arbalete legere":
                return  "1d8";
            case "fronde" :
                return "1d4";
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

