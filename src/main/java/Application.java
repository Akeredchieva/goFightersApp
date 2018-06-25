import engine.GameEngine;
import models.Assassin;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.AssassinTest;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {

        /**
         * Create new GameEngine and start the game.
         */
        GameEngine gameEngine = new GameEngine();

        gameEngine.start();


    }
}
