package partie;
import donjons.Donjon;
import donjons.Obstacle;
import entites.*;
import equipements.*;

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
        m_donjons.add(creerDonjon());
    }
    // Getters
    public List<Personnage> getJoueurs() {
        return m_joueurs;
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

    public Donjon creerDonjon(){
        //taille de la map
        int x=demanderInt("Entrez la longeur de votre donjon (entre 15 et 25):\n");
        int y=demanderInt("Entrez la hauteur de votre donjon (entre 15 et 25):\n");

        //Création des obstacles
        List<Obstacle> obstacle=creerObstacle(demanderInt("combien d'obstacle se trouveront sur la carte ?\n"));

        //Création des objets ramassables
        List<Equipement> objetAuSol=creerEquipementAuSol(demanderInt("combien d'objet ramassable seront au sol pour les joueurs\n"));

        //Création des monstres
        List<Entite> entites= new ArrayList<>();
        entites.addAll(getJoueurs());
        int nbMonstre=demanderInt("Entrez le nombre de monstre présent dans le donjon:\n");
        entites.addAll(creerMonstre(nbMonstre));

        Donjon donjon=new Donjon(objetAuSol,entites,obstacle,x,y);
        return donjon;
    }

    public List<Monstre> creerMonstre(int nbMonstre){
        List<Monstre> monstres= new ArrayList<>();
        for (int i = 0; i < nbMonstre; i++) {
            String espece= demanderString("Entrez le nom de l'espèce du monstre:\n");
            int numéro= demanderInt("Entrez le numero de monstre:\n");
            int portee= demanderInt("Entrez la portée de l'attaque du monstre (1 pour une attaque au corps à corps):\n");
            String Degat=creerDegat();
            //On créé le monstre et on l'ajoute dans la liste des monstres
            monstres.add(new Monstre(espece,numéro,portee,Degat));
        }

        return monstres;
    }
    public String creerDegat(){
        String nbFace=String.valueOf(demanderInt("Entrez le nombre de face de votre dé de dégat:\n"));
        String nbLancer=String.valueOf(demanderInt("Entrez le numero de lancer de votre dé de dégat:\n"));
        String de=nbLancer+"d"+nbFace;
        return de;
    }
    public List<Obstacle> creerObstacle(int nbo){
        List<Obstacle> res=new ArrayList<>();
        for(int i =0 ; i<nbo ; i++){
            int x =demanderInt("position x de votre obstacle ?\n");
            int y =demanderInt("position y de votre obstacle ?\n");
            res.add(new Obstacle(x,y));
        }
        return res;
    }

    public List<Equipement> creerEquipementAuSol(int nbe) {
        List<Equipement> res = new ArrayList<>();
        String[] tabstuff = {
         "baton", "masse d'armes", "arc court", "arbalete legere", "fronde",
         "epee longue", "rapiere", "epee à deux mains","cotte de mailles", "harnois"
        };
        Equipement nouvelleArme=null;
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
                    break;
                case 5,3,4 :
                    nouvelleArme = new ArmeDistante(tabstuff[numero],demanderString("une description pour cette armes?(sinon appuyer sur entree)"),false);
                    break;
                case 8,6,7:
                    nouvelleArme = new ArmeGuerre(tabstuff[numero],demanderString("une description pour cette armes?(sinon appuyer sur entree)"),false);
                    break;
                case 9,10 :
                    nouvelleArme = new ArmureLegere(tabstuff[numero],demanderString("une description pour cette armes?(sinon appuyer sur entree)"),false);
                    break;
                case 11,12 :
                    nouvelleArme = new ArmureLourde(tabstuff[numero],demanderString("une description pour cette armes?(sinon appuyer sur entree)"),false);
                    break;
            }
            res.add(nouvelleArme);
        }
        return res;
    }
}