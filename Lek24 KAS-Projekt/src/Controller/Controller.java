package Controller;

import Model.*;
import Storage.Storage;
import javafx.collections.ObservableList;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import java.time.LocalDate;
import java.util.ArrayList;

@NullMarked
public abstract class Controller {

    /*
     * Opretter en deltager og retunerer den
     * pre: navn ikke tom, adresse ikke er tom, afrejseDato ikke er tom, telefonNr ikke er tom og by ikke er tom.
     */
    public static Deltager createDeltager(String navn, String adresse, Boolean foredragsholder, LocalDate afrejseDato, String telefonNr, @Nullable String firmaTlfNr, String by) {
        Deltager deltager = new Deltager(navn, adresse, foredragsholder, afrejseDato, telefonNr, firmaTlfNr, by);
        Storage.storeDeltager(deltager);
        return deltager;
    }
    /*
     * Opretter et hotel og retunerer det
     * pre: pris ikke tom, navn ikke tom, dobbeltpris ikke tom
     */
    public static Hotel createHotel(double pris, String navn, double dobbeltPris) {
        Hotel hotel = new Hotel(pris, navn, dobbeltPris);
        Storage.storeHotel(hotel);
        return hotel;
    }
    /*
     * Opretter en konference og retunerer den
     * pre: navn ikke tom, startdato ikke tom, slutdato ikke tom, adresse ikke tom, pris ikke tom
     */
    public static Konference createKonference(String navn, LocalDate startDato, LocalDate slutDato, String adresse, double pris) {
        Konference konference = new Konference(navn, startDato, slutDato, adresse, pris);
        Storage.storeKonference(konference);
        return konference;
    }
    /*
     * Opretter en tilmelding og retunerer den
     * pre: Konference ikke tom, Deltager ikke tom
     */
    public static Tilmelding createTilmelding(Konference konference, Deltager deltager, LocalDate bestillingsdato) {
        Tilmelding tilmelding = new Tilmelding(konference, deltager, bestillingsdato);
        Storage.storeTilmelding(tilmelding);
        konference.addTilmelding(tilmelding);
        return tilmelding;
    }
    /*
     * Opretter en ledsager og retunerer den
     * pre: navn ikke tom
     */
    public static Ledsager createLedsager(String navn) {
        Ledsager ledsager = new Ledsager(navn);
        Storage.storeLedsager(ledsager);
        return ledsager;
    }

    /*
     * Opretter et Tillæg og retunerer den
     * pre: navn ikke tom og pris ikke tom
     */
    public static Tillæg createTillæg(String navn, double pris) {
        Tillæg tillæg = new Tillæg(navn, pris);
        Storage.storeTillæg(tillæg);
        return tillæg;
    }
    /*
     * Opretter en udflugt og retunerer den
     * pre: navn ikke tom, LocalDate indenfor konferencen start og slutdato, pris ikke tom
     */
    public static Udflugt createUdflugt(String navn, LocalDate dato, double pris) {
        Udflugt udflugt = new Udflugt(navn, dato, pris);
        Storage.storeUdflugt(udflugt);
        return udflugt;
    }
    /*
     * Retunerer en boolean sandt eller falsk, alt efter om den
     * kode man har skrevet er indentisk med indtastetkode
     */
    public static boolean tjekAdminKode(String indtastetKode) {
        String kode = "6767";
        return indtastetKode.equals(kode);
    }
    /*
     * Retunerer en ArrayList med hoteller fra storage
     */
    public static ArrayList<Hotel> getHoteller() {
        return Storage.getHoteller();
    }
    /*
     * Retunerer en ObservableList med konferencer fra storage
     */
    public static ObservableList<Konference> getKonferencer() {
        return Storage.getKonferencer();
    }
    /*
     * Fjerner en specifik valgt tilmelding fra tilmeldingslisten i storage
     * Pre: Tilmelding != null og skal eksistere i listen i storage
     */
    public static void removeTilmelding(Tilmelding tilmelding) {
        Storage.removeTilmelding(tilmelding);
    }
    /*
     * Tilføjer en udflugt til en ledsager
     * Pre: ledsager != null og Hotel != udflugt
     */
    public static void addUdflugtTilLedsager(Ledsager ledsager, Udflugt udflugt) {
        ledsager.addUdflugt(udflugt);
        udflugt.addLedsager(ledsager);
    }
    /*
     * Tilføjer et tillæg til et hotel
     * Pre: tillæg != null og Hotel != null
     */
    public static void addTillægTilHotel(Hotel hotel, Tillæg tillæg) {
        hotel.addTillæg(tillæg);
    }
    /*
     * Tilføjer en udflugt til en konference
     * Pre: Konference != null og udflugt != null
     */
    public static void addUdflugtTilKonference(Konference konference, Udflugt udflugt) {
        konference.addUdflugt(udflugt);
    }

    /*
     * Tilføjer et hotel til en konference
     * Pre: Konference != null og Hotel != null
     */
    public static void addHotelTilKonference(Konference konference, Hotel hotel) {
        konference.addHotel(hotel);
    }

    /*
     * Retunerer en string arraylist med alle hotel navn
     */
    public static ArrayList<String> hotelList() {
        ArrayList<String> list = new ArrayList<>();

        for (Hotel h : Storage.getHoteller())
            list.add(h.getNavn());
        return list;
    }

    /*
     * Retunerer en arraylist med tilmeldinger fra storage.
     */
    public static ArrayList<Tilmelding> getTilmeldinger() {
        return Storage.getTilmeldinger();
    }

    public static void addTillægTilTilmelding(Tillæg tillæg, Tilmelding tilmelding){
        tilmelding.addTillæg(tillæg);
    }
}

