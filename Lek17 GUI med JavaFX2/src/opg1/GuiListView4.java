package opg1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GuiListView4 extends Application {
    private final ArrayList<Person> persons = new ArrayList<>(List.of(
            new Person("Jens", "Politi", true),
            new Person("Hans", "Lidl", true),
            new Person("Noah", "Datamatiker", false)
    ));

    @Override
    public void start(Stage stage) {
        stage.setTitle("ListView Demo4");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final ListView<Person> lvwPersons = new ListView<>();
    private final CheckBox checkBox = new CheckBox("Senior");

    private void initContent(GridPane pane) {
        //pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // column 0
        pane.add(new Label("Name:"), 0, 0);
        pane.add(new Label("Title:"), 0, 1);


        Label lblNames = new Label("Persons:");
        pane.add(lblNames, 0, 3);
        GridPane.setValignment(lblNames, VPos.TOP);

        // column 1
        pane.add(txfName, 1, 0);
        pane.add(txfTitle, 1, 1);


        pane.add(lvwPersons, 1, 3);
        lvwPersons.setPrefWidth(300);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);

        lvwPersons.getSelectionModel().selectedItemProperty().addListener(
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

        pane.add(checkBox, 0, 2);

    }

    private void selectionChanged() {
        Person selected = lvwPersons.getSelectionModel().getSelectedItem();
        if (selected != null) {
            txfName.setText(selected.getFirstName());
            txfTitle.setText(selected.getTitle());
            checkBox.setSelected(selected.isSenior());
        } else {
            txfName.clear();
            txfTitle.clear();
            checkBox.setSelected(false);
        }
    }

    private void addAction() {

        if (!txfName.getText().isEmpty() && !txfTitle.getText().isEmpty()) {
            String firstName = txfName.getText().trim();
            String title = txfTitle.getText().trim();

            Person p = new Person(firstName, title, checkBox.isSelected());
            persons.add(p);
            lvwPersons.getItems().setAll(persons);
        } else if (txfName.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Add person");
            alert.setHeaderText("No named typed");
            alert.setContentText("Type the name of the person");
            alert.showAndWait();
        } else if (txfTitle.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Add person");
            alert.setHeaderText("No titled typed");
            alert.setContentText("Type the title of the person");
            alert.showAndWait();
        }
    }

    private void deleteAction() {
        int index = lvwPersons.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            persons.remove(index);
            txfName.clear();
            lvwPersons.getItems().setAll(persons);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Delete person");
            alert.setHeaderText("No person selected");
            alert.setContentText("Select a person to be deleted");
            alert.showAndWait();
        }
    }
}
