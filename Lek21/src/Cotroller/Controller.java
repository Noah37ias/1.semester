package Cotroller;

import Semesterprove2017.model.Arrangement;
import Semesterprove2017.model.Område;
import Semesterprove2017.model.Plads;
import Semesterprove2017.model.Reservation;
import Storage.Storage;

import java.time.LocalDateTime;

public abstract class Controller {
    public static Arrangement createArragement(String navn, boolean offentlig) {
        Arrangement arrangement = new Arrangement(navn, offentlig);
        Storage.storeArrangement(arrangement);
        return arrangement;
    }
    public static Plads createPlads(Område område,int nr) {
        Plads plads = new Plads(område, nr);
        Storage.storePlads(plads);
        return plads;
    }
    public static Reservation createReservation(LocalDateTime start, LocalDateTime slut,Plads plads) {
        Reservation reservation = new Reservation(start,slut,plads);
        return reservation;
    }
}
