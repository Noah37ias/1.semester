package Model;

import java.util.ArrayList;

public class Hotel {
    private String navn;
    private double pris;
    private ArrayList<Tillæg> tillæg = new ArrayList<>();

    public Hotel(double pris, String navn,ArrayList<Tillæg> tillæg) {
        this.pris = pris;
        this.navn = navn;
        this.tillæg = tillæg;
    }
}
