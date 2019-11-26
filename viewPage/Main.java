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
import javafx.stage.Stage;

public class Main extends Application {
	 private static Stage primaryStage;
	 private static BorderPane mainLayout;
	 private static final String HOMEPAGE_PATH = "Home/fxml/HomePageView.fxml";
	 private static final String LOGINPAGE_PATH = "Login/fxml/LoginPageView.fxml";
	 private static final String REGISTERPAGE_PATH = "Regster/fxml/RegistrationPageView.fxml";
	 private static final String ABOUTUSPAGE_PATH = "Home/fxml/AboutUsView.fxml";
	 private static final String COTNTACTUS_PATH = "Home/fxml/ContactUsView.fxml";
	 private static final String CATAGORY1 = "NewUser/fxml/NewUserView.fxml";
	 private static final String CATAGORY2 = "NewUser/fxml/NewUserView2.fxml";
	 private static final String CATAGORY3 = "OtherNewUser/fxml/OthersNewUserView.fxml";
	
	 /**
	  * create the main stage for the entire application
	  * 
	  */
	@Override
	public void start(Stage primaryStage) throws IOException {
		Main.primaryStage = primaryStage;
		Main.primaryStage.setTitle("American Traveller Bucketlist");
		
		showMainView();			
	}
	
	/**
	 * This method display using fxml loader and load the home page.
	 * @throws IOException 
	 */
	public static void FxmlLoader(String _fxmlFilePath) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		//Construct a FXML loader for the home page.
		loader.setLocation(Main.class.getResource(_fxmlFilePath));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		//Construct a main layout for the Main home page
		primaryStage.setScene(scene);
		
	}
	public static void showMainView() throws IOException {
		Main.FxmlLoader(HOMEPAGE_PATH);
		primaryStage.show();	
	}
	

	public static void showLogin() throws IOException {
		Main.FxmlLoader(LOGINPAGE_PATH);
	}
	
	
	public static void showRegister() throws IOException {
		Main.FxmlLoader(REGISTERPAGE_PATH);
	}
	
	/**
	 * This method display using fxml loader and load about us page. 
	 */
	public static void showAboutUs() throws IOException {
		Main.FxmlLoader(ABOUTUSPAGE_PATH);
	}
			
	/**
	 * This method display using fxml loader and load contact us page.
	 */
	public static void showContactUs() throws IOException {
		Main.FxmlLoader(COTNTACTUS_PATH);
	}
	
    /**
	 * This method display using fxml loader and load new user page.
	 */
	public static void showNewUser() throws IOException {
		Main.FxmlLoader(CATAGORY1);
	}
	
	/**
	 * This method display using fxml loader and new user page1  
	 */
	public static void showNewUser1() throws IOException {
		Main.FxmlLoader(CATAGORY2);
	}
	
	public static void showOtherReasons() throws IOException {
		Main.FxmlLoader(CATAGORY3);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
