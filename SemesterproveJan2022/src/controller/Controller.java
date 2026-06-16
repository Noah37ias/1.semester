package controller;

import model.*;
import storage.Storage;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Controller {
    public static Løb createLøb(LocalDate dato, String sted, int normalPris, LocalDate earlyBird, int earlyBirdPris){
        Løb løb = new Løb( dato,  sted,  normalPris,  earlyBird,  earlyBirdPris);
        Storage.storeLøb(løb);
        return løb;
    }
    public static Tilmelding createTilmelding(String navn, boolean kvinde, LocalDate tilmeldingsdato, int løbeNummer, Løb løb){
        Tilmelding tilmelding = new Tilmelding(  navn,  kvinde,  tilmeldingsdato,  løbeNummer,  løb);
        løb.addTilmelding(tilmelding);
        return tilmelding;
    }
    public static Forhindring createForhindring(int nummer,String navn){
        Forhindring forhindring = new Forhindring(  nummer,navn);
        Storage.storeForhindring(forhindring);
        return forhindring;
    }
    public static Note createNote(int strafSekunder, Forhindring forhindring,Tilmelding tilmelding){
        Note note = new Note(strafSekunder, forhindring);
        tilmelding.addNote(note);
        return note;
    }
}
