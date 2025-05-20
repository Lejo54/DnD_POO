package partie;
import  donjons.Donjon;

public abstract class Affichage {

    public static void afficherDonjon(Donjon donjon) {
        for (int y = 0; y < donjon.getTaille().getY(); y++) {
            System.out.print((char) ('A' + y) + " ");

            for (int x = 0; x < donjon.getTaille().getX(); x++) {
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
    public static void afficherPhrase(String phrase) {
        System.out.println(phrase);
    }
}
