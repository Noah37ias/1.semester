package Model;

import javafx.collections.ObservableList;
import org.jspecify.annotations.NullMarked;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;

@NullMarked
public class Konference {
    private String navn;
    private String adresse;
    private LocalDate startDato;
    private LocalDate slutDato;
    private double pris;
    private ArrayList<Hotel> hoteller;
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    private ObservableList<Tilmelding> tilmeldinger = FXCollections.observableArrayList();

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
    public void addUdflugt(Udflugt udflugt){
        udflugter.add(udflugt);
    }
    public ArrayList<Udflugt> getUdflugter(){
        return udflugter;
    }
    public ObservableList<Tilmelding> getTilmeldinger(){
        return tilmeldinger;
    }

    public void addTilmelding(Tilmelding t){
        tilmeldinger.add(t);
    }

    @Override
    public String toString() {
        return navn +" - " + pris + "pr/dag" + " - " + startDato + "/"+slutDato;
    }
}
