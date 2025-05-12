package character;

import stuff.Equipement;

public class Monstre {
    String espece;
    int numero;
    int portee;
    String degat;
    int class_d_armure;

    public String getNom() {
        return espece + " " + numero;
    }
    public int getarmure(){
        return class_d_armure;
    }
    public int getDegat() {
        //je sais plus comment on a dit qu'on ferait pour les dégats
        return 0;
    }
}
