package viewPage;

/**
 * This is a loader page over main pane that display most the pages.
 * Last Updated: 11/04/2019
 * @author Reagan Berhe
 */

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	 private static Stage primaryStage;
	 private static BorderPane mainLayout;
	
	 /**
	  * create the main stage for the entire application 
	  */
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("American Traveller Bucketlist");
		
		showMainView();			
	}
	
	/**
	 * This method display using fxml loader and load the home page.
	 */
	public static void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		//Construct a FXML loader for the home page.
		loader.setLocation(Main.class.getResource("home/HomePageView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		//Construct a main layout for the Main home page
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
	
	/**
	 * This method display using fxml loader and load login page. 
	 */
	public static void showLogin() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("login/LoginPageView.fxml"));
		BorderPane loginPage = loader.load();
		mainLayout.setCenter(loginPage);
	}
	
	/**
	 * This method display using fxml loader and load register page.
	 */
	public static void showRegister() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("register/RegistrationPageView.fxml"));
		BorderPane registerPage = loader.load();
		mainLayout.setCenter(registerPage);
		
	}
	
	/**
	 * This method display using fxml loader and load about us page. 
	 */
	public static void showAboutUs() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("aboutUs/AboutUsView.fxml"));
		BorderPane aboutUs = loader.load();
		Stage showAboutUsDialogStage = new Stage();
		showAboutUsDialogStage.setTitle("Register Here! ");
		showAboutUsDialogStage.initModality(Modality.WINDOW_MODAL);
		showAboutUsDialogStage.initOwner(primaryStage);
		Scene scene = new Scene(aboutUs);
		showAboutUsDialogStage.setScene(scene);
		showAboutUsDialogStage.showAndWait();
	}
	
	/**
	 * This method display using fxml loader and load contact us page.
	 */
	public static void showContactUs() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("contactUs/ContactUsView.fxml"));
		BorderPane contactUs = loader.load();
		mainLayout.setCenter(contactUs);
	}
	
    /**
	 * This method display using fxml loader and load new user page.
	 */
	public static void showNewUser() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("newUser/NewUserView.fxml"));
		BorderPane newUser = loader.load();
		//this section here display the new user as a dialog box
		Stage showNewUserFirstDialogStage = new Stage();
		showNewUserFirstDialogStage.setTitle("Register Here! ");
		showNewUserFirstDialogStage.initModality(Modality.WINDOW_MODAL);
		showNewUserFirstDialogStage.initOwner(primaryStage);
		Scene scene = new Scene(newUser);
		showNewUserFirstDialogStage.setScene(scene);
		showNewUserFirstDialogStage.showAndWait();	
	}
	
	/**
	 * This method display using fxml loader and new user page1  
	 */

	public static void showNewUser1() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("reasonForTraveling/ReasonForTravelView.fxml"));
		BorderPane newUser1 = loader.load();
		mainLayout.setCenter(newUser1);
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
