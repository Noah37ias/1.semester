package storage;

import model.*;

import java.util.ArrayList;

public abstract class Storage {
    private static final ArrayList<Medarbejder> medarbejdere = new ArrayList<>();
    private static final ArrayList<Funktion> funktioner = new ArrayList<>();
    private static final ArrayList<Vagt> vagter = new ArrayList<>();

    public static void storeMedarbejder(Medarbejder medarbejder){
        medarbejdere.add(medarbejder);
    }
    public static void storeVagt(Vagt vagt){
        vagter.add(vagt);
    }
    public static void storeFunktion(Funktion funktion){
        funktioner.add(funktion);
    }
}
