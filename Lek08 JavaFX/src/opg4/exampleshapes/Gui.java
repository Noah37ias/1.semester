package opg4.exampleshapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Gui extends Application {
    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(200, 200);
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {
        int x1 = 10; // Starter 20 pixels inde
        int y1 = 20;
        int x2 = 10; // Så vi rammer 20 fra frame ligesom i starten
        int y2 = 180;
        while (x1 <= 200) {
            Line line = new Line(x1, y1, x2, y2);
            pane.getChildren().add(line);
            x1 += 40;
            x2 += 40;
        }
    }
}
