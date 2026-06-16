package model;

import java.time.LocalDate;

public class Tur {
    private LocalDate dato;
    private int antalMinutter;
    private int antalKm;
    private Deltager deltager;

    public Tur(LocalDate dato, int antalMinutter, int antalKm, Deltager deltager) {
        this.dato = dato;
        this.antalMinutter = antalMinutter;
        this.antalKm = antalKm;
        this.deltager = deltager;
    }

    public LocalDate getDato() {
        return dato;
    }

    public int getAntalMinutter() {
        return antalMinutter;
    }

    public int getAntalKm() {
        return antalKm;
    }

    public Deltager getDeltager() {
        return deltager;
    }

    @Override
    public String toString() {
        return dato + ", " + antalMinutter + ", "+ antalKm + " km";
    }
}
