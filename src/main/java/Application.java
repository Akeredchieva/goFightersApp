import engine.GameEngine;

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
