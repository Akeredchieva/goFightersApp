package models;
/**
 * Basic functionality of the player Monk. It represent what attack will do and what damage will received
 * @author Ana Keredchieva
 * @since 15.06.2018
 */
public class Monk extends Hero {

    /**
     * Default values from the beginning of the game of the player Monk. They should be the same in the start of the game.
     */
    private static final int HEALTH_POINT_MONK = 250;
    private static final int ATTACK_POINT_MONK = 150;
    private static final int ARMOR_POINT_MONK = 50;
    private static final int NUMBER_OF_PERCENTAGE_DAMAGE = 3;

    /**
     * Constructor for the player Monk which call the constructor of the parent and set up the starting values of the player.
     */
    public Monk() {
        super(HEALTH_POINT_MONK, ATTACK_POINT_MONK, ARMOR_POINT_MONK);
    }


    @Override
    public void damageReceived(double damageMade) {
        double remainingPoints;
        if (this.getCounterForDefence() % NUMBER_OF_PERCENTAGE_DAMAGE == 0) {
            remainingPoints = damageMade - percentageOfAttacking();
            if (remainingPoints > 0) {
                double remainingPointsHealth = this.getHealthPoints() - remainingPoints;
                this.setHealthPoints(remainingPointsHealth);
            }
        } else {
            remainingPoints = this.getHealthPoints() - damageMade;
            this.setHealthPoints(remainingPoints);
        }
    }
}
