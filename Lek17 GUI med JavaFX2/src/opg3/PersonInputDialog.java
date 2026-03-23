package opg3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonInputDialog extends Stage {

    public PersonInputDialog(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final CheckBox checkBox = new CheckBox("Senior");
    private Person actualPerson = null;

    private void initContent(GridPane pane) {
//        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // column 0
        pane.add(new Label("Name:"), 0, 0);
        pane.add(new Label("Title:"), 0, 1);

        // column 1
        pane.add(txfName, 1, 0);
        pane.add(txfTitle, 1, 1);

        // column 0
        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 3, 2, 1);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.CENTER);

        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(_ -> this.cancelAction());

        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(_ -> this.okAction());

        pane.add(checkBox,1 ,2);
    }

    private void cancelAction() {
        txfTitle.clear();
        txfName.clear();
        txfTitle.requestFocus();
        actualPerson = null;
        this.hide();
    }

    private void okAction() {
        String title = txfTitle.getText().trim();
        String name = txfName.getText().trim();

        if (!title.isEmpty() && !name.isEmpty()) {
            actualPerson = new Person(name,title,checkBox.isSelected());
            txfTitle.clear();
            txfName.clear();
            txfTitle.requestFocus();
            this.hide();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Create person");
            alert.setHeaderText("Information missing");
            alert.setContentText("Type title and actor");
            alert.showAndWait();

            txfTitle.requestFocus();
        }
    }

    // -------------------------------------------------------------------------

    public Person getActualPerson() {
        return actualPerson;
    }
}
