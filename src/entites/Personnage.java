package entites;

import java.util.ArrayList;
import java.util.List;

import equipements.Arme;
import equipements.Armure;
import equipements.Equipement;
import static partie.De.lancerDe;

public class Personnage extends Entite{
    private Race m_race;
    private CharClasse m_classe;
    private Statistiques m_statistiques;
    private List<Equipement> m_inventaire= new ArrayList<>();

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
    public void fusionStat(){
        m_statistiques=new Statistiques();
        m_statistiques.setDexterite(m_statistiques.getDexterite()+m_race.getStatistiques().getDexterite());
        m_statistiques.setPV(m_classe.getStatistiques().getPv());
        m_statistiques.setForce(m_statistiques.getForce()+m_race.getStatistiques().getForce());
        m_statistiques.setVitesse(m_statistiques.getVitesse()+m_race.getStatistiques().getVitesse());
    }

    public String getType() {
        return "Personnage";
    }
}

