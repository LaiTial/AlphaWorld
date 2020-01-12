package CardMain;

import java.awt.*;
import javax.swing.*;
import ExplainPage.*;
import GamePage.*;
import MainPage.*;

public class ControllMain extends JFrame{
   
   private static JPanel[] panel;
   private static Container contain;
   private static CardLayout card;

   private String[] panelName = {
		   "mainPanel",
		   "CardGame",
		   "Explain a CardGame",
		   "HangMan",
		   "Explain a HangMan"
   };
   
   public ControllMain()
   {
      contain = this.getContentPane();
      
      card = new CardLayout();
      contain.setLayout(card);
      
      panel = new JPanel[5];
    		  
      panel[0] = new MainPanel();
      panel[1] = new CardWordGame();
      panel[2] = new ExplainACardGame();
      panel[3] = new HangManGame();
      panel[4] = new ExplainAHangMan();
      
      for(int i = 0; i < 5; i++)
      {
          contain.add(panel[i]);
          card.addLayoutComponent(panel[i], panelName[i]);
      }
      
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Alpha World");
      setSize(1300, 870);
      setResizable(false);
   }   

   public static JPanel getPanel(int i) {
	return panel[i];
   }
   
   public static Container getContain() {
      return contain;
   }


   public static CardLayout getCard() {
      return card;
   }


   public static void main(String[] args) {

	   new ControllMain();
   }

}