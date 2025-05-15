package Partie;
import  donjons.Donjon;

public class Affichage {

    void afficherDonjon(Donjon donjon) {
        for (int y = 0; y < donjon.taille.getY(); y++) {
            System.out.print((char) ('A' + y) + " ");

            for (int x = 0; x < donjon.taille.getX(); x++) {
                if (y==0){
                    System.out.print(x + " ");
                }


                else if (donjon.contientObstacle(x,y)) {
                    System.out.print("♦ ");
                } else if (donjon.contientEquipement(x,y)) {
                    System.out.print("† ");
                } else if (donjon.contientEntite(x,y)) {
                    System.out.print(donjon.getNomEntite(x,y));
                } else {
                    System.out.print("∙ ");
                }
            }
            System.out.println();

        }
    }
}
