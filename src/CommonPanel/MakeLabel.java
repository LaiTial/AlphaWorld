package CommonPanel;

import java.awt.Font;
import javax.swing.*;

public class MakeLabel {
	
	private JLabel label[];
	private JLabel OneLabel;
	
	public MakeLabel(int num, int[][] Loca, ImageClass image, String text[], String textType, int textSize)
	{
		label = new JLabel[num];
		
		for(int i=0; i<num; i++)
		{
			label[i] = new JLabel();
			
			label[i].setLayout(null);
			label[i].setText(text[i]);
			label[i].setBounds(Loca[i][0], Loca[i][1], Loca[i][2], Loca[i][3]);
			label[i].setFont(new Font(textType, Font.BOLD, textSize));
			
			image.add(label[i]);
		}
	}
	
	public MakeLabel(int x, int y, int width, int height, ImageClass image, String text, String textType, int textSize)
	{
		OneLabel = new JLabel();
		OneLabel.setLayout(null);
		OneLabel.setText(text);
		OneLabel.setBounds(x, y, width, height);
		OneLabel.setFont(new Font(textType, Font.BOLD, textSize));
			
		image.add(OneLabel);
		
	}
	
	public void setLabel(String text, int i)
	{
		label[i].setText(text);
	}

}
