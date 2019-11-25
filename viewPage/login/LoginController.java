package viewPage.fxml;
/**
 * This class manages the interaction between login page and home page.
 * Reagan Berhe 
 * 10/30/2019
 */

import java.awt.Button;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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
    

   
    /**
//     * .... THOSE METHODS IS UNDER CONSTRUCTION 
//     */
//  @FXML
//  private void loginPageLogin( ) throws IOException{
//  
//  	}
//  
//  
//    @FXML
//    private void showLoginFullNameField () {
//    	fullNameLoginField.setText("First Last name please!");
//    
//    }
//    
}
