package lancer;

import java.util.Random;

public interface De {
    Random random = new Random();

    static int lancerDe(int taille_Lancer, int nb_Lancer) {
        int total = 0;
        for (int i = 0; i < nb_Lancer; i++) {
            total += random.nextInt(taille_Lancer) + 1;
        }
        return total;
    }
}
