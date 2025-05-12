package stuff;

public class Armure extends Equipement {
    int m_classe_Armure;

    public Armure(String nom, String description, boolean actif) {
        super(nom, description, actif);
    }

    public int getClasseArmure(){
        return m_classe_Armure;
    }
}
