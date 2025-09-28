package donjons;


import entites.*;
import entites.jouable.Personnage;
import entites.jouable.EntiteJouable;
import entites.jouable.Monstre;
import equipements.*;
import equipements.arme.ArmeCourante;
import equipements.arme.ArmeDistante;
import equipements.arme.ArmeGuerre;
import equipements.armure.ArmureLegere;
import equipements.armure.ArmureLourde;

import static entites.jouable.EntiteJouable.afficherBandeauTour;
import static entites.Statistiques.persosVivant;
import static entites.Statistiques.monstresVivant;

import java.util.ArrayList;
import java.util.List;

import static partie.Affichage.*;


/**
 * Classe représentant un donjon
 * Un donjon contient des entités jouables (joueurs et monstres), des obstacles et des objets ramassables
 **/
public class Donjon {
    List<Equipement> m_objetAuSol=new ArrayList<>();
    List<EntiteJouable> m_entites=new ArrayList<>();
    List<Obstacle> m_obstacles=new ArrayList<>();
    Position m_taille;

    /**
     * Constructeur entier de la classe Donjon
     * @param objetAuSol liste des objets ramassables au sol
     * @param entites liste des entités jouables (joueurs et monstres)
     * @param obstacles liste des obstacles présents dans le donjon
     * @param x largeur du donjon (entre 15 et 25)
     * @param y hauteur du donjon (entre 15 et 25)
     **/
    public Donjon(List<Equipement> objetAuSol, List<EntiteJouable> entites,List<Obstacle> obstacles,int x, int y) {
        this.m_objetAuSol = objetAuSol;
        this.m_entites = entites;
        this.m_obstacles = obstacles;
        this.m_taille=new Position(x,y);
    }

    /**
     * Constructeur de la classe Donjon
     * Initialise les entités, les obstacles et les objets ramassables
     * @param x largeur du donjon (entre 15 et 25)
     * @param y hauteur du donjon (entre 15 et 25)
     **/
    public Donjon(int x, int y) {
        this.m_entites = new ArrayList<>();
        setTaille(x,y);
        //Création des obstacles
        creerObstacles(demanderInt("combien d'obstacle se trouveront sur la carte ?\n"));
        this.afficherDonjon();

        //Création des objets ramassables
        List<Equipement> objetAuSol=creerEquipementAuSol(demanderInt("combien d'objet ramassable seront au sol pour les joueurs\n"));
        this.setobjetAuSol(objetAuSol);
        this.afficherDonjon();


    }

    /**
     * Méthode pour créer des équipements au sol du donjon
     * @param nbe nombre d'équipements à créer au sol
     * @return une liste d'équipement créée
     **/
    public List<Equipement> creerEquipementAuSol(int nbe) {
        List<Equipement> res = new ArrayList<>();
        String[] tabstuff = {
         " ","baton", "masse d'armes", "arc court", "arbalete legere", "fronde",
         "epee longue", "rapiere", "epee à deux mains","armure d ecailles","demi plate","cotte de mailles", "harnois"
        };
        Equipement nouvelleArme=null;
        for (int i = 0; i < nbe; i++) {

            this.afficherDonjon();
            afficherPhrase("Quelle est le nom de l'arme parmi celles-ci ?\n");
            for (int j = 1; j < tabstuff.length; j++) {
                afficherPhrase("arme " + (j) + " = " + tabstuff[j]+"\n");
            }
            int numero=0;
            while (numero < 1 || numero > tabstuff.length){
                numero = demanderInt("Veuillez entrer un numéro entre 1 et " + (tabstuff.length)+"\n");
            }
            switch (numero) {
                case 1,2:
                    nouvelleArme = new ArmeCourante(tabstuff[numero],
                     demanderString("Donnez une description pour "+tabstuff[numero]+" ? (sinon appuyez sur entrée)\n"),
                     false);
                    break;

                case 3,4,5:
                    nouvelleArme = new ArmeDistante(tabstuff[numero],
                     demanderString("Donnez une description pour "+tabstuff[numero]+" ? (sinon appuyez sur entrée)"),
                     false);
                    break;

                case 6,7,8:
                    nouvelleArme = new ArmeGuerre(tabstuff[numero],
                     demanderString("Donnez une description pour "+tabstuff[numero]+" ? (sinon appuyez sur entrée)"),
                     false);
                    break;

                case 9,10:
                    nouvelleArme = new ArmureLourde(tabstuff[numero],
                     demanderString("Donnez une description pour "+tabstuff[numero]+" ? (sinon appuyez sur entrée)"),
                     false);
                    break;

                case 11,12:
                    nouvelleArme = new ArmureLegere(tabstuff[numero],
                     demanderString("Donnez une description pour "+tabstuff[numero]+" ? (sinon appuyez sur entrée)"),
                     false);
                    break;
            }
            int x=0,y=0;
            while(x<=0 || x>this.getTailleX() || y<=0 || y>this.getTailleY()) {
                x = demanderInt("position horizontale de votre objet (entre 1 et " + this.getTailleX() + ") ?\n");
                y = demanderInt("position verticale de votre objet (entre 1 et " + this.getTailleY() + ") ?\n");
                nouvelleArme.getPosition().changeXY(x, y);
            }
            res.add(nouvelleArme);
            afficherPhrase("Nouvel équipement ajouté : " + nouvelleArme.getNom() + " à la position " + nouvelleArme.getPosition().toString() + "\n");
        }
        return res;
    }

