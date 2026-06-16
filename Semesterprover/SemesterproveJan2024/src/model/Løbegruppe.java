package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Løbegruppe {
    private String betegnelse;
    private int antalTræningerPrUge;
    private Distance distance;
    private double minutterPrKm;
    private ArrayList<Medlem> medlemmer = new ArrayList<>();
    private ArrayList<Træning> træninger = new ArrayList<>();

    public Løbegruppe(String betegnelse, double minutterPrKm, Distance distance, int antalTræningerPrUge) {
        this.betegnelse = betegnelse;
        this.minutterPrKm = minutterPrKm;
        this.distance = distance;
        this.antalTræningerPrUge = antalTræningerPrUge;
    }
    public void addMedlem(Medlem medlem){
        this.medlemmer.add(medlem);
    }
    public void addTræning(Træning træning){
        this.træninger.add(træning);
    }
    public void removeTræning(Træning træning){
        this.træninger.remove(træning);
    }
    public void remove(Medlem medlem){
        this.medlemmer.remove(medlem);
    }

    public String getBetegnelse() {
        return betegnelse;
    }

    public int getAntalTræningerPrUge() {
        return antalTræningerPrUge;
    }

    public Distance getDistance() {
        return distance;
    }

    public double getMinutterPrKm() {
        return minutterPrKm;
    }

    public ArrayList<Medlem> getMedlemmer() {
        return medlemmer;
    }

    public ArrayList<Træning> getTræninger() {
        return træninger;
    }

    public String yngsteMedlem(){
        LocalDate min = LocalDate.MAX;
        String navn = "";
        for(Medlem medlem : medlemmer){
            if(min.isAfter(medlem.getFødselsDato())){
                min = medlem.getFødselsDato();
                navn = medlem.getNavn();
            }
        }
        return navn;
    }
    public double gennemsnitligKmPrTræning(){
        double average = 0;
        int antal = 0;
        for(Træning træning : træninger){
            average = træning.getAntalKm() + average;
            antal++;
        }
        return average / antal;
    }
}
