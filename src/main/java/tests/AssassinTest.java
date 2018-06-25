package tests;

import models.Assassin;
import models.Hero;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class AssassinTest {


    private Hero hero ;

    @Before
    public void setUP(){
        hero = new Assassin("Annie");
    }

    @Test
    public void isEqualName(){
        assertEquals("The name did not match to Annie",hero.getName(),"Annie");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nameEqualToEmptyString(){
        new Assassin("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nameEqualToNull(){
        new Assassin(null);
    }

    @Test
    public void isEqualHealth(){
        assertEquals("The health points did not match with the default 15000.",15000, hero.getHealthPoints(),0.0);
    }

    @Test
    public void isEqualAttack(){
        assertEquals("The attack points did not match with the default 500.",500, hero.getAttackPoints(),0.0);
    }

    @Test
    public void isEqualArmor(){
        assertEquals("The attack points did not match with the default 300.",300, hero.getArmorPoints(),0.0);
    }

    @Test
    public void heroIsAlive() {
        assertTrue("The hero is dead.",hero.isAlive());
    }

    @Test
    public void heroIsDead() {
        hero.damageReceived(Integer.MAX_VALUE);
        assertTrue("The hero is dead.", !hero.isAlive());
    }

    //Change this test if you have time to HeroTests.class
    @Test
    public void testPercentageOfAttacking() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        double theHundred;
        boolean flag = false;

        Method percentageOfAttacking = Hero.class.getDeclaredMethod("percentageOfAttacking", int.class, int.class);
        percentageOfAttacking.setAccessible(true);

        for (int i=0;i<10000;i++) {
           theHundred = (Double) percentageOfAttacking.invoke(hero, 80, 120);
           int converted = (int)(theHundred*100);
           if (converted < 80 || converted >120) {
               flag = true;
           }
        }
        assertEquals(false, flag);
    }

    @Test
    public void testIfItMakeTripleDamage(){

        double invoke = hero.attackingDamage();
        double attackPoints = 1500;
        boolean flagForTripleDamage = false;
        //boolean flagForDamageInRange = false;

        for (int i=0; i<100;i++) {
            if (attackPoints == invoke) {
                flagForTripleDamage = true;
            }
            invoke = hero.attackingDamage();
        }

        assertTrue(flagForTripleDamage);

    }

    @Test
    public void testIfTheDamageIsInRange(){

        double invoke = hero.attackingDamage();
        boolean flagForDamageInRange = true;
        double attackPoints = 1500;

        for (int i=0; i<100;i++) {
            if (invoke < 300 || invoke > 600 && attackPoints != invoke) {
                flagForDamageInRange = false;
            }
            invoke = hero.attackingDamage();
        }

        assertTrue(flagForDamageInRange);
    }

    @Test
    public void testReceiveDamageMoreThenTheHealthOfTheHero(){
        hero.damageReceived(Integer.MAX_VALUE);
        double heroHealth = hero.getHealthPoints();
        assertTrue(heroHealth == 0);

    }
}