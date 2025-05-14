package donjons;

//importer les list
import stuff.Equipement;
import Entites.Entite;
import java.util.List;

public class Donjon {
    List<Equipement> m_objetAuSol;
    List<Entite> m_entites;
    List<Obstacle> m_obstacles;

    public Donjon(List<Equipement> m_objetAuSol, List<Entite> m_entites,List<Obstacle> m_obstacles) {
        this.m_objetAuSol = m_objetAuSol;
        this.m_entites = m_entites;
        this.m_obstacles = m_obstacles;
    }
    public List<Obstacle> getObstacles() {
        return m_obstacles;
    }
    public List<Equipement> getObjets()
    {
        return m_objetAuSol;
    }

    public List<Entite> getEntites()
    {
        return m_entites;
    }

    public boolean contientObstacle(int x, int y) {
        for (Obstacle obstacle : m_obstacles) {
            if (obstacle.m_position.getX() == x && obstacle.m_position.getY() == y) {
                return true;
            }
        }
        return false;
    }
    public boolean contientEntite(int x, int y) {
        for (Entite entite : m_entites) {
            if (entite.getPosition().getX() == x && entite.getPosition().getY() == y) {
                return true;
            }
        }
        return false;
    }
    public boolean contientEquipement(int x, int y) {
        for (Equipement equipement : m_objetAuSol) {
            if (equipement.getPosition().getX() == x && equipement.getPosition().getY() == y) {
                return true;
            }
        }
        return false;
    }

}
