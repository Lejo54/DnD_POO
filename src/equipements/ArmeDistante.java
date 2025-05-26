package equipements;

public class ArmeDistante extends Arme{

    public ArmeDistante(String nom, String description, boolean actif) {
        super(nom, description, actif, calculportee(nom), calculdegat(nom));
    }
    private static int calculportee(String nom){
        switch (nom.toLowerCase()) {
            case "arc court":
                return 16;
            case "arbalete legere":
                return  16;
            case "fronde" :
                return 6;
        }
        return 0;
    }
    private static String calculdegat(String nom){
        switch (nom.toLowerCase()) {
            case "epee longue":
                return "1d6";
            case "rapiere":
                return  "1d8";
            case "epee_à_deux_mains" :
                return "1d4";
        }
        return "";
    }
}
