package entites.classe;

import entites.Statistiques;

/**
 * Classe des classes
 * Composé d'un nom et de statistiques
 */
public abstract class CharClasse {
 private String m_classe;
 private Statistiques m_statistiques;

 /**
  * Constructeur des classes
  * @param classe au choix
  * @param statistiques de la classe
  */
 public CharClasse(String classe, Statistiques statistiques) {
  m_classe = classe;
  m_statistiques = statistiques;
 }

 /**
  * Méthode pour avoir les statistiques de la classe
  * @return les statistiques
  */
 public Statistiques getStatistiques() {return m_statistiques;}

 public String toString() {return m_classe;}
}
