package entites;

public abstract class CharClasse {
 private String m_classe;
 private Statistiques m_statistiques;

 public CharClasse(String classe, Statistiques statistiques) {
  m_classe = classe;
  m_statistiques = statistiques;
 }
 public Statistiques getStatistiques() {return m_statistiques;}
 public abstract String toString();

}
