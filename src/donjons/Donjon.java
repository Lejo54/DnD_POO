package donjons;


import equipements.*;
import entites.Entite;

import java.util.ArrayList;
import java.util.List;

import static partie.Affichage.*;

public class Donjon {
    List<Equipement> m_objetAuSol;
    List<Entite> m_entites;
    List<Obstacle> m_obstacles;
    Position m_taille;

    public Donjon(List<Equipement> objetAuSol, List<Entite> entites,List<Obstacle> obstacles,int x, int y) {
        this.m_objetAuSol = objetAuSol;
        this.m_entites = trierParInitiative(entites);
        this.m_obstacles = obstacles;
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

    public void lancerTour(){

    }
    public void afficherInfoDonjon(int n){
        String info="";
        for(int i=0;i<80;i++){
            info+="*";
        }
        info+="\n\n";
        String d="Donjon numéro "+n+"\n";
        int espacement=(80+d.length())/2;
        for(int i=0;i<espacement;i++){
            info+=" ";
        }
        info+=d;
        for(int i=0;i<getEntites().size();i++){
            info+=getEntites().get(i).infoBref();
        }

        afficherPhrase(info);
    }
    public boolean contientObstacle(int x, int y) {
        for (Obstacle obstacle : getObstacles()) {
            if (obstacle.getPosition().getX() == x && obstacle.getPosition().getY() == y) {
                return true;
            }
        }
        return false;
    }
    public boolean contientEntite(int x, int y) {
        for (Entite entite : getEntites()) {
            if (entite.getPosition().getX() == x && entite.getPosition().getY() == y) {
                return true;
            }
        }
        return false;
    }
    public boolean contientEquipement(int x, int y) {
        for (Equipement equipement : getObjets()) {
            if (equipement.getPosition().getX() == x && equipement.getPosition().getY() == y) {
                return true;
            }
        }
        return false;
    }
    public String getNomEntite(int x , int y){
        for(Entite e:getEntites()){
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
   public List<Entite> trierParInitiative(List<Entite> entites) {
       //On crée une nouvelle liste qui va être trié par ordre d'initiative
       List<Entite> entitesTriees = new ArrayList<>(entites);

       // Tri par sélection
       int n = entitesTriees.size();
       for (int i = 0; i < n - 1; i++) {
           int maxIndex = i;
           for (int j = i + 1; j < n; j++) {
               if (entitesTriees.get(j).getStatistiques().getInitiative() > entitesTriees.get(maxIndex).getStatistiques().getInitiative()) {
                   maxIndex = j;
               }
           }
           // Échange des entités
           Entite temp = entitesTriees.get(i);
           entitesTriees.set(i, entitesTriees.get(maxIndex));
           entitesTriees.set(maxIndex, temp);
       }

       return entitesTriees;
   }


}
