package donjons;


import entites.Personnage;
import equipements.*;
import entites.Entite;

import static donjons.Position.deplacement;
import static entites.Entite.afficherBandeauTour;
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
        this.m_entites = entites;
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

    public boolean lancerTours(int nbDonjon){
        int tour=0;
        do{
            if (tour==0){
                 for(Entite entite: this.getEntites()){
                     if(entite.toString().equals("Personnage")){
                         entite.choixEquipement();
                     }
                 }
            }
            tour++;
            for (Entite e:this.getEntites()) {
                //choix des actions
                for (int x = 3; x > 0; x--) {
                    if(!persosVivant(this.getEntites())){
                        afficherPhrase("Défaite, tout les personnages sont morts\n");
                        return true;
                    }
                    afficherBandeauTour(tour,e,this.getEntites());
                    afficherDonjon();
                    e.afficherInfoEntite();
                    afficherPhrase("vous avez "+x+" action restantes pour ce tour\n");
                    e.choixAction(this);
                    if (this.victoireDonjon()){
                        if(this.victoirePartie(nbDonjon)){
                            afficherPhrase("Victoire, tout les donjons ont été vaincus\n");
                            return true;
                        }
                        afficherPhrase("Tout les monstres du donjon on été vaincus, passage au donjon suivant\n");
                        for (Entite entite : this.getEntites()) {
                            entite.getStatistiques().healMax();
                            if(entite.toString().equals("Personnage")){
                                entite.desequiperTout();
                            }
                        }
                        return false;
                    }
                }
            }
        } while (!this.victoirePartie(nbDonjon));
        afficherPhrase("pas censé être ici");
        return false;
    }
    public void afficherEntites() {
        String info="";
        for(int i=0;i<this.getEntites().size();i++){
            info+=(i+1)+". "+this.getEntites().get(i).infoBref()+"\n";
        }
        afficherPhrase(info+"\n");
    }

    public boolean victoirePartie(int nbDonjon){
     return nbDonjon == 3 && persosVivant(this.getEntites());
    }
    public boolean victoireDonjon(){
        if(persosVivant(this.getEntites())){
            if(!monstresVivant(this.getEntites(),this.compteurMonstre())){
                return true;
            }

        }
        return false;
    }


    public void afficherInfoDonjon(int n){
        String info="";
        for(int i=0;i<80;i++){
            info+="*";
        }
        info+="\n\n";
        String d="Donjon numéro "+(n+1)+"\n";
        int espacement=(80+d.length())/4;
        for(int i=0;i<espacement;i++){
            info+=" ";
        }
        info+=d;
        afficherEntites();

        info+="\n" +
         "Nombre de Monstres: "+this.compteurMonstre()+"\n"
        +"Nombre de Joueurs: "+this.compteurJoueur()+"\n";
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
           if (y != 0) {
               afficherPhrase((char) ('A' + y - 1) + "  ");
           } else {
               afficherPhrase("   ");
           }

           for (int x = 0; x < this.getTaille().getX(); x++) {
               if (y == 0) {
                   if (x > 8) {
                       afficherPhrase(x + 1 + " ");
                   }
                   else {
                       afficherPhrase(" "+(x + 1) + " ");
                   }
               } else if (this.contientEntite(x, y)) {
                   String petitnom = this.getNomEntite(x, y).substring(0, 3);
                   afficherPhrase(petitnom);
               } else if (this.contientObstacle(x, y)) {
                   afficherPhrase(" ♦ ");
               } else if (this.contientEquipement(x, y)) {
                   afficherPhrase(" † ");

               } else {
                   afficherPhrase(" ∙ ");
               }
           }
           afficherPhrase("\n");
       }
   }


}
