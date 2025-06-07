package partie;

import donjons.Donjon;
import entites.Entite;
import entites.EntiteJouable;

import static donjons.Position.deplacement;
import static partie.Affichage.*;

public class Mj extends Entite {

    private Partie m_partie;

    public Mj() {
        super("Maître du Jeu");
        m_partie = new Partie();
    }

    public String getDegat() {
        int nbFaces=demanderInt("Nombre de faces du dé d'attaque ?\n");
        int nbDes=demanderInt("Nombre de dés d'attaque ?\n");
        return nbDes+"d"+nbFaces;
    }
    public Partie getPartie() {return m_partie;}
    public void commentaireMJ(){
        String commentaire = demanderString("Entrez votre commentaire :\n");
        afficherPhrase("Commentaire du MJ : " + commentaire+"\n");

    }
    public String setPseudo(String nom){
        return "MJ";
    }

    public void afficherAction(){
        afficherPhrase(this.getNom()+" , c'est à vous, que voulez vous faire ?\n");
        afficherPhrase("1 - Attaquer une entite \n");
        afficherPhrase("2 - Deplace une entite\n");
        afficherPhrase("3 - Ajouter un obstacle\n");
        afficherPhrase("4 - Laisser un commentaire\n");
        afficherPhrase("5 - Ne rien faire\n");
        afficherPhrase("chaque ligne correspond a une action (1 = action citez à la ligne 1 etc...)\n");
    }
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
    public EntiteJouable choixCible(Donjon donjon){
        donjon.afficherEntites();
        int indexCible = demanderInt("Donnez l'indice de la cible\n") - 1;
        return donjon.getEntite(indexCible);
    }
}
