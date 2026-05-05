package Model;

import java.util.ArrayList;

public class Hotel {
    private String navn;
    private double pris;
    private double dobbeltPris;
    private ArrayList<Tillæg> tillæg = new ArrayList<>();

    public Hotel(double pris, String navn, double dobbeltPris) {
        this.pris = pris;
        this.navn = navn;
        this.dobbeltPris = dobbeltPris;
    }
    public void addTillæg(Tillæg tillæg){
        this.tillæg.add(tillæg);
    }
    public double getPris(){
        return pris;
    }
    public double getDobbeltPris(){
        return dobbeltPris;
    }
    public String getNavn(){
        return navn;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "navn='" + navn + '\'' +
                ", pris=" + pris +
                ", tillæg=" + tillæg +
                '}';
    }
}
