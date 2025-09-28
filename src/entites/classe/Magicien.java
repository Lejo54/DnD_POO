package entites.classe;

import entites.Statistiques;

/**
 * Classe de la classe magicien
 */
public class Magicien extends CharClasse {

 /**
  * Constructeur du magicien
  * Il a 12 pv
  */
 public Magicien() {
  super("Magicien",new Statistiques(12));
 }

 /**
  * Méthode pour avoir la classe
  * @return la classe
  */
 @Override
 public String toString() {return "Magicien";}
}
