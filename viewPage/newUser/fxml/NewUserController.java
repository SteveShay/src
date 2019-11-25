package viewPage.NewUser.fxml;

/**
 * This class manages the interaction between new user page and home page.
 * Reagan Berhe 
 * 10/30/2019
 */
import java.awt.Button;
import java.awt.Event;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import viewPage.Main;

public class NewUserController {
	@FXML
	private RadioButton newAdventureIntersted;
	@FXML
	private RadioButton newAdventureNotIntersted;
	@FXML
	private RadioButton historicalSiteIntersted;
	@FXML
	private RadioButton historicalSiteNotIntersted;
	@FXML
	private RadioButton familyVacationIntersted;
	@FXML
	private RadioButton familyVacationNotIntersted;
	@FXML
	private RadioButton newExperianceIntersted;
	@FXML
	private RadioButton newExperianceNotIntersted;

	@FXML
	private void goToReasonForTravel2() throws IOException {
		Main.showNewUser1();
	}
}
