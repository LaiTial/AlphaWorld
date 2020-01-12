package GamePage;

import java.awt.event.*;
import javax.swing.*;
import CommonPanel.Audio;

public class SoundOnOff implements ActionListener{
	
	private String musicSrc;
	
	public SoundOnOff(String musicSrc)
	{
		this.musicSrc = musicSrc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		
		if(button.getText().equals("MusicPlay")) 
		{
			button.setIcon(new ImageIcon("src\\MainPage\\SoundImage11.png"));
			button.setText("MusicStop");
			Audio.musicStop();
		}
		
		else 
		{
			button.setIcon(new ImageIcon("src\\MainPage\\SoundImage10.png"));
			button.setText("MusicPlay");
			Audio.playMusicLoop(musicSrc);
		}
	}
}
