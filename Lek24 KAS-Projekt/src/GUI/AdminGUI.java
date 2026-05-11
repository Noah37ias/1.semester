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
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;


public class AdminGUI extends Stage {
    private ListView<Tilmelding> lstTilmelding;
    private TextArea txatDetaljer;
    private ListView<Udflugt> lstUdflugt;
    private TextArea txatDetaljerUdflugt;
    private ComboBox<Konference> cbKonference;
    private TextArea txatDetaljerHotel;

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

        cbKonference = new ComboBox<>();
        cbKonference.setItems(Controller.getKonferencer());


        lstTilmelding = new ListView<>();
        lstTilmelding.setMaxHeight(150);

        cbKonference.setOnAction(event -> {
            {
                Konference valgtKonf = cbKonference.getSelectionModel().getSelectedItem();

                lstTilmelding.getItems().setAll(valgtKonf.getTilmeldinger());
                lstUdflugt.getItems().setAll(valgtKonf.getUdflugter());
                txatDetaljerUdflugt.clear();
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
        fjern.setOnMouseClicked(event -> {
            Tilmelding t = lstTilmelding.getSelectionModel().getSelectedItem();
            Konference valgtKonf = cbKonference.getSelectionModel().getSelectedItem();
            if (t != null && valgtKonf != null) {
                Controller.removeTilmelding(t);
                valgtKonf.removeTilmelding(t);
                lstTilmelding.getItems().setAll(valgtKonf.getTilmeldinger());
                txatDetaljer.clear();
            }
        });

        Button btnVisUdflugter = new Button("Vis udflugtsliste");
        btnVisUdflugter.setOnAction(event -> {
            Konference valgtKonf = cbKonference.getSelectionModel().getSelectedItem();
            if (valgtKonf != null) {
                String tekst = oversigtUdflugt(valgtKonf);
                visOversigt(tekst, valgtKonf);
            } else {
                visFejl("Ingen konference", "Vælg en konference for at se udflugter.");
            }
        });
        gemHotelFil();

        VBox vBoxHotel = VisHotel();
        vboxVenstre.getChildren().addAll(lblKonferenceTitel, cbKonference, lblListeTitel, lstTilmelding, lblDetaljeTitel, txatDetaljer, fjern, btnVisUdflugter,vBoxHotel);
        pane.add(vboxVenstre, 0, 0);

        // Registrer Konference
        VBox vboxHøjre = registrerKonferenceBoks();
        pane.add(vboxHøjre, 1, 0);

        VBox vboxUdflugt = visUdlugtOgLedsager();
        pane.add(vboxUdflugt, 0, 1);



        lstUdflugt.getSelectionModel().selectedItemProperty().addListener((_, _, nyU) -> {
            visUdflugtDetaljer(nyU);
        });
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
                for (Hotel h : lswHoteller.getSelectionModel().getSelectedItems()) {
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

    private VBox visUdlugtOgLedsager() {
        VBox vboxUdflugt = new VBox(15);

        Label lblUdflugt = new Label("Udflugter");
        lblUdflugt.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        lstUdflugt = new ListView<>();
        lstUdflugt.setPrefHeight(75);

        Label lblDetaljeTitel = new Label("Ledsagerne koblet på udflugten");
        lblDetaljeTitel.setStyle("-fx-font-weight: bold;");

        txatDetaljerUdflugt = new TextArea();
        txatDetaljerUdflugt.setEditable(false);//Så man ikke kan slette eller skrive i feltet
        txatDetaljerUdflugt.setPromptText("Vælg en udflugt for at se ledsagerne...");
        txatDetaljerUdflugt.setPrefHeight(300);

        vboxUdflugt.getChildren().addAll(lblUdflugt, lstUdflugt, lblDetaljeTitel, txatDetaljerUdflugt);
        return vboxUdflugt;
    }

    private void visUdflugtDetaljer(Udflugt udflugt) {
        txatDetaljerUdflugt.setText(udflugt.getLedsagere().toString());

    }

    private String oversigtUdflugt(Konference konference) {
        String tekst = "UDFLUGTER: " + konference.getNavn() + "\n";
        tekst += "--------------------------------------------------\n";
        for (Udflugt u : konference.getUdflugter()) {
            tekst+= "Udflugt: " + u.getNavn() + "\n";
            for (Tilmelding t : konference.getTilmeldinger()) {
                Ledsager ledsager = t.getLedsager();
                Deltager deltager = t.getDeltager();

                if (ledsager != null && ledsager.getUdflugter().contains(u)) {
                    tekst += "  - " + ledsager.getNavn() + " (" + deltager.getTelefonNr() + " " + deltager.getNavn() + ")\n";
                }
            }

        }
        return tekst;
    }

    private void visOversigt(String oversigt, Konference konference) {
        Stage popupVindue = new Stage();
        popupVindue.setTitle("Udflugtsoversigt");

        TextArea txatOversigt = new TextArea(oversigt);
        txatOversigt.setEditable(false);
        txatOversigt.setPrefSize(400, 500);

        Button btnGem = new Button("Gem til fil");
        btnGem.setStyle("-fx-background-color: #6e9eeb; -fx-text-fill: red; -fx-font-weight: bold;");

        btnGem.setOnAction(e -> {
            try {
                String fileName = konference.getNavn() + "_udflugter" + ".txt";
                PrintWriter out = new PrintWriter(fileName);
                out.println(oversigt);
                out.close();
            } catch (FileNotFoundException ex) {
                visFejl("Filfejl", "Der skete en fejl.");
            }
        });

        VBox vbox = new VBox(10, txatOversigt, btnGem);
        vbox.setPadding(new Insets(15));

        Scene scene = new Scene(vbox);
        popupVindue.setScene(scene);
        popupVindue.show();
    }
    private VBox VisHotel(){
        VBox vboxHotel = new VBox(15);

        Label lblHotel = new Label("Hoteller");
        lblHotel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        txatDetaljerHotel = new TextArea();
        txatDetaljerHotel.setEditable(false);//Så man ikke kan slette eller skrive i feltet
        txatDetaljerHotel.setPromptText("Vælg en udflugt for at se ledsagerne...");
        txatDetaljerHotel.setPrefHeight(300);
        txatDetaljerHotel.setText(hotelOversigt());
        Button btnGem = gemHotelFil();
        vboxHotel.getChildren().addAll(lblHotel, txatDetaljerHotel,btnGem);
        return vboxHotel;
    }
    private String hotelOversigt(){
        String tekst = "";
        for (String s : Controller.hotelList()) {
            tekst += s + "\n";

            for (Tilmelding t : Controller.getTilmeldinger()) {
                if (t.getHotel() != null &&
                        s.equals(t.getHotel().getNavn())) {

                    tekst += "   " + t.getDeltager().getNavn() + "\n";

                    if (t.getLedsager() != null) {
                        tekst += "      Ledsager: "
                                        + t.getLedsager().getNavn() + "\n";
                    }
                }
            }
        }
        return tekst;
    }
    private Button gemHotelFil(){
        Button btnGem = new Button("Gem hoteloversigt til fil");
        btnGem.setStyle("-fx-background-color: #6e9eeb; -fx-text-fill: red; -fx-font-weight: bold;");

        btnGem.setOnAction(e -> {
            try {
                String fileName = "HotelOversigt.txt";
                PrintWriter out = new PrintWriter(fileName);
                out.println(hotelOversigt());
                out.close();
            } catch (FileNotFoundException ex) {
                visFejl("Filfejl", "Der skete en fejl.");
            }
        });
        return btnGem;
    }
}
