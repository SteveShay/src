package viewPage.ShowList.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class ShowListController implements Initializable {

	@FXML
	private ListView<String> theFinalList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> items = theFinalList.getItems();
		items.add("One");
		items.add("Two");
		items.add("Three");
		items.add("Four");
		items.add("Five");
	}
}
