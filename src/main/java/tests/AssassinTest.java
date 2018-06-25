package tests;

import models.Assassin;
import models.Hero;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class AssassinTest {

    @Mock
    private Hero hero ;//= new Assassin("Annie");

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

    // TODO: Change if this is correct for test.
    @Test
    public void heroIsDead() {
        hero.damageReceived(Integer.MAX_VALUE);
        assertTrue("The hero is dead.",!hero.isAlive());
    }

//    public void checkIfTheHeroTakeDamage(){
//        double healthPointsBeforeDamage = hero.getHealthPoints();
//        hero.damageReceived(50);
//        double healthPointsAfterDamage = hero.getHealthPoints();
//        assertEquals("The damage is not received.");
//    }

    /*
    @Test
    public void checkAttack() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Hero hero1 = new Assassin("Ana");
        Hero heroMocked = Mockito.mock(Assassin.class);
        Method method = Hero.class.getDeclaredMethod("percentageOfAttacking",);
        method.setAccessible(true);

        //Mockito.when(heroMocked.)
        Mockito.doReturn(34.56).when(heroMocked);
        //Mockito.doNothing().when(trainSpy).addWagon(0);

    }
    */

    @Test
    public void testPercentageOfAttacking() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        double theHundred;
        boolean flag = false;
        //double[] theHundreds = new double[10000];

        Method percentageOfAttacking = Hero.class.getDeclaredMethod("percentageOfAttacking", int.class, int.class);
        percentageOfAttacking.setAccessible(true);

        for (int i=0;i<10000;i++) {
           theHundred = (Double) percentageOfAttacking.invoke(hero, 80, 120);
           int converted = (int)(theHundred*100);
           if (converted < 80 || converted >120) {
               flag = true;
           }
           //theHundreds[i] = theHundred;
        }
        assertEquals(false, flag);
    }

    // Comments are to be added for test is the hro make triple damage and if the attack is in the range
    @Test
    public void ThirtyPercentChangeForTripleAttack() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //No need of Reflection -
//        Method attackingDamage = Assassin.class.getDeclaredMethod("attackingDamage");
//        attackingDamage.setAccessible(true);
//        double invoke = (double) attackingDamage.invoke(hero);
        Assassin attackingDamage = new Assassin("Annie");
        double invoke = attackingDamage.attackingDamage();
        double attackPoints = 1500;
        int j = 0;
        //boolean flagForTripleDamage = false;
        //boolean flagForDamageInRange = false;

        for (int i=0; i<100;i++) {
            if (attackPoints == invoke) {
                j++;
                //flagForTripleDamage = true;
            } //else if (invoke > 300 || invoke < 600) {
                //flagForDamageInRange = true;
            //}
            invoke = (double) attackingDamage.attackingDamage();
        }

       // assertTrue(flagForDamageInRange);
        // assertTrue(flagForTripleDamage);
        assertTrue(j<40);
        assertTrue(j>20);
    }

    public void testReceiveDamage(){

    }
}