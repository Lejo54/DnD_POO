package Partie;
import Entites.Entite;
import donjons.Obstacle;
import stuff.Equipement;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Partie {
    private List<Entite> entites;
    private List<Obstacle> obstacles;
    private List<Equipement> equipements;

    // Constructeur avec filtrage
    public Partie(List<Entite> entites, List<Obstacle> obstacles, List<Equipement> equipements) {
        this.entites = filtrerEntitesParInitiative(entites);
        this.obstacles = obstacles;
        this.equipements = filtrerEquipementsPosition(equipements);
    }

    // Version "init" si l'on préfère avoir un constructeur vide
    public void init(List<Entite> entites, List<Obstacle> obstacles, List<Equipement> equipements) {
        this.entites = filtrerEntitesParInitiative(entites);
        this.obstacles = obstacles != null ? obstacles : new ArrayList<>();
        this.equipements = filtrerEquipementsPosition(equipements);
    }

    // Filtrer et trier les entités par initiative (exemple d'une règle fictive)
    private List<Entite> filtrerEntitesParInitiative(List<Entite> entites) {
        if (entites == null) return new ArrayList<>();
        // Garder uniquement les entités valides et les trier
        return entites.stream()
                .filter(entite -> entite.getInitiative() > 0) // Exemple de filtrage
                .sorted((e1, e2) -> Integer.compare(e2.getInitiative(), e1.getInitiative())) // Trier par initiative descendante
                .collect(Collectors.toList());
    }

    // Filtrer les équipements en fonction de leur position (valide si différente de -1)
    private List<Equipement> filtrerEquipementsPosition(List<Equipement> equipements) {
        if (equipements == null) return new ArrayList<>();
        return equipements.stream()
                .filter(equipement -> equipement.getPosition() != -1)
                .collect(Collectors.toList());
    }

    // Getters pour accéder aux listes (si nécessaire)
    public List<Entite> getEntites() {
        return entites;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public List<Equipement> getEquipements() {
        return equipements;
    }
}