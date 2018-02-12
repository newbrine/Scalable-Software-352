import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.stage.FileChooser;


public class Controller {


	private SongList list = new SongList();

	//privatelist = new Songlist();


@FXML
private Button uploadButton;

@FXML
private Button saveButton;

@FXML 
private Button playButton;

@FXML 
private Button puaseButton;

@FXML
private ListView<String> playSongs;
ObservableList<String> playsamples =  FXCollections.observableArrayList();


@FXML 
private Button cropButton;

@FXML 
public ListView<String> listSongs;
ObservableList<String> samples =  FXCollections.observableArrayList();

@FXML 
private ChoiceBox choiceButton;

@FXML
private void initialize() {
	choiceButton.setItems(FXCollections.observableArrayList(
		    "New Document", "Open ", "Save", "Save as"));
	
	//(samples.get(0)).setOnMouseDragged(event -> dragFile(event));

	
}



@FXML
private void uploadFile() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
	File file = getDataFile1();
	//if (checkType(file)) {
		
		String fil = (file.getCanonicalPath());
		Integer idx = fil.lastIndexOf('/');
		String filString = fil.substring(idx +1);
		list.addMap(filString, fil);
		list.playSong(filString);
		samples.add(filString);
		list.showList();
		//System.out.println(list);
		
		
		
		
	//}
	updateListView();
	
	
	
}
File getDataFile1() {
FileChooser chooser = new FileChooser();
chooser.setTitle("Select test data");
return chooser.showOpenDialog(null);
}



private void updateListView() {
	listSongs.setItems(samples);
	
}



private Boolean checkType(File file) {
	// TODO Auto-generated method stub
	return null;
}



private File getDataFile() {
	// TODO Auto-generated method stub
	return null;
}
}
