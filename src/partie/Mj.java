package partie;

import entites.*;
import equipements.*;

import java.util.ArrayList;
import java.util.List;

import donjons.Donjon;

import static partie.Affichage.*;

public class Mj {

    private List<Personnage> m_joueurs;
    private List<Monstre> m_monstre;

    public Mj() {
        int nbJoueur= demanderInt("quel taille fais notre groupe d'aventurier ?\n");
        for (int i = 0; i < nbJoueur; i++) {
            m_joueurs.add(creerPersonnage());
        }
    }


    public Personnage creerPersonnage(){
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

    public List<Equipement> creerEquipementAuSol(int nbe) {
        List<Equipement> res = new ArrayList<>();
        String[] tabstuff = {
                "baton", "masse d'armes", "arc court", "arbalete legere", "fronde",
                "epee longue", "rapiere", "epee à deux mains","cotte de mailles", "harnois"
        };
        Equipement nouvelleArme = null;
        for (int i = 0; i < nbe; i++) {
            afficherPhrase("Quelle est le nom de l'arme parmi celles-ci ?");
            for (int j = 0; j < tabstuff.length; j++) {
                afficherPhrase("arme " + j + " = " + tabstuff[j]);
            }

            int numero=-1;
            while (numero < 0 || numero >= tabstuff.length){
                numero = demanderInt("Veuillez entrer un numéro entre 0 et " + (tabstuff.length - 1));
            }
            switch (numero){
                case 1,2 :
                    nouvelleArme = new ArmeCourante(tabstuff[numero],demanderString("une description pour cette armes?(sinon appuyer sur entree)"),false);
                case 5,3,4 :
                    nouvelleArme = new ArmeDistante(tabstuff[numero],demanderString("une description pour cette armes?(sinon appuyer sur entree)"),false);
                case 8,6,7:
                    nouvelleArme = new ArmeGuerre(tabstuff[numero],demanderString("une description pour cette armes?(sinon appuyer sur entree)"),false);
                case 9,10 :
                    nouvelleArme = new ArmureLegere(tabstuff[numero],demanderString("une description pour cette armes?(sinon appuyer sur entree)"),false);
                case 11,12 :
                    nouvelleArme = new ArmureLourde(tabstuff[numero],demanderString("une description pour cette armes?(sinon appuyer sur entree)"),false);
            }
        res.add(nouvelleArme);
        }
        return res;
    }

    public int creerObstacle(int nbo){
        
    }


    public void lancerPartie(){
        int x=demanderInt("quelle taille fera votre donjon en longueur (x)");
        int y=demanderInt("quelle taille fera votre donjon en largeur (y)");
        List<Equipement> equipements=creerEquipementAuSol(demanderInt("combien d'objet ramassable seront au sol pour les joueurs"));


        Donjon d=new Donjon()
    }

}
