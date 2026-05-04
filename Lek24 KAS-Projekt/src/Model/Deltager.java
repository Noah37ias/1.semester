package Model;

import java.time.LocalDateTime;

public class Deltager extends Person{
    private String adresse;
    private String by;
    private String firmaTlfNr;
    private String telefonNr;
    private LocalDateTime afrejseDato;
    private Boolean foredragsholder;


    public Deltager(String navn, String adresse, Boolean foredragsholder, LocalDateTime afrejseDato, String telefonNr, String firmaTlfNr, String by) {
        super(navn);
        this.adresse = adresse;
        this.foredragsholder = foredragsholder;
        this.afrejseDato = afrejseDato;
        this.telefonNr = telefonNr;
        this.firmaTlfNr = firmaTlfNr;
        this.by = by;
    }
}
