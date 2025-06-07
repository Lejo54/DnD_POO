package donjons;
import entites.EntiteJouable;
import static partie.Affichage.afficherPhrase;
import static partie.Affichage.demanderChar;
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


    public static void deplacement(Donjon donjon,EntiteJouable entite) {
        // Sauvegarde des positions initiales pour les restaurer en cas d'annulation

        // Sauvegarde des positions initiales pour les restaurer en cas d'annulation

        int deplacementsRestants = entite.getStatistiques().getVitesse() / 3;
        int initY= entite.getPosition().getY();
        int initX= entite.getPosition().getX();
        afficherPhrase("Entrez une direction (z = haut, q = gauche, s = bas, d = droite, o= retour à l'origine) :\n");
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Boucle permettant les déplacements
        for (int i = 0; i < deplacementsRestants; i++) {
            System.out.print("Déplacement " + (i + 1) + "/" + deplacementsRestants + " : \n");
            char direction = demanderChar("Entrez une direction (z,q,s,d, o pour l'origine, r pour rester sur place)\n");
            int oldY= entite.getPosition().getY();
            int oldX= entite.getPosition().getX();
            String erreur= "entite sur le chemin ou passage hors de la carte \n";
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
                    break;
                case 'q':
                    if(deplacementEstPossible(entite.getPosition().getX()-1,entite.getPosition().getY(), donjon)){
                        entite.getPosition().changeX(entite.getPosition().getX() - 1);
                    }
                    else{
                        i--;
                        afficherPhrase(erreur);
                    }
                    break;
                case 'd':
                    if(deplacementEstPossible(entite.getPosition().getX() + 1,entite.getPosition().getY(), donjon)){
                        entite.getPosition().changeX(entite.getPosition().getX() + 1);
                    }
                    else{
                        i--;
                        afficherPhrase(erreur);
                    }
                    break;
                case 'a':
                    if(deplacementEstPossible(entite.getPosition().getX() - 1,entite.getPosition().getY() - 1, donjon)){
                        entite.getPosition().changeXY(entite.getPosition().getX() - 1, entite.getPosition().getY() - 1);
                    }
                    else{
                        i--;
                        afficherPhrase(erreur);
                    }
                    break;
                case 'e':
                    if(deplacementEstPossible(entite.getPosition().getX() + 1,entite.getPosition().getY() - 1, donjon)){
                        entite.getPosition().changeXY(entite.getPosition().getX() + 1,entite.getPosition().getY() - 1);
                    }
                    else{
                        i--;
                        afficherPhrase(erreur);
                    }
                    break;
                case 'w':
                    if(deplacementEstPossible(entite.getPosition().getX() - 1,entite.getPosition().getY() + 1, donjon)){
                        entite.getPosition().changeXY(entite.getPosition().getX() - 1,entite.getPosition().getY() + 1);
                    }
                    else{
                        i--;
                        afficherPhrase(erreur);
                    }
                    break;
                case 'x':
                    if(deplacementEstPossible(entite.getPosition().getX() + 1,entite.getPosition().getY() + 1, donjon)){
                        entite.getPosition().changeXY(entite.getPosition().getX() + 1,entite.getPosition().getY() + 1);
                    }
                    else{
                        i--;
                        afficherPhrase(erreur);
                    }
                    break;
                case 'o':
                    entite.getPosition().changeXY(initX,initY);
                    i=0;

                    break;
                case 'r':
                    break;
                default:
                    afficherPhrase("Direction invalide ! Entrez z, q, s ,d ou o uniquement.\n");
                    i--; // Annule cette itération, car le déplacement n'a pas eu lieu
                    break;
            }

            donjon.afficherDonjon();
            //on transforme la position numérique en alphabétique avec 0=A et 26=Z
            afficherPhrase("Nouvelle position : (" + entite.getPosition().toString() + ")\n");
        }
    }

    public static boolean deplacementEstPossible(int x, int y, Donjon donjon){

        return !((donjon.contientObstacle(x,y)) || (donjon.contientEntite(x,y)) || (x<=0) || (y<=0) || (x>donjon.getTailleX()) || (y>donjon.getTailleY()));
    }
    public int getX() {
        return m_x;
    }
    public void changeX(int newX) {
        this.m_x = newX;
    }
    public int getY() {return m_y;}
    public void changeY(int newY) {
        this.m_y = newY;
    }
    public void changeXY(int newX, int newY) {
        this.m_x = newX;
        this.m_y = newY;
    }
    @Override
    public String toString() {
        return "(" + this.getX() +","+ this.getY() + ')';
        }
    }