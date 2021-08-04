package com.richiecodes;

import parts.Mana;
import parts.ManaPool;
import parts.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DiceWizards {

    List<Player> players;
    private Scanner scanner = new Scanner(System.in);
    boolean running = true;
    List<Integer> poolValues;
    Player player1;
    int chance = 3;

    public DiceWizards() {
        players = new ArrayList<>();
        System.out.println("Enter Wizard's name: ");
        String n = scanner.next();
        players.add(new Player(n, 0, "Wizard"));
        player1 = players.get(0);
        cls();
        turn();
    }

    public void turn() {
        while(running) {
            player1.manaPool.rollAll();
            poolValues = player1.manaPool.getPoolValues();
            player1.orbs++;
            displayPoolValues();
            if(checkPool()) {
                System.out.println("\n" + player1 + " rolled " + chance + " of a kind!!!");
                System.out.print(player1 + "'s power has increased as a result...\n");
                System.out.print("The cost of mana for all has increased as a result...\n");
                for(var player : players) {
                    player.manaCost++;
                }
                player1.manaPool.addMana(1, 6);
                player1.power++;
                chance++;
                poolValues = player1.manaPool.getPoolValues();
            }
            player1.displayStats();
            System.out.println(chance + " of a kind for 1 additional mana");
            System.out.println();
            System.out.println("What would you like to do?: ");
            System.out.println("1. Buy mana (" + player1.manaCost + " orbs)");
            System.out.println("2. Roll");
            int selection = scanner.nextInt();

            switch(selection) {
                case 1:
                    if(players.get(0).orbs >= player1.manaCost) {
                        players.get(0).orbs -= player1.manaCost;
                        player1.manaCost++;
                        player1.manaPool.addMana(1,6);
                        player1.power++;
                        cls();
                        System.out.println(player1 + " purchased 1 mana...");
                        System.out.print(player1 + "'s power has increased as a result...");
                        System.out.print("The price of mana for " + player1 + " has increased as a result...\n\n");
                        break;
                    }
                    cls();
                    System.out.println(player1 + " doesn't have enough Orbs!!!");
                    break;

                case 2:
                    cls();
                    break;
            }
        }
    }

    public void displayPoolValues() {
        String out = "";

        Collections.sort(poolValues);

        for (var i : poolValues) {
            out += "|" + i + "|\t";
        }

        System.out.println(out);
    }

    public boolean checkPool() {
        for(int i : poolValues) {
            if(Collections.frequency(poolValues, i) >= chance) {
                return true;
            }
        }

        return false;
    }

    public void cls() {
        int i = 100;
        while(i > 0) {
            System.out.println();
            i--;
        }
    }
}
