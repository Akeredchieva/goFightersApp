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
     * It calculate the chance to received no damage with the chanceOfSkill.
     * If the chanceOfSkill is lower or equal to 20 (percentage - NUMBER_OF_PERCENTAGE_DAMAGE) then check
     * if the armor is more then the damage and damage is blocked else the armor is empty and the rest of the point of the damage are subtract from health point
     * If the chanceOfSkill is more then 20 then the all of damage points subtract from health point.
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
     * It calculate the chance to make a bigger damage with the chanceOfSkill.
     * If the chanceOfSkill is lower or equal to 10 (percentage - NUMBER_OF_PERCENTAGE_ATTACK) then check
     * the attack will be increase twice
     * If the chanceOfSkill is more then 10 then the attack will be random number between 80 - 120 % from the attack points.
     * {@inheritDoc}
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
