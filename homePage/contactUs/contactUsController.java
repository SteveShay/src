package homePage.contactUs;
/**
 * This class manages the interaction between contact us and home page.
 * Reagan Berhe 
 * 10/30/2019
 */

import java.io.IOException;
import homePage.Main;
import javafx.fxml.FXML;

public class contactUsController {
    private Main main;
     /*This method communicate between Submit Button and swich scene method for 
    * main controller
    */
    @FXML
    private void goHome() throws IOException {
        main.showMainView();
    }
}
