package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {
    private String navn;
    private double pris;
    private LocalDate dato;
    private ArrayList<Ledsager> ledsagere;

    public Udflugt(String navn, LocalDate dato, double pris) {
        this.navn = navn;
        this.dato = dato;
        this.pris = pris;
    }
}
