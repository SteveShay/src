package homePage.view;

import java.io.IOException;
import java.io.InterruptedIOException;

import homePage.Main;
import javafx.fxml.FXML;

public class HomeViewController {
	
	private Main main;
	@FXML
	private void goLoginPage() throws IOException {
		main.showLogin();
	}
	@FXML
	private void goRegisterPage() throws IOException {
		main.showRegister();
	}
	@FXML
	private void goAboutUs() throws IOException {
		main.showAboutUs();
	}
	@FXML
	private void goContactUs() throws IOException {
		main.showContactUs();
	}
	

}
