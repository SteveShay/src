package viewPage.login;
/**
 * This class manages the interaction between login page and home page.
 * Reagan Berhe
 * 10/30/2019
 */

import Database.DatabaseTranslator;
import java.io.IOException;
import static Enumeration.Enumeration.*;
import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.CreateUserFromInput;
import models.User;
import viewPage.Main;
import viewPage.home.HomeViewController;

public class LoginController {
    private Main main;
    @FXML
    private TextField fullNameLoginField;

    /**
     * This method communicate between cancel Button and switches scene method for
    * main controller
    */
    @FXML
    private void loginPageCancel() throws IOException {
        main.showMainView();
    }



    /**
     * .... THOSE METHODS IS UNDER CONSTRUCTION
     */
    @FXML
    private void loginPageLogin() throws IOException{
        String name = fullNameLoginField.getText();
        String filepath = USER_FILEPATH + name + TXT;
        File inputFile = new File(filepath);
        System.out.println("test");
        if(inputFile.exists()){
            System.out.println("TRUE");
            String userFileData = DatabaseTranslator.getUserData(name);
            String[] userData = userFileData.split(INPUT_SPLIT);
            HomeViewController.currentUser = CreateUserFromInput.createUser(userData);

            System.out.println(HomeViewController.currentUser.getAirportCode());
        }
    }
    @FXML
    private void showLoginFullNameField () {

    }

}
