package Model;

import javafx.collections.ObservableList;
import org.jspecify.annotations.NullMarked;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;

@NullMarked
public class Konference {
    private final String navn;
    private final String adresse;
    private final LocalDate startDato;
    private final LocalDate slutDato;
    private final double pris;
    private final ArrayList<Hotel> hoteller = new ArrayList<>();
    private final ArrayList<Udflugt> udflugter = new ArrayList<>();
    private final ObservableList<Tilmelding> tilmeldinger = FXCollections.observableArrayList();

    public Konference(String navn, LocalDate startDato, LocalDate slutDato, String adresse, double pris) {
        this.navn = navn;
        this.slutDato = slutDato;
        this.startDato = startDato;
        this.adresse = adresse;
        this.pris = pris;
    }
    public double getPris(){
        return pris;
    }
    public LocalDate getStartDato(){
        return startDato;
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
    public void removeTilmelding(Tilmelding t){
        tilmeldinger.remove(t);
    }
    @Override
    public String toString() {
        return navn +" - " + pris + "pr/dag" + " - " + startDato + "/"+slutDato;
    }
}
