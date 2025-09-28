package entites.race;

import entites.Statistiques;

/**
 * Classe des races
 * Composé d'un nom et de statistiques
 */
public abstract class Race {
 private String m_race;
 private Statistiques m_statistiques;

 /**
  * Constructeur des races
  * @param race nom
  * @param statistiques de la race
  */
 public Race(String race, Statistiques statistiques) {
  m_race = race;
  m_statistiques = statistiques;
 }

 /**
  * Méthode pour avoir le nom de la race
  * @return le nom de la race
  */
 public String toString() {return m_race;}

 /**
  * Méthode pour avoir les statistiques de la race
  * @return les statistiques
  */
 public Statistiques getStatistiques() {return m_statistiques;}
}
