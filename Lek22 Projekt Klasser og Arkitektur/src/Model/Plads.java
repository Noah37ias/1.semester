package Model;

public class Plads {
    private final int række;
    private final int nr;
    private final int pris;
    private final PladsType pladsType;

    public Plads(int række, int nr, int pris, PladsType pladstype) {
        this.række = række;
        this.nr = nr;
        this.pris = pris;
        this.pladsType = pladstype;

    }

    public String toString() {
        return String.format("Plads(%s, %s, %s, %s)", række, nr, pris, pladsType);
    }

    public int getPris() {
        return pris;
    }
    public int getNr() {
        return nr;
    }

    public int getRække(){
        return række;
    }
}
