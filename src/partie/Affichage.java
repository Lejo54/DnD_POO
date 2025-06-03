package partie;
import donjons.Donjon;
import entites.Entite;
import entites.Monstre;
import entites.Personnage;

import java.lang.*;
import java.util.List;
import java.util.Scanner;

import static entites.Entite.changeEntierEnLettre;

public abstract class Affichage {


    public static int demanderInt(String phrase) {
        int nb=0;
        afficherPhrase(phrase);
        Scanner sc = new Scanner(System.in);
        nb = Integer.parseInt(sc.nextLine());
        return nb;
    }
    public static String demanderString(String phrase) {
        String rendu="";
        afficherPhrase(phrase);
        Scanner sc = new Scanner(System.in);
        rendu = sc.nextLine();
        return rendu;
    }
    public static void afficherPhrase(String phrase) {
        System.out.print(phrase);
    }
}
