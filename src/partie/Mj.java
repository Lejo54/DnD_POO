package partie;

import donjons.Position;
import entites.*;
import equipements.*;
import donjons.Obstacle;
import java.util.ArrayList;
import java.util.List;

import donjons.Donjon;

import static partie.Affichage.*;

public class Mj {

    private Partie m_partie;

    public Mj() {

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

    public List<Obstacle> creerObstacle(int nbo){
        List<Obstacle> res=new ArrayList<>();
        for(int i =0 ; i<nbo ; i++){
            int x =demanderInt("position x de votre obstacle Overlord?");
            int y =demanderInt("position y de votre obstacle Overlord?");
            res.add(new Obstacle(x,y));
        }
        return res;
    }


    public void lancerPartie(){
        int x=demanderInt("quelle taille fera votre donjon en longueur (x)");
        int y=demanderInt("quelle taille fera votre donjon en largeur (y)");
        List<Equipement> equipements=creerEquipementAuSol(demanderInt("combien d'objet ramassable seront au sol pour les joueurs"));
        List<Obstacle> obstacles=creerObstacle(demanderInt("combien d'obstacle se trouveront sur la carte ?"));
        Donjon d=new Donjon(equipements,jsp faut quon voit ensemble , obstacles,x,y);
    }

}
