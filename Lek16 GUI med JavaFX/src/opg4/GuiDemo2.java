package opg4;

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

   private final TextField txfCelsius = new TextField();
    private final TextField txfFahrenheit = new TextField();
    private final TextField txfTemperature = new TextField();



    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("Temperature: ");
        pane.add(lblName, 0, 0);
        Label lblCelsius = new Label("Celcius: ");
        pane.add(lblCelsius, 0, 1);
        Label lblFahrenheit = new Label("Fahrenheit: ");
        pane.add(lblFahrenheit, 0, 2);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
//        Deleted here is:
//        TextField txfName = new TextField();
        pane.add(txfCelsius, 1, 1, 2, 1);
        pane.add(txfTemperature, 1, 0, 2, 1);
        pane.add(txfFahrenheit, 1, 2, 2, 1);
        txfCelsius.setEditable(false);
        txfFahrenheit.setEditable(false);



        // add a button to the pane (at col=1, row=1)
        Button btnUpperCase = new Button("Fahrenheit");
        pane.add(btnUpperCase, 0, 3);
        GridPane.setMargin(btnUpperCase, new Insets(10, 10, 0, 10));
        // connect a method to the button
        btnUpperCase.setOnAction(event -> calculateFahrenheitAction());

        // add a button to the pane (at col=1, row=1)
        Button celsius = new Button("Celsius");
        pane.add(celsius, 1, 3);
        GridPane.setMargin(celsius, new Insets(10, 10, 0, 10));
        // connect a method to the button
        celsius.setOnAction(event -> calculateCelsiusAction());

    }

    private void calculateCelsiusAction() {
        int temperature = Integer.parseInt(txfTemperature.getText());
        txfCelsius.setText(String.valueOf((temperature-32)/1.8));
    }
    private void calculateFahrenheitAction() {
        int temperature = Integer.parseInt(txfTemperature.getText());
        txfFahrenheit.setText(String.valueOf((temperature*1.8)+32));
    }
}
