package partie;

import java.util.Random;

public class De {

    public static int lancerDe(String de) {
        String[] parts = de.split("d");
        int[] deDecompose = {
         Integer.parseInt(parts[0]), // nombre de dés
         Integer.parseInt(parts[1]) //nombre de faces
        };
        Random random = new Random();
        int total = 0;
        for (int i = 0; i < deDecompose[0]; i++) {
            total += random.nextInt(deDecompose[1]) + 1;
        }
        return total;
    }
}
