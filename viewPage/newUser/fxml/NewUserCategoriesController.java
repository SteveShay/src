package viewPage.newUser.fxml;

import Database.DatabaseTranslator;
import com.amadeus.exceptions.ResponseException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import static Enumeration.Enumeration.*;
import viewPage.Main;

/**
 *
 * @author Steve Shay
 */
public class NewUserCategoriesController {

    @FXML private RadioButton OutdoorInterested;
    @FXML private RadioButton OutdoorNotInterested;
    @FXML private RadioButton EntertainmentInterested;
    @FXML private RadioButton EntertainmentNotInterested;
    @FXML private RadioButton EducationalInterested;
    @FXML private RadioButton EducationalNotInterested;
    @FXML private RadioButton HistoricalInterested;
    @FXML private RadioButton HistoricalNotInterested;
    @FXML private RadioButton CulturalIntereested;
    @FXML private RadioButton CulturalNotInterested;

    @FXML private ToggleGroup OutdoorAdventure;
    @FXML private ToggleGroup Entertainment;
    @FXML private ToggleGroup Educational;
    @FXML private ToggleGroup Cultural;
    @FXML private ToggleGroup Historical;


    @FXML private void SubmitResponses() throws IOException {
        //RadioButton[] cats = {OutdoorInterested, EntertainmentInterested, EducationalInterested, CulturalIntereested, HistoricalInterested};
        int[] categories = new int[CATEGORY_ARRAY_SIZE];
        //int currentIndex = 0;

        OutdoorAdventure = new ToggleGroup();
        Educational = new ToggleGroup();
        Entertainment = new ToggleGroup();
        Cultural = new ToggleGroup();
        Historical = new ToggleGroup();

        this.OutdoorInterested.setToggleGroup(OutdoorAdventure);
        this.OutdoorNotInterested.setToggleGroup(OutdoorAdventure);
        this.EntertainmentInterested.setToggleGroup(Entertainment);
        this.EntertainmentNotInterested.setToggleGroup(Entertainment);
        this.EducationalInterested.setToggleGroup(Educational);
        this.EducationalNotInterested.setToggleGroup(Educational);
        this.CulturalIntereested.setToggleGroup(Cultural);
        this.CulturalNotInterested.setToggleGroup(Cultural);
        this.HistoricalInterested.setToggleGroup(Historical);
        this.HistoricalNotInterested.setToggleGroup(Historical);

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
        String output = Main.currentUser.toString();
        output += DatabaseTranslator.getUserLocations(Main.currentUser.getName());
        DatabaseTranslator.storeUserData(Main.currentUser.getName(), output);
    }
}
