package models;

/**
 * Class for the functionality of a player Assassin. It inherit the class Hero.
 * @author Ana Keredchieva
 * @since 15.06.2018
 */
public class Assassin extends Hero {

    /**
     * static values for the points of the player.
     */
    private static final int HEALTH_POINT_ASSASSIN = 15000;
    private static final int ATTACK_POINT_ASSASSIN  = 500;
    private static final int ARMOR_POINT_ASSASSIN  = 300;
    private static final int NUMBER_OF_PERCENTAGE_ATTACK = 30;
    private static final int MULTIPLIER_ASSASSIN = 3;

    /**
     * Default constructor which call the constructor of the parent and set the properties of the hero.
     */
    public Assassin(String name) {
        super(HEALTH_POINT_ASSASSIN , ATTACK_POINT_ASSASSIN , ARMOR_POINT_ASSASSIN, name);
    }

    /**
     * It calculate the chance to make a bigger damage with the chanceOfSkill.
     * If the chanceOfSkill is lower or equal to 10 (percentage - NUMBER_OF_PERCENTAGE_ATTACK) then check
     * the attack will be increase twice
     * If the chanceOfSkill is more then 10 then the attack will be random number between 80 - 120 % from the attack points.
     * @inheritDoc
     * @return The points with which the player will attack.
     */
    @Override
    public double attackingDamage() {
        double chanceOfSkill = this.percentageOfAttacking(MIN_BOUNDER_PERCENTAGE, MAX_BOUNDER_PERCENTAGE) * 100;
        if (chanceOfSkill <= NUMBER_OF_PERCENTAGE_ATTACK ) {
            return this.getAttackPoints() * MULTIPLIER_ASSASSIN;
        }
        int temp = (int)(this.getAttackPoints() * this.percentageOfAttacking(MIN_BOUNDER_PERCENTAGE_RAW_ATTACK, MAX_BOUNDER_PERCENTAGE_RAW_ATTACK)) ;
        return (double)temp;
    }
}
