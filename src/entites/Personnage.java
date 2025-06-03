package entites;

import java.util.ArrayList;
import java.util.List;

import donjons.Donjon;
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
            if (e.toString().equals("armure")){
                if (e.estEquipe()) {
                    return ((Armure) e).getClasseArmure();
                }
            }
        }
        return 0;
    }

    public void afficherAction(){
        afficherPhrase(this.getNom()+" , c'est à vous, que voulez vous faire ?\n");
        afficherPhrase("1 - attaquer un ennemi\n");
        afficherPhrase("2 - se deplacer dans le donjon\n");
        afficherPhrase("3 - ramasser un équipement\n");
        afficherPhrase("4 - changer d'équipement actif\n");
        afficherPhrase("chaque ligne correspond a une action (1 = action citez à la ligne 1 etc...\n");
    }
    public void choixEquipement(){
        this.afficherEquipement();
        int indexEquipement=demanderInt("Entrez le numéro de l'arme à équiper");
        this.getInventaire().get(indexEquipement).equipe();

    }
    public void afficherEquipement(){
        int i=1;
        for(Equipement e:this.getInventaire()){
            afficherPhrase("Equipement "+i+": ");
            e.afficherInfo();
        }
    }
    public String getDegat(){
        for(Equipement e:m_inventaire){
            if (e.toString().equals("arme")){
                if (e.estEquipe()) {
                    return ((Arme) e).getDegat();
                }
            }
        }
        return "";
    }
    public int getPortee(){
        for(Equipement e:this.getInventaire()){
            if (e.toString().equals("arme")){
                if (e.estEquipe()) {
                    return ((Arme) e).getPortee();
                }
            }
        }
        return 0;}

    public void ramasser(Donjon donjon, Entite entite){
        for (int i=0;i<donjon.getObjets().size();i++) {
            if (this.getPosition().getX() == donjon.getObjets().get(i).getPosition().getX() && this.getPosition().getY()==donjon.getObjets().get(i).getPosition().getY()) {
                donjon.getObjets().get(i).getPosition().changeXY(-1,-1);
                this.getInventaire().add(donjon.getObjets().get(i));
                donjon.getObjets().remove(i);
            }
        }
    }


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
    public List<Equipement> getInventaire() {return m_inventaire;}

}

