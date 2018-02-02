import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;

public class Controller {

@FXML
private Button uploadButton;


@FXML 
private Button playButton;

@FXML 
private Button puaseButton;


@FXML 
private Button cropButton;

@FXML 
private ListView<String> listSongs;
ObservableList<File> samples =  FXCollections.observableArrayList();

@FXML 
private ChoiceBox choiceButton;

@FXML
private void initialize() {
	choiceButton.setItems(FXCollections.observableArrayList(
		    "New Document", "Open ", "Save", "Save as"));

	
}



@FXML
private void uploadFile() {
	File file = getDataFile();
	if (checkType(file)) {
		samples.add(file);
	}
	updateListView();
	
	
}



private void updateListView() {
	listSongs.setItems(samples);
	
}



private Boolean checkType(File file) {
	// TODO Auto-generated method stub
	
}



private File getDataFile() {
	// TODO Auto-generated method stub
	return null;
}
}
