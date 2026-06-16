package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDate;


public class gui extends Application {


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

        boks.getChildren().setAll();
        return boks;
    }
    private VBox del2() {
        VBox boks = new VBox(10);

        boks.getChildren().setAll();
        return boks;
    }
    private VBox del3() {
        VBox boks = new VBox(10);

        boks.getChildren().setAll();
        return boks;
    }

}