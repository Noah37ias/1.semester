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
    public static Booking createBooking(int antalPassagerer, String kundeNavn, int bookingNr) {
        Booking booking = new Booking(antalPassagerer,kundeNavn,bookingNr);
        Storage.storeBooking(booking);
        return booking;
    }
    /*
     * Opretter en færge og retunerer den
     * pre:
     */
    public static Færge createFærge() {
        Færge færge = new Færge();
        Storage.storeFærge(færge);
        return færge;
    }
    /*
     * Opretter en afgang og retunerer den
     * pre:
     */
    public static Køretøj createKøretøj() {
        Deltager deltager = new Deltager();
        Storage.storeDeltager(deltager);
        return køretøj;
    }
}
