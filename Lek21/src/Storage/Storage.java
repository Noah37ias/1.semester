package Storage;

import Semesterprove2017.model.Arrangement;
import Semesterprove2017.model.Plads;

import java.util.ArrayList;

public abstract class Storage {
    private static final ArrayList<Arrangement> arrangementer = new ArrayList<>();
    private static final ArrayList<Plads> pladser = new ArrayList<>();

    public static ArrayList<Arrangement> getArrangementer(){
        return arrangementer;
    }
    public static ArrayList<Plads> getPladser(){
        return pladser;
    }
    public static void storeArrangement(Arrangement arrangement){
        arrangementer.add(arrangement);
    }
    public static void storePlads(Plads plads){
        pladser.add(plads);
    }
}
