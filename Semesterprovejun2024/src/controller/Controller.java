package controller;

import model.*;
import storage.Storage;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Controller {
    public static Hold createHold(String navn){
        Hold hold = new Hold(navn);
        Storage.storeHold(hold);
        return hold;
    }
    public static Deltager createDeltager(String navn,String mobil) {
        Deltager deltager = new Deltager(navn, mobil);

        return deltager;
    }
    public static Tur createTur(LocalDate dato, int antalMinutter, int antalKm, Deltager deltager){
        Tur tur = new Tur(dato,antalMinutter,antalKm,deltager);
        deltager.addTur(tur);
        return tur;
    }
    public static Badge createBadge(String beskrivelse){
        Badge badge = new Badge( beskrivelse);
        Storage.storeBadges(badge);
        return badge;
    }

    public static ArrayList<Hold> getHoldene(){
        return Storage.getHoldene();
    }

    public static void tilføjDeltagerTilHold(Deltager deltager, Hold hold){
        hold.addDeltager(deltager);
    }
    public static void tilføjBadgeTilDeltager(Deltager deltager, Badge badge){
        deltager.addBadge(badge);
    }
    public static String deltagerOversigt(Hold hold){
        String print = "Hold: " + hold.getNavn();

        for(Deltager deltager : hold.getDeltagere()){
            print += "\n";
        print += deltager.getNavn() +" " + deltager.getMobil() + ", " + deltager.kmIAlt()+ " km , " + " Badges: ";
        if(deltager.getBadges().isEmpty()){
            print+= " INGEN BADGES " + "\n";

        }
        else{
            for(Badge badge : deltager.getBadges())
            print += badge + ", ";
        }
        }
        return print;
    }
    public static String stringBuilederDeltagerOversigt(Hold hold){
        StringBuilder print = new StringBuilder("Hold: " + hold.getNavn());

        for(Deltager deltager : hold.getDeltagere()){
            print.append("\n");
            print.append(deltager.getNavn()).append(" ").append(deltager.getMobil()).append(", ").append(deltager.kmIAlt()).append(" km , ").append(" Badges: ");
            if(deltager.getBadges().isEmpty()){
                print.append(" INGEN BADGES " + "\n");

            }
            else{
                for(Badge badge : deltager.getBadges())
                    print.append(badge).append(", ");
            }
        }
        return print.toString();
    }
}
