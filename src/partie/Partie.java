package partie;
import donjons.Donjon;
import donjons.Obstacle;
import entites.*;
import equipements.*;

import java.util.ArrayList;
import java.util.List;

import static partie.Affichage.*;
import static entites.Statistiques.setStat;

public class Partie {
    private final List<Personnage> m_joueurs = new ArrayList<>();
    private final List<Donjon> m_donjons = new ArrayList<>();

    // Constructeur avec filtrage
    public Partie() {
        List<Personnage> joueurs = new ArrayList<>();
        int nbJoueur = demanderInt("Entrez un nombre de joueur :\n");
        while (nbJoueur <= 0) {
            nbJoueur = demanderInt("Nombre erroné, entrez un nombre de joueur :\n");
        }
        for (int i = 0; i < nbJoueur; i++) {
            joueurs.add(creerJoueurs());
            setStat(joueurs.get(i));
        }
        m_joueurs.addAll(joueurs);
    }

    public void lancerPartie(Entite mj) {
        //Déroulement de la partie
        boolean finPartie = false;
        for (int donjon = 0; donjon < 3; donjon++) {
            //création et ajout du ie donjon
            m_donjons.add(creerDonjon());
            getDonjons().get(donjon).afficherInfoDonjon(donjon);
            finPartie = getDonjons().get(donjon).lancerTours(donjon + 1, mj);
            if (finPartie) {
                return;
            }
        }
    }

    // Getters
    public List<Personnage> getJoueurs() {
        return m_joueurs;
    }

    public List<Donjon> getDonjons() {
        return m_donjons;
    }

    public Personnage creerJoueurs() {
        String nom = "";
        while (nom.length() < 2) {
            nom = demanderString("Entrez un nom de personnage (Minimum 3 caractères):\n");
        }

        afficherPhrase("Choisir votre classe parmis:\n");
        afficherPhrase("1/ Clerc:\n");
        afficherPhrase("2/ Guerrier:\n");
        afficherPhrase("3/ Roublard:\n");
        afficherPhrase("4/ Magicien:\n");
        CharClasse classe = new Clerc();
        int numeroclasse = 0;
        while (numeroclasse != 1 && numeroclasse != 2 && numeroclasse != 3 && numeroclasse != 4) {
            numeroclasse = demanderInt("Entrez le numéro de la classe:\n");
        }
        switch (numeroclasse) {
            case 1:
                break;
            case 2:
                classe = new Guerrier();
                break;
            case 3:
                classe = new Roublard();
                break;
            case 4:
                classe = new Magicien();
                break;
        }

        afficherPhrase("Choisir votre Race parmis:\n");
        afficherPhrase("1/ Humain:\n");
        afficherPhrase("2/ Elfe:\n");
        afficherPhrase("3/ Halfelin:\n");
        afficherPhrase("4/ Nain:\n");
        Race race = new Humain();
        int numerorace = 0;
        while (numerorace != 1 && numerorace != 2 && numerorace != 3 && numerorace != 4) {
            numerorace = demanderInt("Entrez le numéro de la Race choisi:\n");
        }
        switch (numerorace) {
            case 1:
                break;
            case 2:
                race = new Elfe();
                break;
            case 3:
                race = new Halfelin();
                break;
            case 4:
                race = new Nain();
                break;
        }
        return new Personnage(nom, race, classe);
    }

    public Donjon creerDonjon() {
        //taille de la map
        int x = 0, y = 0;
        while (!(x >= 15 && x <= 25 && y >= 15 && y <= 25)) {
            x = demanderInt("Entrez la longeur de votre donjon (entre 15 et 25):\n");
            y = demanderInt("Entrez la hauteur de votre donjon (entre 15 et 25):\n");
        }
        Donjon donjon = new Donjon(x, y);
        afficherPhrase("Votre donjon sera de taille " + x + " sur " + y + ".\n");


        //Position des joueurs
        for (Personnage p : this.getJoueurs()) {
            p.setPosition(x, y);
        }

        donjon.setEntites(this.getJoueurs());

        return donjon;
    }
}