    /**
     * Méthode pour créer des obstacles au sol du donjon
     * @param nbo nombre d'obstacles à créer au sol
     **/
    public void creerObstacles(int nbo){
        List<Obstacle> res=new ArrayList<>();
        int xd=this.getTailleX();
        int yd=this.getTailleY();
        for(int i =0 ; i<nbo ; i++){
            int x=0,y=0;
            while(x<=0 || x>xd || y<=0 || y>yd) {
                x =demanderInt("position x de votre obstacle (entre 1 et "+xd+") ?\n");
                y =demanderInt("position y de votre obstacle (entre 1 et "+yd+") ?\n");
            }
            res.add(new Obstacle(x,y));
            afficherPhrase("Nouvel obstacle ajouté à la position " + res.get(i).getPosition().toString() + "\n");
        }
        res.addAll(this.getAllObstacles());
        this.setObstacles(res);
    }

    /**
     * Méthode pour créer une liste de monstres dans le donjon
     * Crée une liste de monstres en demandant le nombre d'espèces et le nombre de spécimens par espèce
     * @return une liste de monstres créée
     **/
    public List<Monstre> creerListMonstres(){
        //On demande le nombre d'espèces de monstre
        int nbEspece=0;
        while(nbEspece<=0) {
            nbEspece = demanderInt("Donnez le nombre d'espèce pour les monstres \n");
        }

        //On demande le nom des différentes espèces
        List<String> nomsEspece= new ArrayList<>();
        List<Integer> nbParEspeces= new ArrayList<>();
        int nbParEspece=0;
        for (int i = 0; i < nbEspece; i++) {
            nomsEspece.add(demanderString("Donner le nom de votre espèce N°"+(i+1)+"\n"));
            //On récupère le nombre de spécimen d'une espèce
            nbParEspece=demanderInt("Donner le nombre de spécimen de " + nomsEspece.get(i) + "\n");
            nbParEspeces.add(nbParEspece);
        }
        //On crée la liste des monstres
        List<Monstre> monstres= new ArrayList<>();
        for (int i = 0; i < nbEspece; i++) {
            for (int j = 0; j < nbParEspeces.get(i); j++) {
                List<Entite> entitetemp=new ArrayList<>();
                entitetemp.addAll(monstres);
                //On crée le monstre et on l'ajoute dans la liste des monstres
                this.afficherDonjon();
                monstres.add(creerMonstre(j, nomsEspece.get(i)));
                monstres.get(j).setPosition(this.getTailleX(),this.getTailleY());

            }
        }

        return monstres;
    }

