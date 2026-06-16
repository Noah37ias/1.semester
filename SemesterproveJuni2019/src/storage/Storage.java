package storage;

import model.Bil;

import java.util.ArrayList;


public abstract class Storage {
    private static final ArrayList<Bil> biler = new ArrayList<>();

    public static void storeBil(Bil bil){
        biler.add(bil);
    }
    public static ArrayList<Bil> getBiler() {
        return biler;
    }
}
