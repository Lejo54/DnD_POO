package entites;

import java.util.ArrayList;
import java.util.List;

import equipements.Armure;
import equipements.Equipement;

public class Personnage extends Entite{
    Race m_race;
    CharClasse m_classe;
    List<Equipement> m_inventaire= new ArrayList<>();

    public Personnage(String nom, Race race, CharClasse classe, List<Equipement> inventaire) {
        super(nom);
        m_race= race;
        m_classe= classe;
        m_inventaire.addAll(inventaire);
    }


    //getters
    public int getarmure(){
        for(Equipement e:m_inventaire){
            if (e.getClass() == Armure.class){
                if (e.estEquipe()) {
                    return ((Armure) e).getClasseArmure();
                }
            }
        }
        return 0;
    }

    public String getType() {
        return "Personnage";
    }
}

