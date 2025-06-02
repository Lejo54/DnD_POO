package partie;
import donjons.Donjon;
import entites.Entite;
import entites.Monstre;
import entites.Personnage;

import java.lang.*;
import java.util.List;
import java.util.Scanner;

import static entites.Entite.changeEntierEnLettre;

public abstract class Affichage {

    public static void afficherActionEntite(Entite entite){
        afficherPhrase(entite.getNom()+" , c'est a vous que voulez vous faire ?\n");
        afficherPhrase("1 - attaquer un ennemi\n");
        afficherPhrase("2 - se deplacer dans le donjon\n");
        if (entite.toString().equals("Personnage")){
            afficherPhrase("3 - ramasser un équipement\n");
            afficherPhrase("4 - changer d'arme équipé\n");
            afficherPhrase("5 - changer d'armure équipé\n");
        }
        afficherPhrase("chaque ligne correspond a une action (1 = action citez à la ligne 1 etc...\n");
    }
    public static void afficherInfoEntite(Entite entite){
        afficherPhrase(entite.getNom()+ "à une armure de "+entite.getArmure() +" de résistance et il inflige "+entite.getDegat()+" et il se trouve en "+entite.getPosition().getX()+changeEntierEnLettre(entite.getPosition().getY()));
        afficherPhrase("voici les differentes informations de l'entite : \nInitiative de "+entite.getStatistiques().getInitiative()+"\nVitesse de "+entite.getStatistiques().getVitesse()+" case/action");
        afficherPhrase("Il lui reste "+entite.getStatistiques().getPv()+"point de vie restants\nUne force de "+entite.getStatistiques().getForce()+"\nUne dextérité de "+entite.getStatistiques().getDexterite());
    }

    public static void afficherBandeau(Entite entite){
        afficherPhrase("c'est au tour de "+entite.getNom()+"de jouer , il lui reste "+entite.getStatistiques().getPv()+"/"+entite.getStatistiques().getPvMax()+" point de vie restant au début de ce tour\n");
    }
    public static int demanderInt(String phrase) {
        int nb=0;
        afficherPhrase(phrase);
        Scanner sc = new Scanner(System.in);
        nb = Integer.parseInt(sc.nextLine());
        return nb;
    }
    public static String demanderString(String phrase) {
        String rendu="";
        afficherPhrase(phrase);
        Scanner sc = new Scanner(System.in);
        rendu = sc.nextLine();
        return rendu;
    }
    public static void afficherPhrase(String phrase) {
        System.out.print(phrase);
    }
}
