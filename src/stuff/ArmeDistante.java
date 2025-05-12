package stuff;

public class ArmeDistante extends Arme{
    public ArmeDistante(String nom, String description, boolean actif) {
        super(nom, description, actif);
        switch (nom.toLowerCase()) {
            case "arc court":
                this.m_degat = "1d6";
                this.m_portee = 16;
                break;
            case "arbalete legere":
                this.m_degat = "1d8";
                this.m_portee = 16;
                break;
            case "fronde":
                this.m_degat = "1d4";
                this.m_portee = 6;
                break;

        }
    }
}
