package viewPage.Login.fxml;

/**
 * This class manages the interaction between login page and home page.
 * Reagan Berhe 
 * 10/30/2019
 */

import java.awt.Button;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import viewPage.Main;

public class LoginController {
	@FXML
	private TextField fullNameLoginField;
	@FXML
	private Button loginButton;

	/**
	 * This method communicate between cancel Button and switches scene method for
	 * main controller
	 */
	@FXML
	private void loginPageCancel() throws IOException {
		Main.showMainView();
	}

	@FXML
	private void loginLoginBtn() throws IOException {
		FileReader rdr = new FileReader("viewPage/Regster/fxml/TempReg.txt");
		Scanner scanFile = new Scanner(rdr);

		if (scanFile.equals(fullNameLoginField.getText())) {
			Main.showNewUser();
		} else {
			Main.showLogin();
		}

	}

}
