package model;

import java.util.ArrayList;

public class Forhindring {
    private int nummer;
    private String navn;
    private ArrayList<Løb> løb = new ArrayList<>();

    public Forhindring(int nummer,String navn){
    this.nummer = nummer;
    this.navn= navn;
    }
    public void addLøb(Løb løb){
        this.løb.add(løb);
    }
    public int getNummer() {
        return nummer;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Løb> getLøb() {
        return løb;
    }
}
