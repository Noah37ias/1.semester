package Model;

import org.jspecify.annotations.NullMarked;

@NullMarked
public class Tillæg {
    private final String navn;
    private final double pris;

    public Tillæg(String navn,double pris){
        this.navn = navn;
        this.pris = pris;
    }
    public double getPris(){
        return pris;
    }
    public String getNavn(){
        return navn;
    }
}
