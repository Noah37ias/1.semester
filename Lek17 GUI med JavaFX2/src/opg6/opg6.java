package opg6;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class opg6 extends Application {
    private Slider redSlider;
    private Slider greenSlider;
    private Slider blueSlider;

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(15);

        Label redLabel = new Label("Red:");
        Label greenLabel = new Label("Green:");
        Label blueLabel = new Label("Blue:");

        redSlider = new Slider(0, 255, 67);
        greenSlider = new Slider(0, 255, 67);
        blueSlider = new Slider(0, 255, 67);

        pane.add(redLabel, 0, 0);
        pane.add(redSlider, 1, 0);
        pane.add(greenLabel, 0, 1);
        pane.add(greenSlider, 1, 1);
        pane.add(blueLabel, 0, 2);
        pane.add(blueSlider, 1, 2);

        // Listeners til hver slider, så metoden kaldes, hver gang de bevæges
        redSlider.valueProperty().addListener(event -> this.sliderValueChanged(pane));
        greenSlider.valueProperty().addListener(event -> this.sliderValueChanged(pane));
        blueSlider.valueProperty().addListener(event -> this.sliderValueChanged(pane));

        sliderValueChanged(pane);

        Scene scene = new Scene(pane, 300, 150);
        primaryStage.setTitle("Exercise 6");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void sliderValueChanged(GridPane pane) {
        int redValue = (int) redSlider.getValue();
        int greenValue = (int) greenSlider.getValue();
        int blueValue = (int) blueSlider.getValue();

        String color = "#" + String.format("%02X", redValue)
                + String.format("%02X", greenValue)
                + String.format("%02X", blueValue);

        pane.setStyle("-fx-background-color: " + color + ";");
    }
}
