package equipements;

public class ArmureLourde extends Armure {
    public ArmureLourde(String nom, String description, boolean actif) {
        int classeArmure=0;
        switch (nom.toLowerCase()) {
            case "armure d'ecailles":
                classeArmure =9 ;
                break;
            case "demi-plate":
                classeArmure= 10;
                break;
        }
        super(nom, description, actif,classeArmure);
    }
}
