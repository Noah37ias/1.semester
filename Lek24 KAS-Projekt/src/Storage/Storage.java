package Storage;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jspecify.annotations.NullMarked;
import java.util.ArrayList;

@NullMarked
public abstract class Storage {
    private static final ArrayList<Hotel> hoteller = new ArrayList<>();
    private static final ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    private static final ObservableList<Konference> konferencer = FXCollections.observableArrayList();
    private static final ArrayList<Deltager> deltagere = new ArrayList<>();
    private static final ArrayList<Ledsager> ledsagere = new ArrayList<>();
    private static final ArrayList<Tillæg> tillægs = new ArrayList<>();
    private static final ArrayList<Udflugt> udflugter = new ArrayList<>();

    public static void storeKonference(Konference konference) {
        konferencer.add(konference);
    }

    public static void storeDeltager(Deltager deltager) {
        deltagere.add(deltager);
    }

    public static void storeHotel(Hotel hotel) {
        hoteller.add(hotel);
    }

    public static void storeTilmelding(Tilmelding tilmelding) {
        tilmeldinger.add(tilmelding);
    }

    public static void storeLedsager(Ledsager ledsager) {
        ledsagere.add(ledsager);
    }

    public static void storeTillæg(Tillæg tillæg) {
        tillægs.add(tillæg);
    }

    public static void storeUdflugt(Udflugt udflugt) {
        udflugter.add(udflugt);
    }

    public static ArrayList<Hotel> getHoteller() {
        return hoteller;
    }

    public static ObservableList<Konference> getKonferencer() {
        return konferencer;
    }

    public static void removeTilmelding(Tilmelding tilmelding) {
        tilmeldinger.remove(tilmelding);
    }

    public static ArrayList<Tilmelding> getTilmeldinger() {
        return tilmeldinger;
    }
}
