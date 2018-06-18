package models;

/**
 * Abstract class which represent the same functionality of every player.
 * @author Ana Keredchieva
 * @since 15.06.2018
 */
public abstract class Hero {

    private static final int DEFAULT_VALUE_COUNTER = 0;
    private static final int MIN_BOUNDER_PERCENTAGE = 80;
    private static final int MAX_BOUNDER_PERCENTAGE = 120;
    private static final int MAX_COUNTER = 10;
    private static final int MIN_COUNTER = 1;

    /**
     * The characteristic of every player.
     */
    private double healthPoints;
    private double attackPoints;
    private double armorPoints;
    /**
     * Two parameters for the chances of different skills (for the attack skills and for the defence skills)
     */
    private int counterForAttack;
    private int counterForDefence;

    /**
     * Constructor which set the points of every player.
     * @param healthPoints parameter for the health points of the current hero, based on his type.
     * @param attackPoints parameter for the attack points of the current hero, based on his type.
     * @param armorPoints parameter for the armor points of the current hero, based on his type.
     */
    protected Hero(int healthPoints, int attackPoints, int armorPoints) {
        this.setHealthPoints(healthPoints);
        this.setAttackPoints(attackPoints);
        this.setArmorPoints(armorPoints);
        this.setCounterForAttack(DEFAULT_VALUE_COUNTER);
        this.setCounterForDefence(DEFAULT_VALUE_COUNTER);
    }

    /**
     * Abstract method for what damage will receive the player.
     * @param damageMade value of the current attack damage.
     */
    public void damageReceived(double damageMade){
        double remainingHealthPoints = getHealthPoints()- damageMade;
        setHealthPoints(remainingHealthPoints);
    }

    /**
     * Abstract method for what damage will send the player.
     * @return The value of the damage in double.
     */
    public double attackingDamage(){
        return this.percentageOfAttacking();
    }


    /**
     * Method which calculate the basic atack damage that the player will make without any bonus skills.
     */
    public double percentageOfAttacking(){
        double range = (MAX_BOUNDER_PERCENTAGE - MIN_BOUNDER_PERCENTAGE + 1);
        return this.getArmorPoints() * (((Math.random() * range) + MIN_BOUNDER_PERCENTAGE) / 100);
    }

    /**
     * Getter for health points of the current player.
     * @return The health points of the player in double.
     */
    public double getHealthPoints() {
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
     * Setter for the attack points of the player.
     * @param attackPoints the input parameter for the attack points of the current player.
     */
    protected void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
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
    public void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    /**
     * Getter which check if the counter is above 10. If it is not then it increase it and return the counter. If it is then it turns it do the 1.
     * The logic is that all of the numbers to 10 can be divide by one special number, because for example from 1 to 10 3 numbers can be
     * divide by 3 so the percentage will be 30. 50% can be when divide the numbers with 2 and etc.
     * @return Return the value of the counter to be divide by the special number.
     */
    public int getCounterForAttack() {
        int counter = this.counterForAttack;
        if (counter < MAX_COUNTER) {
            this.setCounterForAttack(++counter);
            return counter;
        } else {
            counter = MIN_COUNTER;
            this.setCounterForAttack(counter);
            return counter;
        }
    }

    /**
     * Setter for the counter for the chance of the attack skill of the player.
     * @param counterForAttack the counter with which count the chance of the special skill.
     */
    public void setCounterForAttack(int counterForAttack) {
        this.counterForAttack = counterForAttack;
    }

    /**
     * Getter which check if the counter is above 10. If it is not then it increase it and return the counter. If it is then it turns it do the 1.
     * The logic is that all of the numbers to 10 can be divide by one special number, because for example from 1 to 10 3 numbers can be
     * divide by 3 so the percentage will be 30. 50% can be when divide the numbers with 2 and etc.
     * @return Return the value of the counter to be divide by the special number.
     */
    public int getCounterForDefence() {
        int counter = this.counterForDefence;
        if (counter < 10) {
            this.setCounterForDefence(++counter);
            return counter;
        } else {
            counter = 1;
            this.setCounterForDefence(counter);
            return counter;
        }
    }

    /**
     * Setter for the counter for the chance of the defence skill of the player.
     * @param counterForDefence the counter with which count the chance of the special skill.
     */
    public void setCounterForDefence(int counterForDefence) {
        this.counterForDefence = counterForDefence;
    }

    /**
     * Boolean method which check if the hero is alive
     * @return true if he still have health points, false if he doesn't.
     */
    public boolean isAlive(){
        return this.getHealthPoints() > 0;
    }
}
