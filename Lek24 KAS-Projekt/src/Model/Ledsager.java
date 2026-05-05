package Model;

import java.util.ArrayList;

public class Ledsager extends Person {
    private Tilmelding tilmelding;
    private ArrayList<Udflugt> udflugter = new ArrayList<>();

    public Ledsager(String navn) {
        super(navn);
    }

    public void addUdflugt(Udflugt udflugt) {
        udflugter.add(udflugt);
    }

    public double totalPrisUdflugter() {
        double total = 0;
        for (Udflugt udflugt : udflugter) {
            total += udflugt.getPris();
        }
        return total;
    }
}
