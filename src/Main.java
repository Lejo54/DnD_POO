import static partie.De.lancerDe;
import java.util.Scanner;
import partie.Mj;
public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("vous allez maintenant entrez dans le monde de DOOnjon et Dragons\n préparez vos armes et vos armures jeunes aventuriers il est temps de se préparer!");
        Mj j=new Mj();
        int nb = lancerDe(4,5);
        System.out.println(nb);

    }
}