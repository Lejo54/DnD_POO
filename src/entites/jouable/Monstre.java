package entites.jouable;

import donjons.Donjon;
import entites.Entite;
import entites.Statistiques;

import static donjons.Position.deplacement;
import static partie.Affichage.*;

/**
 * Classe des monstres
 * Ils ont un numéro, une portée, des dégats, une classe d'armure
 */
public class Monstre extends EntiteJouable {
    int m_numero;
    int m_portee;
    String m_degat;
    int m_classArmure;

    /**
     * Constructeur des monstres
     * @param espece du monstre
     * @param numero du monstre
     * @param portee du monstre
     * @param classeArmure du monstre
     * @param stat statistiques du monstre
     */
    public Monstre(String espece, int numero, int portee, int classeArmure, Statistiques stat) {
        super(espece,stat);
        m_numero = numero;
        m_portee = portee;
        m_classArmure = classeArmure;
        m_degat = creerDegat();
    }

    /**
     * Méthode qui renvoie les informations brèves du monstre
     * @return les informations du monstre
     */
    public String infoBref(){
       return this.getPseudo()+" "+this.getNom()+"("+this.getStatistiques().getPv()+"/"+this.getStatistiques().getPvMax()+")\n";
    }

    /**
     * Méthode pour afficher les informations du monstre
     */
    public void afficherInfoEntite(){
        afficherPhrase(this.getNom()+" \n"+"Vie:"+this.getStatistiques().getPv()+"/"+this.getStatistiques().getPvMax()+"\n"+"Degats:"+this.getDegat()+" \n"+"Portee:"+this.getPortee()+"\n"+"Initiative:"+this.getStatistiques().getInitiative()+"\n");
    }

    /**
     * Méthode pour avoir la classe d'armure
     * @return la classe d'armure
     */
    public int getArmure(){
        return m_classArmure;
    }

    /**
     * Méthode pour avoir les dégats
     * @return les dégats
     */
    public String getDegat() {
        return m_degat;
    }

    /**
     * Méthode pour avoir le type d'entité
     * @return le type du monstre
     */
    public String toString() {
        return "Monstre";
    }

    /**
     * Méthode pour avoir la portée
     * @return la portée
     */
    public int getPortee(){return m_portee;}

    /**
     * Méthode pour avoir le numéro
     * @return le numéro du monstre
     */
    public int getNumero(){return m_numero;}

    /**
     * Méthode pour créer le pseudo du monstre
     * Le pseudo ets composé des deux premières lettres de l'espèce et de son numéro
     * @param nom de l'entité
     * @return le pseudo
     */
    @Override
    public String setPseudo(String nom){
        String pseudo="";
        pseudo+=nom.substring(0, 2).toLowerCase();
        pseudo+=this.getNumero();
        return pseudo;
    }

    /**
     * Méthode pour créer le dé de dégats pour le monstre
     * @return le dé de dégats
     */
    public String creerDegat(){
        String nbFace=String.valueOf(demanderInt("Entrez le nombre de face de votre dé de dégat:\n"));
        String nbLancer=String.valueOf(demanderInt("Entrez le numero de lancer de votre dé de dégat:\n"));
        return nbLancer+"d"+nbFace;
    }

    /**
     * Méthode pour afficher les actions possibles du monstre
     */
    public void afficherAction(){
        afficherPhrase(this.getNom()+" , c'est à vous, que voulez vous faire ?\n");
        afficherPhrase("1 - attaquer un ennemi\n");
        afficherPhrase("2 - se deplacer dans le donjon\n");
        afficherPhrase("3 - Ne rien faire\n");
        afficherPhrase("chaque ligne correspond a une action (1 = action citez à la ligne 1 etc...\n");
    }

    /**
     * Méthode pour que le monstre puisse choisir les actions possibles
     * @param donjon donjon dans lequel on veut choisir les actions
     */
    public void choixAction(Donjon donjon) {
        this.afficherAction();
        int indexAction= demanderInt("Quelle est votre action ?\n");
        switch (indexAction){
            case 1: this.attaquer(choixCible(donjon),this.getDegat());
                break;
            case 2: deplacement(donjon,this);
                break;
            case 3: afficherPhrase("Vous ne faites rien pour ce tour\n");
                break;
            default:break;
        }
    }

    /**
     * Méthode pour choisir la cible qui doit être obligatoirement un personnage
     * @param donjon dans lequel on veut choisir la cible
     * @return le personnage choisi
     */
    public EntiteJouable choixCible(Donjon donjon){
        afficherPhrase("Choisissez votre cible \n");
        donjon.afficherEntites();
        int indexCible= demanderInt("Donnez l'indice de la cible\n")-1;
        while (donjon.getAllEntites().get(indexCible).toString().equals("Monstre") && donjon.getAllEntites().get(indexCible)==this){
            indexCible=demanderInt("Indice mauvais: Donnez l'indice d'une cible (la cible doit être un personnage)\n");
        }
        return donjon.getAllEntites().get(indexCible);
    }

    /**
     * Méthode pour ramasser un équipement, non implémentée pour l'instant
     * @param donjon donjon dans lequel on veut ramasser l'équipement
     */
    public void ramasser(Donjon donjon){}

    /**
     * Méthode non implémentée pour l'instant
     */
    public void choixEquipement(){}

    /**
     * Méthode non implémentée pour l'instant
     */
    public void desequiperTout(){}

}
