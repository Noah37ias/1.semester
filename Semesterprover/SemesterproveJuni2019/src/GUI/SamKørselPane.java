package GUI;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.*;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.scene.control.*;

import java.time.LocalTime;


public class SamKørselPane extends Application {
    private DatePicker datoValg;
    private Button visLift;
    private ListView<Lift> lifts;
    private TextArea taNavn;
    private TextArea taSted;
    private TextArea taTid;
    private Button btnOpret;
    private ListView<Booking> lswBookinger;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Samkørsel");
        GridPane pane = new GridPane();
        pane.setStyle("-fx-background-color: #93c47e;");
        this.initContent(pane);

        //SCROLLBAR
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(pane);
        scrollPane.setFitToWidth(true);
        //Opretter vores stage samt størrelse
        Scene scene = new Scene(scrollPane, 740, 470);
        stage.setScene(scene);
        //Viser vores stage
        stage.show();

    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        //Mellemrum mellem ting
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(15);

        VBox venstre = del1();
        VBox højre = del2();
        højre.setMaxWidth(300);
        pane.add(venstre, 0, 0);
        pane.add(højre, 1, 0);

    }

    private HBox datooglift() {
        HBox boks = new HBox(10);
        Label dato = new Label("Udbudte lift på dato: ");
        datoValg = new DatePicker();
        visLift = new Button("Vis lift");

        boks.getChildren().addAll(dato, datoValg, visLift);
        return boks;
    }

    private VBox del1() {
        VBox boks = new VBox(10);
        HBox h1 = datooglift();

        lifts = new ListView<>();
        visLift.setOnAction(event -> {
            if (datoValg != null) {
                lifts.getItems().setAll(Controller.liftPåDato(datoValg.getValue()));
            }
        });
        lifts.getSelectionModel().selectedItemProperty().addListener((_, _, _) -> {
            opdaterBookinger();
        });
        boks.getChildren().addAll(h1, lifts);

        return boks;
    }

    public VBox del2() {
        VBox boks = new VBox(10);
        Label passager = new Label("Passager: ");
        Label sted = new Label("Opsamlingssted: ");
        Label tid = new Label("Opsamlings tid: ");
        taNavn = new TextArea();
        taSted = new TextArea();
        taTid = new TextArea();
        taTid.setMaxHeight(8);
        taNavn.setMaxHeight(8);
        taSted.setMaxHeight(8);
        btnOpret = new Button("Opret booking");
        Label b1 = new Label("Bookinger");
        lswBookinger = new ListView<>();
        lswBookinger.setMaxHeight(145);
        btnOpret.setOnAction(event -> opretBooking());
        //lifts.getSelectionModel().clearSelection();

        boks.getChildren().addAll(passager, taNavn, sted, taSted, tid, taTid, btnOpret, b1, lswBookinger);

        return boks;
    }

    public void opretBooking() {
        if (taNavn.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Mangler navn");
            alert.setContentText("Du skal vælge et navn før du kan tilmelde dig");
            alert.showAndWait();
        } else if (taSted.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Mangler sted");
            alert.setContentText("Du skal vælge et sted før du kan tilmelde dig");
            alert.showAndWait();
        } else if (taTid.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Mangler tid");
            alert.setContentText("Du skal vælge et tidpunkt før du kan tilmelde dig");
            alert.showAndWait();
        } else {
            Lift lift = lifts.getSelectionModel().getSelectedItem();
            if (!lift.LedigPlads()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Ingen pladser");
                alert.setContentText("Der er ikke flere pladser");
                alert.showAndWait();
            } else {
                String navn = taNavn.getText();
                LocalTime tid = LocalTime.parse(taTid.getText());
                String sted = taSted.getText();

                Controller.createBooking(navn, tid, sted, lift);
                taNavn.clear();
                taSted.clear();
                taTid.clear();
                opdaterBookinger();
            }
        }
    }

    public void opdaterBookinger() {
        Lift lift = lifts.getSelectionModel().getSelectedItem();
        lswBookinger.getItems().setAll(lift.getBookinger());
    }
}
