package model;

import java.util.ArrayList;

public class Bil {
    private String regNr;
    private String chauffør;
    private ArrayList<Lift> lifts = new ArrayList<>();

    public Bil(String regNr,String chauffør){
        this.regNr = regNr;
        this.chauffør = chauffør;
    }

    public String getRegNr() {
        return regNr;
    }

    public String getChauffør() {
        return chauffør;
    }
    public void addLift(Lift lift){
        lifts.add(lift);
    }

    public ArrayList<Lift> getLifts() {
        return new ArrayList<>(lifts);//retunerer en kopi af listen,
        // for at undgå den forekspempel bliver clearet i app
    }

    public int indtægt(){
        int total = 0;
        for(Lift lift : lifts){
            for(Booking booking : lift.getBookinger()){
                total += lift.getPris();
            }
        }
        return total;
    }
    public String toString(){
        return chauffør +" "+ regNr;
    }
}
