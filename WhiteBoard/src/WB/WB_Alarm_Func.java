package WB;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class WB_Alarm_Func {
	public void ss(){
		try {

			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("raw/test.wav"));
			Clip clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();
			Thread.sleep(clip.getMicrosecondLength()/1000);
		}
		catch (Exception ex)
		{
			
		}
	}
	public void sound(int num) {
	
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			public void run(){
				try{
					Thread.sleep(10);
					ss();
					
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}, num);
	}
	
}
