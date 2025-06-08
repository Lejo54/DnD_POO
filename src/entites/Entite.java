package entites;

import static entites.jouable.EntiteJouable.*;
import static partie.Affichage.*;
import static partie.De.lancerDe;
import donjons.Position;
import donjons.Donjon;
import entites.jouable.EntiteJouable;

/**
 * Classe pour les entites
 * Elles ont un nom, un pseudo, une position, des statistiques
 */
public abstract class Entite {
    private final String m_nom;
    private final String m_pseudo;
    private Position m_position;
    private Statistiques m_statistiques;

    /**
     * Constructeur pour les entités
     * @param nom de l'entité
     * @param position de l'entité
     * @param statistiques de l'entité
     */
    public Entite(String nom,Position position,Statistiques statistiques) {
        m_nom = nom;
        m_pseudo = setPseudo(nom);
        m_position = position;
        m_statistiques = statistiques;
    }

    /**
     * Constructeur pour le MJ qui n'a qu'un nom et un pseudo
     * @param nom du maitre du jeu
     */
    public Entite(String nom){
        m_nom = nom;
        m_pseudo = setPseudo(nom);
    }

    /**
     * Méthode abstraite pour créer le pseudo en fonction du nom et de l'entité
     * @param nom de l'entité
     * @return le pseudo de l'entité
     */
    public abstract String setPseudo(String nom);

    /**
     * Méthode qui renvoie le nom de l'entité
     * @return le nom de l'entité
     */
    public String getNom() {
        return m_nom;
    }

    /**
     * Méthode qui renvoie le pseudo de l'entité
     * @return le pseudo de l'entité
     */
    public String getPseudo() {return m_pseudo;}

    /**
     * Méthode qui renvoie la position de l'entité
     * @return la position
     */
    public Position getPosition() {return m_position;}

    /**
     * Méthode qui renvoie les statistiques de l'entité
     * @return les statistiques
     */
    public Statistiques getStatistiques(){return m_statistiques;}

    /**
     * Méthode qui renvoie les dégats de l'entité sous la forme XdY
     * @return les dégats
     */
    public abstract String getDegat() ;

    /**
     * Méthode abstraite qui permet à une entité de choisir les actions possibles
     * @param donjon donjon dans lequel on veut choisir les actions
     */
    public abstract void choixAction(Donjon donjon);

    /**
     * Méthode abstraite pour choisir une cible
     * @param donjon dans lequel on veut choisir la cible
     * @return l'entite jouable que l'on choisit
     */
    public abstract EntiteJouable choixCible(Donjon donjon);

    /**
     * Méthode pour attaquer une cible
     * On vérifie si l'on peut attaquer la cible, si c'est un MJ on peut attaquer dans tous les cas
     * @param cible entité jouable que l'on veut attaquer
     * @param degats dégats que l'on veut infliger
     */
    public void attaquer(EntiteJouable cible,String degats) {

        int degattotaux=lancerDe(degats);
        //si le MJ attaque, il inflige toujours les dégâts
        if(this.getPseudo().equals("MJ")){
            cible.perdrePv(degattotaux);
            return;
        }
        if (estCorpsACops((EntiteJouable) this,cible)) {
            if (!(estResistant(cible, this.getStatistiques().getForce()))) {
                cible.perdrePv(degattotaux);
            } else {
                afficherPhrase("la cible résiste a l'attaque\n");
            }
        }
        else if(estAPortee((EntiteJouable) this,cible)) {
            if (estResistant(cible, this.getStatistiques().getDexterite())) {
                cible.perdrePv(degattotaux);
            }
            else{
                afficherPhrase("la cible résiste a l'attaque\n");
            }
        }
        else {afficherPhrase("hors de portée\n");}

    }

}
