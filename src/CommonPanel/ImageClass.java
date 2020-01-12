package CommonPanel;

import java.awt.*;
import javax.swing.*;

public class ImageClass extends JPanel{
	private ImageIcon images[];
	private Image sIm[];
	private int x[], y[], width[], height[];

	public ImageClass(String src[], int x[], int y[], int width[], int height[])
	{	
		this.setLayout(null);
		
		this.x = x;
		this.y = y;		
		this.width = width;
		this.height = height;
		
		images = new ImageIcon[x.length];
		sIm = new Image[x.length];
		
		for(int i=0; i < src.length; i++)
		{
			images[i] = new ImageIcon(src[i]);
			sIm[i] = images[i].getImage();
		}			
	}
	
	public void repaintXO(String XO) 
	{
		images[x.length-1] = new ImageIcon(XO);
		sIm[x.length-1] = images[x.length-1].getImage();
		
		this.repaint();
	}

    
    public void paintComponent(Graphics g){
    	
		g.clearRect(0, 0, getWidth(), getHeight());
		
		for(int i=0; i< sIm.length; i++)
		{
			g.drawImage(sIm[i], x[i], y[i], width[i], height[i], this);
			
		}
    }
}