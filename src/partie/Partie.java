package partie;
import entites.Personnage;

import java.util.List;

public class Partie {
    private List<Personnage> m_joueurs;

    // Constructeur avec filtrage
    public Partie(List<Personnage> joueurs) {
        //
        this.m_joueurs = rangerParInitiative(joueurs);

    }
    // Getters
    public List<Personnage> getEntites() {
        return m_joueurs;
    }
    public List<Personnage> rangerParInitiative(List<Personnage> joueurs) { return joueurs;}

}