package entites.jouable;

import donjons.Donjon;
import donjons.Position;
import entites.Entite;
import entites.Statistiques;

import java.util.List;

import static partie.Affichage.afficherPhrase;
import static partie.Affichage.demanderInt;
import static partie.De.lancerDe;

/**
 * Classe pour les entités jouables
 */
public abstract class EntiteJouable extends Entite {

 /**
  * Constructeur pour les entités jouables personnages
  * @param nom de l'entité
  */
 public EntiteJouable(String nom) {
  super(nom,new Position(), new Statistiques());
 }

 /**
  * Constructeur pour les entités jouables monstres
  * @param nom de l'entité
  * @param statistiques de l'entité
  */
 public EntiteJouable(String nom,Statistiques statistiques) {
  super(nom,new Position(), statistiques);
 }

 /**
  * Méthode abstraite pour avoir le type d'entité
  * @return le type d'entité
  */
 public abstract String toString();

 /**
  * Méthode pour avoir les informations breves de l'entité jouable
  * @return les informations de l'entité jouable
  */
 public abstract String infoBref();

 /**
  * Méthode pour retirer les pv d'une entité et affiche si elle meurt
  * @param pvRetire les pc à retirer
  */
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

 /**
  * Méthode pour avoir les informations de l'entité jouable
  */
 public abstract void afficherInfoEntite();

 /**
  * Méthode pour afficher le bandeau du tour, la liste des joueurs de la partie
  * avec une indication pour savoir l'entité jouable actuelle
  * @param tour le numéro du tour
  * @param e l'entité qui joue
  * @param entites la liste des entités
  */
 public static void afficherBandeauTour(int tour, Entite e, List<EntiteJouable> entites) {
  afficherPhrase("Tour "+tour+"\n");
  for(EntiteJouable entite : entites) {
   if(entite.getNom().equals(e.getNom())) {
    afficherPhrase("   -->"+entite.infoBref());
   }
   else{
    afficherPhrase(entite.infoBref());
   }
  }
 }

 /**
  * Méthode abstraite pour déséquiper tous les équipements
  */
 public abstract void desequiperTout();

 /**
  * Méthode abstraite pour afficher les actions possibles
  */
 public abstract void afficherAction();

 /**
  * Méthode pour choisir un équipement à équiper
  */
 public abstract void choixEquipement();

 /**
  * Méthode pour vérifier si la cible est au corps à corps
  * donc à une case de l'attaquant
  * @param attaquant entité jouable qui attaque
  * @param cible entité jouable qui est attaqué
  * @return true si l'attaquant est à une case de la cible, false sinon
  */
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

 /**
  * Méthode pour vérifier si la cible est à portée de l'attaquant en fonction de son arme
  * @param attaquant entité jouable qui attaque
  * @param cible entité jouable qui est attaqué
  * @return true si la cible est à portée, false sinon
  */
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

 /**
  * Méthode qui vérifie si une cible peut subir des dégats
  * @param cible entité jouable attaqué
  * @param stat statistique qui définit le type d'attaque (corps à corps ou à distance)
  * @return true si la cible a une armure plus grande que la statistique d'attaque, false sinon
  */
 public static boolean estResistant(EntiteJouable cible,int stat){
  return cible.getArmure() > (lancerDe("1d20") + stat);
 }

 /**
  * Méthode abstraite pour avoir la classe d'armure
  * @return la classe d'armure
  */
 public abstract int getArmure() ;

 /**
  * Méthode abstraite pour avoir la portée de l'arme
  * @return la portée de l'arme
  */
 public abstract int getPortee() ;

 /**
  * Méthode abstraite pour avoir les dégats
  * @return les dégats de la forme XdY
  */
 public abstract String getDegat() ;

 /**
  * Méthode abstraite pour ramasser un équipement
  * @param donjon donjon dans lequel on veut ramasser l'équipement
  */
 public abstract void ramasser(Donjon donjon);

 /**
  * Méthode pour affecter la position d'une entité jouable
  * @param xd taille du donjon en longueur
  * @param yd taille du donjon en hauteur
  */
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
