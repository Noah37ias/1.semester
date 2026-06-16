package GUI;

import controller.Controller;
import model.Distance;
import model.Løbegruppe;
import model.Medlem;
import model.Træning;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class App {
    void main(){
        initStorage();
    }
    public void initStorage(){
        Løbegruppe LG1 = Controller.createLøbegruppe("De hurtige",4.3,Distance.MELLEM, 3);
        Løbegruppe LG2 = Controller.createLøbegruppe("Seniorer",6.3,Distance.LANG, 2);

        Medlem m1 = Controller.createMedlem("Emma Glad", LocalDate.of(2001,5,12));
        Medlem m2 = Controller.createMedlem("Asta Lippert", LocalDate.of(2003,3,16));
        Medlem m3 = Controller.createMedlem("Ellen Jensen", LocalDate.of(2002,10,20));
        Medlem m4 = Controller.createMedlem("Maren Fick", LocalDate.of(2002,9,18));
        Medlem m5 = Controller.createMedlem("Finn Madsen", LocalDate.of(1954,1,23));
        Medlem m6 = Controller.createMedlem("Bent Hansen", LocalDate.of(1956,6,12));

        Træning t1 = Controller.createTræning(LocalDateTime.of(2023,6,4,17,30),24,"De tre bakker",LG2);
        Træning t2 = Controller.createTræning(LocalDateTime.of(2023,6,6,17,30),12,"Store søen rundt",LG2);
        Træning t3 = Controller.createTræning(LocalDateTime.of(2024,1,5,17,30),8,"Lille søen rundt",LG1);
        Træning t4 = Controller.createTræning(LocalDateTime.of(2024,1,7,17,30),12,"Store søen rundt",LG1);
        Træning t5 = Controller.createTræning(LocalDateTime.of(2024,1,6,17,30),24,"De tre bakker",LG2);
        Træning t6 =  Controller.createTræning(LocalDateTime.of(2024,1,25,17,30),12,"Store søen rundt",LG2);

        Controller.addMedlemTilLøbegruppe(m1,LG1);
        Controller.addMedlemTilLøbegruppe(m2,LG1);
        Controller.addMedlemTilLøbegruppe(m3,LG1);
        Controller.addMedlemTilLøbegruppe(m4,LG1);


        Controller.addMedlemTilLøbegruppe(m5,LG2);
        Controller.addMedlemTilLøbegruppe(m6,LG2);
        Controller.addMedlemTilLøbegruppe(m3,LG2);

        Controller.createDeltagelse(m1,true,false,t3);
        Controller.createDeltagelse(m1,true,false,t4);
        Controller.createDeltagelse(m2,true,false,t3);
        Controller.createDeltagelse(m2,true,false,t4);
        Controller.createDeltagelse(m3,true,false,t3);
        Controller.createDeltagelse(m3,true,false,t4);

        Controller.createDeltagelse(m5,false,false,t1);
        Controller.createDeltagelse(m5,true,false,t2);
        Controller.createDeltagelse(m5,true,false,t5);
        Controller.createDeltagelse(m5,true,false,t6);

        Controller.createDeltagelse(m3,true,false,t1);
        Controller.createDeltagelse(m3,true,false,t2);
        Controller.createDeltagelse(m3,true,false,t5);
        Controller.createDeltagelse(m3,true,false,t6);

        Controller.createDeltagelse(m6,true,false,t1);
        Controller.createDeltagelse(m6,true,false,t5);
        Controller.createDeltagelse(m6,true,false,t6);
    }
}
