package entites.classe;

import entites.Statistiques;

/**
 * Classe de la classe clerc
 */
public class Clerc extends CharClasse {

 /**
  * Constructeur du clerc
  * Il a 16 pv
  */
 public Clerc() {
  super("Clerc", new Statistiques(16));
 }

 /**
  * Méthode pour avoir la classe
  * @return la classe
  */
 @Override
 public String toString() {return "Clerc";}
}
