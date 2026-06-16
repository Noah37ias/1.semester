package storage;

import model.Løbegruppe;
import model.Medlem;

import java.util.ArrayList;

public abstract class Storage {
    private static ArrayList<Medlem> medlemmer = new ArrayList<>();
    private static ArrayList<Løbegruppe> løbegrupper = new ArrayList<>();

    public static void storeMedlemmer(Medlem medlem){
        medlemmer.add(medlem);
    }
    public static ArrayList<Medlem> getMedlemmer(){
        return medlemmer;
    }
    public static void storeLøbegrupper(Løbegruppe løbegruppe){
        løbegrupper.add(løbegruppe);
    }
    public static ArrayList<Løbegruppe> getLøbegrupper(){
        return løbegrupper;
    }

}
