package storage;

import model.*;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<JuletræsGrossist> juletræsGrossister = new ArrayList<>();
    private static final ArrayList<Juletræ> juletræer = new ArrayList<>();
    private static final ArrayList<Salg> salgs = new ArrayList<>();

    public static void storeJuletræsGrossist(JuletræsGrossist juletræsGrossist) {
        juletræsGrossister.add(juletræsGrossist);
    }

    public static void storeJuletræ(Juletræ juletræ) {
        juletræer.add(juletræ);
    }

    public static void storeSalg(Salg salg) {
        salgs.add(salg);
    }

    public static ArrayList<JuletræsGrossist> getJuletræsGrossister() {
        return juletræsGrossister;
    }

    public static ArrayList<Juletræ> getJuletræer() {
        return juletræer;
    }

    public static ArrayList<Salg> getSalg() {
        return salgs;
    }
}
