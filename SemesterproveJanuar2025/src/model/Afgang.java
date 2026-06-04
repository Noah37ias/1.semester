package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Afgang {
    private Havn fraDestination;
    private Havn tilDestination;
    private LocalDate dato;
    private LocalTime klokkeslæt;
    private double grundPris;
    private ArrayList<Booking> bookings;
    private Færge færge;

    public Afgang(Havn fraDestination, Havn tilDestination, LocalDate dato, LocalTime klokkeslæt, double grundPris, Færge færge) {
        this.fraDestination = fraDestination;
        this.tilDestination = tilDestination;
        this.dato = dato;
        this.klokkeslæt = klokkeslæt;
        this.grundPris = grundPris;
        this.færge = færge;
    }
    public void addBooking(Booking booking){
        bookings.add(booking);
    }
    public void setFærge(Færge færge){
        this.færge = færge;
    }
}
