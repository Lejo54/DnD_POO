package partie;

import java.util.Random;

/**
 * Classe pour simuler le lancer d'un dé.
 * Permet de lancer un nombre de dés avec un nombre de faces spécifié.
 */
public class De {

    /**
     * Lance un dé spécifié par une chaîne de caractères au format "XdY",
     * où X est le nombre de dés et Y est le nombre de faces.
     * @param de La chaîne de caractères représentant le dé à lancer.
     * @return Le résultat total du lancer des dés.
     */
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
