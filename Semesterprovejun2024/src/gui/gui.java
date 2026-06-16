package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.*;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.scene.control.*;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;

import javafx.scene.control.*;


public class gui extends Application {
    private ListView<Hold> lswHold;
    private ListView<Deltager> lswDeltagere;
    private ListView<Tur> lswTure;
    private Label lblNavn;
    private Label lblKm;
    private Label lblMin;
    private DatePicker dpDato;
    private TextField tfMin;
    private TextField tfKm;
    private Button btnOpretTur;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Cykel");
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
        VBox højre = del3();
        VBox midt = del2();


        pane.add(venstre, 0, 0);
        pane.add(midt, 1, 0);
        pane.add(højre, 2, 0);

    }

    private VBox del1() {
        VBox boks = new VBox(10);
        Label lblHold = new Label("Hold");
        lswHold = new ListView<>();
        lswHold.setMaxHeight(200);
        lswHold.getItems().setAll(Controller.getHoldene());
        lswHold.getSelectionModel().selectedItemProperty().addListener((_,_,_) -> {
            opdatterDeltagere();
        });
        boks.getChildren().setAll(lblHold,lswHold);
        return boks;
    }
    private VBox del2() {
        VBox boks = new VBox(10);
        Label lblDeltagere = new Label("Deltagere");
        lswDeltagere = new ListView<>();
        lswDeltagere.setMaxHeight(200);

        lblNavn = new Label("Valgt deltager: ");
        lblKm = new Label("Km i alt: ");
        lblMin = new Label("Minutter i alt: ");

        lswDeltagere.getSelectionModel().selectedItemProperty().addListener((_,_,_)->{
            opdatterTure();
            opdatterDeltagerInfo();
        });

        boks.getChildren().setAll(lblDeltagere,lswDeltagere,lblNavn,lblKm,lblMin);
        return boks;
    }
    private VBox del3() {
        VBox boks = new VBox(10);
        Label lblTure = new Label("Ture");
        lswTure = new ListView<>();
        lswTure.setMaxHeight(200);
        Label lblDato = new Label("Tur dato: ");
        dpDato = new DatePicker();
        Label lblKm = new Label("Tur km: ");
        tfKm = new TextField();
        Label lblMin = new Label("Tur minutter: ");
        tfMin = new TextField();
        btnOpretTur = new Button("OPRET TUR :)");
        btnOpretTur.setOnAction(event -> {
            opretTur();
            opdatterTure();
        });
        boks.getChildren().setAll(lblTure,lswTure,lblDato,dpDato,lblKm,tfKm,lblMin,tfMin,btnOpretTur);
        return boks;
    }
    private void opdatterDeltagere(){
    Hold hold = lswHold.getSelectionModel().getSelectedItem();
    if(hold != null) {
        lswDeltagere.getItems().setAll(hold.getDeltagere());
    }
    else{
        lswDeltagere.getItems().clear();// Tømmer listen, hvis intet hold er valgt
    }

    }
    private void opdatterTure(){
        Deltager deltager = lswDeltagere.getSelectionModel().getSelectedItem();
        if(deltager != null) {
            lswTure.getItems().setAll(deltager.getTure());
        }
        else{
            lswTure.getItems().clear();// Tømmer listen, hvis intet hold er valgt
        }
    }
    private void opdatterDeltagerInfo(){
        Deltager deltager = lswDeltagere.getSelectionModel().getSelectedItem();
        if(deltager != null) {
            lblNavn.setText("Valgt deltager: "+ deltager.getNavn());
            lblKm.setText("Km i alt: "+ deltager.kmIAlt());
            lblMin.setText("Minutter i alt: ");
        }
        else{
            lblNavn.setText("Valgt deltager: ");
            lblKm.setText("Km i alt: ");
            lblMin.setText("Minutter i alt: ");
        }
    }
    private void opretTur(){
        if(dpDato!=null&& !tfMin.getText().isEmpty() && !tfKm.getText().isEmpty()){
            LocalDate valgtDato =  dpDato.getValue();
            int antalMin = Integer.parseInt(tfMin.getText());
            int antalKm = Integer.parseInt(tfKm.getText());
            Deltager valgtDeltager = lswDeltagere.getSelectionModel().getSelectedItem();
            Controller.createTur(valgtDato,antalMin,antalKm,valgtDeltager);

            tfMin.clear();
            tfKm.clear();
            dpDato.setValue(null);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("FEJL I OPRETTELSE");
            alert.setContentText("fejl i indtastning");
            alert.showAndWait();
        }
    }
}