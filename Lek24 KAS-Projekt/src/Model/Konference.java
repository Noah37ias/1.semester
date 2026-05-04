package Model;

import java.time.LocalDateTime;

public class Konference {
    private String navn;
    private String adresse;
    private LocalDateTime startDato;
    private LocalDateTime slutDato;

    public Konference(String navn, LocalDateTime slutDato, LocalDateTime startDato, String adresse) {
        this.navn = navn;
        this.slutDato = slutDato;
        this.startDato = startDato;
        this.adresse = adresse;
    }
}
