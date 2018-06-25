package tests;

import engine.GameEngine;
import models.Hero;
import org.junit.Test;
import org.mockito.Mockito;

public class GameEngineTest {

    @Test
    public void tryToChooseHeroWhichNotPresent(){
        GameEngine gameEngine = Mockito.mock(GameEngine.class);
        Mockito.when(gameEngine);
        gameEngine.start();
    }

}