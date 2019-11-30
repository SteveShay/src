package viewPage.newUser.fxml;

import Database.DatabaseTranslator;
import com.amadeus.exceptions.ResponseException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import static Enumeration.Enumeration.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import viewPage.Main;

/**
 *
 * @author Steve Shay
 */
public class NewUserCategoriesController {

    @FXML private RadioButton OutdoorInterested;
    @FXML private RadioButton EntertainmentInterested;
    @FXML private RadioButton EducationalInterested;
    @FXML private RadioButton HistoricalInterested;
    @FXML private RadioButton CulturalIntereested;


    @FXML private void SubmitResponses() throws IOException {
        //RadioButton[] cats = {OutdoorInterested, EntertainmentInterested, EducationalInterested, CulturalIntereested, HistoricalInterested};
        int[] categories = new int[CATEGORY_ARRAY_SIZE];
        //int currentIndex = 0;

        if (OutdoorInterested.isSelected()) {
            categories[OUTDOOR_ADVENTURES] = TRUE;
        }
        if (EntertainmentInterested.isSelected()) {
            categories[ENTERTAINMENT] = TRUE;
        }
        if (EducationalInterested.isSelected()) {
            categories[EDUCATIONAL_ENTERTAINMENT] = TRUE;
        }
        if (CulturalIntereested.isSelected()) {
            categories[CULTURAL] = TRUE;
        }
        if (HistoricalInterested.isSelected()) {
            categories[HISTORICAL] = TRUE;
        }

        Main.currentUser.setCategories(categories);


        if (Main.currentUser.checkCategoriesVaild()) {
            String output = Main.currentUser.toString();
            output += DatabaseTranslator.getUserLocations(Main.currentUser.getName());
            DatabaseTranslator.storeUserData(Main.currentUser.getName(), output);
            Main.loopCategories();
        }
        else {
            Alert invalidSelection = new Alert(Alert.AlertType.ERROR, "No categories have been selected. Selecting 5 random locations.", ButtonType.OK);
            invalidSelection.showAndWait();
            Main.currentUser.responseOverride();
            String output = Main.currentUser.toString();
            output += DatabaseTranslator.getUserLocations(Main.currentUser.getName());
            DatabaseTranslator.storeUserData(Main.currentUser.getName(), output);
        }


    }
}
