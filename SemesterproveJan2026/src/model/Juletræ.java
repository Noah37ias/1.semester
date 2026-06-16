package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Juletræ implements Comparable<Juletræ>{
    private Sort sort;
    private int højde;
    private int antalPrPalle;
    private ArrayList<PeriodePris> periodePriser = new ArrayList<>();
    private JuletræsGrossist juletræsGrossist;

    public Juletræ(Sort sort, int højde, int antalPrPalle) {
        this.sort = sort;
        this.højde = højde;
        this.antalPrPalle = antalPrPalle;
    }

    public void setJuletræsGrossist(JuletræsGrossist juletræsGrossist) {
        this.juletræsGrossist = juletræsGrossist;
    }

    public void addPeriodePris(PeriodePris periodePris) {
        periodePriser.add(periodePris);
    }

    public void removePeriodePris(PeriodePris periodePris) {
        periodePriser.remove(periodePris);
    }

    public Sort getSort() {
        return sort;
    }

    public int getHøjde() {
        return højde;
    }

    public int getAntalPrPalle() {
        return antalPrPalle;
    }

    public ArrayList<PeriodePris> getPeriodePriser() {
        return periodePriser;
    }

    public JuletræsGrossist getJuletræsGrossist() {
        return juletræsGrossist;
    }

    public double prisPåDato(LocalDate salgsDato) {
        PeriodePris fundetPris = null;
        int i = 0;

        // Gennemløb listen så længe vi ikke har fundet prisen, og der er flere elementer
        while (fundetPris == null && i < periodePriser.size()) {
            PeriodePris pp = periodePriser.get(i);

            // Tjekker om salgsDato ligger inden for (eller præcis på) fraDato og tilDato
            if (!salgsDato.isBefore(pp.getFraDato()) && !salgsDato.isAfter(pp.getTilDato())) {
                fundetPris = pp; // Vi har fundet den rigtige periode!
            } else {
                i++; // Tjek næste objekt i listen
            }
        }

        // Håndtering af resultatet
        if (fundetPris != null) {
            return fundetPris.getPris();
        } else {
            throw new RuntimeException("Der findes ingen pris for juletræet på den valgte dato");
        }
    }

    public double pallePris(int antalTræer) {
        double pallePris = 0;
        double antalPaller = Math.ceil((double) antalTræer / antalPrPalle);
        pallePris = juletræsGrossist.getFragtPrisPrPalle() * antalPaller;
        return pallePris;
    }

    @Override
    public int compareTo(Juletræ other) {
        return Integer.compare(this.højde,other.højde);
    }

    @Override
    public String toString() {
        return "Juletræ{" +
                "antalPrPalle=" + antalPrPalle +
                ", sort=" + sort +
                ", højde=" + højde +
                '}';
    }
}
