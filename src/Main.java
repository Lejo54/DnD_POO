import static partie.Affichage.afficherPhrase;
import entites.Mj;
public class Main {
    public static void main(String args[]) {

        afficherPhrase("Vous allez maintenant entrez dans le monde de DOOnjon et Dragons\n Préparez vos armes et vos armures jeunes aventuriers il est temps de se préparer!\n");
        Mj mj=new Mj();
        mj.getPartie().lancerPartie(mj);


    }
}