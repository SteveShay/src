package homePage.aboutUs;
/**
 * This class manages the interaction between about us page and home page.
 * Reagan Berhe 
 * 10/30/2019
 */

import java.io.IOException;
import homePage.Main;
import javafx.fxml.FXML;

public class AboutUsController {

    private Main main;
    /**
     * This method communicate between ok Button and swich scene method for 
    * main controller
    */
    @FXML
    private void goHome() throws IOException {
        main.showMainView();
    }
}
