package opg8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
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

        int centerx = 100;
        int centery = 100;
        int radiusx = 5;
        int radiusy = 5;
        while(radiusy<100){
            Ellipse ellipse = new Ellipse(centerx, centery, radiusx, radiusy);
            ellipse.setFill(null);
            ellipse.setStroke(Color.BLACK);
            ellipse.setStrokeWidth(1);
            pane.getChildren().add(ellipse);
            radiusx += 10;
            radiusy += 10;
        }


    }
}
