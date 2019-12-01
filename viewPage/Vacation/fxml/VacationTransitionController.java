package viewPage.Vacation.fxml;

import Database.DatabaseTranslator;
import static Enumeration.Enumeration.*;
import api.APITranslator;
import com.amadeus.exceptions.ResponseException;
import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import models.CreateDestinationFromInput;
import models.Destination;
import viewPage.Main;

/**
 *
 * @author Steve Shay
 */
public class VacationTransitionController {

    @FXML private Label displayText;

    @FXML
    private void initialize() {
        if (Main.registered) {
            displayText.setText("User Data Saved. \n \nDo you want to select a random destination?");
        }
        else {
            displayText.setText("User Data Loaded \n \nDo you want to select a random destination?");
        }
    }

    @FXML
    void save() throws IOException {
        String output = Main.currentUser.toString();
        output += DatabaseTranslator.getUserLocations(Main.currentUser.getName());
        DatabaseTranslator.storeUserData(Main.currentUser.getName(), output);

        Alert saved = new Alert(Alert.AlertType.CONFIRMATION, "All location preferences have been saved.", ButtonType.OK);
        saved.showAndWait();

        System.exit(0);
    }

    @FXML
    void selectDestination() throws IOException, ResponseException {
        Main.selection = Main.currentUser.selectRandomDestination();

        if (Main.selection == -1){
            Alert complete = new Alert(Alert.AlertType.CONFIRMATION, "All of your prefered locations have been exhausted. Select new locations?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> result = complete.showAndWait();
            if (result.get() == ButtonType.YES) {
                Main.showCategories();
            }
            else {
                System.exit(0);
            }
        }
        else {
            Main.destination = loadLocation(DatabaseTranslator.mapFilename(Main.currentUser.getName(), Main.selection));
            getFlightAndHotel();
            Main.showVacationFinal();
        }
    }

    Destination loadLocation(String _name) throws IOException {
        String locationFileData = DatabaseTranslator.getLocationData(_name);
        String[] locationData = locationFileData.split(INPUT_SPLIT);
        return CreateDestinationFromInput.createLocation(locationData);
    }

    void getFlightAndHotel() throws ResponseException, IOException{
        Main.flight = APITranslator.getExpectedFlightCost(Main.currentUser.getAirportCode(), Main.destination.getAirportCode(), TEST_DATE);
        System.out.println(Main.flight);

        Main.hotel = APITranslator.getExpectedHotelCost(Main.destination.getCityCode());
        System.out.println(Main.hotel);
    }
}
