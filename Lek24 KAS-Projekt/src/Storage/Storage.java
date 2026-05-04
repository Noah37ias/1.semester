package Storage;

import Model.*;

import java.util.ArrayList;

public abstract class Storage {
    private static final ArrayList<Hotel> hoteller = new ArrayList<>();
    private static final ArrayList<Person> personer = new ArrayList<>();
    private static final ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    private static final ArrayList<Konference> konferencer = new ArrayList<>();
    private static final ArrayList<Deltager> deltagere = new ArrayList<>();

    public static void storeKonference(Konference konference){
        konferencer.add(konference);
    }
    public static void storePerson(Person person){
        personer.add(person);
    }
    public static void storeDeltager(Deltager deltager){
        deltagere.add(deltager);
    }
    public static void storeHotel(Hotel hotel){
        hoteller.add(hotel);
    }
    public static void storeTilmelding(Tilmelding tilmelding){
        tilmeldinger.add(tilmelding);
    }
}
