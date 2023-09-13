package di;

import com.google.inject.AbstractModule;

import interfaces.*;
import services.*;

public class BasicModule extends AbstractModule {
	 
    @Override
    protected void configure() {
        bind(IGameBoardCreatorService.class).to(GameBoardCreatorService.class);
        bind(IGameBoardInputService.class).to(GameBoardInputService.class);
        bind(IGameBoardOutputService.class).to(GameBoardOutputService.class);
        bind(IGameRunnerService.class).to(GameRunnerService.class);
        bind(IRulesEvaluatorService.class).to(RulesEvaluatorService.class);
    }
}
