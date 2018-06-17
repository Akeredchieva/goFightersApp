import models.Hero;
import models.Knight;
import models.Warrior;

public class Application {

    public static void main(String[] args) {

        Hero warrior = new Knight();
        Hero warrior2 = new Knight();
        GameEngine gameEngine = new GameEngine();
        gameEngine.attack(warrior,warrior2);

    }
}
