package yatzystudent;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jdk.jfr.Event;

import java.util.ArrayList;

public class YatzyGui extends Application {
    private YatzyDice dice = new YatzyDice();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        // --- NY KODE HERUNDER ---
        // Pak din 'pane' ind i en ScrollPane
        javafx.scene.control.ScrollPane scrollPane = new javafx.scene.control.ScrollPane(pane);
        scrollPane.setFitToWidth(true); // Sørger for at indholdet tilpasser sig bredden
        scrollPane.setStyle("-fx-background-color: transparent;"); // Fjerner grimme kanter

        // Brug scrollPane i din Scene i stedet for pane.
        // Du kan også sætte en standardstørrelse, f.eks. 400x600.
        Scene scene = new Scene(scrollPane, 400, 600);
        stage.setScene(scene);
        // stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // txfValues shows the face values of the 5 dice.
    private final TextField[] txfValues = new TextField[5];
    // cbxHolds shows the hold status of the 5 dice.
    private final CheckBox[] cbxHolds = new CheckBox[5];
    // txfResults shows the obtained results.
    // For results not set yet, the possible result of 
    // the actual face values of the 5 dice are shown.
    private final ArrayList<TextField> txfResults = new ArrayList<>(15);
    // Shows points in sums, bonus and total.
    private final TextField txfSumSame = new TextField();
    private final TextField txfBonus = new TextField();
    private final TextField txfSumOther = new TextField();
    private final TextField txfTotal = new TextField();

    private final Label lblThrowCount = new Label();
    private final Button btnThrow = new Button(" Throw ");

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------
        // dicePane

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // add txfValues, chbHolds
        // TODO
        // add lblThrowCount and btnThrow


        pane.add(btnThrow, 2, 2);

        // ---------------------------------------------------------------------
        // scorePane

        GridPane scorePane = new GridPane();
        //pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int width = 50; // width of the text fields

        // add labels for results
        // add txfResults
        Label lbl1 = new Label("1-s");
        pane.add(lbl1, 0, 3);
        Label lbl2 = new Label("2-s");
        pane.add(lbl2, 0, 4);
        Label lbl3 = new Label("3-s");
        pane.add(lbl3, 0, 5);
        Label lbl4 = new Label("4-s");
        pane.add(lbl4, 0, 6);
        Label lbl5 = new Label("5-s");
        pane.add(lbl5, 0, 7);
        Label lbl6 = new Label("6-s");
        pane.add(lbl6, 0, 8);
        Label lbl7 = new Label("One Pair");
        pane.add(lbl7, 0, 10);
        Label lbl8 = new Label("Two Pairs");
        pane.add(lbl8, 0, 11);
        Label lbl9 = new Label("Three-Same");
        pane.add(lbl9, 0, 12);
        Label lbl10 = new Label("Four-Same");
        pane.add(lbl10, 0, 13);
        Label lbl11 = new Label("Full House");
        pane.add(lbl11, 0, 14);
        Label lbl12 = new Label("Small str");
        pane.add(lbl12, 0, 15);
        Label lbl13 = new Label("Large str");
        pane.add(lbl13, 0, 16);
        Label lbl14 = new Label("Chance");
        pane.add(lbl14, 0, 17);
        Label lbl15 = new Label("Yatzy");
        pane.add(lbl15, 0, 18);


        for (int i = 0; i < 16; i++) {
            if (i == 6) {
                txfResults.add(new TextField());
                pane.add(txfResults.get(i), 1, i + 4);
                GridPane.setHalignment(txfResults.get(i), HPos.CENTER);
                txfResults.get(i).setMaxWidth(50);
                txfResults.get(i).setEditable(false);
                txfResults.get(i).setOnMouseClicked(event -> this.mouseClicked(event));
            } else {
                txfResults.add(new TextField());
                pane.add(txfResults.get(i), 1, i + 3);
                GridPane.setHalignment(txfResults.get(i), HPos.CENTER);
                txfResults.get(i).setMaxWidth(50);
                txfResults.get(i).setEditable(false);
                txfResults.get(i).setOnMouseClicked(event -> this.mouseClicked(event));
            }
        }

