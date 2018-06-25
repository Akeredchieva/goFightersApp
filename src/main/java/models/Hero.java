package models;

import java.text.DecimalFormat;

/**
 * Abstract class which represent the same functionality of every player.
 * @author Ana Keredchieva
 * @since 15.06.2018
 */
public abstract class Hero {

    /**
     * Default minimum boundary for the raw attack.
     */
    protected static final int MIN_BOUNDER_PERCENTAGE_RAW_ATTACK = 80;
    /**
     * Default maximum boundary for the raw attack.
     */
    protected static final int MAX_BOUNDER_PERCENTAGE_RAW_ATTACK = 120;
    /**
     * Default maximum boundary for the chance of the special skill.
     */
    protected static final int MIN_BOUNDER_PERCENTAGE = 0;
    protected static final int MAX_BOUNDER_PERCENTAGE = 100;

    /**
     * The characteristic of every player.
     */
    private double healthPoints;
    private double attackPoints;
    private double armorPoints;
    private String name;

    /**
     * Constructor which set the points of every player.
     * @param healthPoints parameter for the health points of the current hero, based on his type.
     * @param attackPoints parameter for the attack points of the current hero, based on his type.
     * @param armorPoints parameter for the armor points of the current hero, based on his type.
     */
    protected Hero(int healthPoints, int attackPoints, int armorPoints, String name) {
        this.setHealthPoints(healthPoints);
        this.setAttackPoints(attackPoints);
        this.setArmorPoints(armorPoints);
        this.setName(name);
    }

    /**
     * Abstract method for what damage will receive the player.
     * @param damageMade value of the current attack damage.
     */
    public void damageReceived(double damageMade){
        double remainingHealthPoints = getHealthPoints()- damageMade;
        if (remainingHealthPoints > 0) {
            setHealthPoints(remainingHealthPoints);
        } else {
            setHealthPoints(0);
        }
    }

    /**
     * Abstract method for what damage will send the player.
     * @return The value of the damage in double.
     */
    public double attackingDamage(){
        int temp = (int)(this.getAttackPoints() *
                percentageOfAttacking(MIN_BOUNDER_PERCENTAGE_RAW_ATTACK, MAX_BOUNDER_PERCENTAGE_RAW_ATTACK));
        return (double)temp;
    }


    /**
     * Method which calculate a random number between some boundary.
     * DecimalFormat is using for set the value of the result in one number after the point.
     * @param minBounder The minimum boundary.
     * @param maxBounder The maximum boundary.
     * @return number between the max and min boundary (between 0.01 to 0.99 depends on the boundaries)
     */
    protected double percentageOfAttacking(int minBounder, int maxBounder){

        double range = (maxBounder - minBounder + 1);
        DecimalFormat twoDForm = new DecimalFormat("#.#");
        double result = ((Math.random() * range) + minBounder) / 100;
        String resultInString = twoDForm.format(result);
        result = Double.parseDouble(resultInString);
        return result;
    }

    /**
     * Getter for health points of the current player.
     * @return The health points of the player in double.
     */
    public double getHealthPoints() {
        if (healthPoints <= 0) {
            setHealthPoints(0);
            return healthPoints;
        }
        return healthPoints;
    }

    /**
     * Setter for the health points of the player.
     * @param healthPoints the input parameter for the health points of the current player.
     */
    protected void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * Getter for attack points of the current player.
     * @return The attack points of the player in double.
     */
    public double getAttackPoints() {
        return attackPoints;
    }

    /**
     * Getter for armor points of the current player.
     * @return The armor points of the player in double.
     */
    public double getArmorPoints() {
        return armorPoints;
    }

    /**
     * Setter for the armor points of the player.
     * @param armorPoints the input parameter for the armor points of the current player.
     */
    protected void setArmorPoints(double armorPoints) {
        this.armorPoints = armorPoints;
    }

    /**
     * Setter for the attack points of the player.
     * @param attackPoints the input parameter for the attack points of the current player.
     */
    protected void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    /**
     * Boolean method which check if the hero is alive
     * @return true if he still have health points, false if he doesn't.
     */
    public boolean isAlive(){
        return this.getHealthPoints() > 0;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        if (name == null || name.equalsIgnoreCase("")) {
            throw new IllegalArgumentException("The value of the name is not correct.");
        }
        this.name = name;
    }
}
