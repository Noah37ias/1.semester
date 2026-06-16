package model;

import java.util.ArrayList;

public class Færge {
    private String navn;
    private int maxAntalPassagerer;
    private int maxAntalBiler;
    private int maxAntalLastbiler;
    private ArrayList<Afgang> afgange = new ArrayList<>();

    public Færge(String navn, int maxAntalPassagerer, int maxAntalBiler, int maxAntalLastbiler) {
        this.navn = navn;
        this.maxAntalPassagerer = maxAntalPassagerer;
        this.maxAntalBiler = maxAntalBiler;
        this.maxAntalLastbiler = maxAntalLastbiler;
    }
    public void addAfgang(Afgang afgang){
        afgange.add(afgang);
    }
    public Booking findBooking(int bookingNr){
        boolean found = false;
        int i = 0;
        Afgang afgang;

        Booking result = null;
        while(!found && i < afgange.size()){
            afgang = afgange.get(i);
            int k = 0;
            while(!found && afgang.getBookings().size()>k){
                if(afgang.getBookings().get(k).getBookingNr()==bookingNr){
                    result = afgang.getBookings().get(k);
                    found = true;
                }
                k++;
            }
            i++;
        }
        return result;
    }
}
