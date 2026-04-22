package GUI;

import Controller.Controller;
import Model.Forestilling;
import Model.Kunde;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TeaterGUI extends Application {
    public void start(Stage stage) {
        Scene scene = new Scene(initContent());
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        GridPane pane = new GridPane();
        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        PlayContentPane playPane = new PlayContentPane("Forestillinger");
        KunderContentPane kunderPane = new KunderContentPane("Kunder");
        SeatContentPane seatPane = new SeatContentPane("Pladser", playPane, kunderPane);
        HBox hbox = new HBox(playPane, kunderPane, seatPane);
        hbox.setSpacing(20);
        hbox.setPadding(new Insets(20));
        return hbox;
    }
}
