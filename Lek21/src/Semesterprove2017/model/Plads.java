package Semesterprove2017.model;

import java.util.ArrayList;

public class Plads {
    private Område område;
    private int nr;
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private static int timePris = 50;

    public Plads(Område område, int nr){
        this.nr = nr;
        this.område  = område;
    }

    public int getTimePris(){
        return timePris;
    }
    public void setTimePris(int timePris){
        this.timePris = timePris;
    }

    public double pris(int timer){
        double pris = 0;

        if(Område.VIP==getOmråde()){
        pris = (timer * timePris) * 1.25;
        }
        if(Område.BØRNE==getOmråde()){
            pris = (timer * timePris) * 0.8;
        }
        if(Område.TURNERING==getOmråde()){
            pris = (timer * timePris) * 1.1;
        }
        return pris;
    }

    public Område getOmråde() {
        return område;
    }

    public void setOmråde(Område område) {
        this.område = område;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

}
