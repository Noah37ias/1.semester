package Model;

import java.time.LocalDate;
import java.util.ArrayList;

import org.jspecify.annotations.NullMarked;

@NullMarked
public class Forestilling {
    private final String navn;
    private final LocalDate startDato;
    private final LocalDate endDato;
    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Forestilling(String navn, LocalDate startDato, LocalDate endDato) {
        this.navn = navn;
        this.startDato = startDato;
        this.endDato = endDato;
    }

    public void addBestilling(Bestilling bestilling) {
        if (!bestillinger.contains(bestilling)) {
            this.bestillinger.add(bestilling);
        }
    }
    public LocalDate getStartDato(){
        return startDato;
    }
    public LocalDate getEndDato(){
        return endDato;
    }
    public String toString() {
        return String.format("Forestilling(%s, %s, %s)", navn, startDato, endDato);
    }

    public boolean erPladsLedig(int række, int nr, LocalDate date) {
        for (Bestilling bestilling : bestillinger) {
            if (bestilling.getDate().equals(date)) {
                for (Plads plads : bestilling.getPladser()) {
                    if (række == plads.getRække() && nr == plads.getNr()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int antalBestiltePladserPåDag(LocalDate date) {
        int total = 0;
        for (Bestilling bestilling : bestillinger) {
            if (bestilling.getDate().equals(date)) {
                for (Plads plads : bestilling.getPladser()) {
                    total++;
                }
            }
        }
        return total;
    }


    public LocalDate succesDato() {
        int max = -67;
        LocalDate maxDate = this.startDato;
        LocalDate loopDate = this.startDato;

        while(!loopDate.isAfter(this.endDato)){
            if(max < antalBestiltePladserPåDag(loopDate)){
                max = antalBestiltePladserPåDag(loopDate);
                maxDate = loopDate;
            }
            loopDate = loopDate.plusDays(1);
        }
        return maxDate;
    }
}
