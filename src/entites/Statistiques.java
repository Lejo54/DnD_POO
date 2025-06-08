package entites;

import entites.jouable.Personnage;
import entites.jouable.EntiteJouable;

import java.util.List;

import static partie.De.lancerDe;
import static partie.Affichage.afficherPhrase;

/**
 * Classe des statistiques
 * Ils possèdent la vie, la vie max, la force, l'initiative (pour avoir l'ordre des entités qui jouent),
 * la vitesse (pour avoir le nombre de déplacements par action possible) et la dextérité (pour les armes à distance=)
 */
public class Statistiques {
 private int m_pv=0;
 private int m_pvMax=0;
 private int m_force=0;
 private int m_initiative=0;
 private int m_vitesse=0;
 private int m_dexterite=0;


 /**
  * Constructeur pour les armes/armures et les monstres
  * @param pv la vie
  * @param force la force
  * @param initiative l'initiative
  * @param vitesse la vitesse
  * @param dexterite la dextérité
  */
 public Statistiques(int pv, int force, int initiative, int vitesse, int dexterite) {
  m_pv=pv;
  m_pvMax=pv;
  m_force=force;
  m_initiative=initiative;
  m_vitesse=vitesse;
  m_dexterite=dexterite;
 }

 //Constructeur pour les Personnages

 /**
  * Constructeur pour les personnages joueurs
  * Chaques statistiques est définie par un jé de dés avec un ajout de 3
  */
 public Statistiques(){
 int stat;
 String de="4d4";
 stat= lancerDe(de)+3;
 m_force=stat;
 stat= lancerDe(de)+3;
 m_vitesse=stat;
 stat= lancerDe(de)+3;
 m_dexterite=stat;
 stat= lancerDe("1d20");
 m_initiative=stat;
 }

 //Constructeur pour les classes

 /**
  * Constructeur pour les classes, ce qui définit la vie des joueurs
  * @param pv vie
  */
 public Statistiques(int pv) {
  m_pv=pv;
  m_pvMax=pv;
 }

 /**
  * Constructeur pour les races
  * ce qui donne un bonus pour le joueur en fonction de sa race
  * @param force force
  * @param dexterite dextérité
  * @param vitesse vitesse
  */
 public Statistiques(int force,int dexterite,int vitesse) {
  m_force=force;
  m_dexterite=dexterite;
  m_vitesse=vitesse;
 }

 //Getters

 /**
  * Méthode qui renvoie la vie
  * @return la vie
  */
 public int getPv() {return m_pv;}

 /**
  * Méthode qui renvoie la vie max
  * @return la vie max
  */
 public int getPvMax() {return m_pvMax;}

 /**
  * Méthode pour affecté les pv max
  * @param pv vie max
  */
 public void setPvMax(int pv) {m_pvMax=pv;}

 /**
  * Méthode pour affecter les pv
  * @param pv vie
  */
 public void setPV(int pv){m_pv=pv;}

 /**
  * Méthode qui renvoie la force
  * @return la force
  */
 public int getForce() {return m_force;}

 /**
  * Méthode pour affecter la force
  * @param force force
  */
 public void setForce(int force){m_force=force;}

 /**
  * Méthode qui renvoie l'initiative
  * @return l'initiative
  */
 public int getInitiative() {return m_initiative;}

 /**
  * Méthode pour affecter l'initiative
  * @param initiative initiative
  */
 public void setInitiative(int initiative){m_initiative=initiative;}

 /**
  * Méthode qui renvoie la vitesse
  * @return la vitesse
  */
 public int getVitesse() {return m_vitesse;}

 /**
  * Méthode pour affecter la vitesse
  * @param vitesse vitesse
  */
 public void setVitesse(int vitesse){m_vitesse=vitesse;}

 /**
  * Méthode qui renvoie la dextérité
  * @return la dextérité
  */
 public int getDexterite() {return m_dexterite;}

 /**
  * Méthode pour affecter la dextérité
  * @param dexterite dextérité
  */
 public void setDexterite(int dexterite){m_dexterite=dexterite;}

 //Méthodes

 /**
  * Méthode qui retire les pv
  * @param pvPerdu pv à retirer
  */
 public void retirerPv(int pvPerdu){m_pv-=pvPerdu;}

 /**
  * Méthode qui vérifie si les pv sont supérieurs à 0
  * @return true si les pv sont positifs, false sinon
  */
 public boolean estVivant(){
  return getPv() > 0;
 }

 /**
  * Méthode qui vérifie si tous les personnages sont vivants
  * @param entites liste des entites
  * @return false si un personnage est mort, true sinon
  */
 public static boolean persosVivant(List<EntiteJouable> entites) {
  for (EntiteJouable perso: entites){
   if(!perso.getStatistiques().estVivant() && perso.toString().equals("Personnage")){
    return false;
   }
  }
  return true;
 }

 /**
  * Méthode pour remettre la vie au maximum
  */
 public void healMax(){
  m_pv=getPvMax();
 }

 /**
  * Méthode qui vérifie si les monstres sont vivants
  * @param entites liste des entites
  * @param nbMonstre nombre de monstres dans le donjon
  * @return true si tous les monstres sont morts, false sinon
  */
 public static boolean monstresVivant(List<EntiteJouable> entites, int nbMonstre) {
  int nbMort=0;
  for (EntiteJouable monstre: entites){
   if(!monstre.getStatistiques().estVivant() && monstre.toString().equals("Monstre")){
    nbMort++;
   }
  }
  return nbMort != nbMonstre;
 }

 /**
  * Méthode pour afficher les statistiques
  */
 public void afficherStat(){
  afficherPhrase(
   "Vie:"+this.getPv()+"/"+this.getPvMax()+"\n"
   +"Force:"+this.getForce()+"\n"
   +"Initiative:"+this.getInitiative()+"\n"
   +"Vitesse:"+this.getVitesse()+"\n"
   +"Dexterite:"+this.getDexterite()+"\n"
  );
}

 /**
  * Méthode qui affecte les statistiques en fonction de la classe, la race et des équipements équipés
  * @param perso le personnage dont un affecte les statistiques
  */
 public static void setStat(Personnage perso) {
  perso.getStatistiques().setDexterite(perso.getStatistiques().getDexterite()+perso.getRace().getStatistiques().getDexterite());
  perso.getStatistiques().setPV(perso.getClasse().getStatistiques().getPv());
  perso.getStatistiques().setForce(perso.getStatistiques().getForce()+perso.getRace().getStatistiques().getForce()+perso.getArmeEquipee().getStat().getForce());
  perso.getStatistiques().setVitesse(perso.getStatistiques().getVitesse()+perso.getRace().getStatistiques().getVitesse()+perso.getArmeEquipee().getStat().getVitesse()+perso.getArmureEquipee().getStat().getVitesse());
  perso.getStatistiques().setPvMax(perso.getClasse().getStatistiques().getPvMax());


 }
}
