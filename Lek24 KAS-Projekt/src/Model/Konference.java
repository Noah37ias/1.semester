package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private String adresse;
    private LocalDate startDato;
    private LocalDate slutDato;
    private double pris;
    private ArrayList<Hotel> hoteller;
    private ArrayList<Konference> konferencer;

    public Konference(String navn, LocalDate startDato, LocalDate slutDato, String adresse, double pris) {
        this.navn = navn;
        this.slutDato = slutDato;
        this.startDato = startDato;
        this.adresse = adresse;
        this.pris = pris;
        this.hoteller = new ArrayList<>();
    }
    public double getPris(){
        return pris;
    }
    public LocalDate getStartDato(){
        return startDato;
    }
    public LocalDate getSlutDato(){
        return slutDato;
    }
    public String getAdresse(){
        return adresse;
    }
    public String getNavn(){
        return navn;
    }
    public ArrayList<Hotel> getHoteller(){
        return hoteller;
    }
    public void addHotel(Hotel hotel){
        hoteller.add(hotel);
    }
}
