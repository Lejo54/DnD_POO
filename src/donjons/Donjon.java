package donjons;


import equipements.*;
import entites.Entite;
import static entites.Statistiques.persosVivant;
import static entites.Statistiques.monstresVivant;

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

    public void lancerTours(){
        while(!finPartie()){
            //afficher le bandeau du tour
            //afficher la map
            //afficher les actions en fonction du mob je crois
            //en fonction de l'action choisit faire l'action
            //et en vrai je crois que c'est la fin après
            //faire en sorte qu'au début du jeu les gens peuvent choisir les armes à équiper
            //et les armures aussi
            //en vrai ca peut le faire demain matin je pense et après gros débug
            //test d'abord si la création de joueurs fonctionne avant tt
        }
    }
    public boolean finPartie(){
        if(!monstresVivant(getEntites())){
            afficherPhrase("Victoire aventuriers, vous avez vaincu tout les monstres de ce donjon !\n");
            return true;
        }
        else if(!persosVivant(getEntites())){
            afficherPhrase("Défaite, toute l'équipe s'est faite éliminé !\n");
            return true;
        }
        return false;
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
        for(int i=0;i<this.getEntites().size();i++){
            info+=this.getEntites().get(i).infoBref();
        }

        info+="\n" +
         "Nombre de Monstres: "+this.compteurMonstre()+"\n"
        +"Nombre de Joueurs"+this.compteurJoueur()+"\n";
        afficherPhrase(info);
        this.afficherDonjon();
    }
    public int compteurJoueur(){
        int nbJoueur=0;
        for(Entite entite : this.getEntites()){
            if(entite.toString().equals("Personnage")){
                nbJoueur++;
            }
        }
        return nbJoueur;
    }
    public int compteurMonstre(){
        int nbMonstre=0;
        for(Entite entite : this.getEntites()){
            if(entite.toString().equals("Monstre")){
                nbMonstre++;
            }
        }
        return nbMonstre;
    }

    public boolean contientObstacle(int x, int y) {
        for (Obstacle obstacle : this.getObstacles()) {
            if (obstacle.getPosition().getX() == x && obstacle.getPosition().getY() == y) {
                return true;
            }
        }
        return false;
    }
    public boolean contientEntite(int x, int y) {
        for (Entite entite : this.getEntites()) {
            if (entite.getPosition().getX() == x && entite.getPosition().getY() == y) {
                return true;
            }
        }
        return false;
    }
    public boolean contientEquipement(int x, int y) {
        for (Equipement equipement : this.getObjets()) {
            if (equipement.getPosition().getX() == x && equipement.getPosition().getY() == y) {
                return true;
            }
        }
        return false;
    }
    public String getNomEntite(int x , int y){
        for(Entite e:this.getEntites()){
            if(e.getPosition().getX()==x && e.getPosition().getY()==y){
                //que les 3 premiers caractere de nom
                return e.getNom().substring(0, 3);
            }
        }
        return "";
    }

   public void afficherDonjon() {
       for (int y = 0; y < this.getTaille().getY(); y++) {
           System.out.print((char) ('A' + y) + " ");

           for (int x = 0; x < this.getTaille().getX(); x++) {
               if (y==0){
                   System.out.print(" "+x + " ");
               }
               else if (this.contientObstacle(x,y)) {
                   System.out.print("♦ ");
               } else if (this.contientEquipement(x,y)) {
                   System.out.print("† ");
               } else if (this.contientEntite(x,y)) {
                   String petitnom=this.getNomEntite(x,y).substring(0,2);
                   System.out.print(petitnom);
               } else {
                   System.out.print("∙ ");
               }
           }
           System.out.println();
       }
   }
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
