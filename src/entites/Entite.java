package entites;

import java.util.Map;
import static partie.Affichage.afficherPhrase;
import static partie.De.lancerDe;

import donjons.Position;
import donjons.Donjon;


public abstract class Entite {
    private Position m_position;
    private String m_nom;
    private Statistiques m_statistiques;



    public Entite(String nom) {
     m_nom=nom;
     m_statistiques=new Statistiques();

    }

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
            afficherPhrase(this.getNom() +  "est mort");
            //Affichage
            //Sortir l'entite de la liste
            return true;
        }
        return false;
    }
    public void Passer_Le_Tour(){
        afficherPhrase("je suis fatiguée... je vais me reposer...");
    }


    public static char changeEntierEnLettre(int number) {

        return (char) ('A'+number);
    }


    public void attaquer(Entite cible) {
        this.m_actions.put("attaquer",true);
         //verifier si la cible est l'assaillant ou plus ou moins d'une case de distance,
        // si c'est 1 case ou moins, on ajoute la force au resultat du lancer, si c'est plus c'est la dexterite
        int degattotaux=0;
        String[] decomposeDe = getDegat().split("d"); // ["3", "4"]
        int nombreLancers = Integer.parseInt(decomposeDe[0]);
        int typeDe = Integer.parseInt(decomposeDe[1]);
        degattotaux=lancerDe(typeDe,nombreLancers);
        if ((cible.m_position.getX() - m_position.getX() == 1 || cible.m_position.getX()-m_position.getX()== -1) && (cible.m_position.getY() - m_position.getY() == 1 || cible.m_position.getY()-m_position.getY() == -1)) {
            if (cible.getArmure() < (lancerDe(20,1)+ this.m_statistiques.getForce())){
                cible.perdrePv(degattotaux);
            }
        }
        else if(cible.getArmure()<(lancerDe(20,1)+ this.m_statistiques.getDexterite())) {

            cible.perdrePv(degattotaux);
        }
        else{
            afficherPhrase("la cible résiste a l'attaque");
        }


    }
    public boolean getStatusAction(String action) { return m_actions.get(action); }
    public Position getPosition() {return m_position;}
    public Statistiques getStatistiques(){return m_statistiques;}
    public String getNom() {
        return m_nom;
    }
    public int getArmure(){
        return 0;
    }
    public Map<String,Boolean> getActions() {return m_actions;}

}
