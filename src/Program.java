import java.util.Arrays;

import di.DiResolver;
import interfaces.IGameBoardCreatorService;
import interfaces.IGameBoardInputService;
import interfaces.IGameBoardOutputService;
import interfaces.IGameRunnerService;
import model.GameConfig;
import services.*;

public class Program {
	
    public static void main ( String [] arguments ) throws Exception
    {
      
    	runAppExample2();
    	
    }
    
    private static void runAppExample1() throws Exception
    {
    	// as per requirement document example 1
    	var di = new DiResolver();
    	var runner = di.resolve(IGameRunnerService.class);
    	
    	var cfg = new GameConfig();
    	cfg.height = 200;
    	cfg.width = 200;
    	cfg.gameBoardDefinition = "[[1,1]";
    	cfg.maxStepCount = 10;
    
    	runner.run(cfg);
    }
    
    private static void runAppExample2() throws Exception
    {
    	// as per requirement document example 2
    	var di = new DiResolver();
    	var runner = di.resolve(IGameRunnerService.class);
    	
    	var cfg = new GameConfig();
    	cfg.height = 200;
    	cfg.width = 200;
    	cfg.gameBoardDefinition = "[[5, 5], [6, 5], [7, 5], [5, 6], [6, 6], [7, 6]]";
    	cfg.maxStepCount = 10;
    
    	runner.run(cfg);
    }
    
    private static void runAppExample3() throws Exception
    {
    	// this one moves, as per https://playgameoflife.com/
    	var di = new DiResolver();
    	var runner = di.resolve(IGameRunnerService.class);
    	
    	var cfg = new GameConfig();
    	cfg.height = 200;
    	cfg.width = 200;
    	cfg.gameBoardDefinition = "[[1, 0], [2, 1], [0, 2], [1, 2], [2, 2]]";
    	cfg.maxStepCount = 100;
    
    	runner.run(cfg);
    }
    
    private static void test1() throws Exception
    {
    	var di = new DiResolver();
        	
    	var creatorSvc = di.resolve(IGameBoardCreatorService.class);    	
    	var outputSvc = di.resolve(IGameBoardOutputService.class);
    	
    	var gb = creatorSvc.create(100, 100);
    	gb.matrix[1][1].isAlive = true;
    	gb.matrix[99][1].isAlive = true;    	
    	var output = outputSvc.convertToString(gb);
    	System.out.println(output);
    	
    	
    }
    
    private static void test2() throws Exception
    {
    	    
    	var di = new DiResolver();
    	
    	var inputSvc = di.resolve(IGameBoardInputService.class);    	
    	var outputSvc = di.resolve(IGameBoardOutputService.class);
    	
    	var gb2 = inputSvc.convertFromString("[[1,20],[2,14],[3,34]]", 100, 100);
    	
    	var output2 = outputSvc.convertToString(gb2);
    	System.out.println(output2);
    }
}
