package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private String adresse;
    private LocalDateTime startDato;
    private LocalDateTime slutDato;
    private ArrayList<Hotel> hoteller;
    private ArrayList<Konference> konferencer;

    public Konference(String navn, LocalDateTime slutDato, LocalDateTime startDato, String adresse) {
        this.navn = navn;
        this.slutDato = slutDato;
        this.startDato = startDato;
        this.adresse = adresse;
    }
}
