package equipements;

public class ArmeGuerre extends Arme {
    public ArmeGuerre(String nom, String description, boolean actif) {
        int portee=0;
        String degat="";
        switch (nom.toLowerCase()) {
            case "epee longue":
                degat = "1d8";
                portee = 1;
                break;
            case "rapiere":
                degat = "1d8";
                portee = 1;
                break;
                //vitesse du personnage -2 force +4
        }
        super(nom, description, actif,portee,degat);
    }
}
