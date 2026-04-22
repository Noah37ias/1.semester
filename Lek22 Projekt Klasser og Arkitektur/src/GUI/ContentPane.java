package GUI;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ContentPane extends VBox {
    private final GridPane fieldGrid = new GridPane();
    protected final Button btnCreate = new Button();


    public ContentPane(String title) {
        fieldGrid.setGridLinesVisible(false);
        setSpacing(10);
        getChildren().add(new Label(title));
        getChildren().add(fieldGrid);
        getChildren().add(btnCreate);
        fieldGrid.setVgap(10);
        fieldGrid.setHgap(10);

        btnCreate.setOnAction(_ -> createAction());

    }

    public void createAction() {

    }
    public void createOrder(){

    }
    protected TextField createTextField(String label) {
        int row = fieldGrid.getRowCount();
        Label lb = new Label(label);
        fieldGrid.add(lb, 0, row);
        TextField field = new TextField();
        GridPane.setHgrow(lb, Priority.ALWAYS);
        fieldGrid.add(field, 1, row);
        return field;
    }
}
