package GUI;

import Controller.Controller;
import Model.*;
import javafx.application.Application;

import java.time.LocalDate;

public class App {
    void main(){
        initStorage();
        Application.launch(TilmeldingGUI.class);

    }
    public static void initStorage(){
        Konference k1 = Controller.createKonference("Hav og himmel", LocalDate.of(2026,5,28),LocalDate.of(2026,5,30),"Odense universitet",1500);
        Konference k2 = Controller.createKonference("Himmel og Hav", LocalDate.of(2026,5,28),LocalDate.of(2026,5,30),"Odense universitet",1667);


        Deltager d1 = Controller.createDeltager("Finn Madsen","Psykovej 67", false,LocalDate.of(2026,5,30),"52243141","57575757","Århus");
        Deltager d2 = Controller.createDeltager("Niels Petersen","Psykovej 69", false,LocalDate.of(2026,5,30),"65783421","12568945","Århus");
        Deltager d3 = Controller.createDeltager("Ulla Hansen","Psykovej 167", false,LocalDate.of(2026,5,29),"89678945","54765467","Århus");
        Deltager d4 = Controller.createDeltager("Peter Sommer","Psykovej 267", false,LocalDate.of(2026,5,30),"76237689","12214343","Århus");
        Deltager d5 = Controller.createDeltager("Lone Jensen","Psykovej 367", true,LocalDate.of(2026,5,30),"76548954","09875634","Århus");

        Udflugt u1 = Controller.createUdflugt("Odense byrundtur", LocalDate.of(2026,5,28),125);
        Udflugt u2 = Controller.createUdflugt("Egeskov",LocalDate.of(2026,5,29),75);
        Udflugt u3 = Controller.createUdflugt("Trapholt Museum Kolding",LocalDate.of(2026,5,30),200);

        Ledsager l1 = Controller.createLedsager("Hans hansen");
        l1.addUdflugt(u1);

        Ledsager l2 = Controller.createLedsager("Mie Sommer");
        l2.addUdflugt(u2);
        l2.addUdflugt(u3);

        Ledsager l3 = Controller.createLedsager("Jan Madsen");
        l3.addUdflugt(u1);
        l3.addUdflugt(u2);

        Hotel h1 = Controller.createHotel(1050,"Den Hvide svane",1250);
        Tillæg t1 = Controller.createTillæg("WIFI",50);
        Tillæg t2 = Controller.createTillæg("Morgenmad",150);
        h1.addTillæg(t1);
        h1.addTillæg(t2);
        k1.addUdflugt(u1);
        k1.addUdflugt(u2);
        k1.addUdflugt(u3);

        Tilmelding tilmelding1 = Controller.createTilmelding(k1,d1,LocalDate.now());

        Tilmelding tilmelding2 = Controller.createTilmelding(k1,d2,LocalDate.now());
        tilmelding2.setHotel(h1);

        Tilmelding tilmelding3 = Controller.createTilmelding(k1,d3,LocalDate.now());
        tilmelding3.setLedsager(l1);
        k1.addHotel(h1);

        Tilmelding tilmelding4 = Controller.createTilmelding(k1,d4,LocalDate.now());
        tilmelding4.setHotel(h1);
        tilmelding4.setLedsager(l2);
        tilmelding4.addTillæg(t1);

        Tilmelding tilmelding5 = Controller.createTilmelding(k1,d5,LocalDate.now());
        tilmelding5.setHotel(h1);
        tilmelding5.addTillæg(t1);
        tilmelding5.setLedsager(l3);
    }
}
