package Entites;

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
    public String getDegat() {
        return degat;
    }
}
