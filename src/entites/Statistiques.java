package entites;

import entites.jouable.Personnage;
import entites.jouable.EntiteJouable;

import java.util.List;

import static partie.De.lancerDe;
import static partie.Affichage.afficherPhrase;

public class Statistiques {
 private int m_pv=0;
 private int m_pvMax=0;
 private int m_force=0;
 private int m_initiative=0;
 private int m_vitesse=0;
 private int m_dexterite=0;

 //Constructeur pour les armes/armures et monstre
 public Statistiques(int pv, int force, int initiative, int vitesse, int dexterite) {
  m_pv=pv;
  m_pvMax=pv;
  m_force=force;
  m_initiative=initiative;
  m_vitesse=vitesse;
  m_dexterite=dexterite;
 }

 //Constructeur pour les Personnages
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
 public Statistiques(int pv) {
  m_pv=pv;
  m_pvMax=pv;
 }
 //pour les races Halfelin,Elfe,Nain
 public Statistiques(int force,int dexterite,int vitesse) {
  m_force=force;
  m_dexterite=dexterite;
  m_vitesse=vitesse;
 }
 //Getters
 public int getPv() {return m_pv;}
 public int getPvMax() {return m_pvMax;}
 public void setPvMax(int pv) {m_pvMax=pv;}
 public void setPV(int pv){m_pv=pv;}
 public int getForce() {return m_force;}
 public void setForce(int force){m_force=force;}
 public int getInitiative() {return m_initiative;}
 public void setInitiative(int initiative){m_initiative=initiative;}
 public int getVitesse() {return m_vitesse;}
 public void setVitesse(int vitesse){m_vitesse=vitesse;}
 public int getDexterite() {return m_dexterite;}
 public void setDexterite(int dexterite){m_dexterite=dexterite;}

 //Méthodes
 public void retirerPv(int pv){m_pv-=pv;}
 public boolean estVivant(){
  return getPv() > 0;
 }
 public static boolean persosVivant(List<EntiteJouable> entites) {
  for (EntiteJouable perso: entites){
   if(!perso.getStatistiques().estVivant() && perso.toString().equals("Personnage")){
    return false;
   }
  }
  return true;
 }
 public void healMax(){
  m_pv=getPvMax();
 }
 public static boolean monstresVivant(List<EntiteJouable> entites, int nbMonstre) {
  int nbMort=0;
  for (EntiteJouable monstre: entites){
   if(!monstre.getStatistiques().estVivant() && monstre.toString().equals("Monstre")){
    nbMort++;
   }
  }
  return nbMort != nbMonstre;
 }
public void afficherStat(){
  afficherPhrase(
   "Vie:"+this.getPv()+"/"+this.getPvMax()+"\n"
   +"Force:"+this.getForce()+"\n"
   +"Initiative:"+this.getInitiative()+"\n"
   +"Vitesse:"+this.getVitesse()+"\n"
   +"Dexterite:"+this.getDexterite()+"\n"
  );
}

 public static void setStat(Personnage perso) {
  perso.getStatistiques().setDexterite(perso.getStatistiques().getDexterite()+perso.getRace().getStatistiques().getDexterite());
  perso.getStatistiques().setPV(perso.getClasse().getStatistiques().getPv());
  perso.getStatistiques().setForce(perso.getStatistiques().getForce()+perso.getRace().getStatistiques().getForce()+perso.getArmeEquipee().getStat().getForce());
  perso.getStatistiques().setVitesse(perso.getStatistiques().getVitesse()+perso.getRace().getStatistiques().getVitesse()+perso.getArmeEquipee().getStat().getVitesse()+perso.getArmureEquipee().getStat().getVitesse());
  perso.getStatistiques().setPvMax(perso.getClasse().getStatistiques().getPvMax());


 }
}
