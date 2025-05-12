package stuff;

public class ArmureLegere extends Armure {
    public ArmureLegere(String nom, String description, boolean actif) {
        super(nom, description, actif);
        switch (nom.toLowerCase()) {
            case "cotte de mailles":
                this.m_classe_Armure =11 ;
                break;
            case "harnois":
                this.m_classe_Armure= 12;
                break;
                //vitesse -4
        }
    }
}
