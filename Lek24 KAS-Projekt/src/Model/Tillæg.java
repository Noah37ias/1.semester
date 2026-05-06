package Model;

public class Tillæg {
    private String navn;
    private Double pris;

    public Tillæg(String navn,Double pris){
        this.navn = navn;
        this.pris = pris;
    }
    public double getPris(){
        return pris;
    }
    public String getNavn(){
        return navn;
    }
    @Override
    public String toString() {
        return "Tillæg{" +
                "navn='" + navn + '\'' +
                ", pris=" + pris +
                '}';
    }
}
