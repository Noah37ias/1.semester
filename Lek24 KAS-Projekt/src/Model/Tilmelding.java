package Model;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
@NullMarked
public class Tilmelding {
    private Deltager deltager;
    private Konference konference;
    @Nullable
    private Ledsager ledsager;
    @Nullable
    private Hotel hotel;
    private LocalDate bestillingsdato;
    private ArrayList<Tillæg> tillæg = new ArrayList<>();


    public Tilmelding(Konference konference, Deltager deltager, LocalDate bestillingsdato) {
        this.konference = konference;
        this.deltager = deltager;
        this.bestillingsdato = bestillingsdato;
    }

    public double totalPris() {
        double kTotal = 0;
        double hTotal = 0;
        double lTotal = 0;
        double tTotal = 0;
        if (!deltager.isForedragsholder()) {
            kTotal = konference.getPris() * antalDage();
        }

        if (ledsager != null) {
            lTotal += ledsager.totalPrisUdflugter();
            if (hotel != null) {
                hTotal += hotel.getDobbeltPris() * (antalDage() - 1);
            }
        } else {
            if(hotel != null) {
                hTotal += hotel.getPris() * (antalDage() - 1);
            }
        }
        for (Tillæg tillæg : tillæg) {
            tTotal += tillæg.getPris() * (antalDage() - 1);
        }
        return tTotal + kTotal + hTotal + lTotal;
    }

    public void setLedsager(Ledsager ledsager) {
        this.ledsager = ledsager;
    }

    public void addTillæg(Tillæg tillæg) {
        this.tillæg.add(tillæg);
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int antalDage() {
        return (int) ChronoUnit.DAYS.between(konference.getStartDato(), deltager.getAfrejseDato()) + 1;
    }
    public Deltager getDeltager(){
        return deltager;
    }
    @Override
    public String toString() {
        return deltager.getNavn() + " - Bestillingsdato: " + LocalDate.parse(bestillingsdato.toString());
    }

    public Konference getKonference() {
        return konference;
    }

    public @Nullable Ledsager getLedsager() {
        return ledsager;
    }

    public @Nullable Hotel getHotel() {
        return hotel;
    }
    public ArrayList<Tillæg> getTillæg() {
        return tillæg;
    }
}
