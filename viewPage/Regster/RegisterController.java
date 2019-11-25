package viewPage.fxml;
/**
 * This is the register page controller for the American Traveller Bucket list webapp.
 *  It switch the new user page and go back home page in the page.
 * Last Updated: 10/30/2019
 * @author Reagan Berhe
 */

import java.io.IOException;

import javafx.fxml.FXML;
import viewPage.Main;

public class RegisterController {

	/*
	 * It call a method from Main controller that display Home page.
	 */
	@FXML
	private void goHome() throws IOException {
		Main.showMainView();
	}
	/*
	 * It call a method from Main controller that display new user page.
	 */
	@FXML
	private void goNewPage1() throws IOException {
		Main.showNewUser();
	}

}
