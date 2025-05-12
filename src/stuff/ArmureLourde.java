package stuff;

public class ArmureLourde extends Armure {
    public ArmureLourde(String nom, String description, boolean actif) {
        super(nom, description, actif);
        switch (nom.toLowerCase()) {
            case "armure d'ecailles":
                this.m_classe_Armure =9 ;
                break;
            case "demi-plate":
                this.m_classe_Armure= 10;
                break;
        }
    }
}
