package entites.jouable;

import donjons.Donjon;
import entites.Entite;
import entites.Statistiques;

import static donjons.Position.deplacement;
import static partie.Affichage.*;

public class Monstre extends EntiteJouable {
    int m_numero;
    int m_portee;
    String m_degat;
    int m_class_armure;

    public Monstre(String espece, int numero, int portee, int classe_armure, Statistiques stat) {
        super(espece,stat);
        m_numero = numero;
        m_portee = portee;
        m_class_armure = classe_armure;
        m_degat = creerDegat();
    }
    public String infoBref(){
       return this.getPseudo()+" "+this.getNom()+"("+this.getStatistiques().getPv()+"/"+this.getStatistiques().getPvMax()+")\n";
    }
    public void afficherInfoEntite(){
        afficherPhrase(this.getNom()+" \n"+"Vie:"+this.getStatistiques().getPv()+"/"+this.getStatistiques().getPvMax()+"\n"+"Degats:"+this.getDegat()+" \n"+"Portee:"+this.getPortee()+"\n"+"Initiative:"+this.getStatistiques().getInitiative()+"\n");
    }
    public int getArmure(){
        return m_class_armure;
    }
    public String getDegat() {
        return m_degat;
    }
    public String toString() {
        return "Monstre";
    }
    public int getPortee(){return m_portee;}
    public int getNumero(){return m_numero;}

    @Override
    public String setPseudo(String nom){
        String pseudo="";
        pseudo+=nom.substring(0, 2).toLowerCase();
        pseudo+=this.getNumero();
        return pseudo;
    }

    public String creerDegat(){
        String nbFace=String.valueOf(demanderInt("Entrez le nombre de face de votre dé de dégat:\n"));
        String nbLancer=String.valueOf(demanderInt("Entrez le numero de lancer de votre dé de dégat:\n"));
        return nbLancer+"d"+nbFace;
    }


    public void afficherAction(){
        afficherPhrase(this.getNom()+" , c'est à vous, que voulez vous faire ?\n");
        afficherPhrase("1 - attaquer un ennemi\n");
        afficherPhrase("2 - se deplacer dans le donjon\n");
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
            case 3:break;
        }
    }
    public EntiteJouable choixCible(Donjon donjon){
        afficherPhrase("Choisissez votre cible \n");
        donjon.afficherEntites();
        int indexCible= demanderInt("Donnez l'indice de la cible\n")-1;
        while (donjon.getAllEntites().get(indexCible).toString().equals("Monstre") && donjon.getAllEntites().get(indexCible)==this){
            indexCible=demanderInt("Indice mauvais: Donnez l'indice d'une cible (la cible doit être un personnage)\n");
        }
        return donjon.getAllEntites().get(indexCible);
    }
    public void ramasser(Donjon donjon, Entite entite){}
    public void choixEquipement(){}
    public void afficherArme(){}
    public void desequiperTout(){}
    public void afficherArmure(){}
    public void afficherEntite(){
        //On affiche les informations du monstre

    }
}
