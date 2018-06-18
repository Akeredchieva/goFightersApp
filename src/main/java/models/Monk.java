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
    private static final int HEALTH_POINT_MONK = 1000;
    private static final int ATTACK_POINT_MONK = 50;
    private static final int ARMOR_POINT_MONK = 50;
    private static final int NUMBER_OF_PERCENTAGE_DAMAGE = 30;

    /**
     * Constructor for the player Monk which call the constructor of the parent and set up the starting values of the player.
     */
    public Monk(String name) {
        super(HEALTH_POINT_MONK, ATTACK_POINT_MONK, ARMOR_POINT_MONK, name);
    }


    @Override
    public void damageReceived(double damageMade) {
        double remainingPoints;
        double chanceOfSkill = percentageOfAttacking(MIN_BOUNDER_PERCENTAGE,MAX_BOUNDER_PERCENTAGE);
        if (chanceOfSkill <= NUMBER_OF_PERCENTAGE_DAMAGE) {
            remainingPoints = damageMade - (this.getArmorPoints() * this.percentageOfAttacking(MIN_BOUNDER_PERCENTAGE_RAW_ATTACK, MAX_BOUNDER_PERCENTAGE_RAW_ATTACK));
            double remainingPointsHealth = this.getHealthPoints() - remainingPoints;
            this.setHealthPoints(remainingPointsHealth);
        } else {
            remainingPoints = this.getHealthPoints() - damageMade;
            this.setHealthPoints(remainingPoints);
        }
    }
}
