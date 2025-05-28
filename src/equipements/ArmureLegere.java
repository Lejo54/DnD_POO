package equipements;

public class ArmureLegere extends Armure {
    public ArmureLegere(String nom, String description, boolean actif) {
        super(nom, description, actif, calculclasseArmure(nom));
    }

    private static int calculclasseArmure(String nom){
        switch (nom.toLowerCase()) {
            case "cotte de mailles":
                return 11 ;
            case "harnois":
                return 12;
                //vitesse -4
        }
        return 0;
    }

    @Override
    public String getPoid() {
        return "leger";
    }
}
