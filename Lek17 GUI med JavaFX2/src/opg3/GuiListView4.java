package opg3;

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
        personWindow = new PersonInputDialog("Create a person", stage);

    }

    // -------------------------------------------------------------------------

    private final ListView<Person> lvwPersons = new ListView<>();
    private PersonInputDialog  personWindow;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNames = new Label("Persons:");
        pane.add(lblNames, 0, 1);
        GridPane.setValignment(lblNames, VPos.TOP);

        pane.add(lvwPersons, 1, 1);
        lvwPersons.setPrefWidth(300);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);

        // column 2
        Button btnAddPerson = new Button("Add person");
        pane.add(btnAddPerson, 2, 1);
        GridPane.setMargin(btnAddPerson, new Insets(10, 10, 0, 10));
        btnAddPerson.setOnAction(_ -> this.createPersonAction());

        Button btnDelete = new Button("Delete");
        pane.add(btnDelete, 2, 0);
        GridPane.setMargin(btnDelete, new Insets(10, 10, 0, 10));
        btnDelete.setOnAction(_ -> this.deleteAction());
    }

    private void deleteAction() {
        int index = lvwPersons.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            persons.remove(index);
            lvwPersons.getItems().setAll(persons);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Delete person");
            alert.setHeaderText("No person selected");
            alert.setContentText("Select a person to be deleted");
            alert.showAndWait();
        }
    }
    private void createPersonAction() {
        // Viser vinduet og venter på at det lukkes
        personWindow.showAndWait();

        // Hent den nye person fra dialogen
        Person newPerson = personWindow.getActualPerson();

        // Tjek om der rent faktisk blev oprettet en person (dvs. brugeren trykkede OK, ikke Cancel)
        if (newPerson != null) {
            persons.add(newPerson); // Tilføj til listen
            lvwPersons.getItems().setAll(persons); // Opdater brugerfladen
        }
    }
    }

