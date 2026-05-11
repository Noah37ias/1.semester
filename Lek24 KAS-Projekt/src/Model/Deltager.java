package Model;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.time.LocalDate;

@NullMarked
public class Deltager extends Person{
    private final String adresse;
    private final String by;
    private final String firmaTlfNr;
    private final String telefonNr;
    private final LocalDate afrejseDato;
    private final Boolean foredragsholder;

    public Deltager(String navn, String adresse, Boolean foredragsholder, LocalDate afrejseDato, String telefonNr, @Nullable String firmaTlfNr, String by) {
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

    public String getFirmaTlfNr() {
        return firmaTlfNr;
    }

    public String getTelefonNr() {
        return telefonNr;
    }

    public String getAdresse() {
        return adresse;
    }
    public String getBy() {
        return by;
    }
}
