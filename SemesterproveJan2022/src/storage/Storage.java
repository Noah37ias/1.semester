package storage;

import model.*;
import java.util.ArrayList;

public abstract class Storage {
    private static final ArrayList<Løb> løbs = new ArrayList<>();
    private static final ArrayList<Forhindring> forhindringer = new ArrayList<>();

    public static void storeLøb(Løb løb){
        løbs.add(løb);
    }
    public static void storeForhindring(Forhindring forhindring){
        forhindringer.add(forhindring);
    }
    public static ArrayList<Løb> getLøb(){
        return løbs;
    }
    public static ArrayList<Forhindring> getForhindringer(){
        return forhindringer;
    }
}
