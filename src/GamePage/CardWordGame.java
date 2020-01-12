package GamePage;

import java.awt.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;
import CommonPanel.*;
import Timmer.*;

public class CardWordGame extends JPanel{

	private PutImage SeveralIm;
	private int [][]size = {{0, 170, 500, 840, 400}, {0, 620, 620, 620, 200}, {1300, 300, 300, 300, 400}, {850, 200, 200, 200, 400}};
	
	private int[][] ButtonLocation = {{170, 620, 300, 200},
			{500, 620, 300, 200},
			{840, 620, 300, 200}
	};
	
	private int[][] NewPageButton = {{20, 720, 100, 100}};
	private int[][] Label = {{690, 95, 400, 100}, {220, 20, 100, 100}, {310, 45, 50, 50}};
	
	private String[] src = {
			"mainPanel"
	};
	
	private String text[] = {"", "Score = ", "0"};
	
	private int wordNum = 0, answerNum, score;
	private ImageClass image;
	private MakeLabel thinking;
	private GoToButton setButton;
	private ArrayList<ArrayList<String>> textWord = new ArrayList<>();
	private int[] soundLo = {1200, 20, 50, 50};

	public CardWordGame()
	{	
		this.setLayout(new BorderLayout());
				
		SeveralIm = new PutImage(size, "Image0", "src\\GamePage\\");
		image = new ImageClass(SeveralIm.getSrc(), SeveralIm.getX(), SeveralIm.getY(), SeveralIm.getWidth(), SeveralIm.getHeight());
		
		wordNum = UseFile.readFileWord(textWord, "src\\GamePage\\GameWord.txt");
		
		thinking = new MakeLabel(3, Label, image, text, "ÇÑÄÄ ¼ÖÀÙ M", 20);
		setButton = new GoToButton(3, ButtonLocation, image, textWord, wordNum, answerNum);
		setButton.clickEvent(new CheckPairCard(textWord), 3);
		
		GoToButton b = new GoToButton(1, NewPageButton, image, false, false, "src\\GamePage\\ImageBack0");
		b.clickEvent(src);
		
		GoToButton soundButton = new GoToButton(soundLo, image, false, false, "src\\MainPage\\SoundImage1", "MusicPlay");
		soundButton.clickEvent(new SoundOnOff("src\\GamePage\\Breeze.wav"));
		
		this.add(image);
	}
	
	
	public void startGame()
	{
		answerNum = makeRandNumber(wordNum);
		CheckPairCard.setAnswer(answerNum);
		
		thinking.setLabel(textWord.get(answerNum).get(1), 0);
		setButton.buttonSetAlpha(3, textWord, answerNum);
		
		MakeTimmerTask.MakeCancel(false);
		new TimmerGui(image);
	}
	
	public void winCase()
	{
		this.score += 1;
		thinking.setLabel(String.valueOf(score), 2);
	}
	
	public void animation(String OX, String WinOrLose)
	{
		image.repaintXO(OX);
		
		TimerTask task = new TimerTask() {
			int second=2;
			
			@Override
			public void run()
			{
				second--;
				
				if(second <= 0) {
					
					if(WinOrLose.equals("Win"))
						winCase();
					
					startGame();
					image.repaintXO("");
					
					cancel();
				}
			}
				};
				
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, 1000);
	}
	
	public static int makeRandNumber(int num)
	{
		int number;
		
		Random rand = new Random();
		number = rand.nextInt(num);
		
		return number;
	}
	
	
	public static void playMusic()
	{
		Audio.playMusicLoop("src\\GamePage\\Breeze.wav");
	}
}
