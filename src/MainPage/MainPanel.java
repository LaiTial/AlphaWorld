package MainPage;

import java.awt.*;
import javax.swing.*;
import CommonPanel.*;
import GamePage.SoundOnOff;
public class MainPanel extends JPanel{

	private PutImage SeveralIm;
	private int [][]size = {{0}, {0}, {1300}, {850}};
	
	private int[][] ButtonLocation = {{300, 350, 300, 183},
			{700, 350, 300, 183},
	};
	
	private String[] src = {
			"Explain a CardGame",
			"Explain a HangMan"
	};
	
	private int[] NewPageButton = {1200, 20, 50, 50};

	public MainPanel()
	{	
		this.setLayout(new BorderLayout());
				
		SeveralIm = new PutImage(size, "Image0", "src\\MainPage\\");
		
		ImageClass image = new ImageClass(SeveralIm.getSrc(), SeveralIm.getX(), SeveralIm.getY(), SeveralIm.getWidth(), SeveralIm.getHeight());
		
		GoToButton setButton = new GoToButton(2, ButtonLocation, image, true, false, "src\\MainPage\\GameType0");
		setButton.clickEvent(src);
		this.add(image);
		
		GoToButton soundButton = new GoToButton(NewPageButton, image, false, false, "src\\MainPage\\SoundImage1", "MusicPlay");
		soundButton.clickEvent(new SoundOnOff("src\\MainPage\\CuteCafe.wav"));
		
		playMusic();
	}
	
	public static void playMusic()
	{

		Audio.playMusicLoop("src\\MainPage\\CuteCafe.wav");   
	}

}