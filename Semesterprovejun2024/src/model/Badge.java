package model;

import java.util.ArrayList;

public class Badge {
    private String beskrivelse;
    private ArrayList<Deltager> deltagere = new ArrayList<>();

    public Badge(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public void addDeltager(Deltager deltager){
        this.deltagere.add(deltager);
    }
    public void removeDeltager(Deltager deltager){
        this.deltagere.remove(deltager);
    }
    public String getBeskrivelse() {
        return beskrivelse;
    }

    public ArrayList<Deltager> getDeltagere() {
        return deltagere;
    }

    @Override
    public String toString() {
        return beskrivelse;
    }
}
