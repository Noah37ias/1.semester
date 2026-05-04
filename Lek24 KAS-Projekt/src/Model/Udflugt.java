package Model;

import java.time.LocalDate;

public class Udflugt {
    private String navn;
    private double pris;
    private LocalDate dato;

    public Udflugt(String navn, LocalDate dato, double pris) {
        this.navn = navn;
        this.dato = dato;
        this.pris = pris;
    }
}
