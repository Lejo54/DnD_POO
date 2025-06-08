package donjons;
import entites.jouable.EntiteJouable;
import static partie.Affichage.afficherPhrase;
import static partie.Affichage.demanderChar;

/**
 * Classe représentant une position dans le donjon
 * Contient les coordonnées x et y
 **/
public class Position {
    private int m_x;
    private int m_y;

    /**
     * Constructeur par défaut qui initialise la position à (-1, -1)
     * Utilisé pour les entités et equipement qui n'ont pas de position définie
     */
    public Position() {
         this.m_x = -1;
         this.m_y = -1;
    }

    /**
     * Constructeur qui initialise la position avec des coordonnées spécifiques
     * @param x Coordonnée x de la position
     * @param y Coordonnée y de la position
     */
    public Position(int x, int y) {
        this.m_x = x;
        this.m_y = y;
    }

    /**
     * Méthode pour déplacer une entité dans le donjon
     * On utilise les touches z, q, s, d pour déplacer l'entité (comme un jeu video classique)
     * On peut aussi annuler le déplacement avec la touche o
     * On peut aussi ne pas se deplacer avec la touche r
     * @param donjon Le donjon dans lequel l'entité se déplace
     * @param entite L'entité jouable qui se déplace
     */
    public static void deplacement(Donjon donjon,EntiteJouable entite) {
        // Sauvegarde des positions initiales pour les restaurer en cas d'annulation
        int deplacementsRestants = entite.getStatistiques().getVitesse() / 3;
        int initY= entite.getPosition().getY();
        int initX= entite.getPosition().getX();

        // Boucle permettant les déplacements
        for (int i = 0; i < deplacementsRestants; i++) {
            afficherPhrase("Déplacement " + (i + 1) + "/" + deplacementsRestants + " : \n");
            char direction = demanderChar("""
             Entrez une direction :
             Z vers le haut
             Q vers la gauche
             S vers le bas
             D vers la droite
             A en haut à gauche
             E en haut à droite
             W en bas à gauche
             X en bas à droite
             R pour ne pas se déplacer
             O pour annuler le déplacement et revenir à la position initiale
             
             """);
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

    /**
     * Méthode statique pour vérifier si un déplacement est possible
     * @param x Coordonnée x de la position cible
     * @param y Coordonnée y de la position cible
     * @param donjon Le donjon dans lequel on vérifie le déplacement
     * @return true si le déplacement est possible, false sinon
     */
    public static boolean deplacementEstPossible(int x, int y, Donjon donjon){

        return !((donjon.contientObstacle(x,y)) || (donjon.contientEntite(x,y)) || (x<=0) || (y<=0) || (x>donjon.getTailleX()) || (y>donjon.getTailleY()));
    }

    /**
     * Méthodes d'accès pour les coordonnées x
     * @return la coordonnée x de la position
     **/
    public int getX() {
        return m_x;
    }

    /**
     * Méthodes pour changer les coordonnées x
     * @param newX la nouvelle coordonnée x
     **/
    public void changeX(int newX) {
        this.m_x = newX;
    }

    /**
     * Méthodes d'accès pour les coordonnées y
     * @return la coordonnée y de la position
     **/
    public int getY() {return m_y;}

    /**
     * Méthodes pour changer les coordonnées y
     * @param newY la nouvelle coordonnée y
     **/
    public void changeY(int newY) {
        this.m_y = newY;
    }

    /**
     * Méthodes pour changer les coordonnées x et y
     * @param newX la nouvelle coordonnée x
     * @param newY la nouvelle coordonnée y
     **/
    public void changeXY(int newX, int newY) {
        this.m_x = newX;
        this.m_y = newY;
    }

    /**
     * Méthode toString pour afficher la position sous forme de chaîne de caractères
     * @return la position sous forme de chaîne de caractères
     */
    @Override
    public String toString() {
        return "(" + this.getX() +","+ this.getY() + ')';
        }
    }