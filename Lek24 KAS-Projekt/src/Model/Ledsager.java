package Model;

import java.util.ArrayList;

public class Ledsager extends Person {
    private Tilmelding tilmelding;
    private ArrayList<Udflugt> udflugter;
    public Ledsager(String navn){
        super(navn);
    }
}
