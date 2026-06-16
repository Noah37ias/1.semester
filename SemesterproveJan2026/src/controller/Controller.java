package controller;


import model.*;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Controller {

    public static JuletræsGrossist createJuletræsGrossist(String navn, String cvr, double fragtPrisPrPalle) {
        JuletræsGrossist juletræsGrossist = new JuletræsGrossist(navn, cvr, fragtPrisPrPalle);

        Storage.storeJuletræsGrossist(juletræsGrossist);
        return juletræsGrossist;
    }

    public static Juletræ createJuletræ(Sort sort, int højde, int antalPrPalle, JuletræsGrossist juletræsGrossist) {
        Juletræ juletræ = new Juletræ(sort, højde, antalPrPalle);
        juletræ.setJuletræsGrossist(juletræsGrossist);
        juletræsGrossist.addJuletræ(juletræ);
        Storage.storeJuletræ(juletræ);
        return juletræ;
    }

    public static void createPeriodePris(Juletræ juletræ, LocalDate fraDato, LocalDate tilDato, double pris) {
        PeriodePris periodePris = new PeriodePris(fraDato, tilDato, pris);
        juletræ.addPeriodePris(periodePris);
    }

    public static Salg createSalg(String kunde, LocalDate salgsDato) {
        Salg salg = new Salg(kunde, salgsDato);
        Storage.storeSalg(salg);
        return salg;
    }

    public static void createSalgsLinje(int antal, double aftaltRabatPrTræ, Salg salg, Juletræ juletræ) {
        SalgsLinje salgsLinje = new SalgsLinje(antal, aftaltRabatPrTræ, salg);
        salgsLinje.setJuletræ(juletræ);
        salg.addSalgslinje(salgsLinje);
    }

    public static void printInfo() {
        String fileName = ("SemesterproveJan2026/src/controller/test");
        File out = new File(fileName);
        String text = "";
        try (PrintWriter writer = new PrintWriter(out)) {
            writer.println("Grossist,Sort,Højde,FraDato,til Dato, pris");
            writer.println("------");
            for (Juletræ juletræ : Storage.getJuletræer()) {
                for (PeriodePris periodePris : juletræ.getPeriodePriser()) {
                    writer.println(juletræ.getJuletræsGrossist() + ", " + juletræ.getSort() + ", " + juletræ.getHøjde() + "cm , " + periodePris.getFraDato() + "- " + periodePris.getTilDato() + "," + periodePris.getPris() + " kr");
                }
            }
            writer.println(text);
        } catch (FileNotFoundException ex) {
            IO.println(ex);
        }
    }

    public static ArrayList<JuletræsGrossist> getJuletræsGrossister(){
        return Storage.getJuletræsGrossister();
    }

    public static ArrayList<Juletræ> oversigtOverJuletræer() {
        ArrayList<Juletræ> juletræerKopi = new ArrayList<>(Storage.getJuletræer());
        insertionSort(juletræerKopi);
        return juletræerKopi;
    }

    public static void insertionSort(ArrayList<Juletræ> juletræer) {
        for (int i = 1; i < juletræer.size(); i++) {
            Juletræ temp = juletræer.get(i);
            int next = i - 1;
            while (next >= 0 && juletræer.get(next).compareTo(temp) > 0) {
                juletræer.set(next + 1, juletræer.get(next));
                next--;
            }
            juletræer.set(next + 1, temp);
        }
    }
    public static String oversigtTilTekst(){
        String tekst = "";
        for(Juletræ juletræ : oversigtOverJuletræer()){
            tekst += juletræ.getHøjde()+ ", " + juletræ.getSort()+", " + juletræ.getJuletræsGrossist()+"\n";
        }
        return tekst;
    }


    public static void udskrivPrislisteTilFil(String filnavn) {
        // 1. Vi opretter en fil med det givne filnavn. Try-with-resources lukker filen automatisk bagefter.
        try (PrintWriter writer = new PrintWriter(new File(filnavn))) {

            // 2. Skriv overskriften / headeren på filen
            writer.println("\"Grossist\",\"Sort\",\"højde\",\"fra dato - til dato\",\"pris\"");

            // 3. Vi skal formatere datoerne så de står som dd.MM.yyyy
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            // 4. Løb igennem alle juletræer i systemet (forudsat du har en getJuletræer() i Storage)
            for (Juletræ træ : Storage.getJuletræer()) {

                // 5. Et juletræ kan have flere priser, så vi løber dem også igennem
                for (PeriodePris pp : træ.getPeriodePriser()) {

                    // Vi tjekker lige om træet har en grossist, så vi undgår NullPointerException
                    String grossistNavn = "";
                    if (træ.getJuletræsGrossist() != null) {
                        grossistNavn = træ.getJuletræsGrossist().getNavn();
                    }

                    String sort = træ.getSort().toString();
                    String højde = træ.getHøjde() + " cm";

                    // Formater datoerne
                    String fraDato = pp.getFraDato().format(formatter);
                    String tilDato = pp.getTilDato().format(formatter);
                    String datoInterval = fraDato + " - " + tilDato;

                    // Formater prisen med 2 decimaler (virker med komma i dansk locale)
                    String pris = String.format("%.2f kr.", pp.getPris());

                    // 6. Sammensæt hele linjen med citationstegn og kommaer, og skriv den til filen
                    writer.println("\"" + grossistNavn + "\",\"" + sort + "\",\"" + højde + "\",\"" + datoInterval + "\",\"" + pris + "\"");
                }
            }
            System.out.println("Prislisten er nu gemt i filen: " + filnavn);

        } catch (FileNotFoundException e) {
            System.out.println("Der opstod en fejl ved oprettelse af filen: " + e.getMessage());
        }
    }

    public static void udskrivPrislisteTilFilNem() {
        try {
            // 1. Opretter filen
            PrintWriter out = new PrintWriter("prisliste.txt");

            // 2. Skriver en simpel overskrift
            out.println("Grossist, Sort, Hoejde, Periode, Pris");

            // 3. Løber alle træer og deres priser igennem
            for (Juletræ træ : Storage.getJuletræer()) {
                for (PeriodePris pp : træ.getPeriodePriser()) {

                    // Henter grossistens navn (hvis den har en)
                    String grossistNavn = "Ingen grossist";
                    if (træ.getJuletræsGrossist() != null) {
                        grossistNavn = træ.getJuletræsGrossist().getNavn();
                    }

                    // 4. Skriver hele linjen direkte ud i filen med + tegn
                    out.println(grossistNavn + ", " +
                            træ.getSort() + ", " +
                            træ.getHøjde() + ", " +
                            pp.getFraDato() + " - " + pp.getTilDato() + ", " +
                            pp.getPris());
                }
            }

            // 5. VIGTIGT: Husk at lukke filen, ellers bliver den tom!
            out.close();

            System.out.println("Filen er lavet!");

        } catch (FileNotFoundException e) {
            // Hvis der går noget galt
            System.out.println("Filen kunne ikke laves.");
        }
    }
}

