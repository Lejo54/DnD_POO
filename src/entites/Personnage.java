package entites;

import java.util.ArrayList;
import java.util.List;

import equipements.Armure;
import equipements.Equipement;

public class Personnage {
    String nom;
    String race;
    String classe;
    List<Equipement> inventaire= new ArrayList<>();


    //get nom qui renvoie le nom du personnage et qui remplace getnom de entite


    public Personnage(String nom, String race, String classe, List<Equipement> inventaire) {
        this.nom = nom;
        this.race = race;
        this.classe = classe;
        this.inventaire = inventaire;
    }

    public String getNom() {
        return nom;
    }
    public int getarmure(){
        for(Equipement e:inventaire){
            if (e instanceof Armure){
                if (e.estEquipe()) {
                    return ((Armure) e).getClasseArmure();
                }
            }
        }
        return 0;
    }

    public int getDegat() {
        return 0;
    }
    public String getType() {
        return "Personnage";
    }
}

