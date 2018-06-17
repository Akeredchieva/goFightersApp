import models.Hero;

public class GameEngine {

    //TODO : Change the println to something with meaning.
    // TODO: If you want make an interface for this class.
    public void attack(Hero attackingHero, Hero defencingHero){
        double damagePoints = attackingHero.attackingDamage();
        defencingHero.damageReceived(damagePoints);
        if (!defencingHero.isAlive()){
            System.out.println("first player attacked with " + damagePoints + ". Player two have : " + defencingHero.getHealthPoints() + ". Player one have: " + attackingHero.getHealthPoints() + ".\n");
            attack(defencingHero,attackingHero);
        } else {
            System.out.println("The game is end.");
        }
    }
}
