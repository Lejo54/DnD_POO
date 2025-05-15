package Entites;

import java.util.ArrayList;
import java.util.List;

import stuff.Armure;
import stuff.Equipement;
import stuff.Arme;

public class Personnage {
    String m_nom;
    Race m_race;
    CharClasse m_classe;
    List<Equipement> inventaire= new ArrayList<>();
    Armure m_armureequipe;
    Arme m_armeequipe;


    //get nom qui renvoie le nom du personnage et qui remplace getnom de entite
    public String getNom() {
        return m_nom;
    }
    public int getArmure(){
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
