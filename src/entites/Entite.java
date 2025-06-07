package entites;

import java.util.List;
import java.util.Map;

import static entites.EntiteJouable.*;
import static partie.Affichage.*;
import static partie.De.lancerDe;
import donjons.Position;
import donjons.Donjon;
import static entites.Statistiques.setStat;

public abstract class Entite {
    private final String m_nom;
    private final String m_pseudo;
    private Position m_position;
    private Statistiques m_statistiques;

    public Entite(String nom,Position position,Statistiques statistiques) {
        m_nom = nom;
        m_pseudo = setPseudo(nom);
        m_position = position;
        m_statistiques = statistiques;
    }
    public Entite(String nom){
        m_nom = nom;
        m_pseudo = setPseudo(nom);
    }
    public abstract String setPseudo(String nom);
    public String getNom() {
        return m_nom;
    }
    public String getPseudo() {return m_pseudo;}
    public Position getPosition() {return m_position;}
    public Statistiques getStatistiques(){return m_statistiques;}
    public abstract String getDegat() ;

    public abstract void choixAction(Donjon donjon);
    public abstract EntiteJouable choixCible(Donjon donjon);
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
