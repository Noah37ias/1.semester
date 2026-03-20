package opg3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiDemo2 extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Gui Demo 2");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

   private final TextField txfInvestment = new TextField();
    private final TextField txfYears = new TextField();
    private final TextField txfInterst = new TextField();
    private final TextField txfFutureValue = new TextField();


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("Investment:");
        pane.add(lblName, 0, 0);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
//        Deleted here is:
//        TextField txfName = new TextField();
        pane.add(txfInvestment, 1, 0, 2, 1);

        // add a label to the pane (at col=0, row=0)
        Label lblYears = new Label("Years: ");
        pane.add(lblYears, 0, 1);

        pane.add(txfYears, 1, 1, 2, 1);


        // add a label to the pane (at col=0, row=1)
        Label lblInterst = new Label("Yearly Interst:(%): ");
        pane.add(lblInterst, 0, 2);

        pane.add(txfInterst, 1, 2, 2, 1);


        // add a button to the pane (at col=1, row=1)
        Button calculate = new Button("Calculate");
        pane.add(calculate, 1, 3);
        GridPane.setMargin(calculate, new Insets(10, 10, 0, 10));
        // connect a method to the button
        calculate.setOnAction(event -> calculateAction());

        // add a label to the pane (at col=0, row=1)
        Label lblFutureValue = new Label("Future Value: ");
        pane.add(lblFutureValue, 0, 4);

        pane.add(txfFutureValue, 1, 4, 2, 1);
    }

    private void calculateAction() {
        int investment = Integer.parseInt(txfInvestment.getText());
        int  years = Integer.parseInt(txfYears.getText());
        double interst = Double.parseDouble(txfInterst.getText())/100;
        double futureValue = investment * Math.pow((1 + interst/12), years * 12);
        txfFutureValue.setText(futureValue + "");
    }
}
