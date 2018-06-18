import models.Hero;

public class GameEngine {

    // TODO: If you want make an interface for this class.
    public void attack(Hero attackingHero, Hero defencingHero){
        double damagePoints = attackingHero.attackingDamage();
        defencingHero.damageReceived(damagePoints);
        if (defencingHero.isAlive()){
            System.out.println("Player " + attackingHero.getClass().getSimpleName() + " attacked with " + String.format("%.2f",damagePoints) + " damage.\n " +
                    "Player " + defencingHero.getClass().getSimpleName() + " have : " +  String.format("%.2f",defencingHero.getHealthPoints()) + " health points.\n" +
                    "Player " + attackingHero.getClass().getSimpleName() + " have: " +  String.format("%.2f",attackingHero.getHealthPoints()) + " health points.\n");
            attack(defencingHero,attackingHero);
        } else {
            System.out.println("The game is end.");
        }
    }
}
