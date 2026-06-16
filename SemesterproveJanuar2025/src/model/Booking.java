package model;

import java.util.ArrayList;

public class Booking {
    private static int næsteBookingNr = 101;
    private int bookingNr;
    private int antalPassagerer;
    private String kundeNavn;
    private ArrayList<Køretøj> køretøjer = new ArrayList<>();
    private Afgang afgang;

    public Booking(int antalPassagerer, String kundeNavn,Afgang afgang) {
        this.bookingNr = næsteBookingNr;
        næsteBookingNr++;
        this.antalPassagerer = antalPassagerer;
        this.kundeNavn = kundeNavn;
        this.afgang = afgang;
    }

    public void addKøretøj(Køretøj køretøj) {
        køretøjer.add(køretøj);
    }

    public void setAfgang(Afgang afgang) {
        this.afgang = afgang;
    }
    public int getAntalPassagerer(){
        return antalPassagerer;
    }

    public int getBookingNr() {
        return bookingNr;
    }

    public double samletPris(Booking booking){
        int totalPris = 0;

        for(Køretøj køretøj : booking.køretøjer){
            if(køretøj.getKøretøjsKategori().equals(KøretøjsKategori.LASTBIL)){

            }
        }
        return totalPris;
    }

}
