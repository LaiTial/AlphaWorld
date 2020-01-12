package CommonPanel;

import java.awt.*;
import java.awt.event.*;
import CardMain.ControllMain;
import GamePage.*;
import MainPage.*;
import Timmer.*;

public class ChangeCard implements ActionListener {
	
	private CardLayout card;
	private Container contain;
	private String name;
	private CardWordGame game;
	private HangManGame hangman;
	
	public ChangeCard(Container contain, CardLayout card, String name)
	{
		this.contain = contain;
		this.card = card;
		this.name = name;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		game = (CardWordGame)ControllMain.getPanel(1);
		hangman = (HangManGame)ControllMain.getPanel(3);
		
		card.show(contain, name);
		Audio.musicStop();
		MakeTimmerTask.MakeCancel(true);
		MakeTimmerTask.setSecond(10);
		
		if(name.equals("mainPanel"))
			MainPanel.playMusic();
		
		else if(name.equals("CardGame"))
		{
			CardWordGame.playMusic();
			game.startGame();
		}
		
		else if(name.equals("HangMan"))
		{
			HangManGame.playMusic();
			hangman.startGame();
		}
	}
}
