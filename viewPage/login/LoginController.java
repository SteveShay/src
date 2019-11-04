package viewPage.login;
/**
 * This class manages the interaction between login page and home page.
 * Reagan Berhe 
 * 10/30/2019
 */

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import viewPage.Main;

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
//  @FXML
//  private void loginPageLogin() throws IOException{
//  	
//  }
//    @FXML
//    private void showLoginFullNameField () {
//    
//    }
//    
}
