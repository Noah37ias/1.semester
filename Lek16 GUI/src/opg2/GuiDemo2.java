package opg2;

import javafx.application.Application;
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
    int number = 0;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("Number:");
        pane.add(lblName, 0, 1);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
//        Deleted here is:
//        TextField txfName = new TextField();
        txfName.setPrefWidth(50);
        txfName.setMaxWidth(50);
        pane.add(txfName, 1, 1, 1, 1);

        // add a button to the pane (at col=1, row=1)
        Button btnUpperCase = new Button("Inc");
        pane.add(btnUpperCase, 2, 0);
        GridPane.setMargin(btnUpperCase, new Insets(10, 10, 0, 10));
        // connect a method to the button
        btnUpperCase.setOnAction(event -> upperCaseAction());

        // add a button to the pane (at col=2, row=1)
        Button btnLowerCase = new Button("Dec");
        pane.add(btnLowerCase, 2, 2);
        GridPane.setMargin(btnLowerCase, new Insets(10, 10, 0, 10));
        // connect a method to the button
        btnLowerCase.setOnAction(event -> this.lowerCaseAction());
    }

    private void upperCaseAction() {
        number++;
        txfName.setText(String.valueOf(number));

    }

    private void lowerCaseAction() {
        number--;
        txfName.setText(String.valueOf(number));
    }
}
