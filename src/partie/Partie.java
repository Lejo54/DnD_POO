package partie;
import entites.Entite;
import entites.Personnage;

import java.util.ArrayList;
import java.util.List;

import static partie.Affichage.*;
import static partie.Affichage.afficherPhrase;

public class Partie {
    private List<Personnage> m_joueurs;

    // Constructeur avec filtrage
    public Partie(List<Personnage> joueurs) {
        m_joueurs = new ArrayList<>();
        int nbJoueur= demanderInt("Entrez un nombre de joueur :\n");
        for (int i = 0; i < nbJoueur; i++) {
            m_joueurs.add(creerJoueurs());
        }
        this.m_joueurs = rangerParInitiative(joueurs);

    }
    // Getters
    public List<Personnage> getEntites() {
        return m_joueurs;
    }

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