package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Controller {
    /*
     * Opretter en bil og retunerer den
     * pre:
     */
    public static Bil createBil(String regNr, String chauffør) {
        Bil bil = new Bil(regNr, chauffør);
        Storage.storeBil(bil);
        return bil;
    }

    /*
     * Opretter et lift og retunerer det
     * pre:
     */
    public static Lift createLift(LocalDateTime tidspunkt, int pris, String fraAdresse, String tilAdresse, int maxAntalPassagerer, Bil bil) {
        Lift lift = new Lift(tidspunkt, pris, fraAdresse, tilAdresse, maxAntalPassagerer, bil);
        bil.addLift(lift);
        return lift;
    }

    /*
     * Opretter en booking og retunerer den
     * pre:
     */
//    public static Booking createBooking(String passager, LocalTime opsamlingstid, String opsamlingsted, Lift lift) {
//        try {
//            if (!lift.LedigPlads()) throw new RuntimeException();
//            {
//                Booking booking = new Booking(passager, opsamlingstid, opsamlingsted, lift);
//                lift.addBooking(booking);
//                return booking;
//            }
//        } catch (RuntimeException ex) {
//            System.out.println("IKKE FLERE LEDIGE PLADSER!");
//            throw ex;
//        }
//    }
    public static Booking createBooking(String passager, LocalTime opsamlingstid, String opsamlingsted, Lift lift) {
        // 1. Tjek for fejl (fail-fast) og smid en exception MED en besked
        if (!lift.LedigPlads()) {
            throw new RuntimeException("IKKE FLERE LEDIGE PLADSER!");
        }

        // 2. Hvis der er plads, kører koden automatisk videre hertil
        Booking booking = new Booking(passager, opsamlingstid, opsamlingsted, lift);
        lift.addBooking(booking);
        return booking;
    }

    /*
     * Opretter en anbefaling og retunerer den
     * pre:
     */
    public static Anbefaling createAnbefaling(Stjerner stjerner, String kommentar, Booking booking) {
        Anbefaling anbefaling = new Anbefaling(stjerner, kommentar);
        booking.setAnbefaling(anbefaling);
        return anbefaling;
    }
    public static ArrayList<Lift> liftPåDato(LocalDate dato){
        ArrayList<Lift> sammeDag = new ArrayList<>();
        ArrayList<Lift> result = new ArrayList<>();
        for(Bil bil : Storage.getBiler()){
            for(Lift lift : bil.getLifts())
                if(lift.getTidspunkt().toLocalDate().equals(dato)){
                    if(lift.LedigPlads()) {
                        sammeDag.add(lift);
                    }
                }
        }

        Collections.sort(sammeDag);
        return sammeDag;
    }
    public static int[] anbefalingFrekvens(){
        int[] result = new int[5];
        for (Bil bil : Storage.getBiler()) {
            for (Lift lift : bil.getLifts()) {
                for (Booking booking : lift.getBookinger()) {
                    if (booking.getAnbefaling() != null) {
                        if (booking.getAnbefaling().getStjerner().equals(Stjerner.EN)) {
                            result[0]++;
                        }
                        if (booking.getAnbefaling().getStjerner().equals(Stjerner.TO)) {
                            result[1]++;
                        }
                        if (booking.getAnbefaling().getStjerner().equals(Stjerner.TRE)) {
                            result[2]++;
                        }
                        if (booking.getAnbefaling().getStjerner().equals(Stjerner.FIRE)) {
                            result[3]++;
                        }
                        if (booking.getAnbefaling().getStjerner().equals(Stjerner.FEM)) {
                            result[4]++;
                        }
                    }
                }
            }
        }
        return result;
    }
    public static String findChaufførOgAnbefaling(String passager, String opsamlingsted,LocalTime opsamlingstid){
        String tekst = "";
        for(Bil biler : Storage.getBiler()){
            for(Lift lift : biler.getLifts()){
                for(Booking booking : lift.getBookinger()){
                    String sted = booking.getOpsamlingsted();
                    LocalTime tid = booking.getOpsamlingstid();
                    String fundetPassager = booking.getPassager();

                    if(sted.equals(opsamlingsted)&&tid.equals(opsamlingstid)&&fundetPassager.equals(passager)){
                        if(booking.getAnbefaling() != null){
                            return biler.getChauffør() + " " + booking.getAnbefaling();
                        }
                        else {
                            return biler.getChauffør() + " " + "Ingen anbefalinger";
                        }
                    }
                }
            }
        }
        return null;
    }
    public static void setAnbefaling(Booking booking, Anbefaling anbefaling){
        booking.setAnbefaling(anbefaling);
    }
}
