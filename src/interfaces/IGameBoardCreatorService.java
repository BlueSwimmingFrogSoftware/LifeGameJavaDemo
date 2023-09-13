package interfaces;

import model.GameBoard;

public interface IGameBoardCreatorService {
	GameBoard create(int width, int height) throws Exception;
}
