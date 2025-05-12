package character;
import lancer.De;

public class Entite {
    protected int positionX;
    protected int positionY;
    protected Statut status;

    public void perdre_Des_Pv(int vieARetirer) {
        //retire des pv a l'entité subissant une attaque
        status.setPointDeVie(status.getPointDeVie()-vieARetirer);
        System.out.println(this.getNom() + " perd " + vieARetirer + " PV. PV restants : " + status.getPointDeVie());
        est_mort();
    }
    public void est_mort(){
        //verifie si l'entite qui vient d'etre attaquer a toujours des points de vie restant
        if (status.getPointDeVie()<=0){
            System.out.println(this.getNom() +  "est mort");
        }
    }
    public void Passer_Le_Tour(){
        //Lorsque l'entite veut mettre fin a son tour elle peut utiliser dormir
        System.out.println("je suis fatiguée... je vais me reposer...");
    }

    public void Deplacement() {
        // Sauvegarde des positions initiales pour les restaurer en cas d'annulation
        int positionInitialeX = positionX;
        int positionInitialeY = positionY;

        int deplacementsRestants = status.getVitesse() / 3;

        System.out.println("Entrez une direction (z = haut, q = gauche, s = bas, d = droite) :");
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Boucle permettant les déplacements
        for (int i = 0; i < deplacementsRestants; i++) {
            System.out.print("Déplacement " + (i + 1) + "/" + deplacementsRestants + " : ");
            char direction = scanner.next().charAt(0);

            switch (direction) {
                case 'z':
                    positionY--;
                case 's':
                    positionY++;
                case 'q':
                    positionX--;
                case 'd':
                    positionX++;
                default:
                    System.out.println("Direction invalide ! Entrez z, q, s ou d uniquement.");
                    i--; // Annule cette itération, car le déplacement n'a pas eu lieu
            }
            System.out.println("Nouvelle position : (" + positionX + ", " + positionY + ")");
        }

        //changer cette partie quand on aura fais les liste de monstre et d'obstacle
        if (positionX < 0 || positionY < 0) {
            // Si la position finale est invalide, annuler tous les déplacements
            System.out.println("Position finale invalide! Revenir à la position de départ.");

            // Retourner à la position de départ
            positionX = positionInitialeX;
            positionY = positionInitialeY;
            System.out.println("Tous vos déplacements ont été annulés. Essayez une autre approche!");
        }
    }

    public void attaquer(Entite cible) {
        //verifier si la cible est l'assaillant ou plus ou moins d'une case de distance ,
        // si cest 1 case ou moins on ajoute la force au resultat du lancer , si c'est plus c'est la dexterite
        if ((cible.positionX - positionX == 1 || cible.positionX-positionX== -1) && (cible.positionY - positionY == 1 || cible.positionY-positionY == -1)) {
            if (cible.getarmure() < (De.lancerDe(20,1)+ status.getForce())){
                cible.perdre_Des_Pv(this.getDegat());
            }
        }
        else if(cible.getarmure()<(De.lancerDe(20,1)+ status.getDexterite())) {
            cible.perdre_Des_Pv(this.getDegat());
        }
        else{
            System.out.println("la cible résiste a l'attaque");
        }
    }

    
    public String getNom() {
        return "";
    }
    public int getarmure(){
        return 0;
    }
    public int getDegat() {
        return 0;
    }
}
