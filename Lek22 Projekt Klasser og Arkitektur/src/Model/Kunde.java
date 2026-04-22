package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Kunde {
    private final String navn;
    private final String mobil;
    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Kunde(String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;
    }

    public void addBestilling(Bestilling bestilling) {
        if (!bestillinger.contains(bestilling)) {
            this.bestillinger.add(bestilling);
        }
    }

    public ArrayList<Plads> bestiltePladserTilForestillingPåDag(Forestilling forestilling, LocalDate date) {
        ArrayList<Plads> pladserBestilt = new ArrayList<>();
        for (Bestilling bestilling : bestillinger) {
            if (bestilling.getDate().isEqual(date)&& forestilling.equals(bestilling.getForestilling()) ) {
                pladserBestilt.addAll(bestilling.getPladser());
            }
        }
        return pladserBestilt;
    }

    public String toString() {
        return String.format("Kunde(%s, %s)", navn, mobil);
    }
}