        // add labels and text fields for sums, bonus and total.
        for (int i = 0; i < 5; i++) {
            txfValues[i] = new TextField();
            txfValues[i].setPrefWidth(75);
            txfValues[i].setPrefHeight(75);
            txfValues[i].setStyle("-fx-font-size: 36px;");
            txfValues[i].setAlignment(Pos.CENTER);
            txfValues[i].setEditable(false);
            pane.add(txfValues[i], i, 0);

            cbxHolds[i] = new CheckBox("Hold");
            GridPane.setHalignment(cbxHolds[i], HPos.CENTER);
            pane.add(cbxHolds[i], i, 1);

        }
        //Sum
        Label lblSumSame = new Label("Sum");
        pane.add(lblSumSame, 2, 8);
        pane.add(txfSumSame, 3, 8);
        txfSumSame.setMaxWidth(75);
        //Bonus
        Label lblBonus = new Label("Bonus");
        pane.add(lblBonus, 2, 9);
        pane.add(txfBonus, 3, 9);
        txfBonus.setMaxWidth(75);


        Label lblSumOther = new Label("Sum");
        pane.add(lblSumOther, 2, 18);
        pane.add(txfSumOther, 3, 18);
        txfSumOther.setMaxWidth(75);


        Label lblTotal = new Label("Total");
        pane.add(lblTotal, 2, 19);
        pane.add(txfTotal, 3, 19);
        txfTotal.setMaxWidth(75);

        btnThrow.setOnAction(event -> this.throwDice());

    }

    // Create an action method for btnThrow's action.
    public void throwDice() {
        dice.throwDice(readCbxHolds());
        fillTxfValues();
        fillTxfResults();
        disableCbxHolds();
        if (dice.getThrowCount() == 0) {
            btnThrow.setText("Throw ");
            clearUnusedTxfResults();
        } else btnThrow.setText("Throw " + dice.getThrowCount());

    }


    // Create a method for mouse click on one of the text fields in txfResults.
    // TODO
    public void fillResults() {

    }

    // Reset all Hold checkboxes to false and enabled.
    private void resetCbxHolds() {
        // TODO
    }

    // Return the status of Hold checkboxes.
    private boolean[] readCbxHolds() {
        boolean[] status = new boolean[5];
        for (int i = 0; i < 5; i++) {
            if (cbxHolds[i].isSelected()) {
                status[i] = true;
            } else {
                status[i] = false;
            }
        }
        return status;
    }

    // Fill the text fields that show the dice values.
    private void fillTxfValues() {
        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i].setText("" + dice.getValues()[i]);
        }

    }

    // Fill the text fields that show the results.
    private void fillTxfResults() {
        for (int i = 0; i < 6; i++) {
            txfResults.get(i).setText("" + dice.sameValuePoints(i + 1));
        }
        txfResults.get(7).setText("" + dice.onePairPoints());
        txfResults.get(8).setText("" + dice.twoPairPoints());
        txfResults.get(9).setText("" + dice.threeSamePoints());
        txfResults.get(10).setText("" + dice.fourSamePoints());
        txfResults.get(11).setText("" + dice.fullHousePoints());
        txfResults.get(12).setText("" + dice.smallStraightPoints());
        txfResults.get(13).setText("" + dice.fullHousePoints());
        txfResults.get(14).setText("" + dice.chancePoints());
        txfResults.get(15).setText("" + dice.yatzyPoints());
    }

    // Enable result text fields not used yet.
    private void enableTxfResults() {
        // TODO
    }

    // Clear result text fields not used yet.
    private void clearUnusedTxfResults() {
        for (int i = 0; i < txfResults.size(); i++) {
            if(!txfResults.get(i).isMouseTransparent()){
                txfResults.get(i).setText("");
                dice.resetThrowCount();
            }
        }
    }

    // Make result text fields not used yet mouse transparent.
    private void disableUnusedTxfResults() {

    }

    // Disable the Hold check boxes.
    private void disableCbxHolds() {
        if (dice.getThrowCount() == 4) {
            dice.resetThrowCount();
            for (int i = 0; i < cbxHolds.length; i++) {
                cbxHolds[i].setSelected(false);
            }
        }
    }

    // Update the sum, bonus and total text fields.
    private void updateSums() {
        
        // TODO
    }

    private void mouseClicked(MouseEvent event) {
        TextField txf = (TextField) event.getSource();
        txf.setStyle("-fx-control-inner-background: yellow");
        txf.setMouseTransparent(true);
        clearUnusedTxfResults();
    }
}
