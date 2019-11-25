package viewPage.OtherNewUser.fxml;
/**
 * This class manages the interaction between login page and home page.
 * Reagan Berhe 
 * 10/30/2019
 */

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import viewPage.Main;

public class ReasonForTravelingConroller {
    private Main main;
   
    @FXML
	private void showTheList() throws IOException {
		Main.showFinalList();
	}
}

