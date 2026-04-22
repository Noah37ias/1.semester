package GUI;

import Controller.Controller;
import Model.Forestilling;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class PlayContentPane extends ContentPane{
    private ListView<Forestilling> lswforestillinger = new ListView<>();
    private TextField txfNavn;
    private TextField txfStart;
    private TextField txfSlut;
    public PlayContentPane(String title) {
        super(title);
        btnCreate.setText("Opret forestilling");
        btnCreate.setStyle("-fx-text-fill: green;");
        this.getChildren().add(1,lswforestillinger);
        lswforestillinger.getItems().setAll(Controller.getForestillinger());
        txfNavn = createTextField("Navn");
        txfStart = createTextField("Start Dato");
        txfStart.setPromptText("YYYY-MM-DD");
        txfSlut = createTextField("Slut Dato");
        txfSlut.setPromptText("YYYY-MM-DD");

    }

    @Override
    public void createAction() {
        try {
            super.createAction();
            String Navn = txfNavn.getText().trim();
            String start = txfStart.getText().trim();
            String slut = txfSlut.getText().trim();

            if (!Navn.isEmpty() && !start.isEmpty() && !slut.isEmpty()) {
                LocalDate StartDato = LocalDate.parse(start);
                LocalDate SlutDato = LocalDate.parse(slut);
                Controller.createForestilling(Navn, StartDato, SlutDato);

                lswforestillinger.getItems().setAll(Controller.getForestillinger());

                txfNavn.clear();
                txfStart.clear();
                txfSlut.clear();

            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fejl i indtastning");
                alert.setHeaderText("Felt mangler indtastning");
                alert.setContentText("Der mangler indtastning af data i en eller flere felter.");
                alert.showAndWait();
            }
        } catch (DateTimeParseException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fejl i indtastning");
            alert.setHeaderText("Dato format er ikke godkendt");
            alert.setContentText("Datoer skal skrives i formatet YYYY-MM-DD " +
                    "\n(eksempel: 2023-08-10).");
            alert.showAndWait();
        }
    }
    public Forestilling getSelectedForestilling(){
        return lswforestillinger.getSelectionModel().getSelectedItem();
    }
}