    /**
     * Méthode pour créer un monstre
     * @param numero nombre du spécimen de l'espèce
     * @param espece nom de l'espèce du monstre
     * @return une liste d'équipement créée
     **/
    public Monstre creerMonstre(int numero,String espece){
        int portee= demanderInt("Entrez la portée de l'attaque du monstre (1 pour une attaque au corps à corps):\n");

        //On crée les stat du monstre
        int pv=demanderInt("Nombre de pv du monstre:\n");
        int vitesse= demanderInt("Vitesse du monstre:\n");
        int force=0;
        int dexterite=0;
        if(portee==1){
            force= demanderInt("Force du monstre :\n");
        }
        else {
            dexterite=demanderInt("Dextérité du monstre :\n");
        }
        int initiative= demanderInt("Initiative du monstre :\n");
        Statistiques stat= new Statistiques(pv,force,initiative,vitesse,dexterite);

        int classeArmure= demanderInt("Classe d'armure du monstre:\n");

        return new Monstre(espece,numero,portee,classeArmure,stat);
    }

    /**
     * Méthode pour définir les objets ramassables au sol du donjon
     * @param objetAuSol liste des objets ramassables au sol
     **/
    public void setobjetAuSol(List<Equipement> objetAuSol) {
        this.m_objetAuSol = objetAuSol;
    }

    /**
     * Méthode pour définir les entités du donjon
     * Fusionne les joueurs et les monstres dans une liste d'entités
     * @param joueurs liste des joueurs présents dans le donjon
     **/
    public void setEntites(List<Personnage> joueurs) {
        //Création des monstres
        List<EntiteJouable> entites= new ArrayList<>();
        //ajout des joueurs
        entites.addAll(joueurs);
        entites.addAll(creerListMonstres());
        this.m_entites = this.trierParInitiative(entites);
    }

    /**
     * Méthode pour définir les obstacles du donjon
     * @param obstacles liste des obstacles présents dans le donjon
     **/
    public void setObstacles(List<Obstacle> obstacles) {
        this.m_obstacles = obstacles;
    }

    /**
     * Méthode pour définir la taille du donjon
     * @param x largeur du donjon (entre 15 et 25)
     * @param y hauteur du donjon (entre 15 et 25)
     **/
    public void setTaille(int x, int y) {
        this.m_taille = new Position(x, y);
    }

