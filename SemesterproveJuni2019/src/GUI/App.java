package GUI;

import controller.Controller;
import javafx.application.Application;
import model.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class App {
    void main(){
        initStorage();
        Application.launch(SamKørselPane.class);
    }
    public void initStorage(){
        Bil b1 = Controller.createBil("AB 12 345","Jane Jensen");
        Bil b2 = Controller.createBil("XY 98 765","Lene Hansen");

        Lift l1 = Controller.createLift(LocalDateTime.of(2026,6,22,10,0),90,"Aarhus","Odense",3,b1);
        Lift l2 = Controller.createLift(LocalDateTime.of(2026,6,24,20,0),80,"Odense","Århus",2,b1);
        Lift l3 = Controller.createLift(LocalDateTime.of(2026,6,28,10,0),85,"Aarhus","Odense",1,b1);
        Lift l4 = Controller.createLift(LocalDateTime.of(2026,6,22,10,30),100,"Aarhus","Odense",3,b2);

        Booking booking1 = Controller.createBooking("Mette", LocalTime.of(10,0),"Aros",l1);
        Booking booking2 = Controller.createBooking("Karina", LocalTime.of(20,15),"Banegården",l2);
        Booking booking3 = Controller.createBooking("Camilla", LocalTime.of(10,10),"Musikhuset",l3);

        Controller.createAnbefaling(Stjerner.FEM,"God",booking1);
        Controller.createAnbefaling(Stjerner.FIRE,"God",booking2);
        Controller.createAnbefaling(Stjerner.FEM,"Meget God",booking3);

        IO.println(Arrays.toString(Controller.anbefalingFrekvens()));


    }
}
