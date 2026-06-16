package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Controller {
    public static Antal createAntal(int antal, Funktion funktion, Vagt vagt) {
        Antal antals = new Antal(antal, funktion);
        vagt.addAntal(antals);
        return antals;
    }

    public static Vagt createVagt(String navn, LocalDate tidFra, LocalDate tilTil) {
        Vagt vagt = new Vagt(navn, tidFra, tilTil);
        Storage.storeVagt(vagt);
        return vagt;
    }

    public static Funktion createFunktion(String navn) {
        Funktion funktion = new Funktion(navn);
        Storage.storeFunktion(funktion);
        return funktion;
    }

    public static Medarbejder createMedarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid) {
        Medarbejder medarbejder = new Medarbejder(navn, antalTimerPrDag, typiskMødetid);
        Storage.storeMedarbejder(medarbejder);
        return medarbejder;
    }
    public static void tilføjFunktionTilMedarbejder(Medarbejder medarbejder, Funktion funktion) {
        medarbejder.addFunktion(funktion);
    }
    public static void addVagtPåMedarbejder(Medarbejder medarbejder,Vagt vagt){
        medarbejder.addVagt(vagt);
    }
}
