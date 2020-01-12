package Timmer;

import java.awt.*;
import javax.swing.JPanel;
import CommonPanel.*;

public class TimerBar extends JPanel{
	
	private ImageClass image;
	private static int y, height;
	
	public TimerBar(ImageClass image, int y, int height)
	{
		this.image = image;
		this.setSize(500, 1300);
		
		this.y = y;
		this.height = height;
		
		image.add(this);
	}
	
	public static void repaint(ImageClass image, int yN, int Nheight)
	{
		y = yN;
		height = Nheight;
		
		image.repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		GradientPaint gPaint1=new GradientPaint(160, y, Color.magenta, 180, y+height, Color.GREEN);
		Graphics2D g2=(Graphics2D)g;
		
		g2.setPaint(gPaint1);
		g2.drawRect(160, y, 20, height);
		g2.fillRect(160, y, 20, height);
	}
}