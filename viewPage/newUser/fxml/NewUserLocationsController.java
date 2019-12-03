package viewPage.newUser.fxml;

import Database.DatabaseTranslator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import viewPage.Main;

import static Enumeration.Enumeration.*;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Steve
 */
public class NewUserLocationsController {

    @FXML private Label categoryName;
    @FXML private Label location0;
    @FXML private Label location1;
    @FXML private Label location2;
    @FXML private Label location3;
    @FXML private Label location4;

    @FXML private RadioButton location0Selection1;
    @FXML private RadioButton location0Selection3;

    @FXML private RadioButton location1Selection1;
    @FXML private RadioButton location1Selection3;

    @FXML private RadioButton location2Selection1;
    @FXML private RadioButton location2Selection3;

    @FXML private RadioButton location3Selection1;
    @FXML private RadioButton location3Selection3;

    @FXML private RadioButton location4Selection1;
    @FXML private RadioButton location4Selection3;

    @FXML
    private void initialize() {
        categoryName.setText(CURRENT_CATEGORIES[Main.count]);
        location0.setText(CURRENT_LOCATION_NAMES[Main.startIndex]);
        location1.setText(CURRENT_LOCATION_NAMES[Main.startIndex + 1]);
        location2.setText(CURRENT_LOCATION_NAMES[Main.startIndex + 2]);
        location3.setText(CURRENT_LOCATION_NAMES[Main.startIndex + 3]);
        location4.setText(CURRENT_LOCATION_NAMES[Main.startIndex + 4]);
    }

    @FXML
    private void submitResponses() throws IOException {
        if (location0Selection1.isSelected() || location0Selection3.isSelected()){
            Main.currentUser.setSingleResponse(Main.startIndex, TRUE);
        }
        if (location1Selection1.isSelected() || location1Selection3.isSelected()){
            Main.currentUser.setSingleResponse(Main.startIndex + 1, TRUE);
        }
        if (location2Selection1.isSelected() || location2Selection3.isSelected()){
            Main.currentUser.setSingleResponse(Main.startIndex + 2, TRUE);
        }
        if (location3Selection1.isSelected() || location3Selection3.isSelected()){
            Main.currentUser.setSingleResponse(Main.startIndex + 3, TRUE);
        }
        if (location4Selection1.isSelected() || location4Selection3.isSelected()){
            Main.currentUser.setSingleResponse(Main.startIndex + 4, TRUE);
        }

        Main.save();
        Main.count++;

        if (Main.count < 5) {
            Main.loopCategories();
        }
        else {
            if (!Main.currentUser.checkResponseValid()){
                Alert invalidSelection = new Alert(Alert.AlertType.ERROR, "No locations have been selected. Selecting 5 random locations.", ButtonType.OK);
                invalidSelection.showAndWait();
                Main.currentUser.responseOverride();
            }

            Alert saved = new Alert(Alert.AlertType.CONFIRMATION, "All location preferences have been saved.", ButtonType.OK);
            saved.show();
            Main.showVacationTransition();
        }
    }
}
