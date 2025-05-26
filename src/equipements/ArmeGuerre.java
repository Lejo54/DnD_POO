package equipements;

public class ArmeGuerre extends Arme {
    public ArmeGuerre(String nom, String description, boolean actif) {
        super(nom, description, actif, calculportee(nom), calculdegat(nom));
    }
    private static int calculportee(String nom){
        switch (nom.toLowerCase()) {
            case "epee longue":
                return 1;
            case "rapiere":
                return  1;
            case "epee_à_deux_mains" :
                return 1;
                //vitesse du personnage -2 force +4
        }
        return 0;
    }
    private static String calculdegat(String nom){
        switch (nom.toLowerCase()) {
            case "epee longue":
                return "1d8";
            case "rapiere":
                return  "1d8";
            case "epee_à_deux_mains" :
                return "2d6";
            //vitesse du personnage -2 force +4
        }
        return "";
    }
    @Override
    public String Poid() {
        return "guerre";
    }
}
