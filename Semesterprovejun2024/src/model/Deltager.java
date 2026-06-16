package model;

import java.util.ArrayList;

public class Deltager {
    private String navn;
    private String mobil;
    private ArrayList<Tur> ture = new ArrayList<>();
    private ArrayList<Badge>badges = new ArrayList<>();

    public Deltager(String navn,String mobil){
        this.navn = navn;
        this.mobil = mobil;
    }

    public void addTur(Tur tur){
        this.ture.add(tur);
    }
    public void removeTur(Tur tur){
        this.ture.remove(tur);
    }
    public void addBadge(Badge badge){
        this.badges.add(badge);
    }

    public ArrayList<Badge> getBadges() {
        return badges;
    }

    public ArrayList<Tur> getTure() {
        return ture;
    }

    public String getMobil() {
        return mobil;
    }

    public String getNavn() {
        return navn;
    }
    public int kmIAlt(){
        int total = 0;
        for(Tur tur : ture){
            total += tur.getAntalKm();
        }
        return total;
    }

    @Override
    public String toString() {
        return navn + ", mobil: " + mobil;
    }
}
