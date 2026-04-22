package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Bestilling {
    private LocalDate dato;
    private final Forestilling forestilling;
    private final Kunde kunde;
    private final ArrayList<Plads> pladser = new ArrayList<>();

    public Bestilling(LocalDate dato, Forestilling forestilling, Kunde kunde) {
        this.dato = dato;
        this.forestilling = forestilling;
        this.kunde = kunde;
    }

    public void addPlads(Plads[] nyePladser) {
        for (Plads plads : nyePladser) {
            addPlads(plads);
        }
    }

    public void addPlads(Plads plads) {
        if (!pladser.contains(plads)) {
            pladser.add(plads);
        }
    }
    public ArrayList<Plads> getPladser() {
        return pladser;
    }

    public LocalDate getDate(){
        return dato;
    }

    public Forestilling getForestilling() {
        return forestilling;
    }

    public int samletPris(){
        int samletPris = 0;
        for (Plads plads : pladser) {
            samletPris += plads.getPris();
        }
        return samletPris;
    }

    @Override
    public String toString() {
        return String.format("Bestilling(%s, %s, %s)", dato, forestilling, kunde);
    }
}

