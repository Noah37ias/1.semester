package model;

public class Note {
    private int strafSekunder;
    private Forhindring forhindring;
    public Note(int strafSekunder, Forhindring forhindring) {
        this.strafSekunder = strafSekunder;
        this.forhindring = forhindring;
    }

    public void setForhindring(Forhindring forhindring){
        this.forhindring = forhindring;
    }

    public int getStrafSekunder() {
        return strafSekunder;
    }

    public Forhindring getForhindring() {
        return forhindring;
    }
}
