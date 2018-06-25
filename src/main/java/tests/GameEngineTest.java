package tests;

import engine.GameEngine;
import models.Assassin;
import models.Hero;
import models.Knight;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GameEngineTest {

    @Test
    public void checkWhenBothHeroesAreDead() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;

        GameEngine gameEngine = new GameEngine();
        Assassin assassin = new Assassin("Annie");
        Knight knight = new Knight("Pesho");

        Method setHealthPoints = Hero.class.getDeclaredMethod("setHealthPoints", double.class);
        setHealthPoints.setAccessible(true);

        setHealthPoints.invoke(assassin, 0.0);
        setHealthPoints.invoke(knight, 0.0);

        System.setOut(new PrintStream(outContent));
        gameEngine.attack(assassin,knight);
        Assert.assertEquals("The both heroes are dead.\n" +
                "The game is end.\n",outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    public void checkIfTheFirstHeroIsDead() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;

        GameEngine gameEngine = new GameEngine();
        Assassin assassin = new Assassin("Annie");
        Knight knight = new Knight("Pesho");

        Method setHealthPoints = Hero.class.getDeclaredMethod("setHealthPoints", double.class);
        setHealthPoints.setAccessible(true);

        setHealthPoints.invoke(assassin, 0.0);

        System.setOut(new PrintStream(outContent));
        gameEngine.attack(assassin,knight);
        Assert.assertEquals("The winner is : Pesho the Knight\n" +
                "The game is end.\n",outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    public void checkIfTheSecondHeroIsDead() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;

        GameEngine gameEngine = new GameEngine();
        Assassin assassin = new Assassin("Annie");
        Knight knight = new Knight("Pesho");

        Method setHealthPoints = Hero.class.getDeclaredMethod("setHealthPoints", double.class);
        setHealthPoints.setAccessible(true);

        setHealthPoints.invoke(knight, 0.0);

        System.setOut(new PrintStream(outContent));
        gameEngine.attack(assassin,knight);
        Assert.assertEquals("The winner is : Annie the Assassin\n" +
                "The game is end.\n",outContent.toString());

        System.setOut(originalOut);
    }
}