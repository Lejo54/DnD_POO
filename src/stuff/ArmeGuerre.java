package stuff;

public class ArmeGuerre extends Arme {
    public ArmeGuerre(String nom, String description, boolean actif) {
        super(nom, description, actif);
        switch (nom.toLowerCase()) {
            case "epee longue":
                this.m_degat = "1d8";
                this.m_portee = 1;
                break;
            case "rapiere":
                this.m_degat = "1d8";
                this.m_portee = 1;
                break;
                //vitesse du personnage -2 force +4
        }
    }
}
