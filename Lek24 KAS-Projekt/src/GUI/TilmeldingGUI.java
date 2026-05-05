package GUI;

import Controller.Controller;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Optional;
import Controller.Controller;


    public class TilmeldingGUI extends Application {
        private Controller controller;

        @Override
        public void start(Stage stage) {
            stage.setTitle("Gui Demo 2");
            GridPane pane = new GridPane();
            this.initContent(pane);
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.show();
        }

        // -------------------------------------------------------------------------

        private void initContent(GridPane pane) {
            pane.setPadding(new Insets(20));
            pane.setHgap(10);
            pane.setVgap(10);

            Button btnAdmin = new Button("Admin");

            pane.add(btnAdmin, 0, 0);
            GridPane.setHalignment(btnAdmin, HPos.RIGHT); // Placering

            btnAdmin.setOnAction(event -> {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Admin Login");
                dialog.setHeaderText("Adgang for administrationen");
                dialog.setContentText("Indtast venligst adgangskode:");
                Optional<String> result = dialog.showAndWait();

                result.ifPresent(indtastetKode -> {
                    if (controller.tjekAdminKode(indtastetKode)) {
                        //Rigtig kode
                        AdminGUI adminVindue = new AdminGUI();
                        adminVindue.show();

                    } else {
                        //Forkert kode
                        Alert errorAlert = new Alert(AlertType.ERROR);
                        errorAlert.setHeaderText("Forkert kode");
                        errorAlert.setContentText("Den indtastede kode er ikke gyldig.");
                        errorAlert.showAndWait();
                    }
                });
            });

        }
    }

