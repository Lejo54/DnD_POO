package partie;
import entites.Entite;
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

    public void trierParInitiative(Entite[] entites) {
        int n = entites.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (entites[j].getStatistiques().getInitiative() < entites[minIndex].getStatistiques().getInitiative()) {
                    minIndex = j;
                }
            }
            Entite temp = entites[i];
            entites[i] = entites[minIndex];
            entites[minIndex] = temp;
        }
    }

}