package homePage.login;
/**
 * This class manages the interaction between login page and home page.
 * Reagan Berhe 
 * 10/30/2019
 */

import java.io.IOException;
import homePage.Main;
import javafx.fxml.FXML;

public class LoginController {
    private Main main;
    /*This method communicate between cancel Button and swich scene method for 
    * main controller
    */
    @FXML
    private void goHome() throws IOException {
        main.showMainView();
    }
}
