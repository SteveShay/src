package viewPage.Vacation.fxml;

import Database.DatabaseTranslator;
import static Enumeration.Enumeration.*;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import viewPage.Main;

/**
 *
 * @author Steve Shay
 */
public class VacationFinalController {

    @FXML private Button selectBtn;

    @FXML private Button saveBtn;

    @FXML private Label locationName;

    @FXML private Label flightCost;

    @FXML private Label hotelPrice;

    @FXML private Label description;

    @FXML
    private void initialize() {
        String fCost = String.format("%.2f", Main.flight);
        String hCost = String.format("%.2f", Main.hotel);

        locationName.setText(Main.destination.getName());
        flightCost.setText(fCost);
        hotelPrice.setText(hCost);

        description.setText(Main.destination.getDescription());
    }

    @FXML void acceptDestination() throws IOException {
        Main.currentUser.setSingleResponse(Main.selection, FALSE);

        String output = Main.currentUser.toString();
        output += DatabaseTranslator.getUserLocations(Main.currentUser.getName());
        DatabaseTranslator.storeUserData(Main.currentUser.getName(), output);

        System.exit(0);
    }

    @FXML void save() throws IOException {
        String output = Main.currentUser.toString();
        output += DatabaseTranslator.getUserLocations(Main.currentUser.getName());
        DatabaseTranslator.storeUserData(Main.currentUser.getName(), output);

        Alert saved = new Alert(Alert.AlertType.CONFIRMATION, "All location preferences have been saved.", ButtonType.OK);
        saved.showAndWait();

        System.exit(0);
    }
}
