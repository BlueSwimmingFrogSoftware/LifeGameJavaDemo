package services;
import interfaces.IRulesEvaluatorService;
import model.*;


public class RulesEvaluatorService implements IRulesEvaluatorService {

	public boolean checkIfCellLives(GameBoard b, int x, int y)
	{
		var liveCellsCount = CountNeighbourLiveCells(b, x, y);
		Cell c = b.matrix[x][y];
		
		//if (liveCellsCount < 2) return false; // REDUNDAND - dies of underpopulation or stays unborn
		
		if (c.isAlive && (liveCellsCount == 2 || liveCellsCount == 3)) return true; // stays alive
		
		if (!c.isAlive && liveCellsCount == 3) return true; // gets born 
		
		// if (!c.IsLive && liveCellCount == 2) return false // REDUNDAND - unremarkable nothing happens
		
		//if (liveCellsCount > 3) return false; // REDUNDAND - dies of overpopulation or stays unborn
		
		return false; 
	}
	
	private int CountNeighbourLiveCells(GameBoard b, int posX, int posY)
	{
		var liveCellsCount = 0;
		
		for(var x = posX - 1; x <= posX + 1; x++)
		{
			for(var y = posY - 1; y <= posY + 1; y++)
			{
				if(x == posX && y==posY) {continue;} // same field
				if (x < 0) continue; // outside the gameboard
				if (y < 0) continue; // outside the gameboard
				if (x >= b.width) continue; // outside the gameboard
				if (y >= b.height) continue; // outside the gameboard
				
				if(b.matrix[x][y].isAlive) {
					liveCellsCount++;
				}
			}
		}
		
		return liveCellsCount;
	}
	
}
