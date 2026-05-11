package GUI;


import Controller.Controller;
import Model.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jspecify.annotations.NullMarked;

import java.time.LocalDate;
import java.util.ArrayList;
@NullMarked

public class AdminGUI extends Stage {
    private ListView<Tilmelding> lstTilmelding;
    private TextArea txatDetaljer;

    public AdminGUI() {
        this.setTitle("KAS - Administration");
        GridPane adminPane = new GridPane();
        //SCROLLBAR
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(adminPane);
        scrollPane.setFitToWidth(true);
        Scene scene = new Scene(scrollPane, 800, 800);
        this.setScene(scene);
        initContent(adminPane);
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(30);
        pane.setVgap(15);
        pane.setStyle("-fx-background-color: #93c47e;");

        //Liste og Detaljer
        VBox vboxVenstre = new VBox(15);

        Label lblListeTitel = new Label("Tilmeldinger");
        lblListeTitel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        Label lblKonferenceTitel = new Label("Vælg konference: ");
        lblKonferenceTitel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        ComboBox<Konference> cbKonference = new ComboBox<>();
        cbKonference.getItems().setAll(Controller.getKonferencer());


        lstTilmelding = new ListView<>();
        lstTilmelding.setMaxHeight(150);

        cbKonference.setOnAction(event -> {
           {
                Konference valgtKonf = cbKonference.getSelectionModel().getSelectedItem();
                if(valgtKonf!=null) {
                    lstTilmelding.getItems().setAll(valgtKonf.getTilmeldinger());
                    }
            }
        });

        // Detaljefeltet
        Label lblDetaljeTitel = new Label("Detaljer for valgt tilmelding");
        lblDetaljeTitel.setStyle("-fx-font-weight: bold;");

        txatDetaljer = new TextArea();
        txatDetaljer.setEditable(false);//Så man ikke kan slette eller skrive i feltet
        txatDetaljer.setPromptText("Vælg en tilmelding for at se detaljer...");
        txatDetaljer.setPrefHeight(150);

        //Når man vælger ny deltager
        lstTilmelding.getSelectionModel().selectedItemProperty().addListener((_, _, ny) -> {
            visTilmeldingDetaljer(ny);
        });

        Button fjern = new Button("Fjern tilmelding");
        Tilmelding t = lstTilmelding.getSelectionModel().getSelectedItem();
        Konference valgtKonf = cbKonference.getSelectionModel().getSelectedItem();
        fjern.setOnMouseClicked(event -> {
            Controller.removeTilmelding(t);
            lstTilmelding.getItems().setAll(valgtKonf.getTilmeldinger());
            txatDetaljer.clear();
        });

        vboxVenstre.getChildren().addAll(lblKonferenceTitel,cbKonference,lblListeTitel, lstTilmelding, lblDetaljeTitel, txatDetaljer, fjern);
        pane.add(vboxVenstre, 0, 0);

        // Registrer Konference
        VBox vboxHøjre = registrerKonferenceBoks();
        pane.add(vboxHøjre, 1, 0);
    }

    // Metode  til nye konferencer
    private VBox registrerKonferenceBoks() {
        VBox boks = new VBox(10);
        boks.setStyle("-fx-background-color: #f2f2ef; -fx-padding: 15; -fx-border-color: black; -fx-border-radius: 5;");

        Label lblTitel = new Label("Opret ny konference");
        lblTitel.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: #6e9eeb;");

        // Konference info
        TextField txtNavn = new TextField();
        txtNavn.setPromptText("Konference navn");

        TextField txtAdresse = new TextField();
        txtAdresse.setPromptText("Adresse / Lokation");

        TextField txtPris = new TextField();
        txtPris.setPromptText("Pris pr. dag i kr.");

        DatePicker dpStartDato = new DatePicker();
        dpStartDato.setPromptText("Vælg startdato");

        DatePicker dpSlutDato = new DatePicker();
        dpSlutDato.setPromptText("Vælg slutdato");

        // Udflugter
        Label lblUdflugtTitel = new Label("Tilføj udflugter til denne konference:");
        lblUdflugtTitel.setStyle("-fx-font-weight: bold;");

        TextField txtUdflugtNavn = new TextField();
        txtUdflugtNavn.setPromptText("Udflugt navn");

        TextField txtUdflugtPris = new TextField();
        txtUdflugtPris.setPromptText("Udflugt pris");

        DatePicker dpUdflugtDato = new DatePicker();
        dpUdflugtDato.setPromptText("Vælg dato for udflugt");

        ListView<Udflugt> lswNyeUdflugter = new ListView<>();
        lswNyeUdflugter.setPrefHeight(100);

        //Hoteller
        ListView<Hotel> lswHoteller = new ListView<>();
        lswHoteller.setPrefHeight(100);
        lswHoteller.getItems().setAll(Controller.getHoteller());
        lswHoteller.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);



        // Til at gemme udflugterne i indtil konferencen er lavet
        ArrayList<Udflugt> midlertidigUdflugter = new ArrayList<>();

