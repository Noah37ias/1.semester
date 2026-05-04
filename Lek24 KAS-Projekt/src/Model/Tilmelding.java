package Model;

import java.time.LocalDateTime;

public class Tilmelding {
    private LocalDateTime ankomstDato;
    private Deltager deltager;
    private Konference konference;
    private Ledsager ledsager;
    private Hotel hotel;

    public Tilmelding(LocalDateTime ankomstDato, Konference konference,Deltager deltager) {
        this.ankomstDato = ankomstDato;
        this.konference = konference;
        this.deltager = deltager;
    }
}
