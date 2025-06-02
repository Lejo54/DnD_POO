package entites;

import java.util.ArrayList;
import java.util.List;

import equipements.Arme;
import equipements.Armure;
import equipements.Equipement;

import static partie.Affichage.*;


public class Personnage extends Entite{
    private Race m_race;
    private String m_nom;
    private CharClasse m_classe;
    private List<Equipement> m_inventaire= new ArrayList<>();

    public Personnage(String nom, Race race, CharClasse classe) {
        super(nom);
        m_race= race;
        m_classe= classe;
        //Faire un inventaire en fonction de la classe avec des switch case

    }


    //getters
    public CharClasse getClasse() { return m_classe; }
    public Race getRace() { return m_race; }
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


    public String infoBref(){
        return this.getPseudo()+" "+this.getNom()+"("+this.getRace()+" "+this.getClasse()+","+ this.getStatistiques().getPv()+"/"+this.getStatistiques().getPvMax()+")";
    }
    public String toString() {
        return "Personnage";
    }
    public String setPseudo(String nom){
        String temp = nom.substring(0, 3); // extrait les 3 premiers caractères
        return temp.substring(0, 1).toUpperCase() + temp.substring(1).toLowerCase();
    }
    public void afficherEntite(){
        //On affiche les information du personnage
    }
}

