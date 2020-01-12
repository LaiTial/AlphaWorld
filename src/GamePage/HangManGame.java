package GamePage;

import java.awt.*;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import CommonPanel.*;
import Timmer.TimmerGui;

public class HangManGame extends JPanel{

	private PutImage SeveralIm;
	private int [][]size = {{0, 400}, {0, 200}, {1300, 400}, {850, 400}};
	
	private int[][] NewPageButton = {{20, 720, 100, 100}};
	private int[][] Label = {{690, 95, 400, 100}, {690, 295, 400, 100}, {220, 20, 100, 100}, {310, 45, 50, 50}};
	
	private String[] src = {
			"mainPanel"
	};
	
	private String text[] = {"", "",  "Score = ", "0"};
	
	private int wordNum = 0, answerNum, score;
	private ImageClass image;
	private MakeLabel thinking;
	private GoToButton man;
	private ArrayList<ArrayList<String>> textWord = new ArrayList<>();
	private int[] soundLo = {1200, 20, 50, 50};
	private int[] manLocation = {830, 120, 440, 534};
	private GoToButton alpha[][] = new GoToButton[2][13];
	private int wrongNum=0;

	public HangManGame()
	{	
		this.setLayout(new BorderLayout());
				
		SeveralIm = new PutImage(size, "Image1", "src\\GamePage\\");
		image = new ImageClass(SeveralIm.getSrc(), SeveralIm.getX(), SeveralIm.getY(), SeveralIm.getWidth(), SeveralIm.getHeight());
		
		wordNum = UseFile.readFileWord(textWord, "src\\GamePage\\GameWord.txt");
		
		thinking = new MakeLabel(4, Label, image, text, "ÇÑÄÄ ¼ÖÀÙ M", 20);
		
		GoToButton b = new GoToButton(1, NewPageButton, image, false, false, "src\\GamePage\\ImageBack0");
		b.clickEvent(src);
		
		GoToButton soundButton = new GoToButton(soundLo, image, false, false, "src\\MainPage\\SoundImage1", "MusicPlay");
		soundButton.clickEvent(new SoundOnOff("src\\GamePage\\LittleTwinkle.wav"));
		
		char bet = 'A';
		
		for(int i=0; i<2; i++)
			for(int j=0; j<13; j++)
			{	
				alpha[i][j] = new GoToButton(170+70*j, 640+70*i, 70, 70, image, bet++, "Monotype Corsiva", 25);
				alpha[i][j].clickEvent(new CheckAlpabet(textWord));
			}
		
		this.add(image);
		
		man = new GoToButton(manLocation, image, false, false, "src\\GamePage\\Man0", "0");
	}
	
	
	public void startGame()
	{
		text[1] = "";
		
		answerNum = makeRandNumber(wordNum);
		CheckAlpabet.setAnswer(answerNum);
		
		for(int i=0; i<textWord.get(answerNum).get(0).strip().length(); i++)
			text[1] += "_ ";
	
		
		CheckAlpabet.setGuess(text[1]);
		
		thinking.setLabel(textWord.get(answerNum).get(1), 0);
		thinking.setLabel(text[1], 1);
		thinking.setLabel(String.valueOf(score), 3);
		
		wrongNum = 0;
		GoToButton.setButtonImage("src\\GamePage\\Man0", wrongNum, man.getButton());
	}
	
	public void setAlphabet(boolean findWrong)
	{
		text[1] = CheckAlpabet.getGuess();
		thinking.setLabel(text[1], 1);
		
		if(findWrong)
			wrongNum++;
		
		if(wrongNum >= 9) 
		{
			image.repaintXO("src\\GamePage\\OkNoImage01.png");
			animation();
		}
		
		else 
		{
			GoToButton.setButtonImage("src\\GamePage\\Man0", wrongNum, man.getButton());
		}
	}
	
	public void WinCase()
	{
		image.repaintXO("src\\GamePage\\OkNoImage00.png");
		score++;
		animation();
	}
	
	public void animation()
	{
		TimerTask t = new TimerTask() {
			int second=2;
			
			@Override
			public void run()
			{
				second--;
				
				if(second <= 0) {
					startGame();
					image.repaintXO("");
					
					cancel();
				}
			}
				};
				
		Timer tim = new Timer();
		tim.scheduleAtFixedRate(t, 0, 1000);
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
		Audio.playMusicLoop("src\\GamePage\\LittleTwinkle.wav");
	}
}

