package Controller;

import Model.*;
import Storage.Storage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Controller {
    public static Deltager createDeltager(String navn, String adresse, Boolean foredragsholder, LocalDate afrejseDato, String telefonNr, String firmaTlfNr, String by){
        Deltager deltager = new Deltager(navn, adresse, foredragsholder, afrejseDato, telefonNr, firmaTlfNr, by);
        Storage.storeDeltager(deltager);
        return deltager;
    }
    public static Hotel createHotel(double pris, String navn,double dobbeltPris){
        Hotel hotel = new Hotel(pris,navn,dobbeltPris);
        Storage.storeHotel(hotel);
        return hotel;
    }
    public static Konference createKonference(String navn,LocalDate startDato, LocalDate slutDato,String adresse, double pris){
        Konference konference = new Konference(navn,startDato,slutDato,adresse,pris);
        Storage.storeKonference(konference);
        return konference;
    }
    public static Tilmelding createTilmelding(Konference konference, Deltager deltager, LocalDate bestillingsdato){
        Tilmelding tilmelding = new Tilmelding(konference,deltager,bestillingsdato);
        Storage.storeTilmelding(tilmelding);
        return tilmelding;
    }
    public static Ledsager createLedsager(String navn){
        Ledsager ledsager = new Ledsager(navn);
        Storage.storeLedsager(ledsager);
        return ledsager;
    }
    public static Tillæg createTillæg(String navn,double pris){
        Tillæg tillæg = new Tillæg(navn,pris);
        Storage.storeTillæg(tillæg);
        return tillæg;
    }
    public static Udflugt createUdflugt(String navn,LocalDate dato, double pris){
        Udflugt udflugt = new Udflugt(navn,dato,pris);
        Storage.storeUdflugt(udflugt);
        return udflugt;
    }
    public static boolean tjekAdminKode(String indtastetKode) {
        String kode = "6767";
        return indtastetKode.equals(kode);
    }
}

