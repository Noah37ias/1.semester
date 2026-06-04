package storage;

import model.*;

import java.util.ArrayList;

public abstract class Storage {
    private static final ArrayList<Færge> færger = new ArrayList<>();
    private static final ArrayList<Booking> bookinger = new ArrayList<>();
    private static final ArrayList<Køretøj> køretøjer = new ArrayList<>();

    public static void storeFærge(Færge færge){
        færger.add(færge);
    }
    public static ArrayList<Færge> getFærger(){
    return færger;
    }
    public static void storeBooking(Booking booking){
        bookinger.add(booking);
    }
    public static ArrayList<Booking> getbookinger(){
        return bookinger;
    }
    public static void storeKøretøj(Køretøj køretøj){
        køretøjer.add(køretøj);
    }
    public static ArrayList<Køretøj> getKøretøjer(){
        return køretøjer;
    }

}
