package entites.classe;

import entites.Statistiques;

public class Magicien extends CharClasse {
 public Magicien() {
  super("Magicien",new Statistiques(12));
 }
 public String toString() {return "Magicien";}
}
