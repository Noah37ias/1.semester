package GUI;

import Semesterprove2017.model.Område;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.RadialGradient;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Pane extends Application {
        @Override
        public void start(Stage stage) {
            stage.setTitle("Gui Demo 2");
            GridPane pane = new GridPane();
            this.initContent(pane);
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.show();
        }
        private final Label pladser = new Label("Pladser");
        private final ListView<String> liste = new ListView<>();//Listen med navne
        private final Label område = new  Label("Område: ");
        private final TextField nummer = new TextField();
        private final Label tfNummer = new Label("Nummer: ");
        private final Button opret = new Button("Opret");
        private final VBox box = new VBox();
        private final RadioButton rbnVip = new RadioButton("VIP");
        private final RadioButton rbnBarn = new RadioButton("Børne");
        private final RadioButton rbnSta = new RadioButton("Standard");
        private final RadioButton rbnTur = new RadioButton("Turnering");
        private final ToggleGroup group = new ToggleGroup();//Til vores radian buttons



    private void initContent(GridPane pane) {
            pane.setGridLinesVisible(false);
         pane.setPadding(new Insets(20));
         pane.setHgap(20);
         pane.setVgap(20);

            pane.add(pladser, 0, 0);

            liste.setPrefWidth(200);
            liste.setPrefHeight(200);
            pane.add(liste, 0, 1,2,1);


            pane.add(område,0,2);
            rbnVip.setToggleGroup(group);
            rbnBarn.setToggleGroup(group);
            rbnSta.setToggleGroup(group);
            rbnTur.setToggleGroup(group);

            box.getChildren().addAll(rbnVip,rbnBarn,rbnSta,rbnTur);
            group.selectToggle(rbnSta);
            pane.add(box,1,2);
            pane.add(nummer,1,3);
            pane.add(tfNummer,0,3);
            pane.add(opret,1,4);
        }
    }
