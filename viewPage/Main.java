package viewPage;

/**
 * This is the main controller for the American Travel Bucket List app.
 * This class contains the primary loader method, the extensions of this loader method for each view,
 * the static variables which hold the data used by multiple views during operation,
 * and a small amount of logic for saving data and picking the correct view values.
 *
 * Last Updated: 11/30/19
 * @author Reagan Berhe, Stephen Hampson
 */

import Database.DatabaseTranslator;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.User;
import static Enumeration.Enumeration.*;
import models.Destination;

public class Main extends Application {
    public static User currentUser;
    public static Destination destination;
    public static int count = 0;
    public static int startIndex = 0;
    public static boolean registered = false;
    public static int selection = 0;
    public static double flight = 0.0;
    public static double hotel = 0.0;

    private static Stage primaryStage;
    private static BorderPane mainLayout;
    private static final String HOMEPAGE_PATH = "Home/fxml/HomePageView.fxml";
    private static final String LOGINPAGE_PATH = "Login/fxml/LoginPageView.fxml";
    private static final String REGISTERPAGE_PATH = "Regster/fxml/RegistrationPageView.fxml";
    private static final String ABOUTUSPAGE_PATH = "Home/fxml/AboutUsView.fxml";
    private static final String COTNTACTUS_PATH = "Home/fxml/ContactUsView.fxml";
    private static final String CATEGORY_PATH = "NewUser/fxml/NewUserCategories.fxml";
    private static final String LOCATIONS_PATH = "NewUser/fxml/NewUserLocations.fxml";
    private static final String TRANSITON_PATH = "Vacation/fxml/VacationTransition.fxml";
    private static final String FINAL_PATH = "Vacation/fxml/VacationFinal.fxml";

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

    public static void showCategories() throws IOException {
        Main.FxmlLoader(CATEGORY_PATH);
    }

    public static void loopCategories() throws IOException {
        if (count < CATEGORY_ARRAY_SIZE) {
            if (currentUser.getSingleCategory(count) == TRUE) {
                startIndex = count * 5;
                Main.FxmlLoader(LOCATIONS_PATH);
            }
            else {
                count++;
                loopCategories();
            }
        }
    }

    public static void showVacationTransition() throws IOException {
        Main.FxmlLoader(TRANSITON_PATH);
    }

    public static void showVacationFinal() throws IOException {
        Main.FxmlLoader(FINAL_PATH);
    }

    public static void save() throws IOException {
        String output = Main.currentUser.toString();
        output += DatabaseTranslator.getUserLocations(currentUser.getName());
        DatabaseTranslator.storeUserData(currentUser.getName(), output);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
