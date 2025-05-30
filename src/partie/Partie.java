package partie;
import donjons.Donjon;
import entites.*;

import java.util.ArrayList;
import java.util.List;

import static partie.Affichage.*;
import static partie.Affichage.afficherPhrase;

public class Partie {
    private List<Personnage> m_joueurs;
    private List<Donjon> m_donjons;

    // Constructeur avec filtrage
    public Partie() {
        List<Personnage> joueurs= new ArrayList<>();
        int nbJoueur= demanderInt("Entrez un nombre de joueur :\n");
        for (int i = 0; i < nbJoueur; i++) {
            joueurs.add(creerJoueurs());
        }
        m_joueurs.addAll(joueurs);

    }
    // Getters
    public List<Personnage> getJoueurs() {
        return m_joueurs;
    }

    public void trierParInitiative(Entite[] entites) {
        int n = entites.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (entites[j].getStatistiques().getInitiative() < entites[minIndex].getStatistiques().getInitiative()) {
                    minIndex = j;
                }
            }
            Entite temp = entites[i];
            entites[i] = entites[minIndex];
            entites[minIndex] = temp;
        }
    }
    public Personnage creerJoueurs(){
        String nom= demanderString("Entrez un nom de personnage :\n");
        afficherPhrase("Choisir votre classe parmis:\n");
        afficherPhrase("1/ Clerc:\n");
        afficherPhrase("2/ Guerrier:\n");
        afficherPhrase("3/ Roublard:\n");
        afficherPhrase("4/ Magicien:\n");
        CharClasse classe= new Clerc();
        switch (demanderInt("Entrez le numéro de la classe:\n")){
            case 1:
                classe= new Clerc();
                break;
            case 2:
                classe= new Guerrier();
                break;
            case 3:
                classe= new Roublard();
                break;
            case 4:
                classe= new Magicien();
                break;
        }

        afficherPhrase("Choisir votre Race parmis:\n");
        afficherPhrase("1/ Humain:\n");
        afficherPhrase("2/ Elfe:\n");
        afficherPhrase("3/ Halfelin:\n");
        afficherPhrase("4/ Nain:\n");
        Race race= new Humain();
        switch (demanderInt("Entrez le numéro de la race:\n")){
            case 1:
                race= new Humain();
                break;
            case 2:
                race= new Elfe();
                break;
            case 3:
                race= new Halfelin();
                break;
            case 4:
                race= new Nain();
                break;
        }
        return new Personnage(nom,race,classe);
    }

}