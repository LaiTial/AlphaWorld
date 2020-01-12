package GamePage;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import CardMain.ControllMain;
import CommonPanel.*;

public class CheckAlpabet implements ActionListener{
	
	private ArrayList<ArrayList<String>> text;
	static int answer;
	static String guess;
	private HangManGame game;
	private boolean findWrong = true;
	
	public CheckAlpabet(ArrayList<ArrayList<String>> text)
	{
		this.text = text;
	}
	
	public static void setAnswer(int answerNum)
	{
		answer = answerNum;
	}
	
	public static void setGuess(String guessText)
	{
		guess = guessText;
	}
	
	public static String getGuess()
	{
		return guess;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton button = (JButton) e.getSource();
		String answerWord = text.get(answer).get(0).strip();
		String temp = "";
		
		game = (HangManGame)ControllMain.getPanel(3);
		
		for(int i=0; i < answerWord.length(); i++)
		{
			if(button.getText().toLowerCase().equals(String.valueOf(answerWord.charAt(i))) && (guess.charAt(i*2) == '_'))
			{
				temp += button.getText().toLowerCase() + " ";
				findWrong = false;
			}	
			
			else if(button.getText().equals(String.valueOf(answerWord.charAt(i))) && (guess.charAt(i*2) == '_'))
			{
				temp += button.getText() + " ";
				findWrong = false;
			}	

			else
				temp += guess.charAt(i*2) + " ";			
		}
		
		guess = temp;
		game.setAlphabet(findWrong);
		
		findWrong = true;
		
		for(int i=0; i < guess.length(); i++)
			if(guess.charAt(i) == '_')
				return;
		
		
		game.WinCase();
	}

}