        Button btnTilføjUdflugt = new Button("Tilføj udflugt til liste");
        btnTilføjUdflugt.setOnAction(e -> {
            String Navn = txtUdflugtNavn.getText().trim();
            LocalDate startDato = dpUdflugtDato.getValue();

            if (Navn.isEmpty() || txtUdflugtPris.getText().isEmpty() || startDato == null) {
                visFejl("Mangler data", "Udfyld venligst startdato udflugtsnavn og pris.");
                return;
            }

            try {
                double Pris = Double.parseDouble(txtUdflugtPris.getText());

                Udflugt nyU = Controller.createUdflugt(Navn, startDato, Pris);
                midlertidigUdflugter.add(nyU);
                lswNyeUdflugter.getItems().add(nyU);

                txtUdflugtNavn.clear();
                txtUdflugtPris.clear();
            } catch (NumberFormatException ex) {
                visFejl("Pris fejl", "Prisen på udflugten skal være et tal.");
            }
        });

        // gemmer konferencen
        Button btnOpret = new Button("Opret Konference");
        btnOpret.setStyle("-fx-background-color: #6e9eeb; -fx-text-fill: white; -fx-font-weight: bold;");

        btnOpret.setOnAction(event -> {
            String navn = txtNavn.getText().trim();
            String adresse = txtAdresse.getText().trim();
            LocalDate startDato = dpStartDato.getValue();
            LocalDate slutDato = dpSlutDato.getValue();

            if (navn.isEmpty() || adresse.isEmpty() || startDato == null || slutDato == null || txtPris.getText().isEmpty()) {
                visFejl("Mangler data", "Udfyld venligst alle konference-felter.");
                return;
            }

            if (slutDato.isBefore(startDato)) {
                visFejl("Dato fejl", "Slutdatoen kan ikke være før startdatoen.");
                return;
            }

            try {
                double pris = Double.parseDouble(txtPris.getText());


                Konference nyKonf = Controller.createKonference(navn, startDato, slutDato, adresse, pris);
                //Tilføjer udflugterne til konferencen
                for (Udflugt u : midlertidigUdflugter) {
                    nyKonf.addUdflugt(u);
                }
                for(Hotel h : lswHoteller.getSelectionModel().getSelectedItems()) {
                    nyKonf.addHotel(h);
                }

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Konference oprettet");
                alert.setHeaderText("Succes!");
                alert.setContentText(navn + " er nu oprettet med " + midlertidigUdflugter.size() + " udflugter.");
                alert.showAndWait();

                // Ryd alt
                txtNavn.clear();
                txtAdresse.clear();
                txtPris.clear();
                dpStartDato.setValue(null);
                dpSlutDato.setValue(null);
                dpUdflugtDato.setValue(null);
                midlertidigUdflugter.clear();
                lswNyeUdflugter.getItems().clear();
                lswHoteller.getSelectionModel().clearSelection();

            } catch (NumberFormatException e) {
                visFejl("Pris fejl", "Prisen må kun indeholde tal.");
            }
        });



        boks.getChildren().addAll(
                lblTitel,
                new Label("Navn:"), txtNavn,
                new Label("Adresse:"), txtAdresse,
                new Label("Startdato:"), dpStartDato,
                new Label("Slutdato:"), dpSlutDato,
                new Label("Pris pr. dag:"), txtPris,
                lblUdflugtTitel, txtUdflugtNavn, dpUdflugtDato, txtUdflugtPris, btnTilføjUdflugt, lswNyeUdflugter,
                lswHoteller, btnOpret
        );

        return boks;
    }

    private void visTilmeldingDetaljer(Tilmelding t) {
        if (t == null) {
            txatDetaljer.clear();
            return;
        }

        Deltager d = t.getDeltager();

        // tom String
        String tekst = "";

        tekst += "DELTAGER INFO:\n";
        tekst += "Navn: " + d.getNavn() + "\n";
        tekst += "Adresse: " + d.getAdresse() + ", " + d.getBy() + "\n";
        tekst += "Telefon: " + d.getTelefonNr() + "\n";

        // Tilføjer kun firmanummer, hvis det er udfyldt
        if (!d.getFirmaTlfNr().isEmpty()) {
            tekst += "Firma tlf: " + d.getFirmaTlfNr() + "\n";
        }

        // Tjekker om de er foredragsholder
        if (d.isForedragsholder()) {
            tekst += "Foredragholder: ✓\n\n";
        } else {
            tekst += "Foredragholder: ❌\n\n";
        }

        tekst += "KONFERENCE INFO:\n";
        tekst += "Navn: " + t.getKonference().getNavn() + "\n";
        tekst += "Afrejse: " + d.getAfrejseDato() + "\n\n";

        tekst += "HOTEL INFO:\n";
        if (t.getHotel() != null) {
            tekst += "Hotel: " + t.getHotel().getNavn() + "\n";
            tekst += "Tillæg: ";
            if (t.getTillæg().isEmpty()) {
                tekst += "Ingen";
            } else {
                for (Tillæg til : t.getTillæg()) {
                    tekst += til.getNavn() + " ";
                }
            }
            tekst += "\n";
        } else {
            tekst += "Hotel: Intet hotel valgt\n";
        }

        if (t.getLedsager() != null) {
            tekst += "\nLEDSAGER:\n";
            tekst += "Navn: " + t.getLedsager().getNavn() + "\n";
            tekst += "Udflugter: ";
            for (Udflugt u : t.getLedsager().getUdflugter()) {
                tekst += u.getNavn() + ", ";
            }
            tekst += "\n";
        }

        tekst += "SAMLET PRIS: " + t.totalPris() + " kr.";
        //Indsætter teksten
        txatDetaljer.setText(tekst);
    }

    private void visFejl(String titel, String besked) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(titel);
        alert.setHeaderText(null);
        alert.setContentText(besked);
        alert.showAndWait();
    }
}
