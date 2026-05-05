package GUI;


import Controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AdminGUI extends Stage {


    public AdminGUI() {
        this.setTitle("KAS - Administration");

        BorderPane layout = new BorderPane();

        Label velkomst = new Label("Velkommen til Administrationspanelet");
        layout.setTop(velkomst);

        Scene scene = new Scene(layout, 800, 600);
        this.setScene(scene);
    }
}
