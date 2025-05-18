package partie;

import java.util.Random;

public class De {

    public static int lancerDe(int nbLancer, int tailleLancer) {
        Random random = new Random();
        int total = 0;
        for (int i = 0; i < nbLancer; i++) {
            total += random.nextInt(tailleLancer + 1);
        }
        return total;
    }
}
