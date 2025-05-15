package Entites;

import static Partie.De.lancerDe;

import donjons.Position;
import donjons.Donjon;

public class Entite {
    private Position m_position;
    //private Action m_action;
    private String m_nom;
    private Statistiques m_statistiques;

    public void perdrePv(int pvRetire) {
        //retire des pv a l'entité subissant une attaque
        this.m_statistiques.retirerPv(pvRetire);
        String phrase =this.getNom() + " perd " + pvRetire + " PV. PV restants : " + this.m_statistiques.getPv();
        //affichage
        est_mort();
    }
    public boolean est_mort(){
        //verifie si l'entite qui vient d'etre attaquer a toujours des points de vie restant
        if(this.m_statistiques.getPv()<=0){
            affichePhrase(this.getNom() +  "est mort");
            //Affichage
            //Sortir l'entite de la liste
            return true;
        }
        return false;
    }
    public void Passer_Le_Tour(){
        //Lorsque l'entite veut mettre fin a son tour elle peut utiliser dormir
        String phrase="je suis fatiguée... je vais me reposer...";
    }

    public void deplacement() {
        // Sauvegarde des positions initiales pour les restaurer en cas d'annulation

        // Sauvegarde des positions initiales pour les restaurer en cas d'annulation

        int deplacementsRestants = this.m_statistiques.getVitesse() / 3;
        int initY= this.m_position.getY();
        int initX= this.m_position.getX();
        affichePhrase("Entrez une direction (z = haut, q = gauche, s = bas, d = droite, o= retour à l'origine) :");
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Boucle permettant les déplacements
        for (int i = 0; i < deplacementsRestants; i++) {
            System.out.print("Déplacement " + (i + 1) + "/" + deplacementsRestants + " : ");
            char direction = scanner.next().charAt(0);
            int oldY= this.m_position.getY();
            int oldX= this.m_position.getX();
            String erreur= "entite sur le chemin ou passage hors de la carte ";
            switch (direction) {
                case 'z':
                    if(deplacementEstPossible(this.m_position.getX(),this.m_position.getY()-1)){
                        this.m_position.changeY(this.m_position.getY() - 1);
                    }
                    else{
                        i--;
                        affichePhrase(erreur);
                    }
                    break;
                case 's':
                    if(deplacementEstPossible(this.m_position.getX(),this.m_position.getY()+1)){
                        this.m_position.changeY(this.m_position.getY() + 1);
                    }
                    else{
                        i--;
                        affichePhrase(erreur);
                    }
                case 'q':
                    if(deplacementEstPossible(this.m_position.getX()-1,this.m_position.getY())){
                        this.m_position.changeX(this.m_position.getX() - 1);
                    }
                    else{
                        i--;
                        affichePhrase(erreur);
                    }

                case 'd':
                    if(deplacementEstPossible(this.m_position.getX() + 1,this.m_position.getY())){
                        this.m_position.changeX(this.m_position.getX() + 1);
                    }
                    else{
                        i--;
                        affichePhrase(erreur);
                    }
                case 'o':
                    this.m_position.changeXY(initX,initY);
                default:
                    System.out.println("Direction invalide ! Entrez z, q, s ,d ou o uniquement.");
                    i--; // Annule cette itération, car le déplacement n'a pas eu lieu
            }

            //on transforme la position numérique en alphabétique avec 0=A et 26=Z
            affichePhrase("Nouvelle position : (" + this.changeEntierEnLettre(this.m_position.getX()) + ", " + this.m_position.getY() + ")");
        }
    }
    public char changeEntierEnLettre(int number) {
        return (char) ('A'+number);
    }
    public boolean deplacementEstPossible(int x, int y, Donjon donjon){
        return !(donjon.contientObstacle(x, y) || donjon.contientEntite(x, y) || x <= 0 || y <= 0);
    }

    public void attaquer(Entite cible) {
        //verifier si la cible est l'assaillant ou plus ou moins d'une case de distance ,
        // si cest 1 case ou moins on ajoute la force au resultat du lancer , si c'est plus c'est la dexterite
        int degattotaux=0;
        String[] decomposeDe = getDegat().split("d"); // ["3", "4"]
        int nombreLancers = Integer.parseInt(decomposeDe[0]);
        int typeDe = Integer.parseInt(decomposeDe[1]);
        degattotaux=lancerDe(typeDe,nombreLancers);
        if ((cible.m_position.getX() - m_position.getX()== 1 || cible.m_position.getX()-m_position.getX()== -1) && (cible.m_position.getY() - m_position.getY() == 1 || cible.m_position.getY()-m_position.getY() == -1)) {
            if (cible.getArmure() < (lancerDe(20,1)+ this.m_statistiques.getForce())){
                cible.perdrePv(degattotaux);
            }
        }
        else if(cible.getArmure()<(lancerDe(20,1)+ this.m_statistiques.getDexterite())) {

            cible.perdrePv(degattotaux);
        }
        else{
            System.out.println("la cible résiste a l'attaque");
        }
    }


    public String getNom() {
        return m_nom;
    }
    public int getArmure(){
        return 0;
    }
    public String getDegat() {
        return "";
    }
}

