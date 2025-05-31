package entites;

import java.util.Map;
import static partie.Affichage.afficherPhrase;
import static partie.De.lancerDe;

import donjons.Position;
import donjons.Donjon;


public abstract class Entite {
    private Position m_position;
    private String m_nom;
    private String m_pseudo;
    private String m_type;
    private Statistiques m_statistiques;



    public Entite(String nom) {
     m_nom=nom;
     m_statistiques=new Statistiques();
     m_pseudo=setPseudo(nom);

    }
    public Entite(String nom,Statistiques statistiques) {
        m_nom=nom;
        m_statistiques=statistiques;
    }
    public abstract String setPseudo(String nom);
    public abstract String toString();

    public void perdrePv(int pvRetire) {
        //retire des pv a l'entité subissant une attaque
        this.m_statistiques.retirerPv(pvRetire);
        String phrase =this.getNom() + " perd " + pvRetire + " PV. PV restants : " + this.m_statistiques.getPv();
        afficherPhrase(phrase+"\n");
        //affichage
        est_mort();
    }
    public boolean est_mort(){
        //verifie si l'entite qui vient d'etre attaquer a toujours des points de vie restant
        if(this.m_statistiques.getPv()<=0){
            afficherPhrase(this.getNom() +  "est mort\n");
            //Affichage
            //Sortir l'entite de la liste
            return true;
        }
        return false;
    }
    public void Passer_Le_Tour(){
        //Lorsque l'entite veut mettre fin a son tour elle peut utiliser dormir
        String phrase="je suis fatiguée... je vais me reposer...\n";
        afficherPhrase(phrase);
    }
    public static char changeEntierEnLettre(int number) {

        return (char) ('A'+number);
    }


    public void attaquer(Entite cible) {
        //verifier si la cible est l'assaillant ou plus ou moins d'une case de distance,
        // si c'est 1 case ou moins, on ajoute la force au resultat du lancer, si c'est plus c'est la dexterite
        int degattotaux=0;
        int grandx=0;
        int petitx=0;
        int grandy=0;
        int petity=0;
        if (cible.getPosition().getX()>getPosition().getX()){
            grandx=cible.getPosition().getX();
            petitx=getPosition().getX();
        }
        else {
            grandx=cible.getPosition().getX();
            petitx=getPosition().getX();
        }
        if (cible.getPosition().getY()>getPosition().getY()){
            grandy=cible.getPosition().getY();
            petity=getPosition().getY();
        }
        else {
            grandy=cible.getPosition().getY();
            petity=getPosition().getY();
        }
        String[] decomposeDe = getDegat().split("d"); // ["3", "4"]
        int nombreLancers = Integer.parseInt(decomposeDe[0]);
        int typeDe = Integer.parseInt(decomposeDe[1]);
        degattotaux=lancerDe(typeDe,nombreLancers);
        if ((grandx - petitx < 2) && (grandy - petity < 2)) {
            if (getPortee()==1) {
                if (cible.getArmure() < (lancerDe(1, 20) + this.getStatistiques().getForce())) {
                    cible.perdrePv(degattotaux);
                }
                else{
                    afficherPhrase("la cible résiste a l'attaque\n");
                }
            }
            if((getPortee()<grandx-petitx)||(getPortee()<grandy-petity)) {
                if (cible.getArmure() < (lancerDe(1, 20) + this.getStatistiques().getDexterite())) {
                    cible.perdrePv(degattotaux);
                }
                else{
                    afficherPhrase("la cible résiste a l'attaque\n");
                }
            }
            else {afficherPhrase("hors de portée\n");}
        }
    }

    public Position getPosition() {return m_position;}
    public Statistiques getStatistiques(){return m_statistiques;}
    public String getNom() {
        return m_nom;
    }
    public abstract int getArmure() ;
    public abstract int getPortee() ;

    public abstract String getDegat() ;
}
