package equipements;

public class ArmeCourante extends Arme {
    public ArmeCourante(String nom, String description, boolean actif) {
        int portee=0;
        String degat="";
        switch (nom.toLowerCase()) {
            case "baton":
                degat = "1d6";
                portee = 1;
                break;
            case "masse d'armes":
                degat = "1d6";
                portee = 1;
                break;

        }
        super(nom, description, actif,portee,degat);
    }
}
