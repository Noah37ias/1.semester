package Semesterprove2017.model;

import java.time.LocalDateTime;

public class Reservation {
    private LocalDateTime start;
    private LocalDateTime slut;
    private Plads plads;

    public Reservation(LocalDateTime start,LocalDateTime slut,Plads plads) {
        this.start = start;
        this.slut= slut;
        this.plads = plads;
    }

    public LocalDateTime getSlut() {
        return slut;
    }

    public void setSlut(LocalDateTime slut) {
        this.slut = slut;
    }

    public Plads getPlads() {
        return plads;
    }



    public void setPlads(Plads plads) {
        this.plads = plads;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

}
