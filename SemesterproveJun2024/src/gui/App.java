package gui;

import controller.Controller;
import javafx.application.Application;
import model.*;

import java.time.LocalDate;

public class App {
    void main() {
        initStorage();
        Application.launch(gui.class);
    }

    public void initStorage() {
        Hold h1 = Controller.createHold("Cyklisterne");
        Hold h2 = Controller.createHold("Optimisterne");

        Deltager d1 = Controller.createDeltager("Ole", "12345678");
        Deltager d2 = Controller.createDeltager("Ib", "12341234");
        Deltager d3 = Controller.createDeltager("Pia", "12344321");

        Controller.tilføjDeltagerTilHold(d1, h1);
        Controller.tilføjDeltagerTilHold(d2, h1);
        Controller.tilføjDeltagerTilHold(d3, h1);


        Tur t1 = Controller.createTur(LocalDate.of(2024, 5, 15), 120, 30, d1);
        Tur t2 = Controller.createTur(LocalDate.of(2024, 5, 16), 60, 15, d1);
        Tur t3 = Controller.createTur(LocalDate.of(2024, 5, 16), 90, 25, d2);

        Badge b1 = Controller.createBadge("25 km på én dag");
        Badge b2 = Controller.createBadge("2 dage i træk");
        Badge b3 = Controller.createBadge("Hent en kollega");

        Controller.tilføjBadgeTilDeltager(d1,b1);
        Controller.tilføjBadgeTilDeltager(d2,b1);
        Controller.tilføjBadgeTilDeltager(d1,b2);

        IO.println(Controller.deltagerOversigt(h1));

    }
}
