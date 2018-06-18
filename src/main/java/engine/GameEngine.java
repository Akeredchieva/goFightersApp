package engine;

import models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class which represent the basic logic for the game. How will start the game and how will end.
 */
public class GameEngine {

    // TODO: If you want make an interface for this class.

    /**
     * Method which represent the hole game. Every player attack each other and vice versa. The game will end when one the the player is dead.
     * @param attackingHero Player One
     * @param defencingHero Play Two
     */
    public void attack(Hero attackingHero, Hero defencingHero){
        double damagePoints = attackingHero.attackingDamage();
        defencingHero.damageReceived(damagePoints);
        if (defencingHero.isAlive()){
            System.out.println("Player " + attackingHero.getClass().getSimpleName() + " attacked with " + String.format("%.2f",damagePoints) + " damage.\n" +
                    "Player " + defencingHero.getClass().getSimpleName() + " have : " +  String.format("%.2f",defencingHero.getHealthPoints()) + " health points.\n" +
                    "Player " + attackingHero.getClass().getSimpleName() + " have: " +  String.format("%.2f",attackingHero.getHealthPoints()) + " health points.\n");
            attack(defencingHero,attackingHero);
        } else {
            if (defencingHero.getHealthPoints() > 0 ) {
                System.out.println("The winner is : " + defencingHero.getClass().getSimpleName());
            } else {
                System.out.println("The winner is : " + attackingHero.getClass().getSimpleName());
            }
            System.out.println("The game is end.");
        }
    }

    /**
     * Method for the starting of the game where the two players pick what type of hero they choose.
     * @throws IOException because the input value.
     */
    public void start() throws IOException {
        System.out.println("Choose the player one:\n(Please press one of the numbers to choose the type of the player)\n" +
                            "1. Warrior\n2. Assassin\n3.Knight\n4. Monk");
        String bufferedReader = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int thePlayer = Integer.parseInt(bufferedReader);
        Hero playerOne ;
        Hero playerTwo;
        switch (thePlayer) {
            case 1: playerOne = new Warrior();
                    break;
            case 2: playerOne = new Assassin();
                    break;
            case 3: playerOne = new Knight();
                    break;
            case 4: playerOne = new Monk();
                    break;
            default: playerOne = new Warrior();
                    break;
        }
        System.out.println("Choose the player two:\n(Please press one of the numbers to choose the type of the player)\n" +
                "1. Warrior\n2. Assassin\n3. Knight\n4. Monk");
        bufferedReader = new BufferedReader(new InputStreamReader(System.in)).readLine();
        thePlayer = Integer.parseInt(bufferedReader);
        switch (thePlayer) {
            case 1: playerTwo = new Warrior();
                    break;
            case 2: playerTwo = new Assassin();
                    break;
            case 3: playerTwo = new Knight();
                    break;
            case 4: playerTwo = new Monk();
                    break;
            default: playerTwo = new Warrior();
                    break;
        }
        System.out.println("Let the game begin: \n");
        this.attack(playerOne,playerTwo);
    }
}
