package entites.jouable;

import java.util.ArrayList;
import java.util.List;

import donjons.Donjon;
import entites.Entite;
import entites.classe.CharClasse;
import entites.race.Race;
import equipements.*;
import equipements.arme.Arme;
import equipements.arme.ArmeCourante;
import equipements.arme.ArmeDistante;
import equipements.arme.ArmeGuerre;
import equipements.armure.Armure;
import equipements.armure.ArmureLegere;
import equipements.armure.ArmureLourde;

import static donjons.Position.deplacement;
import static partie.Affichage.*;


public class Personnage extends EntiteJouable {
    private Race m_race;
    private String m_nom;
    private CharClasse m_classe;
    private List<Equipement> m_inventaire= new ArrayList<>();

    public Personnage(String nom, Race race, CharClasse classe) {
        super(nom);
        m_race= race;
        m_classe= classe;

        //Faire un inventaire en fonction de la classe
        m_inventaire.addAll(baseStuff(classe));
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

    public List<Equipement> baseStuff(CharClasse classe){
        List<Equipement> equipements= new ArrayList<>();
        switch(classe.toString()){
            case "Clerc":
                equipements.add(new ArmeCourante("masse d arme","",false));
                equipements.add(new ArmeDistante("arbalete legere","",false));
                equipements.add(new ArmureLourde("armure d ecaille","",false));
                break;
            case "Magicien":
                equipements.add(new ArmeDistante("fronde","",false));
                equipements.add(new ArmeCourante("baton","c'est un beau baton",false));
                break;
            case "Roublard":
                equipements.add(new ArmeDistante("arc court","",false));
                equipements.add(new ArmeGuerre("rapiere","",false));
                break;
            case "Guerrier":
                equipements.add(new ArmureLegere("cotte de mailles","",false));
                equipements.add(new ArmeGuerre("epee longue","",false));
                equipements.add(new ArmeDistante("arbalete legere","",false));
                break;
        }
        return equipements;
    }

    public void afficherAction(){
        afficherPhrase(this.getNom()+" , c'est à vous, que voulez vous faire ?\n");
        afficherPhrase("1 - attaquer un ennemi\n");
        afficherPhrase("2 - se deplacer dans le donjon\n");
        afficherPhrase("3 - ramasser un équipement\n");
        afficherPhrase("4 - changer d'équipement actif\n");
        afficherPhrase("5 - Ne rien faire\n");
        afficherPhrase("chaque ligne correspond a une action (1 = action citez à la ligne 1 etc...\n");
    }
    public void choixAction(Donjon donjon) {
        this.afficherAction();
        int indexAction= demanderInt("Quelle est votre action ?\n");
        switch (indexAction){
            case 1: this.attaquer(choixCible(donjon),this.getDegat());
                break;
            case 2: deplacement(donjon,this);
                break;
            case 3: this.ramasser(donjon,this);
                break;
            case 4: this.changementEquipement();
                break;
            case 5: break;
        }
    }
    public void desequiperTout(){
        for(Equipement e:m_inventaire){
            if(e.estEquipe()){
                e.desequipe(this);
            }
        }
    }
    public EntiteJouable choixCible(Donjon donjon){
        afficherPhrase("Choisissez votre cible \n");
        donjon.afficherEntites();
        int indexCible= demanderInt("Donnez l'indice de la cible\n")-1;
        while (donjon.getAllEntites().get(indexCible).toString().equals("Personnage") && donjon.getAllEntites().get(indexCible)==this){
            indexCible=demanderInt("Indice mauvais: Donnez l'indice d'une cible (la cible doit être un monstre)\n")-1;
        }
        return donjon.getAllEntites().get(indexCible);
    }
    public void choixEquipement(){
        afficherPhrase(this.getNom()+"\n");
        for(int i=0;i<2;i++) {
            this.afficherEquipements();
            int indexEquipement = demanderInt("Entrez le numéro de l'arme à équiper: \n") - 1;
            this.getInventaire().get(indexEquipement).equipe(this);
        }
    }
    public void changementEquipement(){
        afficherPhrase(this.getNom()+"\n");
        for(int i=0;i<2;i++) {
            this.afficherEquipements();
            int indexEquipement = demanderInt("Entrez le numéro de l'arme à équiper: \n") - 1;
            if(this.getInventaire().get(indexEquipement).toString().equals("arme")){
                this.getArmeEquipee().desequipe(this);
            }
            else {
                this.getArmureEquipee().desequipe(this);
            }
            this.getInventaire().get(indexEquipement).equipe(this);
        }
    }
    public void afficherEquipements(){
        int i=1;
        for(Equipement e:this.getInventaire()){
            afficherPhrase("Equipement "+i+": ");
            e.afficherInfo();
            i++;
        }
    }
    public String getDegat(){
        for(Equipement e:this.getInventaire()){
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
        for (int i=0;i<donjon.getAllObjets().size();i++) {
            if (this.getPosition().getX() == donjon.getObjet(i).getPosition().getX() && this.getPosition().getY()==donjon.getObjet(i).getPosition().getY()) {
                donjon.getObjet(i).getPosition().changeXY(-1,-1);
                this.getInventaire().add(donjon.getObjet(i));
                donjon.getAllObjets().remove(i);
                return;
            }
        }
        afficherPhrase("Aucun objet à ramasser ici\n");
    }

    public void afficherInfoEntite(){
        afficherPhrase(this.getNom()+" \n"
         +"Armure:");
        this.afficheArmureEquipee();
        afficherPhrase("Arme:");
        this.afficheArmeEquipee();
        this.getStatistiques().afficherStat();
    }

    public String infoBref(){
        return this.getPseudo()+" "+this.getNom()+"("+this.getRace().toString()+" "+this.getClasse().toString()+","+ this.getStatistiques().getPv()+"/"+this.getStatistiques().getPvMax()+")\n";
    }
    public void afficheArmureEquipee(){
        for(Equipement e:this.getInventaire()){
            if (e.toString().equals("armure") && e.estEquipe()){
                e.afficherInfo();
            }
        }
    }
    public void afficheArmeEquipee(){
        for(Equipement e:this.getInventaire()){
            if (e.toString().equals("arme") && e.estEquipe()){
                e.afficherInfo();
            }
        }
    }
    public Arme getArmeEquipee(){
        for(Equipement e:this.getInventaire()){
            if (e.toString().equals("arme") && e.estEquipe()){
                return (Arme) e;
            }
        }
        return null;
    }
    public Armure getArmureEquipee(){
        for(Equipement e:this.getInventaire()){
            if (e.toString().equals("armure") && e.estEquipe()){
                return (Armure) e;
            }
        }
        return null;
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

