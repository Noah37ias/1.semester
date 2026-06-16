package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Medlem {
    private String navn;
    private LocalDate fødselsDato;
    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Medlem(String navn, LocalDate fødselsDato) {
        this.navn = navn;
        this.fødselsDato = fødselsDato;
    }
    public void addDeltagelse(Deltagelse deltagelse) {
        this.deltagelser.add(deltagelse);
    }
    public ArrayList<Deltagelse> getDeltagerer() {
        return deltagelser;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getFødselsDato() {
        return fødselsDato;
    }
    public boolean fungeretSomTræner(Løbegruppe løbegruppe){
        boolean found = false;
        int i = 0;

        while(!found && i < deltagelser.size()){
            Deltagelse nuværende = deltagelser.get(i);
            if(nuværende.getTræner()==true&& nuværende.getTræning().getLøbegruppe() == løbegruppe){
                found = true;
            }
            i++;
        }
        return found;
    }

    public double antalLøbteKmIÅr(int år){
        double totalKm = 0;
        for(Deltagelse deltagelse : deltagelser){
            int årForTræning = deltagelse.getTræning().getTidspunkt().getYear();
            if(deltagelse.getFremmødt() == true && år == årForTræning){
                totalKm = deltagelse.getTræning().getAntalKm() + totalKm;
            }
        }
        return totalKm;
    }
}
