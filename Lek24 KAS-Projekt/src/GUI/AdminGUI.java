package GUI;


import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminGUI extends Stage {


    public AdminGUI() {
        this.setTitle("KAS - Administration");

        GridPane adminPane = new GridPane();

        Label velkomst = new Label("Velkommen til Administrationspanelet");
        adminPane.add(velkomst, 0, 0);
        Scene scene = new Scene(adminPane, 800, 600);
        this.setScene(scene);
    }
}
