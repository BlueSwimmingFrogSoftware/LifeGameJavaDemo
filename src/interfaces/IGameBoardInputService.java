package interfaces;

import model.GameBoard;

public interface IGameBoardInputService {
	GameBoard convertFromString(String inputText, int width, int height) throws Exception;
}
