package Timmer;

import java.util.Timer;
import CommonPanel.*;

public class TimmerGui {
	
	private static ImageClass image;
		
	public TimmerGui(ImageClass image)
	{
		MakeTimmerTask task = new MakeTimmerTask();
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, 1000);
		
		this.image = image;
		TimerBar texta = new TimerBar(image, 110, 500);
	}

	public static void MakeLabel(int second)
	{	
		
		int time = 10 - MakeTimmerTask.getSecond();
		TimerBar.repaint(image, 110 + 50*time, 500 - 50*time);
	}
}