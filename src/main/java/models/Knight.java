package models;

/**
 * Basic functionality of the player Knight. It represent what attack will do and what damage will received
 * @author Ana Keredchieva
 * @since 15.06.2018
 */
public class Knight extends Hero {

    /**
     * Default values from the beginning of the game of the player Monk. They should be the same in the start of the game.
     */
    private static final int HEALTH_POINT_KNIGHT = 180;
    private static final int ATTACK_POINT_KNIGHT = 20;
    private static final int ARMOR_POINT_KNIGHT = 100;

    /**
     * Constructor for the player Knight which call the constructor of the parent and set up the starting values of the player.
     */
    public Knight() {
        super(HEALTH_POINT_KNIGHT, ATTACK_POINT_KNIGHT, ARMOR_POINT_KNIGHT);
    }

    /**
     * Method receive a counter which is from 1 to 10. Then try to divide the counter to 5 - because in numbers from 1 to 10
     * there is only two numbers which can be divided by 5 without rest which is 20% of the numbers.
     * @param damageMade value of the current attack damage.
     */
    //TODO: Change the duplicating code.
    @Override
    public void damageReceived(double damageMade) {
        double remainingPoints;
        if (this.getCounterForDefence() % 5 == 0) {
            remainingPoints = this.getArmorPoints() - percentageOfAttacking();
            if (remainingPoints < 0) {
                double remainingPointsHealth = this.getHealthPoints() - remainingPoints;
                this.setHealthPoints(remainingPointsHealth);
                this.setArmorPoints(0);
            } else {
                this.setArmorPoints(remainingPoints);
            }
        } else {
            remainingPoints = this.getHealthPoints() - damageMade;
            this.setHealthPoints(remainingPoints);
        }
    }

    /**
     * Method receive a counter which is from 1 to 10. Then try to divide the counter to 7 - because in numbers from 1 to 10
     * there is only one number which can be divided by 7 without rest which is 10% of the numbers.
     * @return the value of the attack points which the player will do.
     */
    @Override
    public double attackingDamage() {
        double rowAttackingPoints = this.percentageOfAttacking();
        if (this.getCounterForAttack() % 7 == 0) {
            return rowAttackingPoints*2;
        } else {
            return rowAttackingPoints;
        }
    }
}
