package homePage;
/**
 * This is the main controller for the web application. It tracks the home buttons and the action handler methods for each controller
 *  in the page.
 * Last Updated: 10/30/2019
 * @author Reagan Berhe
 */

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	 private static Stage primaryStage;
	 private static BorderPane mainLayout;
	
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
		loader.setLocation(Main.class.getResource("view/HomePageView.fxml"));
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
		mainLayout.setCenter(aboutUs);
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
		mainLayout.setCenter(newUser);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