    /**
     * Méthode pour trier les entités par ordre d'initiative
     * @param entites liste des entités jouables (joueurs et monstres)
     * @return une liste d'entités triées par ordre d'initiative
     **/
    public List<EntiteJouable> trierParInitiative(List<EntiteJouable> entites) {
        //On crée une nouvelle liste qui va être trié par ordre d'initiative
        List<EntiteJouable> entitesTriees = new ArrayList<>(entites);

        // Tri par sélection
        int n = entitesTriees.size();
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (entitesTriees.get(j).getStatistiques().getInitiative() > entitesTriees.get(maxIndex).getStatistiques().getInitiative()) {
                    maxIndex = j;
                }
            }
            // Échange des entités
            EntiteJouable temp = entitesTriees.get(i);
            entitesTriees.set(i, entitesTriees.get(maxIndex));
            entitesTriees.set(maxIndex, temp);
        }
        return entitesTriees;
    }

    /**
     * Retourne la taille du donjon
     * @return taille du donjon sous forme d'objet Position
     **/
    public Position getTaille() {
        return m_taille;
    }

    /**
     * Retourne la longueur du donjon
     * @return longueur du donjon
     **/
    public int getTailleX() {
        return m_taille.getX();
    }

    /**
     * Retourne la hauteur du donjon
     * @return hauteur du donjon
     **/
    public int getTailleY() {
        return m_taille.getY();
    }

    /**
     * Retourne la liste des obstacles du donjon
     * @return liste des obstacles
     **/
    public List<Obstacle> getAllObstacles() {
        return m_obstacles;
    }

    /**
     * Retourne un obstacle spécifique du donjon
     * @return un obstacle à l'index spécifié
     **/
    public Obstacle getObstacle(int index){return m_obstacles.get(index);}

    /**
     * Retourne la liste des objets ramassables au sol du donjon
     * @return liste des objets ramassables
     **/
    public List<Equipement> getAllObjets()
    {
        return m_objetAuSol;
    }

    /**
     * Retourne un objet ramassable spécifique du donjon
     * @return un objet à l'index spécifié
     **/
    public Equipement getObjet(int i)
    {
        return m_objetAuSol.get(i);
    }

    /**
     * Retourne une entité spécifique du donjon
     * @return une entité à l'index spécifié
     **/
    public EntiteJouable getEntite(int i)
    {
        return m_entites.get(i);
    }

    /**
     * Retourne la liste de toutes les entités du donjon
     * @return liste de toutes les entités
     **/
    public List<EntiteJouable> getAllEntites() {
        return m_entites;
    }

    /**
     * Méthode pour lancer les tours de jeu dans le donjon
     * @param nbDonjon numéro du donjon actuel
     * @param mj entité maître du jeu (MJ) qui peut agir à chauque action
     * @return true si la partie est terminée, false sinon
     **/
    public boolean lancerTours(int nbDonjon,Entite mj){
        int tour=0;
        do{
            if (tour==0){
                 for(EntiteJouable entite: this.getAllEntites()){
                     if(entite.toString().equals("Personnage")){
                         entite.choixEquipement();
                     }
                 }
            }
            tour++;
            for (EntiteJouable e:this.getAllEntites()) {
                //choix des actions
                for (int x = 3; x > 0; x--) {
                    if(!persosVivant(this.getAllEntites())){
                        afficherPhrase("Défaite, un des  personnages est mort\n");
                        return true;
                    }
                    afficherBandeauTour(tour,e,this.getAllEntites());
                    afficherDonjon();
                    afficherInfoCase(e);
                    e.afficherInfoEntite();
                    afficherPhrase("vous avez "+x+" action restantes pour ce tour\n");
                    e.choixAction(this);
                    mj.choixAction(this);
                    if (this.victoireDonjon()){
                        if(this.victoirePartie(nbDonjon)){
                            afficherPhrase("Victoire, tout les donjons ont été vaincus\n");
                            return true;
                        }
                        afficherPhrase("Tout les monstres du donjon on été vaincus, passage au donjon suivant\n");
                        for (EntiteJouable entite : this.getAllEntites()) {
                            entite.getStatistiques().healMax();
                            if(entite.toString().equals("Personnage")){
                                entite.desequiperTout();
                            }
                        }
                        return false;
                    }
                }
            }
        } while (!this.victoirePartie(nbDonjon));
        afficherPhrase("pas censé être ici");
        return false;
    }

    /**
     * Méthode pour afficher les entités du donjon
     **/
    public void afficherEntites() {
        String info="";
        for(int i = 0; i<this.getAllEntites().size(); i++){
            info+=(i+1)+". "+this.getEntite(i).infoBref()+"\n";
        }
        afficherPhrase(info+"\n");
    }

    /**
     * Méthode pour afficher les informations de la case où se trouve l'entité
     * @param entite l'entité dont on veut afficher les informations de la case
     **/
    public void afficherInfoCase(EntiteJouable entite){
        for(Equipement e: this.getAllObjets()){
            if(e.getPosition().getX()==entite.getPosition().getX() && e.getPosition().getY()==entite.getPosition().getY()){
                afficherPhrase("Vous êtes sur un objet: "+e.toString()+" "+e.getNom()+"\n");
                return;
            }
        }
        afficherPhrase("Il n'y a rien là oû vous êtes\n");
    }

    /**
     * Méthode pour vérifier si la partie est gagnée
     * Une partie est gagnée si tous les donjons sont gagnés et que tous les personnages sont vivants
     * @return true si la partie est gagnée, false sinon
     **/
    public boolean victoirePartie(int nbDonjon){
     return nbDonjon == 3 && persosVivant(this.getAllEntites());
    }

    /**
     * Méthode pour vérifier si le donjon est gagné
     * Un donjon est gagné si tous les monstres sont morts
     * @return true si le donjon est gagné, false sinon
     **/
    public boolean victoireDonjon(){
        if(persosVivant(this.getAllEntites())){
            if(!monstresVivant(this.getAllEntites(),this.compteurMonstre())){
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode pour afficher les informations du donjon
     * @param n numéro du donjon (pour l'affichage)
     **/
    public void afficherInfoDonjon(int n){
        String info="";
        for(int i=0;i<80;i++){
            info+="*";
        }
        info+="\n\n";
        String d="Donjon numéro "+(n+1)+"\n";
        int espacement=(80+d.length())/4;
        for(int i=0;i<espacement;i++){
            info+=" ";
        }
        info+=d;
        afficherEntites();

        info+="\n" +
         "Nombre de Monstres: "+this.compteurMonstre()+"\n"
        +"Nombre de Joueurs: "+this.compteurJoueur()+"\n\n";
        afficherPhrase(info);
        afficherPhrase("Ordre des initiatives:\n");
        for(EntiteJouable e: this.getAllEntites()){
            afficherPhrase(e.infoBref());
        }
        afficherPhrase("\n");
        this.afficherDonjon();
    }

    /**
     * Méthode pour compter le nombre de joueurs dans le donjon
     * @return le nombre de joueurs dans le donjon
     **/
    public int compteurJoueur(){
        int nbJoueur=0;
        for(EntiteJouable entite : this.getAllEntites()){
            if(entite.toString().equals("Personnage")){
                nbJoueur++;
            }
        }
        return nbJoueur;
    }

    /**
     * Méthode pour compter le nombre de monstres dans le donjon
     * @return le nombre de monstres dans le donjon
     **/
    public int compteurMonstre(){
        int nbMonstre=0;
        for(EntiteJouable entite : this.getAllEntites()){
            if(entite.toString().equals("Monstre")){
                nbMonstre++;
            }
        }
        return nbMonstre;
    }

    /**
     * Méthode pour vérifier si une case contient un obstacle
     * @param x position horizontale de la case
     * @param y position verticale de la case
     * @return true si la case contient un obstacle, false sinon
     **/
    public boolean contientObstacle(int x, int y) {
        for (Obstacle obstacle : this.getAllObstacles()) {
            if (obstacle.getPosition().getX() == x && obstacle.getPosition().getY() == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode pour vérifier si une case contient une entité jouable (joueur ou monstre)
     * @param x position horizontale de la case
     * @param y position verticale de la case
     * @return true si la case contient une entité jouable, false sinon
     **/
    public boolean contientEntite(int x, int y) {
        for (EntiteJouable entite : this.getAllEntites()) {
            if (entite.getPosition().getX() == x && entite.getPosition().getY() == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode pour vérifier si une case contient un équipement
     * @param x position horizontale de la case
     * @param y position verticale de la case
     * @return true si la case contient un équipement, false sinon
     **/
    public boolean contientEquipement(int x, int y) {
        for (Equipement equipement : this.getAllObjets()) {
            if (equipement.getPosition().getX() == x && equipement.getPosition().getY() == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode pour obtenir le nom de l'entité à une position donnée
     * @param x position horizontale de la case
     * @param y position verticale de la case
     * @return le nom de l'entité à cette position, ou une chaîne vide si aucune entité n'est présente
     **/
    public String getNomEntite(int x , int y){
        for(EntiteJouable e:this.getAllEntites()){
            if(e.getPosition().getX()==x && e.getPosition().getY()==y){
                //que le pseudo de l'entité
                return e.getPseudo();
            }
        }
        return "";
    }

    /**
     * Méthode pour afficher le donjon
     * Affiche les entités, les obstacles et les objets ramassables dans le donjon
     **/
    public void afficherDonjon() {
        // Affichage de l'entête des colonnes
        afficherPhrase("    ");
        for (int x = 1; x < this.getTaille().getX()+1; x++) {
            if (x > 9) {
                afficherPhrase(x + " ");
            } else {
                afficherPhrase(" " + x + " ");
            }
        }
        afficherPhrase("\n");

        // Affichage des lignes avec la lettre et le contenu
        for (int y = 1; y < this.getTaille().getY()+1; y++) {
            if(y<10) {
                afficherPhrase(" " + y + "  ");
            }
            else {
                afficherPhrase(y + "  ");
            }

            for (int x = 1; x < this.getTaille().getX()+1; x++) {
                if (this.contientEntite(x, y)) {
                    String petitnom = this.getNomEntite(x, y);
                    afficherPhrase(petitnom);
                } else if (this.contientObstacle(x, y)) {
                    afficherPhrase(" ♦ ");
                } else if (this.contientEquipement(x, y )) {
                    afficherPhrase(" † ");
                } else {
                    afficherPhrase(" ∙ ");
                }
            }
            afficherPhrase("\n");
        }
    }


}
