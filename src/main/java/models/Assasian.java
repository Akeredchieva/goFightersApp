package models;

public class Assasian extends Hero {

    private static final int HEALTH_POINT_ASSASIAN = 150;
    private static final int ATTACK_POINT_ASSASIAN = 50;
    private static final int ARMOR_POINT_ASSASIAN = 200;

    public Assasian() {
        super(HEALTH_POINT_ASSASIAN, ATTACK_POINT_ASSASIAN, ARMOR_POINT_ASSASIAN);
    }

    @Override
    public double attackingDamage() {
        double rowAttackingPoints = this.percentageOfAttacking();
        if (this.getCounterForAttack() % 3 == 0) {
            return rowAttackingPoints*3;
        } else {
            return rowAttackingPoints;
        }
    }
}
