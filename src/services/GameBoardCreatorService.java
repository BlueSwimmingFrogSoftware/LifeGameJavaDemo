package services;

import interfaces.IGameBoardCreatorService;
import model.*;

public class GameBoardCreatorService implements IGameBoardCreatorService {

		public GameBoard create(int width, int height) throws Exception {
			
			if(width<=0) throw new Exception("Width cannot equal or be lower than 0");
			if(height<=0) throw new Exception("Height cannot equal or be lower than 0");
			
			var g = new GameBoard();
			g.height= height;
			g.width = width;
			g.matrix = new Cell[width][height];
			
			for(var x=0; x<width; x++)
			{
				for(var y =0; y<height; y++)
				{
					var c  = new Cell();
					c.x = x;
					c.y = y;
					g.matrix[x][y] = c;
				}
			}
			
			return g;			
		}
}
