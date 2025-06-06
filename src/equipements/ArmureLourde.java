package equipements;

import entites.Statistiques;

import static partie.Affichage.afficherPhrase;

public class ArmureLourde extends Armure {
    public ArmureLourde(String nom, String description, boolean actif) {
        super(nom, description, actif, calculclasseArmure(nom),new Statistiques(0,0,-4));
    }
    private static int calculclasseArmure(String nom){
        switch (nom.toLowerCase()) {
            case "armure d ecailles":
                return 9 ;
            case "demi plate":
                return  10;
        }
        return 0;
    }
    @Override
    public String getPoid() {
        return "lourd";
    }
    public void afficherInfo(){
        afficherPhrase(this.getNom()+"\n -Classe d'armure :"+this.getClasseArmure()+"\n -Malus: -4 vitesse \n");
    }
}
