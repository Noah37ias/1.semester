package Semesterprove2017.model;

import Cotroller.Controller;

import java.time.LocalDateTime;

public class Main {
    void main(){
        Arrangement a1 = new Arrangement("Fødselsdag",true);
        Plads p1 = new Plads(Område.VIP,67);
        Plads p2 = new Plads(Område.VIP,69);
        Plads p3 = new Plads(Område.BØRNE,420);
        Reservation r1 = new Reservation(LocalDateTime.now(),LocalDateTime.now(),p1);
        Reservation r2 = new Reservation(LocalDateTime.now(),LocalDateTime.now(),p2);


        IO.println(a1.antalReservedePladser());
        IO.println(p1.pris(2));
        IO.println(p3.pris(4));

        Controller.createArragement("Dota",true);
    }
}
