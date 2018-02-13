import com.sun.media.jfxmedia.Media;

import javafx.scene.control.Slider;
import javafx.util.Duration;

public class MediaPlayer {
	
	
	private MediaPlayer mp = new MediaPlayer();
	private Duration duration;
    private Slider timeSlider;
    private Slider volumeSlider;
    
    
    
    
    public void play(String toPlay) {
    	mp.play(toPlay);
    	
    }
	

}
