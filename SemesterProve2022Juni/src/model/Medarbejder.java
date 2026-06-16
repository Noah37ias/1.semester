package model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Medarbejder {
    private String navn;
    private int antalTimerPrDag;
    private LocalTime typiskMødetid;
    private ArrayList<Vagt> vagter = new ArrayList<>();
    private ArrayList<Funktion> funktioner = new ArrayList<>();

    public Medarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid) {
        this.navn = navn;
        this.antalTimerPrDag = antalTimerPrDag;
        this.typiskMødetid = typiskMødetid;
    }
    public void addVagt(Vagt vagt){
        vagter.add(vagt);
    }
    public void addFunktion(Funktion funktion){
        funktioner.add(funktion);
    }

    public String getNavn() {
        return navn;
    }

    public int getAntalTimerPrDag() {
        return antalTimerPrDag;
    }

    public LocalTime getTypiskMødetid() {
        return typiskMødetid;
    }

    public ArrayList<Vagt> getVagter() {
        return vagter;
    }

    public ArrayList<Funktion> getFunktioner() {
        return funktioner;
    }
}
