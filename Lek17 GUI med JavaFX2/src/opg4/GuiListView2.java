package opg4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GuiListView2 extends Application {
    private final ArrayList<String> names = new ArrayList<>(
            List.of("Noah","Sten","Seb","Arian")
    );

    @Override
    public void start(Stage stage) {
        stage.setTitle("ListView Demo2");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final ListView<String> lvwNames = new ListView<>();

    private void initContent(GridPane pane) {
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // column 0
        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 1);

        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 0);
        GridPane.setValignment(lblNames, VPos.TOP);

        // column 1
        pane.add(txfName, 1, 1);

        pane.add(lvwNames, 1, 0);
        lvwNames.setPrefWidth(200);
        lvwNames.setPrefHeight(200);
        lvwNames.getItems().setAll(names);

        lvwNames.getSelectionModel().selectedItemProperty().addListener(
                (_, _, _) -> this.selectionChanged()
        );

        // column 2
        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 2, 1);
       // btnAdd.setDefaultButton(true);
        btnAdd.setOnAction(_ -> this.addAction());

        Button btnDelete = new Button("Delete");
        pane.add(btnDelete, 2, 2);
        btnDelete.setOnAction(_ -> this.deleteAction());
    }

    private void selectionChanged() {
        String selected = lvwNames.getSelectionModel().getSelectedItem();
        if (selected != null) {
            txfName.setText(selected);
        } else {
            txfName.clear();
        }
    }

    private void addAction() {
        String name = txfName.getText().trim();

        if (name.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Create person");
            alert.setHeaderText("Information missing");
            alert.setContentText("Type title and name");
            alert.showAndWait();
            txfName.requestFocus();
        }
        else if (name.matches(".*\\d.*")) {
            Alert alert = new Alert(Alert.AlertType.ERROR); // Rød fejl-boks
            alert.setTitle("Ugyldigt input");
            alert.setHeaderText("Navnet indeholder tal");
            alert.setContentText("Et navn må ikke indeholde tal, prøv igen.");
            alert.showAndWait();
            txfName.requestFocus();
        }
        else{
            names.add(name);
            lvwNames.getItems().setAll(names);
            txfName.clear();
        }
    }

    private void deleteAction() {
        int index = lvwNames.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            names.remove(index);
            txfName.clear();
            lvwNames.getItems().setAll(names);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete person");
            alert.setHeaderText("No person selected");
            alert.setContentText("Select a person to be deleted");
            alert.showAndWait();
        }
    }
}
