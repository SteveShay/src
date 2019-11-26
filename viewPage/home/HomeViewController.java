package viewPage.Home;

/**
 * This is the Home view controller for home page. It tracks the home buttons and the action handler
 *  methods for each other page controller
 * Last Updated: 11/04/2019
 * @author Reagan Berhe
 */
import java.io.IOException;
import javafx.fxml.FXML;
import viewPage.Main;

public class HomeViewController {

    /**
     * This handle the login button on the home page that direct the user to login page.
     * @throws IOException
     */
    @FXML
    private void goLoginPage() throws IOException {
        Main.showLogin();
    }

    /**
     * This handle the register button on the home page that direct the user to register page.
     * @throws IOException
     */
    @FXML
    private void goRegisterPage() throws IOException {
        Main.showRegister();
    }

    /**
     * This handle the About us  button on the home page that direct the user to about us page.
     * @throws IOException
     */
    @FXML
    private void goAboutUs() throws IOException {
        Main.showAboutUs();
    }

    /**
     * This handle the contact us button on the home page that direct the user to contact us page
     * @throws IOException
     */
    @FXML
    private void goContactUs() throws IOException {
        Main.showContactUs();
    }
}
