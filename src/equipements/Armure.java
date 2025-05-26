package equipements;

public abstract class Armure extends Equipement {
    int m_classe_Armure;

    public Armure(String nom, String description, boolean actif, int classe_Armure) {
        super(nom, description, actif);
        m_classe_Armure = classe_Armure;
    }
    public String getType(){return "armure";}
    public abstract String Poid();

    public int getClasseArmure(){
        return m_classe_Armure;
    }
}
