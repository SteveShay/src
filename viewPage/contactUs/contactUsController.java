package viewPage.contactUs;
/**
 * This class manages the interaction between contact us and home page.
 * Reagan Berhe 
 * 11/04/2019
 */

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import viewPage.Main;

public class contactUsController {
    private Main main;
    @FXML
    private TextField fullNameField;
    @FXML
    private TextField emailAdressField;
    @FXML
    private TextField companyFiled;
    @FXML
    private TextField messageField;
       
    /**
     * .... THOSE METHODS ARE UNDER CONSTRUCTION 
     * 
     * This Method Store the user full name for their comments on site
     */
    @FXML
    private void showFullName() {
    	
    	
    }
    
    /**
     * This Method Store the user email for their comments on site
     */
    @FXML
    private void showEmailField() {
    	
    }
    
    /**
     * This Method Store the user company name for their comment on site
     */
    @FXML
    private void showNameCompanyField() {
    	
    }
    
    /**
     * This Method Store the user message/comment on the site
     */
    @FXML
    private void showMessageField() {
    	
    }
    
    /**
     * This Method submit their message and return to home page
     */
    @FXML
    private void goHome() throws IOException {
        main.showMainView();
    }
    
}
