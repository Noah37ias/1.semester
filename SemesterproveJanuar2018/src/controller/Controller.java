package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Controller {
    public static Tutor createTutor(String navn, String email){
        Tutor tutor = new Tutor(navn, email);
        Storage.storeTutor(tutor);
        return tutor;
    }
    public static Arrangement createArrangement(String titel, LocalDate date, LocalTime startTid, LocalTime slutTid, double pris){
        Arrangement arrangement = new Arrangement(titel,date,startTid,slutTid,pris);
        Storage.storeArrangement(arrangement);
        return arrangement;
    }
    public static Hold createHold(String betegnelse, String holdleder, Uddannelse uddanelse){
        Hold hold = new Hold(betegnelse,holdleder,uddanelse);
        return hold;
    }
    public static Uddannelse createUddannelse(String navn){
        Uddannelse uddanelse = new Uddannelse(navn);
        Storage.storeUddannelse(uddanelse);
        return uddanelse;
    }
}
