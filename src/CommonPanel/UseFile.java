package CommonPanel;

import java.io.*;
import java.util.ArrayList;

public class UseFile {
	
	public static int readFileWord(ArrayList<ArrayList<String>> text, String src)
	{
        String line = ""; 
        int lineNum=0;
        
        try {             
            BufferedReader br = new BufferedReader(new FileReader(src)); 
            
            while((line = br.readLine()) != null) 
            {
            	ArrayList<String> list = new ArrayList<>();
            	
            	list.add(line.split(":")[0]);
            	list.add(line.split(":")[1]);
            	
            	text.add(list);
            	
            	lineNum++;
            } 

            br.close(); 
            
      } catch (IOException e){ 
            e.printStackTrace(); 
      }
		return lineNum;
	}
	
	public static int readFileLine(ArrayList<String> text, String src)
	{
        String line; 
        int lineNum=0;
        
        try {             
            BufferedReader br = new BufferedReader(new FileReader(src)); 
            
            while((line = br.readLine()) != null) 
            {
            	text.add(line);
            	lineNum++;
            }
            br.close(); 
            
      } catch (IOException e){ 
            e.printStackTrace(); 
      }
		return lineNum;
	}
}
