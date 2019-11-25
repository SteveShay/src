package viewPage.Regster.fxml;

import java.io.File;
import java.io.FileWriter;

/**
 * This is the register page controller for the American Traveller Bucket list webapp.
 *  It switch the new user page and go back home page in the page.
 * Last Updated: 10/30/2019
 * @author Reagan Berhe
 */

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import viewPage.Main;

public class RegisterController {
	@FXML
	private Button registerBtn, cancelRegBtn;
	@FXML
	private TextField fullNameRegField, zipCodeRegField;

	/*
	 * It call a method from Main controller that display Home page.
	 */
	@FXML
	private void goHome() throws IOException {
		Main.showMainView();
	}

	@FXML
	private void storeDataTemp() throws IOException {
		StringBuilder stringBuld = new StringBuilder();
		stringBuld.append(fullNameRegField.getText().toString() + "\t");
		stringBuld.append(zipCodeRegField.getText().toString() + "\n");
		File file = new File("viewPage/Regster/fxml/TempReg.txt");
		FileWriter regiTxt = new FileWriter(file);
		regiTxt.write(stringBuld.toString());
		regiTxt.close();
		Main.showNewUser();

	}

	/*
	 * It call a method from Main controller that display new user page.
	 */

}
