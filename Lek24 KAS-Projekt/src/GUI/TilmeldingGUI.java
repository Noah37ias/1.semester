package GUI;

import Controller.Controller;
import Model.Hotel;
import Model.Konference;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

import Controller.Controller;


public class TilmeldingGUI extends Application {
    private ComboBox<String> cbKonference;
    private ComboBox<String> cbHotel;
    private Label lblKonference;
    private Label lblHotel;
    private Label lblTotal;

    @Override
    public void start(Stage stage) {
        stage.setTitle("KAS - KonferenceAdministrationsSystemet");
        GridPane pane = new GridPane();
        pane.setStyle("-fx-background-color: #e0e0e0;");
        this.initContent(pane);

        //SCROLLBAR
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(pane);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane, 400, 600);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(15);

        Button btnAdmin = new Button("Admin");
        pane.add(btnAdmin, 0, 0);
        GridPane.setHalignment(btnAdmin, HPos.RIGHT);

        btnAdmin.setOnAction(event -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Admin Login");
            dialog.setHeaderText("Adgang for administrationen");
            dialog.setContentText("Indtast venligst adgangskode:");
            Optional<String> result = dialog.showAndWait();

            result.ifPresent(indtastetKode -> {
                if (Controller.tjekAdminKode(indtastetKode)) {
                    //Rigtig kode
                    AdminGUI adminVindue = new AdminGUI();
                    adminVindue.show();
                } else {
                    //Forkert kode
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("Forkert kode");
                    errorAlert.setContentText("Den indtastede kode er ikke gyldig.");
                    errorAlert.showAndWait();
                }
            });
        });


        VBox konference = vælgKonference();
        pane.add(konference, 0, 1);
        GridPane.setHgrow(konference, javafx.scene.layout.Priority.ALWAYS);

        VBox deltager = deltagerInfo();
        pane.add(deltager, 0, 2);
        GridPane.setHgrow(deltager, javafx.scene.layout.Priority.ALWAYS);

        VBox hotel = opretHotel();
        pane.add(hotel, 0, 3);
        GridPane.setHgrow(hotel, javafx.scene.layout.Priority.ALWAYS);

        VBox ledsager = vælgLedsager();
        pane.add(ledsager, 0, 4);
        GridPane.setHgrow(ledsager, javafx.scene.layout.Priority.ALWAYS);

        VBox pris = prisoversigt();
        pane.add(pris, 0, 5);
        GridPane.setHgrow(pris, javafx.scene.layout.Priority.ALWAYS);
    }

    private VBox vælgKonference() {
        VBox boks = new VBox(10);
        //Overskrift
        Label lblTitel = new Label("Konference");
        lblTitel.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");
        // ComboBox til konference valg
        cbKonference = new ComboBox<>();
        for (Konference konference : Controller.getKonferencer()) {
            String tekstKonference = konference.getNavn() + " - " + konference.getPris() + " kr/dagen";
            cbKonference.getItems().add(tekstKonference);
        }
        cbKonference.setOnAction(event -> opdaterPriser());
        cbKonference.getSelectionModel().selectFirst();
        cbKonference.setMaxWidth(6767);

        // Tilføj overskrift og dropdown til boksen
        boks.getChildren().addAll(lblTitel, cbKonference);

        boks.setStyle("-fx-background-color: #f2f2ef;" + "-fx-padding: 15;");
        return boks;
    }

    private VBox deltagerInfo() {
        VBox boks = new VBox(5);
        //Overskrift
        //Overskrift
        Label lblTitel = new Label("Deltager");
        lblTitel.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");

        Label lblNavn = new Label("Navn");
        TextField txtNavn = new TextField();
        txtNavn.setPromptText("Fulde navn");
        Label lblFirma = new Label("Firma tlf(valgfri)");
        TextField txtFirma = new TextField();
        txtFirma.setPromptText("Hvis betalt af firma");
        Label lblAdresse = new Label("Adresse");
        TextField txtAdresse = new TextField();
        txtAdresse.setPromptText("Vejnavn og nummer");
        Label lblBy = new Label("By");
        TextField txtBy = new TextField();
        txtBy.setPromptText("Postnummer");
        Label lblTelefon = new Label("Telefon nummer");
        TextField txtTelefon = new TextField();
        txtTelefon.setPromptText("XX XX XX XX");
        Label lblAfrejseDato = new Label("Afrejse dato");
        TextField txtAfrejseDato = new TextField();
        txtAfrejseDato.setPromptText("YYYY-MM-DD");


        boks.getChildren().addAll(lblTitel, lblNavn, txtNavn, lblFirma, txtFirma, lblAdresse, txtAdresse, lblBy, txtBy, lblTelefon, txtTelefon, lblAfrejseDato, txtAfrejseDato);

        boks.setStyle("-fx-background-color: #f2f2ef;" + "-fx-padding: 15;");
        return boks;
    }

    private VBox opretHotel() {
        VBox boks = new VBox(10);

        // Overskrift
        Label lblTitel = new Label("Hotel");
        lblTitel.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");

        // ComboBox til hotelvalg
        cbHotel = new ComboBox<>();
        cbHotel.getItems().add("Intet hotel");


        cbHotel.setOnAction(event -> {
            opdaterHoteller();
            opdaterPriser();
        });
        cbHotel.setMaxWidth(6767);

        VBox ekstraServicesBoks = new VBox(5);
        Label lblEkstra = new Label("Ekstra services");
        lblEkstra.setStyle("-fx-font-weight: bold;");
        CheckBox chkMorgenmad = new CheckBox("Morgenmad + 150 kr./nat");

        ekstraServicesBoks.getChildren().addAll(lblEkstra, chkMorgenmad);

        ekstraServicesBoks.setVisible(false);
        ekstraServicesBoks.setManaged(false);

        cbHotel.getSelectionModel().selectedItemProperty().addListener((_, _, tjek) -> {
            if (!tjek.equals("Intet hotel")) {
                ekstraServicesBoks.setVisible(true);
                ekstraServicesBoks.setManaged(true);
            } else {
                ekstraServicesBoks.setVisible(false);
                ekstraServicesBoks.setManaged(false);
                chkMorgenmad.setSelected(false);
            }
        });

        // Tilføjer tingene til boksen samt farver
        boks.getChildren().addAll(lblTitel, cbHotel, ekstraServicesBoks);
        boks.setStyle("-fx-background-color: #f2f2ef;" + "-fx-padding: 15;");
        return boks;
    }

    private VBox vælgLedsager() {
        VBox boks = new VBox(10);
        //Overskrift
        Label lblTitel = new Label("Ledsager");
        lblTitel.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");
        // Radiobutton til tilvalg af ledsager
        RadioButton rbLedsager = new RadioButton("Jeg medbringer en ledsager(Giver automatisk dobbeltværelse)");

        // Tilføj alt til boksen
        boks.getChildren().addAll(lblTitel, rbLedsager);

        boks.setStyle("-fx-background-color: #f2f2ef;" + "-fx-padding: 15;");
        return boks;
    }

    private VBox prisoversigt() {
        VBox boks = new VBox(10);
        //Overskrift
        Label lblTitel = new Label("Prisoversigt");
        lblTitel.setStyle("-fx-font-size: 16; -fx-font-weight: bold; -fx-font-color: green;");


        lblKonference = new Label("Konference: 0 kr.");
        lblHotel = new Label("Hotel: 0 kr.");
        lblTotal = new Label("Total: 0 kr.");


        // Tilføj overskrift og dropdown til boksen
        boks.getChildren().addAll(lblTitel, lblKonference, lblHotel, lblTotal);

        boks.setStyle("-fx-background-color: #f2f2ef;" + "-fx-padding: 15;");
        return boks;
    }

    private void opdaterPriser() {
        double totalPris = 0;

        int valgtKonf = cbKonference.getSelectionModel().getSelectedIndex();

        Konference valgtKonference = Controller.getKonferencer().get(valgtKonf);
        double konfPris = valgtKonference.getPris();

        lblKonference.setText("Konference: " + konfPris + " kr.");
        totalPris += konfPris;

        int valgtHotelIndex = cbHotel.getSelectionModel().getSelectedIndex();
        if (valgtHotelIndex > 0) {

            Hotel valgtHotel = valgtKonference.getHoteller().get(valgtHotelIndex - 1);
            double hotelPris = valgtHotel.getPris();

            lblHotel.setText("Hotel: " + hotelPris + " kr.");
            totalPris += hotelPris;
        } else {
            lblHotel.setText("Hotel: 0 kr.");
        }
        lblTotal.setText("Total: " + totalPris + " kr.");
    }

    private void opdaterHoteller() {

        cbHotel.getItems().clear();
        cbHotel.getItems().add("Intet hotel");

        int valgtKonfIndex = cbKonference.getSelectionModel().getSelectedIndex();

        if (valgtKonfIndex >= 0) {
            Konference valgtKonference = Controller.getKonferencer().get(valgtKonfIndex);

            for (Hotel hotel : valgtKonference.getHoteller()) {
                String tekstHotel = hotel.getNavn() + " - " + hotel.getPris() + " kr/nat";
                cbHotel.getItems().add(tekstHotel);
            }
        }
        cbHotel.getSelectionModel().selectFirst();
    }
}

