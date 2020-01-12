package CommonPanel;

import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import CardMain.ControllMain;
import GamePage.CardWordGame;

public class GoToButton{
	
	private JButton ArButton[] = null;
	private JButton button = null;
	private int cardNum;
	
	public GoToButton(int []ButtonLocation, ImageClass image, Boolean border, Boolean area, String general, String text)
	{
		button = new JButton();
		
		button.setLayout(null);
		setLocation(ButtonLocation, button);
		setDecorate(border, area, button);
		setButtonImage(general, 0, button);
		button.setText(text);
		
		image.add(button);
	}
	
	public GoToButton(int x, int y, int width, int height, ImageClass image, char text, String textType, int textSize)
	{
		button = new JButton();
		
		button.setLayout(null);
		button.setBounds(x, y, width, height);
		button.setFont(new Font(textType, Font.BOLD, textSize));
		button.setText(String.valueOf(text));
		
		image.add(button);
	}
	
	public GoToButton(int ArrayNumber, int [][]ButtonLocation, ImageClass image)
	{
		ArButton = new JButton[ArrayNumber];
		
		for(int i=0; i < ArrayNumber; i++)
		{
			ArButton[i] = new JButton();
			ArButton[i].setLayout(null);
			setLocation(ButtonLocation[i], ArButton[i]);
			image.add(ArButton[i]);
		}
	}
	
	public GoToButton(int ArrayNumber, int [][]ButtonLocation, ImageClass image, Boolean border, Boolean area, String general)
	{
		this(ArrayNumber, ButtonLocation, image);
		
		for(int i=0; i < ArrayNumber; i++)
		{
			setDecorate(border, area, ArButton[i]);
			setButtonImage(general, i, ArButton[i]);
		}
	}
	
	public GoToButton(int ArrayNumber, int [][]ButtonLocation, ImageClass image, ArrayList<ArrayList<String>> textWord, int cardNum, int answerNum)
	{
		this(ArrayNumber, ButtonLocation, image);
		this.cardNum = cardNum;
		
		for(int i=0; i < ArrayNumber; i++)
		{
			ArButton[i].setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
			setDecorate(true, false, ArButton[i]);
		}
		
		buttonSetAlpha(ArrayNumber, textWord, answerNum);
	}
	
	
	public void buttonSetAlpha(int num, ArrayList<ArrayList<String>> textWord, int answerNum)
	{
		int NumLocation = CardWordGame.makeRandNumber(num);
		
		for(int i=0; i < num; i++)
		{
			if(i == NumLocation)
				ArButton[i].setText(textWord.get(answerNum).get(0));
			
			else
				ArButton[i].setText(textWord.get(CardWordGame.makeRandNumber(cardNum)).get(0));
		}
	}
		
	
	public static void setLocation(int[] loca, JButton b)
	{
		b.setBounds(loca[0], loca[1], loca[2], loca[3]);
		
	}
	
	public static void setText(String text, JButton b)
	{
		b.setText(text);
	}

	
	public static void setButtonImage(String general, int i, JButton b)
	{
		String makeScr;
		
		makeScr = general + i + ".png";

		b.setIcon(new ImageIcon(makeScr));
	}
		
	public static void setDecorate(Boolean border, Boolean area, JButton b)
	{
		b.setBorderPainted(border);
		b.setContentAreaFilled(area);
	}
	
	public JButton getButton() {
		return button;
	}


	public void clickEvent(String panelName[])
	{
		ActionListener buttonListener;
		
		for(int i=0; i< panelName.length; i++)
		{
			buttonListener = new ChangeCard(ControllMain.getContain(), ControllMain.getCard(), panelName[i]);
			ArButton[i].addActionListener(buttonListener);
		}
	}
	
	public void clickEvent(ActionListener buttonListener)
	{
		button.addActionListener(buttonListener);
		
	}
	
	public void clickEvent(ActionListener buttonListener, int num)
	{
		for(int i=0; i< num; i++)
		{
			ArButton[i].addActionListener(buttonListener);
		}
	}

}
