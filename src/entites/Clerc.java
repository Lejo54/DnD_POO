package entites;

public class Clerc extends CharClasse{

 public Clerc() {
  Statistiques statistiques = new Statistiques(16);
  super("Clerc",statistiques);
 }
}
