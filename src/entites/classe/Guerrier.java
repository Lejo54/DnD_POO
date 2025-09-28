package entites.classe;

import entites.Statistiques;

/**
 * Classe de la classe guerrier
 */
public class Guerrier extends CharClasse {

 /**
  * Constructeur du guerrier
  * Il a 20 pv
  */
 public Guerrier() {
  super("Guerrier",new Statistiques(20));
 }

 /**
  * Méthode pour avoir la classe
  * @return la classe
  */
 @Override
 public String toString() {return "Guerrier";}
}
