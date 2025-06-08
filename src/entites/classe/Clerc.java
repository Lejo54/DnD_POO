package entites.classe;

import entites.Statistiques;

public class Clerc extends CharClasse {

 public Clerc() {
  super("Clerc", new Statistiques(16));
 }
 public String toString() {return "Clerc";}
}
