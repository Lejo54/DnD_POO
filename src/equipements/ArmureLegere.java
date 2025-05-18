package equipements;

public class ArmureLegere extends Armure {
    public ArmureLegere(String nom, String description, boolean actif) {
        int classeArmure=0;
        switch (nom.toLowerCase()) {
            case "cotte de mailles":
                classeArmure =11 ;
                break;
            case "harnois":
                classeArmure= 12;
                break;
                //vitesse -4
        }
        super(nom, description, actif,classeArmure);
    }
}
