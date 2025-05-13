package Entites;

import static Partie.De.lancerDe;

public class Statistiques {
 private int m_pv;
 private int m_force;
 private int m_initiative;
 private int m_vitesse;
 private int m_dexterite;
 private boolean status= true;

 //Constructeur pour les armes/armures
 public Statistiques(int pv, int force, int initiative, int vitesse, int dexterite) {
  m_pv=pv;
  m_force=force;
  m_initiative=initiative;
  m_vitesse=vitesse;
  m_dexterite=dexterite;
 }
 //Constructeur pour les entités
 public Statistiques(){
 int stat;
 stat= lancerDe(4,4)+3;
 m_force=stat;
 stat= lancerDe(4,4)+3;
 m_vitesse=stat;
 stat= lancerDe(4,4)+3;
 m_dexterite=stat;


 }
 //Getters
 public int getPv() {return m_pv;}
 public int getForce() {return m_force;}
 public int getInitiative() {return m_initiative;}
 public int getVitesse() {return m_vitesse;}
 public int getDexterite() {return m_dexterite;}
 public boolean getStatus() {return status;}

 //Méthodes
 public void retirerPv(int pv){m_pv-=pv;}
}
