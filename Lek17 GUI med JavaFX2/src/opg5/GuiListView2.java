package opg5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GuiListView2 extends Application {
    //ArrayList med drenge navne
    private final ArrayList<String> boyNames = new ArrayList<>(
            List.of("Noah","Sten","Seb","Arian")
    );
    //ArrayList med piger
    private final ArrayList<String> girlNames = new ArrayList<>(
            List.of("Ellen","Mille","Seb","Arian")
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

    private final TextField txfName = new TextField();//Textfield til at tilføje navne
    private final ListView<String> lvwNames = new ListView<>();//Listen med navne
    private final ToggleGroup group = new ToggleGroup();//Til vores radian buttons
    RadioButton rbnB = new RadioButton();//Radian button til drenge
    RadioButton rbn = new RadioButton();//Radian button til piger
    HBox boxG = new HBox();//Til piger
    HBox boxB = new HBox();//Til Drenge


    private void initContent(GridPane pane) {
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Label navn
        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 1);
        //Label navne
        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 0);
        GridPane.setValignment(lblNames, VPos.TOP);

        // column 1
        pane.add(txfName, 1, 1);

        pane.add(boxG, 0, 2);
        boxG.getChildren().add(rbn);
        rbn.setText("Girl");
        rbn.setToggleGroup(group);
        rbn.setOnAction(_ -> this.showGirlsAction());


        pane.add(boxB, 1, 2);
        boxB.getChildren().add(rbnB);
        rbnB.setText("Boy");
        rbnB.setToggleGroup(group);
        rbnB.setOnAction(_ -> this.showBoyAction());
        rbnB.setSelected(true);



        pane.add(lvwNames, 1, 0);
        lvwNames.setPrefWidth(200);
        lvwNames.setPrefHeight(200);
        lvwNames.getItems().setAll(boyNames);

        //Bruges til vores selection
        lvwNames.getSelectionModel().selectedItemProperty().addListener(
                (_, _, _) -> this.selectionChanged()
        );

        //Add button
        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 2, 1);
        btnAdd.setOnAction(_ -> this.addAction());
        //Delete button
        Button btnDelete = new Button("Delete");
        pane.add(btnDelete, 2, 2);
        btnDelete.setOnAction(_ -> this.deleteAction());
    }
    private void showGirlsAction() {
        lvwNames.getItems().setAll(girlNames);
    }
    private void showBoyAction() {
        lvwNames.getItems().setAll(boyNames);
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
            alert.setContentText("Type name");
            alert.showAndWait();
            txfName.requestFocus();
        }
        else if (name.matches(".*\\d.*")) {
            Alert alert = new Alert(Alert.AlertType.WARNING); // Rød fejl-boks
            alert.setTitle("Ugyldigt input");
            alert.setHeaderText("Navnet indeholder tal");
            alert.setContentText("Et navn må ikke indeholde tal, prøv igen.");
            alert.showAndWait();
            txfName.requestFocus();
        }
        else{
            if(rbnB.isSelected()) {
                boyNames.add(name);
                lvwNames.getItems().setAll(boyNames);
                txfName.clear();
            }
            if(rbn.isSelected()) {
                girlNames.add(name);
                lvwNames.getItems().setAll(girlNames);
                txfName.clear();
            }
        }
    }

    private void deleteAction() {
        int index = lvwNames.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            if (rbnB.isSelected()) {
                boyNames.remove(index);
                lvwNames.getItems().setAll(boyNames);
            } if (rbn.isSelected()) {
                girlNames.remove(index);
                lvwNames.getItems().setAll(girlNames);
            }
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
