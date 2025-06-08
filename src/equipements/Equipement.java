package equipements;

import donjons.Position;
import entites.Statistiques;
import entites.jouable.Personnage;

import static entites.Statistiques.*;

/**
 * Classe abstraite des équipements.
 * Ils ont un nom, une description, une position s'ils sont placé au sol
 * des statistiques, un boolean pour dire s'ils sont équipé ou non.
 */
public abstract class Equipement {
    boolean m_actif=false;
    String m_nom;
    String m_description;
    Position m_position;
    Statistiques m_stat;

    /**
     * Constructeur d'un équipement
     * @param nom de l'équipement
     * @param description de l'équipement
     * @param actif true s'il est équipé, false sinon
     * @param stat statistique de l'équipement
     */
    public Equipement(String nom, String description, boolean actif,Statistiques stat) {
        this.m_nom = nom;
        this.m_description = description;
        this.m_actif = actif;
        m_position=new Position();
        m_stat=stat;
    }

    /**
     * Méthode abstraite pour afficher les informations de l'arme
     */
    public abstract void afficherInfo();

    /**
     * Méthode pour avoir le type de l'équipement
     * @return le type de l'équipement
     */
    public String toString(){return "equipement";}

    /**
     * Méthode qui renvoit si l'équipement est équipé ou non
     * @return true s'il est équipé, false sinon
     */
    public boolean estEquipe() {
        return m_actif;
    }

    /**
     * Méthode pour avoir le nom de l'équipement
     * @return le nom de l'équipement
     */
    public String getNom(){
        return m_nom;
    }

    /**
     * Méthode pour avoir la position de l'équipement
     * @return la position de l'arme
     */
    public Position getPosition(){return m_position;}

    /**
     * Méthode qui retourne les statistiques de l'équipement
     * @return les statistiques de l'équipement
     */
    public Statistiques getStat(){return m_stat;}

    /**
     * Méthode pour équiper un équipement
     * Reforme ses statistiques si l'arme a des bonus ou malus
     */
    public void equipe(Personnage p){
        this.m_actif=true;
        if(this.toString().equals("arme")){
            setStatAjoutArme(p);
        }
        else {
            setStatAjoutArmure(p);
        }
    }

    /**
     * Méthode pour déséquiper un équipement
     * Reforme ses statistiques si l'arme a des bonus ou malus
     */
    public void desequipe(Personnage p){
        if(p.getArmureEquipee()==null) return;
        if(p.getArmeEquipee()==null) return;
        if(this.toString().equals("arme")){
            setStatRetireArme(p);
        }
        else {
            setStatRetireArmure(p);
        }
        this.m_actif=false;

    }

}

