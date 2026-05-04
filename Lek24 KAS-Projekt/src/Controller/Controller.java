package Controller;

import Model.Deltager;
import Model.Hotel;
import Model.Konference;
import Model.Tilmelding;
import Storage.Storage;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Controller {
    public static Deltager createDeltager(String navn, String adresse, Boolean foredragsholder, LocalDateTime afrejseDato, String telefonNr, String firmaTlfNr, String by){
        Deltager deltager = new Deltager(navn, adresse, foredragsholder, afrejseDato, telefonNr, firmaTlfNr, by);
        Storage.storeDeltager(deltager);
        return deltager;
    }
    public static Hotel createHotel(Double pris,String navn){
        Hotel hotel = new Hotel(pris,navn);
        Storage.storeHotel(hotel);
        return hotel;
    }
    public static Konference createKonference(String navn,LocalDateTime slutDato, LocalDateTime startDato,String adresse){
        Konference konference = new Konference(navn,slutDato,startDato,adresse);
        Storage.storeKonference(konference);
        return konference;
    }
    public static Tilmelding createTilmelding(LocalDateTime ankomstDato){
        Tilmelding tilmelding = new Tilmelding(ankomstDato);
        Storage.storeTilmelding(tilmelding);
        return tilmelding;
    }
}
