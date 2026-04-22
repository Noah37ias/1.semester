package Semesterprove2017.model;

import java.util.ArrayList;

public class Arrangement {
    private String navn;
    private boolean offentlig;
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public  Arrangement(String navn, boolean offentlig) {
        this.navn = navn;
        this.offentlig = offentlig;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public boolean isOffentlig() {
        return offentlig;
    }

    public void setOffentlig(boolean offentlig) {
        this.offentlig = offentlig;
    }

    public int antalReservedePladser() {
        return reservations.size();
    }
}
