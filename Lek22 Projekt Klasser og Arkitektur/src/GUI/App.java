package GUI;

import Controller.Controller;
import Model.Forestilling;
import Model.Kunde;
import Model.Plads;
import Model.PladsType;
import javafx.application.Application;

import java.time.LocalDate;

public class App {
    void main() {
        initStorage();
        testPrint();
        Application.launch(TeaterGUI.class);
    }

    public static void initStorage() {
        Controller.createForestilling("Evita", LocalDate.of(2023, 8, 10), LocalDate.of(2023, 8, 20));
        Controller.createForestilling("Lykke Per", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 10));
        Controller.createForestilling("Chess", LocalDate.of(2023, 8, 21), LocalDate.of(2023, 8, 30));

        Controller.createKunde("Anders Hansen", "11223344");
        Controller.createKunde("Peter Jensen", "12345678");
        Controller.createKunde("Niels Madsen", "12341234");
        int rows = 15;
        int seatsPrRow = 20;

        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= seatsPrRow; col++) {
                int price = 400;
                PladsType type = PladsType.STANDARD;

                if (row <= 5) {
                    price += 50;
                }

                if (3 <= col && 18 >= col && row <= 10) {
                    price += 50;
                }

                if (col >= 8 && col <= 12) {
                    type = switch (row) {
                        case 10 -> PladsType.KØRESTOL;
                        case 11 -> PladsType.EKSTRABEN;
                        default -> PladsType.STANDARD;
                    };

                }
                Controller.createPlads(row, col, price, type);
            }
        }
    }

    public void testPrint() {
        IO.println("Forestillinger: ");
        for (Forestilling forestilling : Controller.getForestillinger()) {
            IO.println(forestilling);
        }
        IO.println("");
        IO.println("Kunder:");
        for (Kunde kunder : Controller.getKunder()) {
            IO.println(kunder);
        }
        IO.println("");
        IO.println("Pladser:");
        for (Plads plads : Controller.getPladser()) {
            IO.println(plads);
        }
    }
}