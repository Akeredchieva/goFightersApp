package models;

/**
 * Basic functionality of the player Warrior. It represent what attack will do and what damage will received
 * @author Ana Keredchieva
 * @since 15.06.2018
 */
public class Warrior extends Hero {

    /**
     * Default values from the beginning of the game of the player Warrior. They should be the same in the start of the game.
     */
    private static final int HEALTH_POINT_WARRIOR = 200;
    private static final int ATTACK_POINT_WARRIOR = 20;
    private static final int ARMOR_POINT_WARRIOR = 60;

    /**
     * Constructor for the player Warrior which call the constructor of the parent and set up the starting values of the player.
     */
    public Warrior() {
        super(HEALTH_POINT_WARRIOR, ATTACK_POINT_WARRIOR, ARMOR_POINT_WARRIOR);
    }
}
