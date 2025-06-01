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


   /* public void creerDonjon(){
        int x=demanderInt("quelle taille fera votre donjon en longueur (x)");
        int y=demanderInt("quelle taille fera votre donjon en largeur (y)");
        List<Equipement> equipements=creerEquipementAuSol(demanderInt("combien d'objet ramassable seront au sol pour les joueurs"));
        List<Obstacle> obstacles=creerObstacle(demanderInt("combien d'obstacle se trouveront sur la carte ?"));
        Donjon d=new Donjon(equipements,jsp faut quon voit ensemble , obstacles,x,y);
    }
*/
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


}
