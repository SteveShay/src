package viewPage.Login.fxml;

/**
 * This class manages the interaction between login page and home page.
 * Reagan Berhe
 * 10/30/2019
 */

import Database.DatabaseTranslator;
import java.awt.Button;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import static Enumeration.Enumeration.*;
import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.CreateUserFromInput;
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
        String name = fullNameLoginField.getText();
        if(DatabaseTranslator.checkUser(name)){
            String userFileData = DatabaseTranslator.getUserData(name);
            String[] userData = userFileData.split(INPUT_SPLIT);
            Main.currentUser = CreateUserFromInput.createUser(userData);
            Main.showVacationTransition();
        }
        else{
            Main.showRegister();
        }
    }
}
