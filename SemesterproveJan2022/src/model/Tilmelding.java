package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tilmelding {
    private String navn;
    private boolean kvinde;
    private LocalDate tilmeldingsdato;
    private int løbeNummer;
    private int løbsTid = -1;
    private final Løb løb;
    private ArrayList<Note> noter = new ArrayList<>();

    public Tilmelding(String navn, boolean kvinde, LocalDate tilmeldingsdato, int løbeNummer, Løb løb) {
        this.navn = navn;
        this.kvinde = kvinde;
        this.tilmeldingsdato = tilmeldingsdato;
        this.løbeNummer = løbeNummer;
        this.løb = løb;
    }

    public void setLøbsTid(int løbsTid) {
        this.løbsTid = løbsTid;
    }

    public void addNote(Note note) {
        noter.add(note);
    }

    public ArrayList<Note> getNoter() {
        return noter;
    }

    public Løb getLøb() {
        return løb;
    }

    public int getLøbsTid() {
        return løbsTid;
    }

    public int getLøbeNummer() {
        return løbeNummer;
    }

    public LocalDate getTilmeldingsdato() {
        return tilmeldingsdato;
    }

    public boolean isKvinde() {
        return kvinde;
    }

    public String getNavn() {
        return navn;
    }
}
