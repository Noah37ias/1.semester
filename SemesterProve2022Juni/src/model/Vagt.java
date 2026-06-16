package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Vagt {
    private String navn;
    private LocalDate tidFra;
    private LocalDate tilTil;
    private ArrayList<Antal> antal = new ArrayList<>();
    private ArrayList<Medarbejder> medarbejdere = new ArrayList<>();

    public Vagt(String navn, LocalDate tidFra, LocalDate tilTil) {
        this.navn = navn;
        this.tidFra = tidFra;
        this.tilTil = tilTil;
    }
    public void addMedarbejdere(Medarbejder medarbejder){
        medarbejdere.add(medarbejder);
    }
    public void addAntal(Antal antal){
        this.antal.add(antal);
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getTidFra() {
        return tidFra;
    }

    public LocalDate getTilTil() {
        return tilTil;
    }

    public ArrayList<Antal> getAntal() {
        return antal;
    }

    public ArrayList<Medarbejder> getMedarbejdere() {
        return medarbejdere;
    }
}
