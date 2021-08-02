package com.richiecodes;

import parts.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiceWizards {

    List<Player> players;
    private Scanner scanner = new Scanner(System.in);
    boolean running = true;
    int manaCost = 3;

    public DiceWizards() {
        players = new ArrayList<>();
        players.add(new Player("Wizard 1", 1));
        turn();
    }

    public void turn() {
        while(running) {
            players.get(0).manaPool.rollAll();
            players.get(0).mana++;
            System.out.println(players.get(0).manaPool);
            System.out.println(players.get(0) + "\t Mana: " + players.get(0).mana);
            System.out.println();
            System.out.println("What would you like to do?: ");
            System.out.println("1. Buy mana (" + manaCost + ")");
            System.out.println("2. Roll");
            int selection = scanner.nextInt();

            switch(selection) {
                case 1:
                    if(players.get(0).mana >= manaCost) {
                        players.get(0).mana -= manaCost;
                        manaCost++;
                        players.get(0).manaPool.addDie(6);
                        cls();
                        break;
                    }
                    cls();
                    System.out.println("Not enough Mana!!!");
                    break;

                case 2:
                    cls();
                    break;
            }
        }
    }

    public void checkRoll() {
        for(var die : players.get(0).manaPool.getDice()) {

        }
    }

    public void cls() {
        int i = 100;
        while(i > 0) {
            System.out.println();
            i--;
        }
    }
}
