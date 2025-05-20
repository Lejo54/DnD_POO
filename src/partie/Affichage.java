package partie;
import  donjons.Donjon;
import entites.Entite;

import java.lang.*;
import java.util.List;

public abstract class Affichage {

    public static void afficherDonjon(Donjon donjon) {
        for (int y = 0; y < donjon.getTaille().getY(); y++) {
            System.out.print((char) ('A' + y) + " ");

            for (int x = 0; x < donjon.getTaille().getX(); x++) {
                if (y==0){
                    System.out.print(" "+x + " ");
                }


                else if (donjon.contientObstacle(x,y)) {
                    System.out.print("♦ ");
                } else if (donjon.contientEquipement(x,y)) {
                    System.out.print("† ");
                } else if (donjon.contientEntite(x,y)) {
                    String petitnom=donjon.getNomEntite(x,y).substring(0,2);
                    System.out.print(petitnom);
                } else {
                    System.out.print("∙ ");
                }
            }
            System.out.println();

        }
    }
    public static void afficherActionEntite(Entite entite){
        List<Map> action=new List<Map> (Entite.getAction());
        for(action action : Map){
            if (action.elements()==false){
                System.out.println(action.keys());
            }
        }
    }
    public static void afficherInfoEntite(Entite entite){
        System.out.println(entite.getNom()+ "à une armure de "+entite.getArmure() +" de résistance et il inflige "+entite.getDegat()+" et il se trouve en "+entite.getPosition().getX()+entite.changeEntierEnLettre(entite.getPosition().getY()));
        System.out.println("voici les differentes informations de l'entite : \nInitiative de "+entite.getStatistiques().getInitiative()+"\nVitesse de "+entite.getStatistiques().getVitesse()+" case/action");
        System.out.println("Il lui reste "+entite.getStatistiques().getPv()+"point de vie restants\nUne force de "+entite.getStatistiques().getForce()+"\nUne dextérité de "+entite.getStatistiques().getDexterite());
    }
    public static void afficherPhrase(String phrase) {
        System.out.println(phrase);
    }
}
