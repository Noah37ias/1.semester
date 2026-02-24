package opg12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
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
    private void drawTriangle(Pane pane, int x, int y, int h) {
        Line line1 = new Line(x, y, x + 2 * h, y);             // Bund
        Line line2 = new Line(x + 2 * h, y, x + h, y - h);     // Højre side
        Line line3 = new Line(x + h, y - h, x, y);             // Venstre side

        pane.getChildren().addAll(line1, line2, line3);
    }

    private void drawInnerTriangles(Pane pane, int x, int y, int h) {
        int smallH = h / 3;

        // Kald din egen metode 3 gange for at tegne de små trekanter
        drawTriangle(pane, x, y, smallH);                                 // Nederst venstre
        drawTriangle(pane, x + 4 * smallH, y, smallH);                    // Nederst højre
        drawTriangle(pane, x + 2 * smallH, y - 2 * smallH, smallH);       // Toppen
    }

    private void drawShapes(Pane pane) {
        int startX = 20;   // Vælg en fornuftig x-placering i vinduet
        int startY = 100;  // Vælg en fornuftig y-placering i vinduet
        int h = 81;        // Højden angivet i opgaven

        // 1. Tegn den store ydre trekant
        drawTriangle(pane, startX, startY, h);

        // 2. Tegn de tre indre trekanter indeni
        drawInnerTriangles(pane, startX, startY, h);
    }
}

