package entites.classe;

import entites.Statistiques;

/**
 * Classe de la classe roublard
 */
public class Roublard extends CharClasse {

 /**
  * Constructeur du roublard
  * Il a 12 pv
  */
 public Roublard() {
  super("Roublard",new Statistiques(16));
 }

 /**
  * Méthode pour avoir la classe
  * @return la classe
  */
 @Override
 public String toString() {return "Roublard";}

}

