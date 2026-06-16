package model;

import java.time.LocalDateTime;

public class Træning {
    private LocalDateTime tidspunkt;
    private double antalKm;
    private String rute;
    private Løbegruppe løbegruppe;

    public Træning(LocalDateTime tidspunkt, double antalKm,String rute, Løbegruppe løbegruppe) {
        this.tidspunkt = tidspunkt;
        this.antalKm = antalKm;
        this.rute = rute;
        this.løbegruppe = løbegruppe;
    }

    public LocalDateTime getTidspunkt() {
        return tidspunkt;
    }

    public double getAntalKm() {
        return antalKm;
    }

    public String getRute() {
        return rute;
    }

    public Løbegruppe getLøbegruppe() {
        return løbegruppe;
    }
}
