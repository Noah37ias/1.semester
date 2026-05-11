package Model;

import org.jspecify.annotations.NullMarked;
import java.util.ArrayList;
@NullMarked

public class Hotel {
    private final String navn;
    private final double pris;
    private final double dobbeltPris;
    private final ArrayList<Tillæg> tillæg = new ArrayList<>();

    public Hotel(double pris, String navn, double dobbeltPris) {
        this.pris = pris;
        this.navn = navn;
        this.dobbeltPris = dobbeltPris;
    }
    public void addTillæg(Tillæg tillæg){
        this.tillæg.add(tillæg);
    }
    public double getPris(){
        return pris;
    }
    public double getDobbeltPris(){
        return dobbeltPris;
    }
    public String getNavn(){
        return navn;
    }
    public ArrayList<Tillæg> getTillæg(){
        return tillæg;
    }

    @Override
    public String toString() {
        return navn + " - " + pris + " kr/nat";
    }
}
