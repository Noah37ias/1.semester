package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Deltager extends Person{
    private String adresse;
    private String by;
    private String firmaTlfNr;
    private String telefonNr;
    private LocalDateTime afrejseDato;
    private Boolean foredragsholder;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

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
