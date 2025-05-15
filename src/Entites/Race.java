package Entites;

public abstract class Race {
 private String m_race;
 private Statistiques m_statistiques;

 public Race(String race, Statistiques statistiques) {
  m_race = race;
  m_statistiques = statistiques;
 }
 public String getRace() {return m_race;}
 public Statistiques getStatistiques() {return m_statistiques;}
}
