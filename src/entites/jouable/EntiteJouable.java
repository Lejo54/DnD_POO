package entites.jouable;

import donjons.Donjon;
import donjons.Position;
import entites.Entite;
import entites.Statistiques;

import java.util.List;

import static partie.Affichage.afficherPhrase;
import static partie.Affichage.demanderInt;
import static partie.De.lancerDe;

public abstract class EntiteJouable extends Entite {


 public EntiteJouable(String nom) {
  super(nom,new Position(), new Statistiques());
 }
 public EntiteJouable(String nom,Statistiques statistiques) {
  super(nom,new Position(), statistiques);
 }
 public abstract String toString();
 public abstract String infoBref();
 public void perdrePv(int pvRetire) {
  //retire des pv a l'entité subissant une attaque
  this.getStatistiques().retirerPv(pvRetire);
  String phrase =this.getNom() + " perd " + pvRetire + " PV. PV restants : " + this.getStatistiques().getPv();
  afficherPhrase(phrase+"\n");
  //affichage
  if(!this.getStatistiques().estVivant()){
   afficherPhrase(this.getNom()+" est mort !\n");
  }
 }
 public abstract void afficherInfoEntite();

 public static void afficherBandeauTour(int tour, Entite e, List<EntiteJouable> entites) {
  afficherPhrase("Tour "+tour+"\n     ");
  for(EntiteJouable entite : entites) {
   if(entite.getNom().equals(e.getNom())) {
    afficherPhrase("-->"+entite.infoBref());
   }
   else{
    afficherPhrase(entite.infoBref());
   }
  }
 }
 public abstract void desequiperTout();
 public abstract void afficherAction();



 public abstract void choixEquipement();

 public static boolean estCorpsACops(EntiteJouable attaquant,EntiteJouable cible){
  int grandx=0;
  int petitx=0;
  int grandy=0;
  int petity=0;
  if (cible.getPosition().getX()>attaquant.getPosition().getX()){
   grandx=cible.getPosition().getX();
   petitx=attaquant.getPosition().getX();
  }
  else {
   grandx=cible.getPosition().getX();
   petitx=attaquant.getPosition().getX();
  }
  if (cible.getPosition().getY()>attaquant.getPosition().getY()){
   grandy=cible.getPosition().getY();
   petity=attaquant.getPosition().getY();
  }
  else {
   grandy=cible.getPosition().getY();
   petity=attaquant.getPosition().getY();
  }
  return ((grandx - petitx < 2) && (grandy - petity < 2) && (attaquant.getPortee() >= 1));
 }
 public static boolean estAPortee(EntiteJouable attaquant, EntiteJouable cible){
    int grandx=0;
    int petitx=0;
    int grandy=0;
    int petity=0;
    if (cible.getPosition().getX()>attaquant.getPosition().getX()){
     grandx=cible.getPosition().getX();
     petitx=attaquant.getPosition().getX();
    }
    else {
     grandx=cible.getPosition().getX();
     petitx=attaquant.getPosition().getX();
    }
    if (cible.getPosition().getY()>attaquant.getPosition().getY()){
     grandy=cible.getPosition().getY();
     petity=attaquant.getPosition().getY();
    }
    else {
     grandy=cible.getPosition().getY();
     petity=attaquant.getPosition().getY();
    }
    return ((attaquant.getPortee()>=grandx-petitx)||(attaquant.getPortee()>=grandy-petity));
  }
 public static boolean estResistant(EntiteJouable cible,int stat){
  return cible.getArmure() > (lancerDe("1d20") + stat);
 }



 public abstract int getArmure() ;
 public abstract int getPortee() ;

 public abstract String getDegat() ;
 public abstract void ramasser(Donjon donjon,Entite entite);
 public void setPosition(int xd, int yd) {
  int x=0;
  int y=0;
  while(x<=1||x>xd || y<=1 || y>yd) {
   x=demanderInt("Position horizontale de "+this.getNom()+" (entre 1 et "+xd+"):\n");
   y=demanderInt("Position verticale de "+this.getNom()+"(entre 1 et "+yd+"):\n");
  }
  this.getPosition().changeXY(x,y);
 }
}
