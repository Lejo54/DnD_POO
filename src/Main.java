import static partie.Affichage.afficherPhrase;
import static partie.De.lancerDe;
import java.util.Scanner;
import partie.Mj;
public class Main {
    public static void main(String args[]) {
        System.out.println("Vous allez maintenant entrez dans le monde de DOOnjon et Dragons\n préparez vos armes et vos armures jeunes aventuriers il est temps de se préparer!");
        Mj mj=new Mj();
        mj.getPartie().lancerPartie();


    }
}