import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;


public class Controller {


	private SongList list = new SongList();

	

//private boolean click;
private String currSong = "aa";

@FXML
private Button stopButton;
	
@FXML
private Button uploadButton;

@FXML
private Button saveButton;

@FXML 
private Button playButton;

@FXML 
private Button pauseButton;

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
		    "Add Effects"));
	
	
	
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
		samples.add(filString);
		
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
	private void playSong() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
				String songToPlay = playSongs.getSelectionModel().getSelectedItem();
				System.out.println("song:" + songToPlay);
				if (!songToPlay.equals(currSong)) {
					
					if (playButton.getText().equals("Play")) {
						currSong = songToPlay;
						//list.dispose();
						list.playSong(songToPlay);
						playButton.setText("Pause");
					}
						
				}
				
				else {
					if (playButton.getText().equals("Play")) {
						list.resume();
						playButton.setText("Pause");
					}
					
					else {
					
					playButton.setText("Play");
					list.pauseSound();
					}
				}


			}
	
	@FXML
	private void stop() {
		list.stop();
		playButton.setText("Play");
	}
	


}
