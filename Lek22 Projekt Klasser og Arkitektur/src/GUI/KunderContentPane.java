package GUI;

import Controller.Controller;
import Model.Kunde;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.time.format.DateTimeParseException;

public class KunderContentPane extends ContentPane {
    private ListView<Kunde> lswkunder = new ListView<>();
    private TextField txfNavn;
    private TextField txfMobil;

    public KunderContentPane(String title) {
        super(title);
        btnCreate.setText("Create Kunder");
        lswkunder.setMaxHeight(200);
        this.getChildren().add(1, lswkunder);
        lswkunder.getItems().setAll(Controller.getKunder());
        txfNavn = createTextField("Kunde navn");
        txfMobil = createTextField("Kunde mobil");

    }

    public void createAction() {
        super.createAction();
        String Navn = txfNavn.getText().trim();
        String Mobil = txfMobil.getText().trim();

        if (!Navn.isEmpty() && !Mobil.isEmpty()) {

            Controller.createKunde(Navn, Mobil);

            lswkunder.getItems().setAll(Controller.getKunder());
            txfNavn.clear();
            txfMobil.clear();

        }
    }
    public Kunde getSelectedKunde() {
        return lswkunder.getSelectionModel().getSelectedItem();
    }
}
