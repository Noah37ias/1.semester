package opg1;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiDemo2 extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Gui Demo 2");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

   private final TextField txfName = new TextField();
    private final TextField txfLastName = new TextField();
    private final TextField txfCombinedName = new TextField();





    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(100));
        pane.setHgap(10);
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("First name:");
        pane.add(lblName, 0, 0);

        // add a label to the pane (at col=0, row=0)
        Label lblLastName = new Label("Last name:");
        pane.add(lblLastName, 2, 0);


        // add a text field to the pane (at col=0, row=3, extending 2 columns and 1 row)
//        Deleted here is:
//        TextField txfName = new TextField();
        pane.add(txfName, 0, 1, 2, 1);

        pane.add(txfLastName, 2, 1, 2, 1);


        Label lblFullName = new Label("Full name:");
        pane.add(lblFullName, 0, 3);

        // add a button to the pane (at col=1, row=1)
        Button combineText = new Button("Combine");
        pane.add(combineText, 1, 2,2,1);
        GridPane.setHalignment(combineText, HPos.CENTER);
        // connect a method to the button
        combineText.setOnAction(event -> combinedAction());

        pane.add(txfCombinedName, 1, 3, 2, 1);


    }

    private void combinedAction() {
        String name = txfName.getText().trim();
        String lastName = txfLastName.getText().trim();
        txfCombinedName.setText(name + " " +  lastName);
    }


}