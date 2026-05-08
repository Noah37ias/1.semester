package GUI;


import Controller.Controller;
import Model.Tilmelding;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminGUI extends Stage {
    private ListView<Tilmelding> lstTilmelding;

    public AdminGUI() {
        this.setTitle("KAS - Administration");
        GridPane adminPane = new GridPane();
        //SCROLLBAR
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(adminPane);
        scrollPane.setFitToWidth(true);
        Scene scene = new Scene(adminPane, 800, 800);
        this.setScene(scene);
        initContent(adminPane);
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(15);

        lstTilmelding = new ListView<>();
        lstTilmelding.getItems().setAll(Controller.getTilmeldinger());
        pane.add(lstTilmelding, 0, 0);
    }
}
