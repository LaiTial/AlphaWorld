package CommonPanel;

import java.io.File;
import javax.sound.sampled.*;

public class Audio {

	private static Clip clip;
   
   public static void playMusicLoop(String musicname)  {
       File f = new File(musicname);
      
       try {
          AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
         clip = AudioSystem.getClip();
          clip.open(audioIn);
          clip.loop(Clip.LOOP_CONTINUOUSLY);

       } 
          catch (Exception e) {
          e.printStackTrace();
      }
   }
   
   public static void musicStop() {
      clip.close();
   }
}