package equipements;

public class ArmureLourde extends Armure {
    public ArmureLourde(String nom, String description, boolean actif) {
        super(nom, description, actif, calculclasseArmure(nom));
    }
    private static int calculclasseArmure(String nom){
        switch (nom.toLowerCase()) {
            case "armure d'ecailles":
                return 9 ;
            case "demi-plate":
                return  10;
        }
        return 0;
    }
    @Override
    public String Poid() {
        return "lourd";
    }
}
