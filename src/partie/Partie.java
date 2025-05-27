package partie;
import entites.*;

import java.util.ArrayList;
import java.util.List;

import static partie.Affichage.*;
import static partie.Affichage.afficherPhrase;

public class Partie {
    private List<Personnage> m_joueurs;

    // Constructeur avec filtrage
    public Partie(List<Personnage> joueurs) {
        m_joueurs = new ArrayList<>();
        int nbJoueur= demanderInt("Entrez un nombre de joueur :\n");
        for (int i = 0; i < nbJoueur; i++) {
            m_joueurs.add(creerJoueurs());
        }
        this.m_joueurs = rangerParInitiative(joueurs);

    }
    // Getters
    public List<Personnage> getEntites() {
        return m_joueurs;
    }

    //Méthode
    public List<Personnage> rangerParInitiative(List<Personnage> joueurs) {
        // On crée une copie de la liste d'origine pour pouvoir la vider sans modifier l'originale
        //Au cas ou il y ai une erreur
        List<Personnage> joueursATrier = new ArrayList<>(joueurs);
        List<Personnage> joueursRange = new ArrayList<>();

        while (!joueursATrier.isEmpty()) {
            // Chercher le personnage avec la plus grande initiative dans la liste joueurATrier
            Personnage max = joueursATrier.getFirst();
            for (Personnage p : joueursATrier) {
                if (p.getStatistiques().getInitiative() > max.getStatistiques().getInitiative()) {
                    max = p;
                }
            }
            // Ajouter à la liste triée
            joueursRange.add(max);
            // Enlever de la liste à trier
            joueursATrier.remove(max);
        }
        //On renvoit la liste trie par initative
        return joueursRange;
    }

    public Personnage creerJoueurs(){
        String nom= demanderString("Entrez un nom de personnage :\n");
        afficherPhrase("Choisir votre classe parmis:\n");
        afficherPhrase("1/ Clerc:\n");
        afficherPhrase("2/ Guerrier:\n");
        afficherPhrase("3/ Roublard:\n");
        afficherPhrase("4/ Magicien:\n");
        CharClasse classe= new Clerc();
        switch (demanderInt("Choisir votre classe parmis:\n")){
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
        switch (demanderInt("Choisir votre classe parmis:\n")){
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