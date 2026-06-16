package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Controller {
    public static Deltagelse createDeltagelse(Medlem medlem, Boolean isFremmødt, Boolean isTræner,Træning træning){
        Deltagelse deltagelse = new Deltagelse(isFremmødt, isTræner, træning);
        medlem.addDeltagelse(deltagelse);
        return deltagelse;
    }
    public static Medlem createMedlem(String navn, LocalDate fødselsDato){
        Medlem medlem = new Medlem(navn, fødselsDato);
        Storage.storeMedlemmer(medlem);
        return medlem;
    }
    public static Løbegruppe createLøbegruppe(String betegnelse, double minutterPrKm, Distance distance, int antalTræningerPrUge){
        Løbegruppe løbegruppe = new Løbegruppe(betegnelse,  minutterPrKm,  distance,  antalTræningerPrUge);
        Storage.storeLøbegrupper(løbegruppe);
        return løbegruppe;
    }
    public static Træning createTræning(LocalDateTime tidspunkt, double antalKm,String rute, Løbegruppe løbegruppe){
        Træning træning = new Træning( tidspunkt,  antalKm,rute,  løbegruppe);

        return træning;
    }
    public static void addMedlemTilLøbegruppe(Medlem medlem, Løbegruppe løbegruppe){
        løbegruppe.addMedlem(medlem);
    }
    public static void aflysTræning(Træning træning){
        
    }

}
