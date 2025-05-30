package donjons;

//importer les list
import equipements.*;
import entites.Entite;

import java.util.ArrayList;
import java.util.List;

import static partie.Affichage.*;
import static partie.Affichage.demanderString;

public class Donjon {
    List<Equipement> m_objetAuSol;
    List<Entite> m_entites;
    List<Obstacle> m_obstacles;
    Position m_taille;

    public Donjon(List<Equipement> objetAuSol, List<Entite> entites,List<Obstacle> obstacles,int x, int y) {
        this.m_objetAuSol = m_objetAuSol;
        this.m_entites = m_entites;
        this.m_obstacles = m_obstacles;
        this.m_taille=new Position(x,y);
    }
    public Position getTaille() {return m_taille;}
    public List<Obstacle> getObstacles() {
        return m_obstacles;
    }
    public List<Equipement> getObjets()
    {
        return m_objetAuSol;
    }

    public List<Entite> getEntites()
    {
        return m_entites;
    }

    public boolean contientObstacle(int x, int y) {
        for (Obstacle obstacle : m_obstacles) {
            if (obstacle.getPosition().getX() == x && obstacle.getPosition().getY() == y) {
                return true;
            }
        }
        return false;
    }
    public boolean contientEntite(int x, int y) {
        for (Entite entite : m_entites) {
            if (entite.getPosition().getX() == x && entite.getPosition().getY() == y) {
                return true;
            }
        }
        return false;
    }
    public boolean contientEquipement(int x, int y) {
        for (Equipement equipement : m_objetAuSol) {
            if (equipement.getPosition().getX() == x && equipement.getPosition().getY() == y) {
                return true;
            }
        }
        return false;
    }
    public String getNomEntite(int x , int y){
        for(Entite e:m_entites){
            if(e.getPosition().getX()==x && e.getPosition().getY()==y){
                //que les 3 premiers caractere de nom
                return e.getNom().substring(0, 3);
            }
        }
        return "";
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

}
