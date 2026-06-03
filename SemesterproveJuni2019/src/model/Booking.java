package model;

import java.time.LocalTime;

public class Booking {
    private String passager;
    private String opsamlingsted;
    private LocalTime opsamlingstid;
    private Anbefaling anbefaling;
    private Lift lift;

    public Booking(String passager, LocalTime opsamlingstid, String opsamlingsted,Lift lift) {
        this.passager = passager;
        this.lift = lift;
        this.opsamlingstid = opsamlingstid;
        this.opsamlingsted = opsamlingsted;
    }

    public String getPassager() {
        return passager;
    }

    public String getOpsamlingsted() {
        return opsamlingsted;
    }

    public LocalTime getOpsamlingstid() {
        return opsamlingstid;
    }
    public Anbefaling getAnbefaling(){
        return anbefaling ;
    }
    public void setAnbefaling(Anbefaling anbefaling){
        this.anbefaling = anbefaling;
    }

    public Lift getLift() {
        return lift;
    }

    @Override
    public String toString() {
        return "Booking - " +
                "tid: " + opsamlingstid +
                ", sted: " + opsamlingsted +
                ", navn: " + passager;
    }
}
