package partie;
import donjons.Donjon;
import entites.Entite;
import entites.Monstre;
import entites.Personnage;

import java.lang.*;
import java.util.List;
import java.util.Scanner;

public abstract class Affichage {


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
    public static String demanderString(String phrase) {
        String rendu="";
        afficherPhrase(phrase);
        Scanner sc = new Scanner(System.in);
        rendu = sc.nextLine();
        return rendu;
    }
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
    public static void afficherPhrase(String phrase) {
        System.out.print(phrase);
    }
}
