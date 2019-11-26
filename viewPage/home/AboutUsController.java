package viewPage.Home;
/**
 * This class manages the interaction between About us and home page.
 * Reagan Berhe
 * 11/18/2019
 */

import java.io.IOException;
import javafx.fxml.FXML;
import viewPage.Main;

public class AboutUsController {
    @FXML
    private void aboutUsCancel() throws IOException {
        System.out.println("Test 1");
        Main.showMainView();
        
    }
}
