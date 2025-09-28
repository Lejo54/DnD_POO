package entites;

import donjons.Donjon;
import entites.jouable.EntiteJouable;
import partie.Partie;

import static donjons.Position.deplacement;
import static partie.Affichage.*;

/**
 * Classe représentant le Maître du Jeu (MJ) dans le jeu de rôle.
 * Le MJ est responsable de la gestion de la partie, des actions des joueurs et de l'environnement.
 * Il possède une partie
 */
public class Mj extends Entite {

    private Partie m_partie;

    /**
     * Constructeur de la classe Mj.
     * Initialise le nom du MJ et crée une nouvelle partie.
     */
    public Mj() {
        super("Maître du Jeu");
        m_partie = new Partie();
    }

    /**
     * Méthode pour créer un dé de dégâts.
     */
    public String getDegat() {
        int nbFaces=demanderInt("Nombre de faces du dé d'attaque ?\n");
        int nbDes=demanderInt("Nombre de dés d'attaque ?\n");
        return nbDes+"d"+nbFaces;
    }

    /**
     * Méthode pour récupérer la partie associée au MJ.
     */
    public Partie getPartie() {return m_partie;}

    /**
     * Méthode pour afficher un commentaire du MJ.
     */
    public void commentaireMJ(){
        String commentaire = demanderString("Entrez votre commentaire :\n");
        afficherPhrase("Commentaire du MJ : " + commentaire+"\n");

    }

    /**
     * Méthode pour créer un pseudo pour le MJ.
     * @param nom
     * @return
     */
    public String setPseudo(String nom){
        return "MJ";
    }

    /**
     * Méthode pour afficher les actions possibles pour le MJ.
     */
    public void afficherAction(){
        afficherPhrase(this.getNom()+" , c'est à vous, que voulez vous faire ?\n");
        afficherPhrase("1 - Attaquer une entite \n");
        afficherPhrase("2 - Deplace une entite\n");
        afficherPhrase("3 - Ajouter un obstacle\n");
        afficherPhrase("4 - Laisser un commentaire\n");
        afficherPhrase("5 - Ne rien faire\n");
        afficherPhrase("chaque ligne correspond a une action (1 = action citez à la ligne 1 etc...)\n");
    }

    /**
     * Méthode pour choisir une action à effectuer par le MJ.
     * @param donjon Le donjon dans lequel se déroule la partie.
     */
    public void choixAction(Donjon donjon) {
        this.afficherAction();
        int indexAction= demanderInt("Quelle est votre action ?\n");
        switch (indexAction){
            case 1: this.attaquer(choixCible(donjon),this.getDegat());
                break;
            case 2: deplacement(donjon,choixCible(donjon));
                break;
            case 3: donjon.creerObstacles(1);
                break;
            case 4: this.commentaireMJ();
                break;
            case 5: break;
        }
    }

    /**
     * Méthode pour choisir une cible pour une action.
     * Affiche les entités du donjon et demande à l'utilisateur de choisir une cible.
     * @param donjon Le donjon dans lequel se déroule la partie.
     * @return L'entité jouable choisie comme cible.
     */
    public EntiteJouable choixCible(Donjon donjon){
        donjon.afficherEntites();
        int indexCible = demanderInt("Donnez l'indice de la cible\n") - 1;
        return donjon.getEntite(indexCible);
    }
}
