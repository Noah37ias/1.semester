package Controller;

import Model.Bestilling;
import Model.Forestilling;
import Model.Kunde;
import Model.Plads;
import Storage.Storage;
import Model.PladsType;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Controller {
    public static Kunde createKunde(String navn, String mobil) {
        Kunde kunde = new Kunde(navn, mobil);
        Storage.storeKunde(kunde);
        return kunde;
    }

    public static Plads createPlads(int række, int nr, int pris, PladsType pladstype) {
        Plads plads = new Plads(række, nr, pris, pladstype);
        Storage.storePlads(plads);
        return plads;
    }

    public static void createForestilling(String navn, LocalDate startDato, LocalDate endDato) {
        Forestilling forestilling = new Forestilling(navn, startDato, endDato);
        Storage.storeForestilling(forestilling);
    }

    public static Bestilling createBestilling(LocalDate dato, Forestilling forestilling, Kunde kunde, Plads... plads) {
        Bestilling bestilling = new Bestilling(dato, forestilling, kunde);
        bestilling.addPlads(plads);
        forestilling.addBestilling(bestilling);
        kunde.addBestilling(bestilling);
        return bestilling;
    }

    public static ArrayList<Forestilling> getForestillinger() {
        return Storage.getForestillinger();
    }

    public static ArrayList<Kunde> getKunder() {
        return Storage.getKunde();
    }

    public static ArrayList<Plads> getPladser() {
        return Storage.getPladser();
    }

    public static Bestilling opretBestillingMedPladser(Forestilling forestilling, Kunde kunde, LocalDate date, ArrayList<Plads> pladser) {
        if (date.isAfter(forestilling.getEndDato()) || date.isBefore(forestilling.getStartDato())) {
            return null;
        }
        for (Plads plads : pladser) {
            if (!forestilling.erPladsLedig(plads.getRække(), plads.getNr(), date)) {
                return null;
            }
        }

        Plads[] pladsArray = pladser.toArray(new Plads[0]);
        return createBestilling(date, forestilling, kunde, pladsArray);
    }
}

