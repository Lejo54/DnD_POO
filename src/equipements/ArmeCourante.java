package equipements;

public class ArmeCourante extends Arme {

    public ArmeCourante(String nom, String description, boolean actif) {
        super(nom, description, actif, calculportee(nom), calculdegat(nom));
    }
    private static int calculportee(String nom){
        switch (nom.toLowerCase()) {
            case "baton":
                return 1;
            case "masse d'armes":
                return 1;
        }
        return 0;
    }
    private static String calculdegat(String nom){
        switch (nom.toLowerCase()) {
            case "baton":
                return "1d6";
            case "masse d'armes":
                return  "1d6";
        }
        return "";
    }
}
