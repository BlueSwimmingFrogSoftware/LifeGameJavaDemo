package services;


import model.*;

import java.util.ArrayList;

import interfaces.IGameBoardOutputService;

public class GameBoardOutputService implements IGameBoardOutputService {
	
	public String convertToString(GameBoard b)
	{
		 
		 var liveCells = new ArrayList<String>();
		 
		 for(var i=0; i< b.matrix.length; i++)
		 {
			 for(var j=0; j<b.matrix[i].length; j++)
			 {
				 var c = b.matrix[i][j];
				 
				 if(c.isAlive)
				 {
					 liveCells.add(String.format("[%s, %s]", i,j));
				 }
			 }
		 }
		 		 
		 var out = "[" + String.join(",",liveCells.toArray(new String[0]))+ "]";		 
		 return  out;
	}
}
