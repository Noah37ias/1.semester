package Storage;

import Model.Forestilling;
import Model.Kunde;
import Model.Plads;

import java.util.ArrayList;

public abstract class Storage {
    private static final ArrayList<Forestilling> forestillinger = new ArrayList<>();
    private static final ArrayList<Kunde> kunder = new ArrayList<>();
    private static final ArrayList<Plads> pladser = new ArrayList<>();

    public static void storeForestilling(Forestilling forestilling) {
        if (!forestillinger.contains(forestilling)) {
            forestillinger.add(forestilling);
        }
    }

    public static void storeKunde(Kunde kunde) {
        if (!kunder.contains(kunde)) {
            kunder.add(kunde);
        }
    }

    public static void storePlads(Plads plads) {
        if (!pladser.contains(plads)) {
            pladser.add(plads);
        }
    }

    public static ArrayList<Forestilling> getForestillinger() {
        return forestillinger;
    }

    public static ArrayList<Kunde> getKunde() {
        return kunder;
    }

    public static ArrayList<Plads> getPladser() {
        return pladser;
    }
}
