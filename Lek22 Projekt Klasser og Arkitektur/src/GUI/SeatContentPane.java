package GUI;

import Controller.Controller;
import Model.Bestilling;
import Model.Forestilling;
import Model.Kunde;
import Model.Plads;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;


public class SeatContentPane extends ContentPane {
    private ListView<Plads> lswpladser = new ListView<>();
    private TextField txfDato;
    private PlayContentPane playPane;
    private KunderContentPane kunderPane;

    public SeatContentPane(String title, PlayContentPane playPane, KunderContentPane kunderPane) {
        super(title);
        this.playPane = playPane;
        this.kunderPane = kunderPane;
        btnCreate.setText("Opret bestilling");
        this.getChildren().add(1, lswpladser);
        lswpladser.getItems().setAll(Controller.getPladser());
        lswpladser.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lswpladser.setCellFactory(_ -> {
            ListCell<Plads> celle = new ListCell<Plads>() {
                @Override
                protected void updateItem(Plads plads, boolean empty) {
                    super.updateItem(plads, empty);
                    feltFarve(this, plads, empty);
                }
            };
            celle.selectedProperty().addListener((obs, varIkkeValgt, erNuValgt) -> {
                feltFarve(celle, celle.getItem(), celle.isEmpty());
            });
            return celle;
        });
        txfDato = createTextField("Dato:");
        txfDato.setPromptText("YYYY-MM-DD");
    }

    private void feltFarve(ListCell<Plads> felt, Plads plads, boolean empty) {
        if (empty || plads == null) {
            felt.setText(null);
            felt.setStyle("");
        } else {
            felt.setText(plads.toString());

                if (felt.isSelected()) {
                    felt.setStyle("-fx-background-color: black; -fx-text-fill: green;");
                } else {
                    int pris = plads.getPris();

                    if (pris == 400) {
                        felt.setStyle("-fx-background-color: lightblue; -fx-text-fill: black;");
                    } else if (pris == 450) {
                        felt.setStyle("-fx-background-color: #0B6623; -fx-text-fill: black;");
                    } else if (pris >= 500) {
                        felt.setStyle("-fx-background-color: #D4AF37; -fx-text-fill: black;");
                    }
                }
            }
        }


    @Override
    public void createAction() {
        Forestilling valgtF = playPane.getSelectedForestilling();
        Kunde valgtK = kunderPane.getSelectedKunde();
        ArrayList<Plads> valgteP = new ArrayList<>(lswpladser.getSelectionModel().getSelectedItems());

        if (valgtF == null || valgtK == null || valgteP.isEmpty()) {//Hvis man mangler at vælge en eller flere felter
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Fejl i valg");
            alert.setHeaderText("En eller flere felter mangler");
            alert.setContentText("Du skal vælge 1 forestilling, 1 kunde og \nmindst 1 plads, for at oprette en bestilling");
            alert.showAndWait();
            return;//Stopper metoden
        }
        try {//Når man har valgt alle nødvendige data fra listerne:
            LocalDate dato = LocalDate.parse(txfDato.getText().trim());
            Bestilling nybestilling = Controller.opretBestillingMedPladser(valgtF, valgtK, dato, valgteP);
            if (nybestilling != null) {//Hvis vores metode har retuneret en bestilling
                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                Image billede = new Image("file:C:/users/noah3/OneDrive/Skrivebord/dupreeh.jpg");
                ImageView imageView = new ImageView(billede);
                imageView.setFitHeight(100);
                imageView.setFitWidth(130);
                alert.setGraphic(imageView);
                alert.setTitle("Bestilling oprettet :)");
                alert.setHeaderText("Du har nu oprettet en bestilling");
                alert.setContentText("OPGAVE 7: " +
                        "\n -Bedste dato succesDato(): \n" + valgtF.succesDato() +
                        "\n -Antallet af total bestilte pladser på dagen: \n" + valgtF.antalBestiltePladserPåDag(dato) +
                        "\n -De bestilte pladser til forestillingen på dagen: \n" + valgtK.bestiltePladserTilForestillingPåDag(valgtF, dato) +
                        "\n -Den samlede pris for bestillingen: \n" + nybestilling.samletPris()
                );
                alert.showAndWait();
                txfDato.clear();
                lswpladser.getSelectionModel().clearSelection();
            } else {//Hvis vores Controller.opretBestillingMedPladser retunerer null og derved ikke har oprettet en bestilling
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fejl i oprettelse af bestilling");
                alert.setHeaderText("");
                alert.setContentText("");
                alert.showAndWait();
            }
        } catch (DateTimeParseException e) {//Hvis dato er indtastet forkert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fejl i oprettelse af bestilling");
            alert.setHeaderText("Den indtastede dato er forkert");
            alert.setContentText("");
            alert.showAndWait();
        }
    }
}
