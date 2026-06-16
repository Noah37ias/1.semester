package controller;
import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;

public class Controller {
    /*
     * Opretter en afgang og retunerer den
     * pre:
     */
    public static Afgang createAfgang(Havn fraDestination, Havn tilDestination, LocalDate dato, LocalTime klokkeslæt, double grundPris, Færge færge) {
        Afgang afgang = new Afgang(fraDestination, tilDestination, dato, klokkeslæt, grundPris, færge);
        afgang.setFærge(færge);
        return afgang;
    }
    /*
     * Opretter en booking og retunerer den
     * pre:
     */
    public static Booking createBooking(int antalPassagerer, String kundeNavn,Afgang afgang) {
        Booking booking = new Booking(antalPassagerer,kundeNavn,afgang);
        Storage.storeBooking(booking);
        booking.setAfgang(afgang);
        return booking;
    }
    /*
     * Opretter en færge og retunerer den
     * pre:
     */
    public static Færge createFærge(String navn, int maxAntalPassagerer, int maxAntalBiler, int maxAntalLastbiler) {
        Færge færge = new Færge(navn,maxAntalPassagerer,maxAntalBiler,maxAntalLastbiler);
        Storage.storeFærge(færge);
        return færge;
    }
    /*
     * Opretter en afgang og retunerer den
     * pre:
     */
    public static Køretøj createKøretøj(String regNummer,KøretøjsKategori køretøjsKategori) {
        Køretøj køretøj = new Køretøj(regNummer,køretøjsKategori);
        Storage.storeKøretøj(køretøj);
        return køretøj;
    }
}
