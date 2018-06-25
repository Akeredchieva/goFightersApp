package engine;

import models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class which represent the basic logic for the game. How will start the game and how will end.
 */
public class GameEngine {

    /**
     * Method which represent the hole game. Every player attack each other and vice versa. The game will end when one the the player is dead.
     * @param attackingHero Player One
     * @param defencingHero Play Two
     */
    public void attack(Hero attackingHero, Hero defencingHero){
        double damagePoints = attackingHero.attackingDamage();
        defencingHero.damageReceived(damagePoints);
        System.out.println("Player " + attackingHero.getName() + " attacked with " + String.format("%.2f",damagePoints) + " damage.\n" +
                "Player " + defencingHero.getName() + " have : " +  String.format("%.2f",defencingHero.getHealthPoints()) + " health points.\n" +
                "Player " + attackingHero.getName() + " have: " +  String.format("%.2f",attackingHero.getHealthPoints()) + " health points.\n");

        if (defencingHero.isAlive()){
          attack(defencingHero,attackingHero);
        } else {
            if (defencingHero.getHealthPoints() > 0 ) {
                System.out.println("The winner is : " + defencingHero.getName() + " the " + defencingHero.getClass().getSimpleName());
            } else {
                System.out.println("The winner is : " + attackingHero.getName() + " the " + attackingHero.getClass().getSimpleName());
            }
            System.out.println("The game is end.");
        }
    }

    /**
     * Method for the starting of the game where the two players pick what type of hero they choose.
     * @throws IOException because the input value.
     */
    // TODO: change the duplicate code.
    public void start() {

        Hero playerOne;
        Hero playerTwo;
        playerOne = this.menu();
        playerTwo = this.menu();
        System.out.println("Let the game begin: \n");
        this.attack(playerOne,playerTwo);
    }

    private Hero menu() {
        Hero playerOne;
        System.out.println("Choose the player :\n(Please press one of the numbers to choose the type of the player)\n" +
                "1. Warrior\n2. Assassin\n3.Knight\n4. Monk");
        String bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert bufferedReader != null;
        int thePlayer = Integer.parseInt(bufferedReader);
        System.out.println("Chose the name of the player:\n");
        String nameBR = null;
        try {
            nameBR = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (thePlayer) {
            case 1:
                playerOne = new Warrior(nameBR);
                break;
            case 2:
                playerOne = new Assassin(nameBR);
                break;
            case 3:
                playerOne = new Knight(nameBR);
                break;
            case 4:
                playerOne = new Monk(nameBR);
                break;
            default:
                playerOne = null;
                break;
        }
        if (playerOne == null){
            throw new IllegalArgumentException("You didn't choose type of player.");
        }
        return playerOne;
    }
}
