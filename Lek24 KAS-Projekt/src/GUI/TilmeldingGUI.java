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
import java.util.Optional;

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
        pane.setStyle("-fx-background-color: #93c47e;");
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
        btnAdmin.setStyle("-fx-background-color: black; -fx-text-fill: red; -fx-font-size: 15px; -fx-font-family: Consolas;");


        btnAdmin.setOnAction(event -> {//Hvis der trykkes på admin knappen, åbner pop up
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Admin Login");
            dialog.setHeaderText("KUN ADGANG FOR SEJE ADMINS :)");
            dialog.setContentText("Indtast adgangskode:");
            DialogPane dialogPane = dialog.getDialogPane();
            dialogPane.setStyle("-fx-background-color: orange;");
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
        konference.setStyle("-fx-background-color: #ea999a;");
        konference.setPadding(new Insets(10));
        pane.add(konference, 0, 1);
        GridPane.setHgrow(konference, javafx.scene.layout.Priority.ALWAYS);
        //Bruger metode til at oprette deltager boks boks 0 kolonne,2 række
        VBox deltager = deltagerInfo();
        deltager.setStyle("-fx-background-color: #ea999a;");
        pane.add(deltager, 0, 2);
        GridPane.setHgrow(deltager, javafx.scene.layout.Priority.ALWAYS);
        deltager.setPadding(new Insets(10));
        //Bruger metode til at oprette hotel boks 0 kolonne,3 række
        VBox hotel = opretHotel();
        hotel.setStyle("-fx-background-color: #ea999a;");
        pane.add(hotel, 0, 3);
        GridPane.setHgrow(hotel, javafx.scene.layout.Priority.ALWAYS);
        hotel.setPadding(new Insets(10));
        //Bruger metode til at oprette ledsager boks 0 kolonne,4 række
        VBox ledsager = vælgLedsager();
        ledsager.setStyle("-fx-background-color: #ea999a;");
        pane.add(ledsager, 0, 4);
        GridPane.setHgrow(ledsager, javafx.scene.layout.Priority.ALWAYS);
        ledsager.setPadding(new Insets(10));
        //Bruger metode til at oprette Ledsager boks 0 kolonne,5 række
        VBox pris = prisoversigt();
        pris.setStyle("-fx-background-color: #ea999a;");
        pane.add(pris, 0, 5);
        GridPane.setHgrow(pris, javafx.scene.layout.Priority.ALWAYS);
        pris.setPadding(new Insets(10));

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
        lblTitel.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #6e9eeb; -fx-font-family: Consolas;");
        // ComboBox til konference valg
        cbKonference = new ComboBox<>();
        cbKonference.setStyle("-fx-background-color: #ffd966;");
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
        lblTitel.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #6e9eeb; -fx-font-family: Consolas;");
        // Opretter tekstfelterne, hvor brugeren kan skrive og labels dertil
        Label lblNavn = new Label("Navn");
        TextField txtNavn = new TextField();
        txtNavn.setPromptText("Fulde navn");//Tilføjer hjælpe tekst i feltet
        txtNavn.setStyle("-fx-background-color: #ffd966;");
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
        //Opretter en Vertical boks
        VBox boks = new VBox(10);

        // Overskrift
        Label lblTitel = new Label("Hotel");
        lblTitel.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #6e9eeb; -fx-font-family: Consolas;");

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

        //Til at tjekke hvad der bliver valgt i comboboksen
        cbHotel.getSelectionModel().selectedItemProperty().addListener((_, _, tjek) -> {
            //Hvis teksten der er valgt ikke er "Intet hotel" og teksten tjek eksiterer
            if (tjek != null && !tjek.equals("Intet hotel")) {
                //Så skal ekstra tillæg vises
                ekstraServicesBoks.setVisible(true);
                ekstraServicesBoks.setManaged(true);
            } else {
                //eller hvis man vælger intet hotel igen skjul det
                ekstraServicesBoks.setVisible(false);
                ekstraServicesBoks.setManaged(false);
                //samt opdater tillæg til ikke valgt
                chkMorgenmad.setSelected(false);
            }
        });

        // Tilføjer tingene til boksen samt farver
        boks.getChildren().addAll(lblTitel, cbHotel, ekstraServicesBoks);
        boks.setStyle("-fx-background-color: #f2f2ef;" + "-fx-padding: 15;");
        return boks;
    }

    private VBox vælgLedsager() {
        //Opretter en Vertical boks
        VBox boks = new VBox(10);
        //Overskrift
        Label lblTitel = new Label("Ledsager");
        lblTitel.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #6e9eeb; -fx-font-family: Consolas;");
        // Checkbox til tilvalg af ledsager
        CheckBox cbLedsager = new CheckBox("Jeg medbringer en ledsager\n(Giver automatisk dobbeltværelse)");


        // Tilføj alt til boksen
        boks.getChildren().addAll(lblTitel, cbLedsager);
        //Farver og mellemrum i boksen
        boks.setStyle("-fx-background-color: #f2f2ef;" + "-fx-padding: 15;");
        return boks;
    }

    private VBox prisoversigt() {
        //Opretter en Vertical boks
        VBox boks = new VBox(10);
        //Overskrift farve og størrelse
        Label lblTitel = new Label("Prisoversigt");
        lblTitel.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #6e9eeb; -fx-font-family: Consolas;");

        //Bruger vores label og giver dem tekster
        lblKonference = new Label("Konference: 0 kr.");
        lblHotel = new Label("Hotel: 0 kr.");
        lblTotal = new Label("Total: 0 kr.");
        lblTotal.setStyle("-fx-font-weight: bold;");
        lblHotel.setStyle("-fx-font-weight: bold;");
        lblKonference.setStyle("-fx-font-weight: bold;");

        Button btnGodkend = new Button("Bekræft tilmelding");
        btnGodkend.setStyle("-fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: green;");



        // Tilføj alt til boksen
        boks.getChildren().addAll(lblTitel, lblKonference, lblHotel, lblTotal, btnGodkend);
        //Farver og mellemrum på boksen
        boks.setStyle("-fx-background-color: #f2f2ef;" + "-fx-padding: 15;");
        return boks;
    }

    private void opdaterPriser() {
        //Tjek om bokse er lavet ellers stop
        if (cbKonference == null || cbHotel == null || lblTotal == null) return;

        double totalPris = 0;//Vores total pris variabel
        //Tjekker hvilken konference der er valgt
        int valgtKonf = cbKonference.getSelectionModel().getSelectedIndex();
        //Tager objektet fra listen i controlleren
        Konference valgtKonference = Controller.getKonferencer().get(valgtKonf);
        //Får prisen på konferencen
        double konfPris = valgtKonference.getPris();
        //Opdaterer teksten så der kommer pris på og tilføjer til totalpris
        lblKonference.setText("Konference: " + konfPris + " kr.");
        totalPris += konfPris;

        //Finder det valgte hotel
        int valgtHotelIndex = cbHotel.getSelectionModel().getSelectedIndex();
        //Hvis det er plads 0 der er valgt skal vi ikke regne noget da prisen er 0 kroner
        if (valgtHotelIndex > 0) {
            //Får hotellet fra konferences liste af hoteller og trækker 1 fra da Intet hotel fylder plads 0 ud
            Hotel valgtHotel = valgtKonference.getHoteller().get(valgtHotelIndex - 1);
            //Får prisen af objektet
            double hotelPris = valgtHotel.getPris();
            //Opdaterer teksten og tilføjer til totalpris
            lblHotel.setText("Hotel: " + hotelPris + " kr.");
            totalPris += hotelPris;
        } else {
            //hvis intet hotel er valgt
            lblHotel.setText("Hotel: 0 kr.");
        }
        //Opdaterer total pris teksten med den nye udregnede pris
        lblTotal.setText("Total: " + totalPris + " kr.");
    }

    private void opdaterHoteller() {
        //Fjerner alt fra listen
        cbHotel.getItems().clear();
        //Tilføjer Intet hotel som standard på plads 0
        cbHotel.getItems().add("Intet hotel");
        // Tjekker hvilken konference der er valgt lige nu
        int valgtKonfIndex = cbKonference.getSelectionModel().getSelectedIndex();
        //Hvis man har valgt en konference
        if (valgtKonfIndex >= 0) {
            //tager konfernce objeketet
            Konference valgtKonference = Controller.getKonferencer().get(valgtKonfIndex);
            //Får listen af hoteller fra den konferenc
            for (Hotel hotel : valgtKonference.getHoteller()) {
                //Opretter en tekst med hotel navn og pris
                String tekstHotel = hotel.getNavn() + " - " + hotel.getPris() + " kr/nat";
                //Tilføjer teksten til comboboxen
                cbHotel.getItems().add(tekstHotel);
            }
        }
        //Gør så man starter på "Intet hotel" igen
        cbHotel.getSelectionModel().selectFirst();
    }
}

