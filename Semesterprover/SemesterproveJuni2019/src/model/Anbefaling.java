package model;

public class Anbefaling {
    private Stjerner stjerner;
    private String kommentar;
    public Anbefaling(Stjerner stjerner, String kommentar){
        this.stjerner = stjerner;
        this.kommentar = kommentar;
    }

    public String getKommentar() {
        return kommentar;
    }

    public Stjerner getStjerner() {
        return stjerner;
    }
    public String toString(){
        return stjerner +" " +kommentar;
    }
}
