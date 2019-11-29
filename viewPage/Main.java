package viewPage;

/**
 * This is a loader page over main pane that display most the pages.
 * Last Updated: 11/25/19
 * @author Reagan Berhe
 */

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.User;

public class Main extends Application {
    private static Stage primaryStage;
    private static BorderPane mainLayout;
    private static final String HOMEPAGE_PATH = "Home/fxml/HomePageView.fxml";
    private static final String LOGINPAGE_PATH = "Login/fxml/LoginPageView.fxml";
    private static final String REGISTERPAGE_PATH = "Regster/fxml/RegistrationPageView.fxml";
    private static final String ABOUTUSPAGE_PATH = "Home/fxml/AboutUsView.fxml";
    private static final String COTNTACTUS_PATH = "Home/fxml/ContactUsView.fxml";
    private static final String CATAGORY1_PATH = "NewUser/fxml/NewUserView.fxml";
    private static final String CATAGORY2_PATH = "NewUser/fxml/NewUserView2.fxml";
    private static final String CATAGORY3_PATH = "OtherNewUser/fxml/OthersNewUserView.fxml";
    private static final String SHOWLIST_PATH = "ShowList/fxml/ShowListView.fxml";
    private static final String CATEGORY_PATH = "NewUser/fxml/NewUserCategories.fxml";

    public static User currentUser;


    /**
     * This Method Create the main Stage for all pages.
     *
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        Main.primaryStage = primaryStage;
        Main.primaryStage.setTitle("American Traveller Bucketlist");

        showMainView();
    }

   /**
    * This method display using FXML loader method for Scene.
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
        Main.FxmlLoader(CATAGORY1_PATH);
    }

    /**
     * This method display using fxml loader and new user page1
     */
    public static void showNewUser1() throws IOException {
        Main.FxmlLoader(CATAGORY2_PATH);
    }

    public static void showOtherReasons() throws IOException {
        Main.FxmlLoader(CATAGORY3_PATH);
    }

    public static void showFinalList() throws IOException {
        Main.FxmlLoader(SHOWLIST_PATH);

    }

    public static void showCategories() throws IOException {
        Main.FxmlLoader(CATEGORY_PATH);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
