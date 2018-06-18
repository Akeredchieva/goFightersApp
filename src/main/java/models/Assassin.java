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
    private static final int ATTACK_POINT_ASSASSIN  = 50;
    private static final int ARMOR_POINT_ASSASSIN  = 30;
    private static final int NUMBER_OF_PERCENTAGE_ATTACK = 3;

    /**
     * Default constructor which call the constructor of the parent and set the properties of the hero.
     */
    public Assassin() {
        super(HEALTH_POINT_ASSASSIN , ATTACK_POINT_ASSASSIN , ARMOR_POINT_ASSASSIN);
    }

    /**
     * {@inheritDoc}
     * @return The points with which the player will attack.
     */
    @Override
    public double attackingDamage() {
        double rowAttackingPoints = this.percentageOfAttacking();
        if (this.getCounterForAttack() % NUMBER_OF_PERCENTAGE_ATTACK == 0) {
            return rowAttackingPoints * 3;
        } else {
            return rowAttackingPoints;
        }
    }
}
