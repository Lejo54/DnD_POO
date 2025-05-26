package donjons;
import static entites.Entite.changeEntierEnLettre;
import entites.Entite;
import static partie.Affichage.afficherPhrase;

public class Position {
    private int m_x;
    private int m_y;

    public Position() {
         this.m_x = -1;
         this.m_y = -1;
    }

    public Position(int x, int y) {
        this.m_x = x;
        this.m_y = y;
    }


    public void deplacement(Donjon donjon,Entite entite) {
        // Sauvegarde des positions initiales pour les restaurer en cas d'annulation

        // Sauvegarde des positions initiales pour les restaurer en cas d'annulation

        int deplacementsRestants = entite.getStatistiques().getVitesse() / 3;
        int initY= entite.getPosition().getY();
        int initX= entite.getPosition().getX();
        afficherPhrase("Entrez une direction (z = haut, q = gauche, s = bas, d = droite, o= retour à l'origine) :");
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Boucle permettant les déplacements
        for (int i = 0; i < deplacementsRestants; i++) {
            System.out.print("Déplacement " + (i + 1) + "/" + deplacementsRestants + " : ");
            char direction = scanner.next().charAt(0);
            int oldY= entite.getPosition().getY();
            int oldX= entite.getPosition().getX();
            String erreur= "entite sur le chemin ou passage hors de la carte ";
            switch (direction) {
                case 'z':
                    if(deplacementEstPossible(entite.getPosition().getX(),entite.getPosition().getY()-1, donjon)){
                        entite.getPosition().changeY(entite.getPosition().getY() - 1);
                    }
                    else{
                        i--;
                        afficherPhrase(erreur);
                    }
                    break;
                case 's':
                    if(deplacementEstPossible(entite.getPosition().getX(),entite.getPosition().getY()+1, donjon)){
                        entite.getPosition().changeY(entite.getPosition().getY() + 1);
                    }
                    else{
                        i--;
                        afficherPhrase(erreur);
                    }
                case 'q':
                    if(deplacementEstPossible(entite.getPosition().getX()-1,entite.getPosition().getY(), donjon)){
                        entite.getPosition().changeX(entite.getPosition().getX() - 1);
                    }
                    else{
                        i--;
                        afficherPhrase(erreur);
                    }

                case 'd':
                    if(deplacementEstPossible(entite.getPosition().getX() + 1,entite.getPosition().getY(), donjon)){
                        entite.getPosition().changeX(entite.getPosition().getX() + 1);
                    }
                    else{
                        i--;
                        afficherPhrase(erreur);
                    }
                case 'o':
                    entite.getPosition().changeXY(initX,initY);
                default:
                    afficherPhrase("Direction invalide ! Entrez z, q, s ,d ou o uniquement.");
                    i--; // Annule cette itération, car le déplacement n'a pas eu lieu
            }

            //on transforme la position numérique en alphabétique avec 0=A et 26=Z
            afficherPhrase("Nouvelle position : (" + changeEntierEnLettre(entite.getPosition().getX()) + ", " + entite.getPosition().getY() + ")");
        }
    }

    public boolean deplacementEstPossible(int x, int y, Donjon donjon){

        return !((donjon.contientObstacle(x,y)) && (donjon.contientEntite(x,y)) && (x<=0) && (y<=0));
    }
    public int getX() {
        return m_x;
    }

    public void changeX(int newX) {
        this.m_x = newX;
    }

    public int getY() {
        return m_y;
    }

    public void changeY(int newY) {
        this.m_y = newY;
    }
    public void changeXY(int newX, int newY) {
        this.m_x = newX;
        this.m_y = newY;
    }

    @Override
    public String toString() {
        return "Position{" +
            "x=" + m_x +
            ", y=" + m_y +
            '}';
        }
    }