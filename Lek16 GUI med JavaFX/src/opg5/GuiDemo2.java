package opg5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    private final TextArea txfNames = new TextArea();


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
//        Deleted here is:
//        TextField txfName = new TextField();
        pane.add(txfName, 0, 1, 2, 1);

        // add a button to the pane (at col=1, row=1)
        Button btnUpperCase = new Button("Add");
        pane.add(btnUpperCase, 1, 2);
        GridPane.setMargin(btnUpperCase, new Insets(10, 10, 0, 10));
        // connect a method to the button
        btnUpperCase.setOnAction(event -> upperCaseAction());

        pane.add(txfNames, 0, 3, 2, 3);
    }

    private void upperCaseAction() {
        String names = txfName.getText().trim();
        txfNames.setText(txfNames.getText()+ "\n " + names);

    }
}
