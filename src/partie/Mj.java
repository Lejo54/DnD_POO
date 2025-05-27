package partie;

import entites.*;

import java.util.ArrayList;
import java.util.List;

import static partie.Affichage.*;

public class Mj {

    private List<Personnage> m_joueurs;
    private

    public Mj() {
        List<Personnage> joueurs = new ArrayList<>();
        int nbJoueur= demanderInt("Entrez un nombre de joueur :\n");
        for (int i = 0; i < nbJoueur; i++) {
            joueurs.add(creerJoueurs());
        }
        m_joueurs = joueurs;
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

    public void lancerPartie(){

    }

}
