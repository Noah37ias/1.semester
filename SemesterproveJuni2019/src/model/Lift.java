package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Lift implements Comparable<Lift> {
    private LocalDateTime tidspunkt;
    private int pris;
    private String fraAdresse;
    private String tilAdresse;
    private int maxAntalPassagerer;
    private ArrayList<Booking> bookinger = new ArrayList<>();
    private Bil bil;

    @Override
    public String toString() {
        return "Lift - " +
                "fra: " + fraAdresse +
                ", til " + tilAdresse + ", pris: " + pris;
    }

    public Lift(LocalDateTime tidspunkt, int pris, String fraAdresse, String tilAdresse, int maxAntalPassagerer, Bil bil) {
        this.tidspunkt = tidspunkt;
        this.pris = pris;
        this.fraAdresse = fraAdresse;
        this.tilAdresse = tilAdresse;
        this.maxAntalPassagerer = maxAntalPassagerer;
        this.bil = bil;
    }

    public LocalDateTime getTidspunkt() {
        return tidspunkt;
    }

    public Bil getBil() {
        return bil;
    }

    public ArrayList<Booking> getBookinger() {
        return bookinger;
    }

    public int getMaxAntalPassagerer() {
        return maxAntalPassagerer;
    }

    public int getPris() {
        return pris;
    }

    public String getFraAdresse() {
        return fraAdresse;
    }

    public String getTilAdresse() {
        return tilAdresse;
    }

    public void addBooking(Booking booking) {
        bookinger.add(booking);
    }

    public boolean LedigPlads() {
        int antalBookinger = 0;
        for (Booking booking : bookinger) {
            antalBookinger++;
        }
        return maxAntalPassagerer > antalBookinger;
    }

    @Override
    public int compareTo(Lift other) {
        int dato = this.tidspunkt.compareTo(other.tidspunkt);
        if (dato == 0) {
            int fraAdresse = this.fraAdresse.compareTo(other.fraAdresse);
            if (fraAdresse == 0) {
                return this.tilAdresse.compareTo(other.tilAdresse);
            } else return fraAdresse;
        }
        return dato;
    }

}

