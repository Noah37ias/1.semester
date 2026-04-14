package opg4.gui;

import opg4.controller.Controller;
import opg4.model.Company;
import javafx.application.Application;

public class ArchitectureApp {
    void main() {
        initStorage();
        Application.launch(ArchitectureGui.class);
    }

    public static void initStorage() {
        Company ibm = Controller.createCompany("IBM", 37);
        Company amd = Controller.createCompany("AMD", 40);
        Company sled = Controller.createCompany("SLED", 45);
        Controller.createCompany("Vector", 32);
    }
}
