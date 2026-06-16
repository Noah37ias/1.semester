package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Løb {
    private LocalDate dato;
    private String sted;
    private int normalPris;
    private LocalDate earlyBird;
    private int earlyBirdPris;
    private ArrayList<Forhindring> forhindringer = new ArrayList<>();
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Løb(LocalDate dato, String sted, int normalPris, LocalDate earlyBird, int earlyBirdPris) {
        this.dato = dato;
        this.sted = sted;
        this.normalPris = normalPris;
        this.earlyBird = earlyBird;
        this.earlyBirdPris = earlyBirdPris;
    }
    public void addForhindring(Forhindring forhindring){
        forhindringer.add(forhindring);
    }
    public void addTilmelding(Tilmelding tilmelding){
        tilmeldinger.add(tilmelding);
    }

    public LocalDate getDato() {
        return dato;
    }

    public String getSted() {
        return sted;
    }

    public int getNormalPris() {
        return normalPris;
    }

    public LocalDate getEarlyBird() {
        return earlyBird;
    }

    public int getEarlyBirdPris() {
        return earlyBirdPris;
    }

    public ArrayList<Forhindring> getForhindringer() {
        return forhindringer;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return tilmeldinger;
    }
}
