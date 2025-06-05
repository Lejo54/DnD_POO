package entites;

import java.util.List;

import static partie.De.lancerDe;

public class Statistiques {
 private int m_pv=0;
 private int m_pvMax=0;
 private int m_force=0;
 private int m_initiative=0;
 private int m_vitesse=0;
 private int m_dexterite=0;

 //Constructeur pour les armes/armures
 public Statistiques(int pv, int force, int initiative, int vitesse, int dexterite) {
  m_pv=pv;
  m_pvMax=pv;
  m_force=force;
  m_initiative=initiative;
  m_vitesse=vitesse;
  m_dexterite=dexterite;
 }
 //Constructeur pour les monstres
 public Statistiques(int pv, int force, int dexterite, int vitesse) {
  m_pv=pv;
  m_pvMax=pv;
  m_force=force;
  m_dexterite=dexterite;
  m_vitesse=vitesse;
 }
 //Constructeur pour les Personnages
 public Statistiques(){
 int stat;
 stat= lancerDe(4,4)+3;
 m_force=stat;
 stat= lancerDe(4,4)+3;
 m_vitesse=stat;
 stat= lancerDe(4,4)+3;
 m_dexterite=stat;
 stat= lancerDe(1,20);
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
  if(getPv()==0){
   return false;
  }
  return true;
 }
 public static boolean persosVivant(List<Entite> entites) {
  for (Entite perso: entites){
   if(!perso.getStatistiques().estVivant() && perso.toString().equals("Personnage")){
    return false;
   }
  }
  return true;
 }
 public static boolean monstresVivant(List<Entite> entites) {
  for (Entite monstre: entites){
   if(!monstre.getStatistiques().estVivant() && monstre.toString().equals("Monstre")){
    return false;
   }
  }
  return true;
 }


 public static void setStat(Personnage perso) {
  perso.getStatistiques().setDexterite(perso.getStatistiques().getDexterite()+perso.getRace().getStatistiques().getDexterite());
  perso.getStatistiques().setPV(perso.getClasse().getStatistiques().getPv());
  perso.getStatistiques().setForce(perso.getStatistiques().getForce()+perso.getRace().getStatistiques().getForce());
  perso.getStatistiques().setVitesse(perso.getStatistiques().getVitesse()+perso.getRace().getStatistiques().getVitesse());

 }
}
