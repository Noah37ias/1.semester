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
        //Opretter vores stage samt størrelse
        Scene scene = new Scene(scrollPane, 400, 600);
        stage.setScene(scene);
        //Viser vores stage
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        //Mellemrum mellem ting
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(15);

        //Opretter admin knap
        Button btnAdmin = new Button("Admin");
        pane.add(btnAdmin, 0, 0);
        GridPane.setHalignment(btnAdmin, HPos.RIGHT);

        btnAdmin.setOnAction(event -> {//Hvis der trykkes på admin knappen, åbner pop up
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Admin Login");
            dialog.setHeaderText("Adgang for administrationen");
            dialog.setContentText("Indtast venligst adgangskode:");
            Optional<String> result = dialog.showAndWait();

            result.ifPresent(indtastetKode -> {//Tjek om koden passer
                if (Controller.tjekAdminKode(indtastetKode)) {
                    //Rigtig kode åbner admin GUI
                    AdminGUI adminVindue = new AdminGUI();
                    adminVindue.show();
                } else {
                    //Forkert kode fejl besked
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("Forkert kode");
                    errorAlert.setContentText("Den indtastede kode er ikke gyldig.");
                    errorAlert.showAndWait();
                }
            });
        });

        //Bruger metode til at oprette konference boks boks 0 kolonne,1 række
        VBox konference = vælgKonference();
        pane.add(konference, 0, 1);
        GridPane.setHgrow(konference, javafx.scene.layout.Priority.ALWAYS);
        //Bruger metode til at oprette deltager boks boks 0 kolonne,2 række
        VBox deltager = deltagerInfo();
        pane.add(deltager, 0, 2);
        GridPane.setHgrow(deltager, javafx.scene.layout.Priority.ALWAYS);
        //Bruger metode til at oprette hotel boks 0 kolonne,3 række
        VBox hotel = opretHotel();
        pane.add(hotel, 0, 3);
        GridPane.setHgrow(hotel, javafx.scene.layout.Priority.ALWAYS);
        //Bruger metode til at oprette ledsager boks 0 kolonne,4 række
        VBox ledsager = vælgLedsager();
        pane.add(ledsager, 0, 4);
        GridPane.setHgrow(ledsager, javafx.scene.layout.Priority.ALWAYS);
        //Bruger metode til at oprette Ledsager boks 0 kolonne,5 række
        VBox pris = prisoversigt();
        pane.add(pris, 0, 5);
        GridPane.setHgrow(pris, javafx.scene.layout.Priority.ALWAYS);

        //Tjekker at vi ikke vi ikke vælger ting i tom liste
        if (!cbKonference.getItems().isEmpty()) {
            //Vælger konference 1
            cbKonference.getSelectionModel().selectFirst();
        }
        //Sikrer vores hotel liste bliver vist rigtigt
        opdaterHoteller();
    }

    private VBox vælgKonference() {
        //Opretter en Vertical boks
        VBox boks = new VBox(10);
        //Overskrift
        Label lblTitel = new Label("Konference");
        lblTitel.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");
        // ComboBox til konference valg
        cbKonference = new ComboBox<>();
        for (Konference konference : Controller.getKonferencer()) {
            //Laver en tekststreng med navn og pris
            String tekstKonference = konference.getNavn() + " - " + konference.getPris() + " kr/dagen";
            //sætter tekststrengen ind i comboboxen
            cbKonference.getItems().add(tekstKonference);
        }
        //Hvis man ændrer konference valg skal hoteller opdateres
        cbKonference.setOnAction(event -> {
            opdaterHoteller();
            opdaterPriser();
        });
        cbKonference.setMaxWidth(6767);//Får menuen til at fylde alt hvad den kan

        // Tilføjer overskrift og dropdown til boksen
        boks.getChildren().addAll(lblTitel, cbKonference);
        //Giver boksen farve og mellemrum i
        boks.setStyle("-fx-background-color: #f2f2ef;" + "-fx-padding: 15;");
        return boks;
    }

    private VBox deltagerInfo() {
        //Opretter en Vertical boks
        VBox boks = new VBox(5);
        //Overskrift
        Label lblTitel = new Label("Deltager");
        lblTitel.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");
        // Opretter tekstfelterne, hvor brugeren kan skrive og labels dertil
        Label lblNavn = new Label("Navn");
        TextField txtNavn = new TextField();
        txtNavn.setPromptText("Fulde navn");//Tilføjer hjælpe tekst i feltet
        Label lblFirma = new Label("Firma tlf(valgfri)");
        TextField txtFirma = new TextField();
        txtFirma.setPromptText("Hvis betalt af firma");//Tilføjer hjælpe tekst i feltet
        Label lblAdresse = new Label("Adresse");
        TextField txtAdresse = new TextField();
        txtAdresse.setPromptText("Vejnavn og nummer");//Tilføjer hjælpe tekst i feltet
        Label lblBy = new Label("By");
        TextField txtBy = new TextField();
        txtBy.setPromptText("Postnummer");//Tilføjer hjælpe tekst i feltet
        Label lblTelefon = new Label("Telefon nummer");
        TextField txtTelefon = new TextField();
        txtTelefon.setPromptText("XX XX XX XX");//Tilføjer hjælpe tekst i feltet
        Label lblAfrejseDato = new Label("Afrejse dato");
        TextField txtAfrejseDato = new TextField();
        txtAfrejseDato.setPromptText("YYYY-MM-DD");//Tilføjer hjælpe tekst i feltet

        //Tilføjer alle ting til boksen
        boks.getChildren().addAll(lblTitel, lblNavn, txtNavn, lblFirma, txtFirma, lblAdresse, txtAdresse, lblBy, txtBy, lblTelefon, txtTelefon, lblAfrejseDato, txtAfrejseDato);
        //Giver boksen farve og mellemrum i
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
        //Laver et standard valg, så man ikke er tvunget til at vælge et hotel
        cbHotel.getItems().add("Intet hotel");
        //Hvis man vælget et andet hotel opdateres prisen i totalPris
        cbHotel.setOnAction(_ -> opdaterPriser());
        cbHotel.setMaxWidth(6767);//Tvinger størrelsen på menuen til sit max

        //Ny boks med ekstra tillæg
        VBox ekstraServicesBoks = new VBox(5);
        Label lblEkstra = new Label("Ekstra services");
        lblEkstra.setStyle("-fx-font-weight: bold;");
        CheckBox chkMorgenmad = new CheckBox("Morgenmad + 150 kr./nat");
        ekstraServicesBoks.getChildren().addAll(lblEkstra, chkMorgenmad);


        ekstraServicesBoks.setVisible(false);//Gør så den ikke kan ses når de ikke findes
        ekstraServicesBoks.setManaged(false);//Gør så den ikke fylder når den ikke vises

        cbHotel.getSelectionModel().selectedItemProperty().addListener((_, _, tjek) -> {
            if (tjek != null && !tjek.equals("Intet hotel")) {
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
        if (cbKonference == null || cbHotel == null || lblTotal == null) return;
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

