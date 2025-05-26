import static partie.De.lancerDe;

public class Main {
    public static void main(String args[]) {
        System.out.println("Bienvenue dans DOOnjon et Dragons");
        int nb = lancerDe(4,5);
        System.out.println(nb);

        for (int y = 0; y < 20; y++) {
            System.out.print((char) ('A' + y) + " ");

            for (int x = 0; x < 20; x++) {
                if (y==0){
                    System.out.print(" "+x + " ");
                }
                else {
                    System.out.print("∙ ");
                }
            }
            System.out.println();

        }
    }
}