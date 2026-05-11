package Model;

import org.jspecify.annotations.NullMarked;

import java.time.LocalDate;
import java.util.ArrayList;

@NullMarked
public class Udflugt {
    private final String navn;
    private final double pris;
    private final LocalDate dato;
    private final ArrayList<Ledsager> ledsagere = new ArrayList<>();

    public Udflugt(String navn, LocalDate dato, double pris) {
        this.navn = navn;
        this.dato = dato;
        this.pris = pris;
    }
    public double getPris(){
        return pris;
    }
    public String toString(){
        return navn + " - " +pris +" - " + dato;
    }

    public String getNavn() {
        return navn;
    }
    public void addLedsager(Ledsager ledsager) {
        ledsagere.add(ledsager);
    }
    public ArrayList<Ledsager> getLedsagere() {
        return ledsagere;
    }
}
