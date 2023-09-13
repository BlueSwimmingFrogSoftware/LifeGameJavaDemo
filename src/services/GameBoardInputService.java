package services;

import java.util.regex.*;
import com.google.inject.Inject;

import interfaces.IGameBoardInputService;
import model.GameBoard;

public class GameBoardInputService implements IGameBoardInputService {
	
	private GameBoardCreatorService gbCreatorSvc;
	
	@Inject
	public GameBoardInputService(GameBoardCreatorService gbCreatorSvc)
	{
		this.gbCreatorSvc = gbCreatorSvc;
	}
	
	public GameBoard convertFromString(String inputText, int width, int height) throws Exception
	{
		
		var b = this.gbCreatorSvc.create(width, height);
		
		Pattern p = Pattern.compile("\\[\\s*\\d+\\s*,\\s*\\d+\\s*\\]", Pattern.CASE_INSENSITIVE);
	    Matcher m = p.matcher(inputText);
	    
	    while (m.find()) 
	    {
	    	 var txt = m.group(0);
	    	 var parts = txt.split(",");
	    	 var x = Integer.parseInt(parts[0].replace("[","").trim());
	    	 var y = Integer.parseInt(parts[1].replace("]","").trim());
	    	 
	    	 b.matrix[x][y].isAlive = true;
	    }
	    
		return b;
	    
	}	
}
