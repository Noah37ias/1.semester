package Opg10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
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
        int x = 10;
        int y1 = 175;
        int y2 = 185;


        Line line1 = new Line(0, 180, 175, 180);
        pane.getChildren().add(line1);

        Line line3 = new Line(175, 180, 165, 185);
        Line line4 = new Line(175, 180, 165, 175);
        pane.getChildren().add(line3);
        pane.getChildren().add(line4);

        for (int i = 0; i < 11; i++) {
            Line line = new Line(x, y1, x, y2);
            pane.getChildren().add(line);
            x+=15;

        }
    }
}
