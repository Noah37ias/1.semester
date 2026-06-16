package gui;

import controller.Controller;
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
import model .*;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.scene.control .*;

import java.awt .*;
import java.time.LocalDate;
import java.time.LocalTime;

import javafx.scene.control .*;


    public class GUI extends Application {
        private ListView<JuletræsGrossist> lswJuletræsGrossist;
        private ListView<Juletræ> lswJuletræ;
        private TextArea taOversigt;
        private DatePicker dpDato;
        private Label lblPris;

        @Override
        public void start(Stage stage) {
            stage.setTitle("Juletræer");
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
            VBox bund = del2();


            pane.add(venstre, 0, 0);
            pane.add(bund, 0, 1);
            pane.add(højre, 1, 0);

        }

        private VBox del1() {
            VBox boks = new VBox(10);
            Label lblTitel = new Label("JuletræsGrossister");
            lswJuletræsGrossist = new ListView<>();
            lswJuletræsGrossist.getItems().setAll(Controller.getJuletræsGrossister());
            lswJuletræsGrossist.getSelectionModel().selectedItemProperty().addListener((_, _, _) -> {
                opdatterJuletræer();
            });
            boks.getChildren().setAll(lblTitel,lswJuletræsGrossist);
            return boks;
        }

        private VBox del2() {
            VBox boks = new VBox(10);
            Button btnSorter = new Button("Sorter alle træer");
            taOversigt = new TextArea();
            btnSorter.setOnAction(event -> {
                opdaterSortering();
            });


            boks.getChildren().setAll(btnSorter,taOversigt);
            return boks;
        }

        private VBox del3() {
            VBox boks = new VBox(10);
            Label lblTitel = new Label("Juletræer");
            lswJuletræ = new ListView<>();
            Button btnPris = new Button("BEREGN PRIS");
            dpDato = new DatePicker();
            lblPris = new Label("PRIS PÅ VALGTE DATO: ");
            btnPris.setOnAction(event -> {
            opdatterPris();
            });
            boks.getChildren().setAll(lblTitel,lswJuletræ,dpDato, btnPris,lblPris);
            return boks;
        }
        public void opdatterJuletræer(){
            JuletræsGrossist jg = lswJuletræsGrossist.getSelectionModel().getSelectedItem();
            lswJuletræ.getItems().setAll(jg.getJuletræer());
        }
        public void opdatterPris(){
            LocalDate dato = dpDato.getValue();
            Juletræ træ = lswJuletræ.getSelectionModel().getSelectedItem();
            if(træ != null &&!(dpDato.getValue()==null)) {
                lblPris.setText("PRIS PÅ VALGTE DATO: " + træ.prisPåDato(dato));
            }
        }
        public void opdaterSortering(){
            taOversigt.setText(Controller.oversigtTilTekst());
        }
    }

