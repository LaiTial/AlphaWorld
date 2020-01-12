package GamePage;

import java.awt.event.*;
import java.util.ArrayList;
import GamePage.*;
import Timmer.MakeTimmerTask;

import javax.swing.*;

import CardMain.ControllMain;
import CommonPanel.GoToButton;
import CommonPanel.MakeLabel;

public class CheckPairCard implements ActionListener{
	
	private ArrayList<ArrayList<String>> text;
	private static int answer;
	private CardWordGame game;
	
	public CheckPairCard(ArrayList<ArrayList<String>> text)
	{
		this.text = text;
	}
	
	public static void setAnswer(int answerNum)
	{
		answer = answerNum;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		game = (CardWordGame)ControllMain.getPanel(1);
		
		MakeTimmerTask.MakeCancel(true);
		MakeTimmerTask.setSecond(10);
		
		if(text.get(answer).get(0) == button.getText())
		{
			game.animation("src\\GamePage\\OkNoImage00.png", "Win");
			return;
		}
		
		else
			game.animation("src\\GamePage\\OkNoImage01.png", "Lose");
	}

}
