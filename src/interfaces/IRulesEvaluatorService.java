package interfaces;

import model.GameBoard;

public interface IRulesEvaluatorService {
	boolean checkIfCellLives(GameBoard b, int x, int y);
}
