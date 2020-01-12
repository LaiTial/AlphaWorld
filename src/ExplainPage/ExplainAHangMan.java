package ExplainPage;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import CommonPanel.*;

public class ExplainAHangMan extends JPanel{
	private PutImage SeveralIm;
	private int [][]size = {{240, 110},
			{40, -40},
			{770, 400},
			
			{770, 400}};
	private int[][] ButtonLocation = {{330, 670, 100, 96},
			{700, 600, 200, 220}};
	private String[] src = {
			"mainPanel",
			"HangMan"
	};
	
	private ArrayList<String> letter = new ArrayList<>();
	private int lineNum;
	
	public ExplainAHangMan()
	{
		this.setLayout(new BorderLayout());
		
		SeveralIm = new PutImage(size, "ImageEx0", "src\\ExplainPage\\");
		ImageClass image = new ImageClass(SeveralIm.getSrc(), SeveralIm.getX(), SeveralIm.getY(), SeveralIm.getWidth(), SeveralIm.getHeight());
		
		GoToButton setButton = new GoToButton(2, ButtonLocation, image, false, false, "src\\ExplainPage\\ImageEx1");		
		setButton.clickEvent(src);
		
		this.add(image);
		
		lineNum = UseFile.readFileLine(letter, "src\\ExplainPage\\HangManWay.txt");
		
		new MakeLabel(480, 100, 200, 200, image, "∞‘¿”πÊπ˝", "»ﬁ∏’µ’±Ÿ«ÏµÂ∂Û¿Œ", 40);
		
		for(int i=0; i<lineNum; i++)
			new MakeLabel(320, 140+35*i, 600, 300, image, letter.get(i), "HYø±º≠M", 19);
	}
}
