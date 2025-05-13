package donjons;

//importer les list
import stuff.Equipement;
import Entites.Entite;
import java.util.List;

public class Donjon {
    private List<Equipement> m_objetAuSol;
    private List<Entite> m_entites;

    public Donjon(List<Equipement> m_objetAuSol, List<Entite> m_entites) {
        this.m_objetAuSol = m_objetAuSol;
        this.m_entites = m_entites;
    }

    public List<Equipement> getObjets() {
        return m_objetAuSol;
    }


    public List<Entite> getEntites() {
        return m_entites;
    }
}
