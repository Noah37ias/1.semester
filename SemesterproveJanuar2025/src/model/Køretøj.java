package model;

public class Køretøj {
    private String regNummer;
    private KøretøjsKategori køretøjsKategori;

    public Køretøj(String regNummer,KøretøjsKategori køretøjsKategori){
        this.regNummer = regNummer;
        this.køretøjsKategori = køretøjsKategori;
    }
}
