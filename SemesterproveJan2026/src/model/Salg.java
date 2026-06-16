package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salg {
    private String kunde;
    private LocalDate salgsDato;
    private ArrayList<SalgsLinje> salgsLinjer = new ArrayList<>();

    public Salg(String kunde, LocalDate salgsDato) {
        this.kunde = kunde;
        this.salgsDato = salgsDato;
    }

    public void addSalgslinje(SalgsLinje salgsLinje) {
        salgsLinjer.add(salgsLinje);
    }

    public void removeSalgslinje(SalgsLinje salgsLinje) {
        salgsLinjer.remove(salgsLinje);
    }

    public String getKunde() {
        return kunde;
    }

    public LocalDate getSalgsDato() {
        return salgsDato;
    }

    public ArrayList<SalgsLinje> getSalgsLinjer() {
        return salgsLinjer;
    }
    public double prisExclusivFragt(){
        double totalPris = 0;
        for(SalgsLinje salgsLinje : salgsLinjer){
            totalPris += salgsLinje.getSalgsLinjePris();
        }
        return totalPris;
    }
    public double prisInclusiveFragt(){
        double totalPris = prisExclusivFragt();
        for(SalgsLinje salgsLinje : salgsLinjer){
            totalPris+= salgsLinje.getJuletræ().pallePris(salgsLinje.getAntal());
        }
        return totalPris;
    }
}
