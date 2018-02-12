import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.*; 

public class SongList {
	
	Map<String ,String> songMap = new HashMap<String ,String>();
	private Clip song;
	
	
	public void addMap(String songName, String songPath) {
		songMap.put(songName , songPath);
	}
	
	public void playSong(String songName) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		String songPath = songMap.get(songName);
		File fin = new File(songPath);
		 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(fin.getAbsoluteFile());
         song = AudioSystem.getClip();
         song.open(audioInputStream);
         song.start();
		
	}
	

}
