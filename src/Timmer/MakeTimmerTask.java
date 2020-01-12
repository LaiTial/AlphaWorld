package Timmer;

import java.util.TimerTask;

import CardMain.ControllMain;
import CommonPanel.*;
import GamePage.CardWordGame;

public class MakeTimmerTask extends TimerTask{

	private static int second = 10;
	private static Boolean Cancel;
	
	@Override
	public void run() 
	{
		if(Cancel)
			cancel();
		
		second--;
		
		TimmerGui.MakeLabel(second);
		
		if(second <= 0)
		{
			cancel();
			CardWordGame game = (CardWordGame)ControllMain.getPanel(1);
			second = 10;
			game.animation("src\\GamePage\\OkNoImage01.png", "Lose");
			
		}		
	}

	public static void setSecond(int second) {
		MakeTimmerTask.second = second;
	}
	
	public static int getSecond() {
		return second;
	}
	
	public static void MakeCancel(Boolean t)
	{
		Cancel = t;
	}
}