package GUI;

import Controller.Controller;
import Model.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class TilmeldingGUI extends Application {
    public ComboBox<Konference> cbKonference;
    private ComboBox<Hotel> cbHotel;
    private Label lblKonference;
    private Label lblHotel;
    private Label lblTotal;
    private VBox vboxTillæg;
    private Label lblTillæg;
    private TextField txtAfrejseDato;
    private CheckBox cbForedragsholder;
    private CheckBox cbLedsager;
    private TextField tfLedsagerNavn;
    private ListView<Udflugt> lswUdflugter;
    private VBox vboxudflugter;
    private Label lblUdflugter;
    private TextField txtNavn;
    private TextField txtFirma;
    private TextField txtAdresse;
    private TextField txtBy;
    private TextField txtTelefon;
    private Label lblKonfAdresse;
    public Button btnGodkend;

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
        Scene scene = new Scene(scrollPane, 500, 650);
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
            dialog.setHeaderText("Koden er 6767");
            dialog.setContentText("Indsæt 6767 ");
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
        opretTilmelding();
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
        cbKonference.setItems(Controller.getKonferencer());
        //Hvis man ændrer konference valg skal hoteller opdateres
        cbKonference.setOnAction(event -> {
            opdaterHoteller();
            opdaterPriser();
            opdaterUdflugter();
            if (cbKonference.getSelectionModel().getSelectedItem() != null) {
                lblKonfAdresse.setText(" \uD83D\uDCCD" + cbKonference.getSelectionModel().getSelectedItem().getAdresse());
            }
        });
        cbKonference.setMaxWidth(6767);//Får menuen til at fylde alt hvad den kan

        lblKonfAdresse = new Label(" \uD83D\uDCCD");
        // Tilføjer overskrift og dropdown til boksen
        boks.getChildren().addAll(lblTitel, cbKonference, lblKonfAdresse);
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
        txtNavn = new TextField();
        txtFirma = new TextField();
        txtAdresse = new TextField();
        txtBy = new TextField();
        txtTelefon = new TextField();
        Label lblNavn = new Label("Navn");
        txtNavn.setPromptText("Fulde navn");//Tilføjer hjælpe tekst i feltet
        txtNavn.setStyle("-fx-background-color: #ffd966;");
        Label lblFirma = new Label("Firma tlf(valgfri)");
        txtFirma.setPromptText("Hvis betalt af firma");//Tilføjer hjælpe tekst i feltet
        txtFirma.setStyle("-fx-background-color: #ffd966;");
        Label lblAdresse = new Label("Adresse");
        txtAdresse.setPromptText("Vejnavn og nummer");//Tilføjer hjælpe tekst i feltet
        txtAdresse.setStyle("-fx-background-color: #ffd966;");
        Label lblBy = new Label("By");
        txtBy.setPromptText("Postnummer");//Tilføjer hjælpe tekst i feltet
        txtBy.setStyle("-fx-background-color: #ffd966;");
        Label lblTelefon = new Label("Telefon nummer");
        txtTelefon.setPromptText("XX XX XX XX");//Tilføjer hjælpe tekst i feltet
        txtTelefon.setStyle("-fx-background-color: #ffd966;");
        Label lblAfrejseDato = new Label("Afrejse dato");
        txtAfrejseDato = new TextField();
        txtAfrejseDato.setPromptText("YYYY-MM-DD");//Tilføjer hjælpe tekst i feltet
        txtAfrejseDato.setStyle("-fx-background-color: #ffd966;");
        cbForedragsholder = new CheckBox("Er du foredragsholder?");
        cbForedragsholder.setOnAction(e -> {
            opdaterPriser();
        });
        txtAfrejseDato.textProperty().addListener((_, _, _) -> {
            opdaterPriser();
        });
        //Tilføjer alle ting til boksen
        boks.getChildren().addAll(lblTitel, lblNavn, txtNavn, lblFirma, txtFirma, lblAdresse, txtAdresse, lblBy, txtBy, lblTelefon, txtTelefon, lblAfrejseDato, txtAfrejseDato, cbForedragsholder);
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
        cbHotel.setStyle("-fx-background-color: #ffd966;");
        //Laver et standard valg, så man ikke er tvunget til at vælge et hotel
        cbHotel.getItems().add(null);
        //Hvis man vælget et andet hotel opdateres prisen i totalPris
        cbHotel.setOnAction(event -> {
            opdaterTillæg();
            opdaterPriser();
        });
        cbHotel.setMaxWidth(6767);//Tvinger størrelsen på menuen til sit max

        //Til at tjekke hvad der bliver valgt i comboboksen
        cbHotel.getSelectionModel().selectedItemProperty().addListener((_, _, tjek) -> {
            //Hvis teksten der er valgt ikke er "Intet hotel" og teksten tjek eksiterer
            if (tjek != null) {
                //Så skal ekstra tillæg vises
                vboxTillæg.setVisible(true);
                vboxTillæg.setManaged(true);
            } else {
                //eller hvis man vælger intet hotel igen skjul det
                vboxTillæg.setVisible(false);
                vboxTillæg.setManaged(false);
            }
        });

        vboxTillæg = new VBox(5);

        // Tilføjer tingene til boksen samt farver
        boks.getChildren().addAll(lblTitel, cbHotel, vboxTillæg);
        boks.setStyle("-fx-background-color: #f2f2ef;" + "-fx-padding: 15;");
        return boks;
    }

    public void opdaterTillæg() {
        // clear hvis man skifter hotel
        vboxTillæg.getChildren().clear();

        Konference valgtKonf = cbKonference.getSelectionModel().getSelectedItem();
        Hotel valgtHotel = cbHotel.getSelectionModel().getSelectedItem();

        // Hvis der er valgt en konference og et hotel
        if (valgtKonf != null && valgtHotel != null) {
            //Overskrift
            Label lblEkstra = new Label("Ekstra services");
            lblEkstra.setStyle("-fx-font-weight: bold;");
            vboxTillæg.getChildren().add(lblEkstra);

            // looper gennem alle tillæg på hotellet
            for (Tillæg tillæg : valgtHotel.getTillæg()) {
                String tekstTillæg = tillæg.getNavn() + "  -  " + tillæg.getPris() + " kr/nat";
                CheckBox chkNyTillæg = new CheckBox(tekstTillæg);
                chkNyTillæg.setUserData(tillæg);
                chkNyTillæg.setOnAction(event -> opdaterPriser());
                vboxTillæg.getChildren().add(chkNyTillæg);
            }
        }
    }

    public VBox vælgLedsager() {
        //Opretter en Vertical boks
        VBox boks = new VBox(10);
        //Overskrift
        Label lblTitel = new Label("Ledsager");
        lblTitel.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #6e9eeb; -fx-font-family: Consolas;");
        // Checkbox til tilvalg af ledsager
        cbLedsager = new CheckBox("Jeg medbringer en ledsager\n(Giver automatisk dobbeltværelse)");

        //Hvis ledsager skal med:
        Label lblNavn = new Label("Navn");
        tfLedsagerNavn = new TextField();
        tfLedsagerNavn.setPromptText("Fulde navn");
        tfLedsagerNavn.setStyle("-fx-background-color: #ffd966;");

        Label liste = new Label("Vælg ønskede udflugter:");
        lswUdflugter = new ListView<>();
        lswUdflugter.setPrefHeight(100);
        lswUdflugter.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        vboxudflugter = new VBox(5);
        vboxudflugter.getChildren().addAll(lblNavn, tfLedsagerNavn, liste, lswUdflugter);

        vboxudflugter.setVisible(false);
        vboxudflugter.setManaged(false);

        cbLedsager.setOnAction(event -> {
            if (cbLedsager.isSelected()) {
                //Så skal ekstra tillæg vises
                opdaterUdflugter();
                vboxudflugter.setVisible(true);
                vboxudflugter.setManaged(true);
            } else {
                //eller hvis man vælger intet hotel igen skjul det
                vboxudflugter.setVisible(false);
                vboxudflugter.setManaged(false);
                lswUdflugter.getSelectionModel().clearSelection();
            }
            opdaterPriser();
        });
        lswUdflugter.getSelectionModel().selectedItemProperty().addListener((_, _, _) -> {
            opdaterPriser();
        });

        // Tilføj alt til boksen
        boks.getChildren().addAll(lblTitel, cbLedsager, vboxudflugter);
        //Farver og mellemrum i boksen
        boks.setStyle("-fx-background-color: #f2f2ef;" + "-fx-padding: 15;");
        return boks;
    }

    public void opdaterUdflugter() {
        Konference valgteKonf = cbKonference.getSelectionModel().getSelectedItem();
        if (valgteKonf != null) {
            lswUdflugter.getItems().setAll(valgteKonf.getUdflugter());
        } else {
            lswUdflugter.getItems().clear();
        }

    }

    public VBox prisoversigt() {
        //Opretter en Vertical boks
        VBox boks = new VBox(10);
        //Overskrift farve og størrelse
        Label lblTitel = new Label("Prisoversigt pr/dag");
        lblTitel.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #6e9eeb; -fx-font-family: Consolas;");

        //Bruger vores label og giver dem tekster
        lblKonference = new Label("Konference: 0 kr.");
        lblHotel = new Label("Hotel: 0 kr.");
        lblTotal = new Label("Total: 0 kr.");
        lblTillæg = new Label("Tillæg: 0 kr.");
        lblUdflugter = new Label("Udflugter: 0 kr.");
        lblUdflugter.setStyle("-fx-font-weight: bold;");
        lblTillæg.setStyle("-fx-font-weight: bold;");
        lblTotal.setStyle("-fx-font-weight: bold;");
        lblHotel.setStyle("-fx-font-weight: bold;");
        lblKonference.setStyle("-fx-font-weight: bold;");

        btnGodkend = new Button("Bekræft tilmelding");
        btnGodkend.setStyle("-fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: green;");

        // Tilføj alt til boksen
        boks.getChildren().addAll(lblTitel, lblKonference, lblHotel, lblTillæg, lblUdflugter, lblTotal, btnGodkend);
        //Farver og mellemrum på boksen
        boks.setStyle("-fx-background-color: #f2f2ef;" + "-fx-padding: 15;");
        return boks;
    }

    public void opdaterPriser() {
        //Tjek om bokse er lavet ellers stop
        if (cbKonference == null || cbHotel == null || lblTotal == null) return;

        double totalPris = 0;//Vores total pris variabel
        //Tjekker hvilken konference der er valgt
        Konference valgtKonference = cbKonference.getSelectionModel().getSelectedItem();

        int antalDage = 0;
        int antalNat = 0;
        //Sikrer man har valgt en konference inden man begynder at skrive dato
        if (valgtKonference == null) {
            lblKonference.setText("Konference: 0 kr.");
            lblHotel.setText("Hotel: 0 kr.");
            lblTillæg.setText("Tillæg: 0 kr.");
            lblUdflugter.setText("Udflugter: 0 kr.");
            lblTotal.setText("Total: 0 kr.");
            return;
        }

        try {
            LocalDate startDato = valgtKonference.getStartDato();
            LocalDate afrejseDato = java.time.LocalDate.parse(txtAfrejseDato.getText());
            antalNat = (int) ChronoUnit.DAYS.between(startDato, afrejseDato);
            antalDage = (int) ChronoUnit.DAYS.between(startDato, afrejseDato) + 1;
            //Sikrer man ikke får en minus dato
            if (antalNat < 0) antalNat = 0;
            if (antalDage < 0) antalDage = 0;
        } catch (Exception e) {

        }

        if (!cbForedragsholder.isSelected()) {
            //Får prisen på konferencen
            double konfPris = valgtKonference.getPris() * antalDage;
            //Opdaterer teksten så der kommer pris på og tilføjer til totalpris
            lblKonference.setText("Konference: " + konfPris + " kr.");
            totalPris += konfPris;
        } else {

            lblKonference.setText("Konference: 0 kr / FOREDRAGSHOLDER.");
        }

        //Finder det valgte hotel
        Hotel valgtHotel = cbHotel.getSelectionModel().getSelectedItem();
        //Hvis det er plads 0 der er valgt skal vi ikke regne noget da prisen er 0 kroner
        if (valgtHotel != null) {
            double hotelPris;
            if (cbLedsager.isSelected()) {
                hotelPris = valgtHotel.getDobbeltPris() * antalNat;
            } else {
                hotelPris = valgtHotel.getPris() * antalNat;
            }
            //Opdaterer teksten og tilføjer til totalpris
            lblHotel.setText("Hotel: " + hotelPris + " kr.");
            totalPris += hotelPris;

            double samletTillægPris = 0;

            // looper gennem alt i vboxTillæg
            for (javafx.scene.Node node : vboxTillæg.getChildren()) {
                // Tjekker om det er en checkbox så label ikke kommer med
                if (node instanceof CheckBox) {
                    CheckBox chk = (CheckBox) node; // ændrer til checkbox

                    // Er checkboxen valgt
                    if (chk.isSelected()) {
                        // Tager prisen fra den userdata som er gemt der i
                        double prisForDetteTillæg = ((Tillæg) chk.getUserData()).getPris() * antalNat;

                        samletTillægPris = samletTillægPris + (prisForDetteTillæg);
                    }
                }
            }
            // Opdaterer tillæg label og tilføjer til total
            lblTillæg.setText("Tillæg: " + samletTillægPris + " kr.");
            totalPris += samletTillægPris;
        } else {
            //hvis intet hotel er valgt
            lblHotel.setText("Hotel: 0 kr.");
            lblTillæg.setText("Tillæg: 0 kr.");
        }
        int udflugtPris = 0;
        for (Udflugt udflugt : lswUdflugter.getSelectionModel().getSelectedItems()) {
            udflugtPris += (int) udflugt.getPris();
        }
        lblUdflugter.setText("Udflugter: " + udflugtPris + " kr.");
        totalPris += udflugtPris;


        //Opdaterer total pris teksten med den nye udregnede pris
        lblTotal.setText("Total: " + totalPris + " kr.");
    }

    public void opdaterHoteller() {
        //Fjerner alt fra listen
        cbHotel.getItems().clear();
        //Tilføjer intet hotel til listen
        cbHotel.getItems().add(null);
        // Tjekker hvilken konference der er valgt lige nu
        Konference valgtKonf = cbKonference.getSelectionModel().getSelectedItem();

        //Får listen af hoteller fra den konferenc
        if (valgtKonf != null) {
            for (Hotel hotel : valgtKonf.getHoteller()) {
                cbHotel.getItems().add(hotel);
            }
        }
        cbHotel.getSelectionModel().selectFirst();
    }

    public void opretTilmelding() {
        btnGodkend.setOnAction(event -> {

            Konference valgtKonf = cbKonference.getSelectionModel().getSelectedItem();
            String navn = txtNavn.getText();
            String adresse = txtAdresse.getText();
            String firmaTlf = txtFirma.getText();
            String by = txtBy.getText();
            String telefon = txtTelefon.getText();

            if (valgtKonf == null) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Mangler konference");
                alert.setContentText("Du skal vælge en konference før du kan tilmelde dig");
                alert.showAndWait();
                return;
            }

            LocalDate afrejseDato;
            try {
                afrejseDato = LocalDate.parse(txtAfrejseDato.getText());
            } catch (Exception e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Dato fejl");
                alert.setContentText("Datoen skal skrives YYYY-MM-DD");
                alert.showAndWait();
                return;
            }
            if (txtAdresse.getText().isEmpty()) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Adresse");
                alert.setContentText("Du mangler at indsætte en adresse");
                alert.showAndWait();
                return;
            }
            if (txtTelefon.getText().isEmpty()) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Telefon");
                alert.setContentText("Du mangler at indsætte et telefon nr");
                alert.showAndWait();
                return;
            }
            if (txtBy.getText().isEmpty()) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("By");
                alert.setContentText("Du mangler at indsætte et postnr");
                alert.showAndWait();
                return;
            }
            if (txtNavn.getText().isEmpty()) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Adresse");
                alert.setContentText("Du mangler at indsætte et navn");
                alert.showAndWait();
                return;
            }

            Deltager deltager = Controller.createDeltager(navn, adresse, cbForedragsholder.isSelected(), afrejseDato, telefon, firmaTlf, by);

            Tilmelding tilmelding = Controller.createTilmelding(valgtKonf, deltager, LocalDate.now());
            Hotel valgtHotel = cbHotel.getSelectionModel().getSelectedItem();
            if (valgtHotel != null) {
                tilmelding.setHotel(valgtHotel);
                for (javafx.scene.Node node : vboxTillæg.getChildren()) {
                    if (node instanceof CheckBox) {
                        CheckBox chk = (CheckBox) node;
                        if (chk.isSelected()) {
                            Tillæg valgtTillæg = (Tillæg) chk.getUserData();
                            tilmelding.addTillæg(valgtTillæg);
                        }
                    }
                }
            }
            if (cbLedsager.isSelected() && !tfLedsagerNavn.getText().isEmpty()) {
                Ledsager nyLedsager = Controller.createLedsager(tfLedsagerNavn.getText());

                for (Udflugt u : lswUdflugter.getSelectionModel().getSelectedItems()) {
                    nyLedsager.addUdflugt(u);
                }
                tilmelding.setLedsager(nyLedsager);
            }


            Alert success = new Alert(AlertType.INFORMATION);
            success.setTitle("Tilmelding bekræftet");
            success.setHeaderText("Succes!");
            success.setContentText(navn + " er nu tilmeldt " + valgtKonf.getNavn());
            success.showAndWait();

            txtNavn.clear();
            txtAdresse.clear();
            txtFirma.clear();
            txtBy.clear();
            txtTelefon.clear();
            txtAfrejseDato.clear();
            cbKonference.getSelectionModel().clearSelection();
            cbHotel.getSelectionModel().clearSelection();
            tfLedsagerNavn.clear();
            cbLedsager.setSelected(false);
        });
    }
}