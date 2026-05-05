package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Deltager extends Person{
    private String adresse;
    private String by;
    private String firmaTlfNr;
    private String telefonNr;
    private LocalDate afrejseDato;
    private Boolean foredragsholder;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Deltager(String navn, String adresse, Boolean foredragsholder, LocalDate afrejseDato, String telefonNr, String firmaTlfNr, String by) {
        super(navn);
        this.adresse = adresse;
        this.foredragsholder = foredragsholder;
        this.afrejseDato = afrejseDato;
        this.telefonNr = telefonNr;
        this.firmaTlfNr = firmaTlfNr;
        this.by = by;
    }
    public LocalDate getAfrejseDato(){
        return afrejseDato;
    }
    public boolean isForedragsholder(){
        return foredragsholder == true;
    }
}
