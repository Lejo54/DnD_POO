package equipements;

import entites.Statistiques;

import static partie.Affichage.afficherPhrase;

public class ArmureLegere extends Armure {
    public ArmureLegere(String nom, String description, boolean actif) {
        super(nom, description, actif, calculclasseArmure(nom),new Statistiques(0,0,0));
    }

    private static int calculclasseArmure(String nom){
        switch (nom.toLowerCase()) {
            case "cotte de mailles":
                return 11 ;
            case "harnois":
                return 12;

        }
        return 0;
    }

    @Override
    public String getPoid() {
        return "leger";
    }
    public void afficherInfo(){
        afficherPhrase(this.getNom()+"\n -Classe d'armure :"+this.getClasseArmure()+"\n");
    }
}
