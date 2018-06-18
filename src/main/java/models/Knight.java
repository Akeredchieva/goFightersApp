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
    private static final int HEALTH_POINT_KNIGHT = 1800;
    private static final int ATTACK_POINT_KNIGHT = 200;
    private static final int ARMOR_POINT_KNIGHT = 100;
    private static final int NUMBER_OF_PERCENTAGE_DAMAGE = 20;
    private static final int NUMBER_OF_PERCENTAGE_ATTACK = 10;

    /**
     * Constructor for the player Knight which call the constructor of the parent and set up the starting values of the player.
     */
    public Knight(String name) {
        super(HEALTH_POINT_KNIGHT, ATTACK_POINT_KNIGHT, ARMOR_POINT_KNIGHT, name);
    }

    /**
     * Method receive a counter which is from 1 to 10. Then try to divide the counter to 5 - because in numbers from 1 to 10
     * there is only two numbers which can be divided by 5 without rest which is 20% of the numbers.
     * @inheritDoc
     * @param damageMade value of the current attack damage.
     */
    @Override
    public void damageReceived(double damageMade) {
        double remainingPointsForDamage;
        double remainingPointsHealth;
        double chanceOfSkill = percentageOfAttacking(MIN_BOUNDER_PERCENTAGE,MAX_BOUNDER_PERCENTAGE) * 100;
        if (chanceOfSkill <= NUMBER_OF_PERCENTAGE_DAMAGE ) {
            double percentageOfAttack = this.percentageOfAttacking(MIN_BOUNDER_PERCENTAGE_RAW_ATTACK, MAX_BOUNDER_PERCENTAGE_RAW_ATTACK);
            remainingPointsForDamage = (this.getArmorPoints() * percentageOfAttack) - damageMade ;
            if (remainingPointsForDamage < 0) {
                remainingPointsHealth = this.getHealthPoints() - remainingPointsForDamage;
                this.setHealthPoints(remainingPointsHealth);
            }
        } else {
            remainingPointsForDamage = this.getHealthPoints() - damageMade;
            this.setHealthPoints(remainingPointsForDamage);
        }
    }

    /**
     * Method receive a counter which is from 1 to 10. Then try to divide the counter to 7 - because in numbers from 1 to 10
     * there is only one number which can be divided by 7 without rest which is 10% of the numbers.
     * @return the value of the attack points which the player will do.
     */
    @Override
    public double attackingDamage() {
        double chanceOfSkill = percentageOfAttacking(MIN_BOUNDER_PERCENTAGE,MAX_BOUNDER_PERCENTAGE) * 100;
        double rowAttackingPoints = this.getAttackPoints() * this.percentageOfAttacking(MIN_BOUNDER_PERCENTAGE_RAW_ATTACK, MAX_BOUNDER_PERCENTAGE_RAW_ATTACK);
        if (chanceOfSkill <= NUMBER_OF_PERCENTAGE_ATTACK ) {
            return rowAttackingPoints * 2;
        } else {
            return rowAttackingPoints;
        }
    }
}
