package model;

public class SalgsLinje {
    private int antal;
    private double aftaltRabatPrTræ;
    private Juletræ juletræ;
    private Salg salg;

    public SalgsLinje(int antal, double aftaltRabatPrTræ, Salg salg) {
        this.antal = antal;
        this.aftaltRabatPrTræ = aftaltRabatPrTræ;
        this.salg = salg;
    }
    public void setSalg(Salg salg){
        this.salg=salg;
    }
    public void setJuletræ(Juletræ juletræ) {
        this.juletræ = juletræ;
    }

    public int getAntal() {
        return antal;
    }

    public double getAftaltRabatPrTræ() {
        return aftaltRabatPrTræ;
    }

    public Juletræ getJuletræ() {
        return juletræ;
    }

    public Salg getSalg() {
        return salg;
    }
    public double getSalgsLinjePris(){
        double pris = juletræ.prisPåDato(salg.getSalgsDato());
        double stykPris = pris - aftaltRabatPrTræ;
        return antal * stykPris;
    }

}
