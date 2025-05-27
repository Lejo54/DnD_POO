package entites;

import java.util.ArrayList;
import java.util.List;

import equipements.Arme;
import equipements.Armure;
import equipements.Equipement;

public class Personnage extends Entite{
    Race m_race;
    CharClasse m_classe;
    List<Equipement> m_inventaire= new ArrayList<>();

    public Personnage(String nom, Race race, CharClasse classe) {
        super(nom);
        m_race= race;
        m_classe= classe;
        //Faire un inventaire en fonction de la classe avec des switch case

    }


    //getters
    public int getArmure(){
        for(Equipement e:m_inventaire){
            if (e.getType().equals("armure")){
                if (e.estEquipe()) {
                    return ((Armure) e).getClasseArmure();
                }
            }
        }
        return 0;
    }

    public String getDegat(){
        for(Equipement e:m_inventaire){
            if (e.getType().equals("arme")){
                if (e.estEquipe()) {
                    return ((Arme) e).getDegat();
                }
            }
        }
        return "";
    }
    public int getPortee(){
        for(Equipement e:m_inventaire){
            if (e.getType().equals("arme")){
                if (e.estEquipe()) {
                    return ((Arme) e).getPortee();
                }
            }
        }
        return 0;}

    public String getType() {
        return "Personnage";
    }
}

