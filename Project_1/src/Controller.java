import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
private Button addButton;



@FXML
private ListView<String> playSongs;
ObservableList<String> pSongs =  FXCollections.observableArrayList();


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
	//System.out.println("this was so easy:" + file.getName());
	//if (checkType(file)) {
		
		String fil = (file.getCanonicalPath());
		Integer idx = fil.lastIndexOf('/');
		String filString = fil.substring(idx +1);
		list.addMap(filString, fil);
		//list.playSong(filString);
		samples.add(filString);
		list.showList();
		//System.out.println(list);
		
		
		
		
	//}
	updateListView();
	
	
	
}
private File getDataFile1() {
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

@FXML 
private void addToPlay() {
	String songToPlay = listSongs.getSelectionModel().getSelectedItem();
	final int songRm = listSongs.getSelectionModel().getSelectedIndex();
	pSongs.add(songToPlay);
	samples.remove(songRm);
	updateListView();
	playSongs.setItems(pSongs);
}

@FXML
private void playSong() {
	playButton.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			String songToPlay = playSongs.getSelectionModel().getSelectedItem();
			System.out.println(songToPlay);
			try {
				list.playSong(songToPlay);
			
			} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	});
}
@FXML
private void pauseSound() {
	puaseButton.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			String songToPause = playSongs.getSelectionModel().getSelectedItem();
			System.out.println(songToPause);
			list.pauseSound(songToPause);
			System.out.println("asdasd");
			
			
		}
	});
}
}
