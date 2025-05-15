package Partie;
import  donjons.Donjon;
import donjons.Position;

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
                } else if (donjon.getEntite(x,y).equals("Monstre")) {
                    System.out.print("¤ ");
                } else if (donjon.getEntite(x,y).equals("Personnage")) {
                    System.out.print("¤ ");  //recupere lentite .get nom sub str
                } else {
                    System.out.print("∙ ");
                }
            }
            System.out.println();

        }
    }
}
