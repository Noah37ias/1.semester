package Model;
import org.jspecify.annotations.NullMarked;
import java.util.ArrayList;

@NullMarked
public class Ledsager extends Person {
    private final ArrayList<Udflugt> udflugter = new ArrayList<>();

    public Ledsager(String navn) {
        super(navn);
    }

    public void addUdflugt(Udflugt udflugt) {
        udflugter.add(udflugt);
        udflugt.addLedsager(this);
    }

    public double totalPrisUdflugter() {
        double total = 0;
        for (Udflugt udflugt : udflugter) {
            total += udflugt.getPris();
        }
        return total;
    }
    public ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }
    public String toString(){
        return getNavn();
    }
}
