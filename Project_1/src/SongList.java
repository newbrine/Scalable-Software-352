import javax.sound.sampled.*;

import com.sun.org.apache.xerces.internal.util.Status;

import java.io.File;
import java.io.IOException;
import java.util.*; 
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class SongList {
	private Media media;
	MediaPlayer mp;
	Map<String ,String> songMap = new HashMap<String ,String>();
	private Clip song;
	private long songTime;
	MediaPlayer mediaPlayer;
	Duration PauseTime;
	
	
	
	public void addMap(String songName, String songPath) {
		songMap.put(songName , songPath);
	}
	
	public void mp(Media media) {
		mp = new MediaPlayer(media);
	}
	//https://stackoverflow.com/questions/22344020/could-not-get-audio-input-stream-from-input-file
	public void playSong(String songName) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		String songPath = songMap.get(songName);
		File fin = new File(songPath);
		Media hit = new Media(fin.toURI().toString());
        mp(hit);
        mp.play();
		
	}
	
	public void showList() {
		for (Map.Entry<String,String> entry : songMap.entrySet()) 
            System.out.println("Key = " + entry.getKey() +
                             ", Value = " + entry.getValue());
	}
	public void pauseSound(String songName) {
        mp.pause();
        PauseTime = mp.getStopTime();
        System.out.println(PauseTime.toString());
		
        
		
    }
	
	public String getValue(String key) {
		return songMap.get(key);
	}
	
	public void resume() {
		mp.setStartTime(PauseTime);
		mp.play();
	    
	}


}
