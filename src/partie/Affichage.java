package partie;

import java.lang.*;
import java.util.Scanner;

/**
 * Classe abstraite pour gérer l'affichage et les entrées utilisateur.
 * Fournit des méthodes pour demander des entrées de différents types et afficher des messages.
 */
public abstract class Affichage {


    /**
     * Demande à l'utilisateur de saisir un entier.
     * @param phrase La phrase à afficher avant la saisie.
     * @return L'entier saisi par l'utilisateur.
     */
    public static int demanderInt(String phrase) {
        Scanner sc = new Scanner(System.in);
        int nb = 0;
        boolean valide = false;

        while (!valide) {
            afficherPhrase(phrase);
            String saisie = sc.nextLine();
            try {
                nb = Integer.parseInt(saisie);
                valide = true;
            } catch (NumberFormatException e) {
                System.out.println("Erreur : veuillez entrer un nombre entier valide.");
            }
        }

        return nb;
    }

    /**
     * Demande à l'utilisateur de saisir une chaine de caractères.
     * @param phrase La phrase à afficher avant la saisie.
     * @return La chaine de caractères saisie par l'utilisateur.
     */
    public static String demanderString(String phrase) {
        String rendu="";
        afficherPhrase(phrase);
        Scanner sc = new Scanner(System.in);
        rendu = sc.nextLine();
        return rendu;
    }

    /**
     * Demande à l'utilisateur de saisir un caractère.
     * Si la saisie est vide ou contient plus d'un caractère, une erreur est affichée et la saisie est redemandée.
     * @param phrase La phrase à afficher avant la saisie.
     * @return Le caractère saisi par l'utilisateur.
     */
    public static char demanderChar(String phrase) {
        String saisie = "";

        while (saisie.isBlank()) {
            afficherPhrase(phrase);
            Scanner sc = new Scanner(System.in);
            saisie = sc.nextLine().trim();

            if (saisie.isEmpty()) {
                System.out.println("Erreur : veuillez entrer un caractère.");
            } else if (saisie.length() > 1) {
                System.out.println("Erreur : entrez un seul caractère.");
                saisie = ""; // forcer la boucle à recommencer
            }
        }

        return saisie.charAt(0);
    }

    /**
     * Affiche une phrase sans saut de ligne.
     * @param phrase La phrase à afficher.
     */
    public static void afficherPhrase(String phrase) {
        System.out.print(phrase);
    }
}
