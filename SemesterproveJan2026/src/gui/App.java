package gui;

import controller.Controller;
import javafx.application.Application;
import model.*;
import model.Sort;
import storage.Storage;

import java.time.LocalDate;

public class App {
    void main(){
        initStorage();

        Application.launch(GUI.class);;

    }
    private void initStorage(){
        JuletræsGrossist JG1 = Controller.createJuletræsGrossist("Hammel Juletræer","2316",150);
        JuletræsGrossist JG2 = Controller.createJuletræsGrossist("Sommersminde juletræsplantage","34343",140);

        Juletræ j1 = Controller.createJuletræ(Sort.NORDMANNSGRAN,200,100,JG1);
        Juletræ j2 = Controller.createJuletræ(Sort.RØDGRAN,170,140,JG1);
        Juletræ j3 = Controller.createJuletræ(Sort.NOBILIS,170,140,JG2);
        Juletræ j4 = Controller.createJuletræ(Sort.NORDMANNSGRAN,160,144,JG2);

        Controller.createPeriodePris(j3, LocalDate.of(2025,11,1),LocalDate.of(2025,11,30),40);
        Controller.createPeriodePris(j3, LocalDate.of(2025,12,1),LocalDate.of(2025,12,24),60);
        Controller.createPeriodePris(j4, LocalDate.of(2025,12,1),LocalDate.of(2025,12,24),60);
        Controller.createPeriodePris(j4, LocalDate.of(2025,12,1),LocalDate.of(2025,12,24),75);

        Controller.createPeriodePris(j1, LocalDate.of(2025,11,1),LocalDate.of(2025,11,30),50);
        Controller.createPeriodePris(j1, LocalDate.of(2025,12,1),LocalDate.of(2025,12,24),100);
        Controller.createPeriodePris(j2, LocalDate.of(2025,12,1),LocalDate.of(2025,12,24),40);
        Controller.createPeriodePris(j2, LocalDate.of(2025,12,1),LocalDate.of(2025,12,24),80);

        Salg salg1 = Controller.createSalg("FDF Viby",LocalDate.of(2025,2,25));
        Controller.createSalgsLinje(333,5,salg1,j1);
        Controller.createSalgsLinje(250,3,salg1,j2);


    }

}
