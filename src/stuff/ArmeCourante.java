package stuff;

public class ArmeCourante extends Arme {
    public ArmeCourante(String nom, String description, boolean actif) {
        super(nom, description, actif);
        switch (nom.toLowerCase()) {
            case "baton":
                this.m_degat = "1d6";
                this.m_portee = 1;
                break;
            case "masse d'armes":
                this.m_degat = "1d6";
                this.m_portee = 1;
                break;

        }
    }
}
