package model;

import java.util.ArrayList;

public class Hold {
    private String navn;
    private ArrayList<Deltager> deltagere = new ArrayList<>();

    public Hold(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Deltager> getDeltagere() {
        return deltagere;
    }

    public void addDeltager(Deltager deltager) {
        deltagere.add(deltager);
    }

    public Deltager deltagerMedFlestKM() {
        int max = 0;
        Deltager maxDeltager = null;
        for (Deltager deltager : deltagere) {
            if (max < deltager.kmIAlt()) {
                max = deltager.kmIAlt();
                maxDeltager = deltager;
            }
        }
        return maxDeltager;
    }

    public ArrayList<Badge> holdBadges(Hold hold) {
        ArrayList<Badge> result = new ArrayList<>();
        for (Deltager deltager : deltagere) {
            for (Badge badge : deltager.getBadges()) {
                if (!result.contains(badge)) {
                    result.add(badge);
                }
            }
        }
        return result;
    }
    public Deltager[] hurtigeDeltagere(int minutGrænse, int kmGrænse){
        int antal = 0;
        for(Deltager deltager : deltagere){
            boolean fundet = false;
            for(Tur tur : deltager.getTure()){
                if(tur.getAntalKm()>kmGrænse && tur.getAntalMinutter()<minutGrænse&&!fundet){
                    antal++;
                    fundet = true;
                }
            }
        }
        int i = 0;
        Deltager[] resultDeltagere = new Deltager[antal];
        for(Deltager deltager : deltagere){
            boolean fundet = false;
            for(Tur tur : deltager.getTure()){
                if(tur.getAntalKm()>kmGrænse && tur.getAntalMinutter()<minutGrænse&&!fundet){
                    resultDeltagere[i] = deltager;
                    i++;
                    fundet = true;
                }
            }
        }
        return resultDeltagere;
    }
    public String toString(){
        return navn;
    }
}
