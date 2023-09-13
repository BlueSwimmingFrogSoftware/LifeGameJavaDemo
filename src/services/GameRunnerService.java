package services;

import com.google.inject.Inject;

import interfaces.*;
import model.*;


public class GameRunnerService implements IGameRunnerService {

	private IGameBoardCreatorService creatorSvc;
	private IGameBoardInputService inputSvc;
	private IGameBoardOutputService outputSvc;
	private IRulesEvaluatorService rulesSvc;
	
	@Inject
	public GameRunnerService(IGameBoardCreatorService creatorSvc,
							 IGameBoardInputService inputSvc,
							 IGameBoardOutputService outputSvc,
							 IRulesEvaluatorService rulesSvc)
	{
		this.creatorSvc = creatorSvc;
		this.inputSvc = inputSvc;
		this.outputSvc = outputSvc;
		this.rulesSvc = rulesSvc;
	}
	
	public void run(GameConfig game) throws Exception {
		
			var gb = inputSvc.convertFromString(game.gameBoardDefinition, game.width, game.height);
			
			for(var stepNo = 1; stepNo <= game.maxStepCount; stepNo++) {
				
				var newboard = this.creatorSvc.create(game.width, game.height);
				
				for(var x=0; x<game.width; x++) {
					for(var y=0; y<game.height; y++) {
						
						newboard.matrix[x][y].isAlive = this.rulesSvc.checkIfCellLives(gb, x, y);
						
					}
				}
							
				var stepOutput = this.outputSvc.convertToString(newboard);
				System.out.println("" + stepNo +": " + stepOutput);
				
				
				gb = newboard;
			}
	}
}
