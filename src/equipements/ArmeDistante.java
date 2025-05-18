package equipements;

public class ArmeDistante extends Arme{
    public ArmeDistante(String nom, String description, boolean actif) {
        int portee=0;
        String degat="";
        switch (nom.toLowerCase()) {
            case "arc court":
                degat = "1d6";
                portee = 16;
                break;
            case "arbalete legere":
                degat = "1d8";
                portee = 16;
                break;
            case "fronde":
                degat = "1d4";
                portee = 6;
                break;

        }
        super(nom, description, actif,portee,degat);
    }
}
