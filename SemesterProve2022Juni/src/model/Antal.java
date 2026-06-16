package model;

public class Antal {
    private int antal;
    private Funktion funktion;

    public Antal(int antal, Funktion funktion) {
        this.antal = antal;
        this.funktion = funktion;
    }
    public void setFunktion(Funktion funktion){
        this.funktion = funktion;
    }

    public int getAntal() {
        return antal;
    }

    public Funktion getFunktion() {
        return funktion;
    }
}
