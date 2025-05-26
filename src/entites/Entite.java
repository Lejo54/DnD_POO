package entites;

import static partie.Affichage.afficherPhrase;
import static partie.De.lancerDe;

import donjons.Position;
import donjons.Donjon;


public abstract class Entite {
    private Position m_position;
    //private Action m_action;
    private String m_nom;
    private Statistiques m_statistiques;
    private Donjon m_donjon;
    private String m_pseudo;


    public void changementDonjon(Donjon donjon) {
        m_donjon = donjon;
    }
    public Donjon getDonjon() {return m_donjon;}
    public void perdrePv(int pvRetire) {
        //retire des pv a l'entité subissant une attaque
        this.m_statistiques.retirerPv(pvRetire);
        String phrase =this.getNom() + " perd " + pvRetire + " PV. PV restants : " + this.m_statistiques.getPv();
        afficherPhrase(phrase);
        //affichage
        est_mort();
    }
    public boolean est_mort(){
        //verifie si l'entite qui vient d'etre attaquer a toujours des points de vie restant
        if(this.m_statistiques.getPv()<=0){
            afficherPhrase(this.getNom() +  "est mort");
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
    public static char changeEntierEnLettre(int number) {

        return (char) ('A'+number);
    }

    public void attaquer(Entite cible) {
         //verifier si la cible est l'assaillant ou plus ou moins d'une case de distance,
        // si c'est 1 case ou moins, on ajoute la force au resultat du lancer, si c'est plus c'est la dexterite
        int degattotaux=0;
        String[] decomposeDe = getDegat().split("d"); // ["3", "4"]
        int nombreLancers = Integer.parseInt(decomposeDe[0]);
        int typeDe = Integer.parseInt(decomposeDe[1]);
        degattotaux=lancerDe(typeDe,nombreLancers);
        if ((cible.getPosition().getX() - m_position.getX() == 1 || cible.getPosition().getX()-getPosition().getX()== -1) && (cible.getPosition().getY() - getPosition().getY() == 1 || cible.getPosition().getY()-getPosition().getY() == -1)) {
            if (getPortee()==1) {
                if (cible.getArmure() < (lancerDe(1, 20) + this.getStatistiques().getForce())) {
                    cible.perdrePv(degattotaux);
                }
            }
            if(getPortee()>1) {
                if (cible.getArmure() < (lancerDe(1, 20) + this.getStatistiques().getDexterite())) {
                    cible.perdrePv(degattotaux);
                }
            }
            else{
                afficherPhrase("la cible résiste a l'attaque");
            }
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
