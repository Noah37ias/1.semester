package model;

import java.util.ArrayList;

public class Booking {
    private static int næsteBookingNr = 101;
    private int bookingNr;
    private int antalPassagerer;
    private String kundeNavn;
    private ArrayList<Køretøj> køretøjer = new ArrayList<>();
    private Afgang afgang;

    public Booking(int antalPassagerer, String kundeNavn, int bookingNr) {
        this.bookingNr = næsteBookingNr;
        næsteBookingNr++;
        this.antalPassagerer = antalPassagerer;
        this.kundeNavn = kundeNavn;
    }

    public void addKøretøj(Køretøj køretøj) {
        køretøjer.add(køretøj);
    }

    public void setAfgang(Afgang afgang) {
        this.afgang = afgang;
    }
}
