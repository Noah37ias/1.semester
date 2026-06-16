package model;

import java.util.ArrayList;

public class JuletræsGrossist {
    private String navn;
    private String cvr;
    private double fragtPrisPrPalle;
    private ArrayList<Juletræ> juletræer = new ArrayList<>();

    public JuletræsGrossist(String navn, String cvr, double fragtPrisPrPalle) {
        this.navn = navn;
        this.cvr = cvr;
        this.fragtPrisPrPalle = fragtPrisPrPalle;
    }

    public void addJuletræ(Juletræ juletræ) {
        juletræer.add(juletræ);
    }

    public void removeJuletræ(Juletræ juletræ) {
        juletræer.remove(juletræ);
    }

    public String getNavn() {
        return navn;
    }

    public String getCvr() {
        return cvr;
    }

    public double getFragtPrisPrPalle() {
        return fragtPrisPrPalle;
    }

    public ArrayList<Juletræ> getJuletræer() {
        return juletræer;
    }

    @Override
    public String toString() {
        return  navn;
    }
}
