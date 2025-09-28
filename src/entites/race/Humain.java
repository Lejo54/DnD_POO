package entites.race;

import entites.Statistiques;

/**
 * Classe de la race humain
 */
public class Humain extends Race {

 /**
  * Constructeur de la race humain
  */
 public Humain() {
  super("Humain",new Statistiques(2,2,2,2,2));
 }
}
